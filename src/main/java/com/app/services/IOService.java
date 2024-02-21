package com.app.services;

import com.app.dtos.FirIoDTO;
import com.app.dtos.IOupdateComplaintDTO;
import com.app.dtos.ComplaintsDTO;

import java.util.List;

public interface IOService {

    public List<FirIoDTO> getComplaints(String email);
    public String updateComplaint(String email, Long complaint_id, IOupdateComplaintDTO updateComplaint);

    public List<FirIoDTO> getComplaintByComplaintId(String email, Long complaintId);


}
