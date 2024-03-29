package com.app.services;


import com.app.daos.FIRDao;
import com.app.entities.*;
import com.app.dtos.*;
import com.app.custom_exceptions.ResourseNotFound;
import com.app.daos.IODao;
import com.app.dtos.ComplaintsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IOServiceImpl implements IOService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    IODao ioDao;

    @Autowired
    FIRDao firDao;

    @Override
    public List<FirIoDTO> getComplaints(String email) {
        return ioDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("Could not get")).getCases()
                .stream().map((fir)->{
                    FirIoDTO dto =mapper.map(fir, FirIoDTO.class);
                    dto.setComplaintCitizenFName(fir.getComplaint().getCitizen().getFName());
                    return dto;
                }).collect(Collectors.toList());
    }


    @Override
    public String updateComplaint(String email, Long complaint_id, IOupdateComplaintDTO complaintDTO) {
        ioDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("IO not valid"));
        FirstInformationReport fir = firDao.findById(complaint_id).orElseThrow(()->new ResourseNotFound("Invalid FIR id"));
        fir.setRemark(complaintDTO.getRemark());
        fir.setStatusEnum(complaintDTO.getStatusEnum());
        return "Complaint updated successfully";
    }

    @Override
    public List<FirIoDTO> getComplaintByComplaintId(String email, Long complaintId) {
        return ioDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("Could not get")).getCases()
                .stream().map((fir)->{
                    FirIoDTO dto = null;
                    if(fir.getComplaint().getID() == complaintId){
                        dto =mapper.map(fir, FirIoDTO.class);
                        dto.setComplaintCitizenFName(fir.getComplaint().getCitizen().getFName());
                    }
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public IoDetailDTO getIoDetails(String email) {
        IoDetailDTO dto = mapper.map(ioDao.findByBaseEntityUserEmail(email).orElseThrow(()->new ResourseNotFound("Could not get")),IoDetailDTO.class);

        return dto;
    }
}
