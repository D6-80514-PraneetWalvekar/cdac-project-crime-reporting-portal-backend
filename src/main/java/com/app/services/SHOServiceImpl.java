package com.app.services;

import com.app.custom_exceptions.ResourseNotFound;
import com.app.entities.*;
import com.app.entities.end_users.*;
import com.app.entities.enums.RoleEnum;
import com.app.entities.enums.StatusEnum;

import com.app.dtos.*;
import com.app.daos.*;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SHOServiceImpl implements SHOService{
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SHODao shoDao;

    @Autowired
    private PoliceStationDao psDao;

    @Autowired
    private ComplaintDAO complaintDao;

    @Autowired
    private FIRDao firDao;

    @Autowired
    private IODao ioDao;

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public ShoDTO getSHODetails(String email) {

        StationHouseOfficer sho = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid"));
        ShoDTO dto = mapper.map(sho, ShoDTO.class);
        dto.setPoliceStationAddress(sho.getStation().getAddress());

        return dto;
    }

    @Override
    public PsDTO getPSDetails(String email) {
        PoliceStation ps = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid")).getStation();
        return mapper.map(ps, PsDTO.class);
    }

    @Override
    public List<ComplaintsDTO> getComplaints(String email) {
        List<Complaint> complaints = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid"))
                                     .getStation().getComplaints();
        return complaints.stream().map((complaint)->{
            ComplaintsDTO dto =  mapper.map(complaint, ComplaintsDTO.class);
            dto.setComplainant(complaint.getCitizen().getFName());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<FirDTO> getFIRs(String email) {
        StationHouseOfficer sho = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid"));
        List<FirstInformationReport> FIRs = firDao.findByInvestigatingOfficer_Station(sho.getStation());
        return FIRs.stream().map((fir)->mapper.map(fir, FirDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public List<IoDetailDTO> getIOs(String email) {
        List<InvestigatingOfficer> investigatingOfficers = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid"))
                .getStation().getIoOfficers();
        return investigatingOfficers.stream().map((io)->mapper.map(io, IoDetailDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String acceptComplaint(String email,Long complaint_id, IOEmailDTO ioEmail) {
        StationHouseOfficer sho = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid"));
        System.out.println("IO email : " + ioEmail.getBaseEntityUserEmail());

        Complaint complaint = complaintDao.findById(complaint_id).orElseThrow(() -> new ResourseNotFound("Could not get details"));
        FirstInformationReport fir = new FirstInformationReport();
        complaint.setFIR(true);
        fir.setComplaint(complaint);
        fir.setInvestigatingOfficer(ioDao.findByBaseEntityUserEmail(ioEmail.getBaseEntityUserEmail()).orElseThrow(()->new ResourseNotFound("invalid IO")));
        fir.setStatusEnum(StatusEnum.ONGOING);
        firDao.save(fir);
        return "Complaint accepted and assigned to "+ioEmail;
    }

    @Override
    public IoDTO addIO(String email, IOPostDTO ioAdd) {
        InvestigatingOfficer io = mapper.map(ioAdd, InvestigatingOfficer.class);
        io.setStation(shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid")).getStation());
        io.getBaseEntityUser().setRole(RoleEnum.ROLE_IO);
        io.getBaseEntityUser().setPassword(encoder.encode(io.getBaseEntityUser().getPassword()));
        return  mapper.map(ioDao.save(io), IoDTO.class);
    }

    public String rejectComplaint(String email, Long complaintID){
        List<Complaint> complaint = shoDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("SHO ID invalid")).getStation().getComplaints();
        complaint.stream().filter((com)->com.getID()==complaintID)
                .map(com->{com.setFIR(false);
                        return com;})
                .collect(Collectors.toList());

        return "Complaint rejected";
    }
}
