package com.app.services;

import com.app.dtos.IOupdateComplaintDTO;
import com.app.dtos.complaintsDTO;

import java.util.List;

public interface IOService {

    public List<complaintsDTO> getComplaints(Long io_id);
    public void updateComplaint(Long io_id, Long complaint_id, IOupdateComplaintDTO updateComplaint);
}
