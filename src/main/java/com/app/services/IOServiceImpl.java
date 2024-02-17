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
    public List<ComplaintsDTO> getComplaints(Long io_id) {
        return ioDao.findById(io_id).orElseThrow(()->new ResourseNotFound("Could not get")).getCases()
                .stream().map((fir)->{
                    ComplaintsDTO dto =mapper.map(fir.getComplaint(), ComplaintsDTO.class);
                    dto.setComplainant(fir.getComplaint().getCitizen().getFName());
                    return dto;
                }).collect(Collectors.toList());
    }


    @Override
    public void updateComplaint(Long io_id, Long complaint_id, IOupdateComplaintDTO complaintDTO) {
        FirstInformationReport fir = firDao.findById(complaint_id).orElseThrow();
        fir.setRemark(complaintDTO.getRemark());
        fir.setStatusEnum(complaintDTO.getStatusEnum());

    }
}
