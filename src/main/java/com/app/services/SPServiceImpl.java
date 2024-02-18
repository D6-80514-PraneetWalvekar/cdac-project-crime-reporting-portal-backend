package com.app.services;

import com.app.custom_exceptions.ResourseNotFound;
import com.app.daos.PoliceStationDao;
import com.app.daos.SHODao;
import com.app.daos.SPDao;
import com.app.dtos.*;
import com.app.entities.PoliceStation;
import com.app.entities.end_users.StationHouseOfficer;

import com.app.entities.enums.RoleEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SPServiceImpl implements SPService{

    @Autowired
    private SPDao spDao;
    @Autowired
    private PoliceStationDao psDao;
    @Autowired
    private SHODao shoDao;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseEntity<?> getSPDetails(String email) {
        return null;
    }

    @Override
    public List<PsDTO> getAllPoliceStations(String email) {
        return spDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("could not get!!")).getPoliceStations()
                .stream().map((ps)->mapper.map(ps, PsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShoDTO> getAllSHOs(String email) {
        return spDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("could not get!!")).getStationHouseOfficers()
                .stream().map((sho)->mapper.map(sho, ShoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ShoDTO addSHO(String email, SHOPostDTO shoAdd) {
        StationHouseOfficer sho = mapper.map(shoAdd, StationHouseOfficer.class);
        PoliceStation ps = psDao.findPoliceStationByAddress(shoAdd.getPoliceStation()).orElseThrow(()->new ResourseNotFound("PS not found!"));
        sho.setStation(ps);
        sho.setSpOfficer(spDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SP id invalid")));
        sho.getBaseEntityUser().setRole(RoleEnum.ROLE_SHO);
        sho.getBaseEntityUser().setPassword(encoder.encode(sho.getBaseEntityUser().getPassword()));
        return mapper.map(shoDao.save(sho), ShoDTO.class);
    }

    @Override
    public PsDTO addPS(String email, PSPostDTO psAdd) {

        PoliceStation ps = mapper.map(psAdd, PoliceStation.class);
        ps.setSpOfficer(spDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SP Id invalid")));

        return mapper.map(psDao.save(ps), PsDTO.class);
    }

    @Override
    public TransferDTO transferSHO(String email, TransferDTO transferDTO) {

        PoliceStation ps1 = psDao.findById(transferDTO.getPsOneID()).orElseThrow(()->new ResourseNotFound("could not get!"));
        PoliceStation ps2 = psDao.findById(transferDTO.getPsTwoID()).orElseThrow(()->new ResourseNotFound("could not get!"));


        StationHouseOfficer sho1 = shoDao.findById(transferDTO.getShoOneID()).orElseThrow(()->new ResourseNotFound("could not get!"));
        StationHouseOfficer sho2 = shoDao.findById(transferDTO.getShoTwoID()).orElseThrow(()->new ResourseNotFound("could not get!"));

        if(!ps1.getSho().equals(sho1) || !ps2.getSho().equals(sho2))
            return null;
        ps1.setSho(sho2);
        sho2.setStation(ps1);

        ps2.setSho(sho1);
        sho1.setStation(ps2);


        return new TransferDTO(sho2.getID(), ps2.getID(), sho1.getID(), ps2.getID());
    }
}
