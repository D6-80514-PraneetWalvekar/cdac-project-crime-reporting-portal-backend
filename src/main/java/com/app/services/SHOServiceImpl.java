package com.app.services;

import com.app.custom_exceptions.ResourseNotFound;
import com.app.entities.*;
import com.app.entities.end_users.*;
import com.app.entities.enums.StatusEnum;

import com.app.dtos.*;
import com.app.daos.*;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ComplaintDao complaintDao;

    @Autowired
    private FIRDao firDao;

    @Autowired
    private IODao ioDao;
    @Override
    public ShoDTO getSHODetails(Long sho_id) {

        StationHouseOfficer sho = shoDao.findById(sho_id).orElseThrow(()->new ResourseNotFound("Could not get details"));
        ShoDTO dto = mapper.map(sho, ShoDTO.class);
        dto.setPoliceStation(sho.getStation().getLocation());

        return dto;
    }

    @Override
    public PsDTO getPSDetails(Long sho_id) {
        PoliceStation ps = shoDao.findById(sho_id).orElseThrow(()->new ResourseNotFound("Could not get details")).getStation();
        return mapper.map(ps, PsDTO.class);
    }

    @Override
    public List<complaintsDTO> getComplaints(Long sho_id) {
        List<Complaint> complaints = shoDao.findById(sho_id).orElseThrow(()->new ResourseNotFound("Could not get details"))
                                     .getStation().getComplaints();
        return complaints.stream().map((complaint)->{
            complaintsDTO dto =  mapper.map(complaint, complaintsDTO.class);
            dto.setComplainant(complaint.getCitizen().getFName());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<IoDTO> getIOs(Long sho_id) {
        List<InvestigatingOfficer> investigatingOfficers = shoDao.findById(sho_id).orElseThrow(()->new ResourseNotFound("Could not get details"))
                .getStation().getIoOfficers();
        return investigatingOfficers.stream().map((io)->mapper.map(io, IoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void acceptComplaint(Long complaint_id, Long io_id) {
        Complaint complaint = complaintDao.findById(complaint_id).orElseThrow(() -> new ResourseNotFound("Could not get details"));
        FirstInformationReport fir = new FirstInformationReport();
        fir.setComplaint(complaint);
        fir.setInvestigatingOfficer(ioDao.getReferenceById(io_id));
        fir.setStatusEnum(StatusEnum.ONGOING);
        firDao.save(fir);
    }
}
