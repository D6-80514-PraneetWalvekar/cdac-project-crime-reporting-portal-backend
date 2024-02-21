package com.app.services;

import com.app.dtos.*;

import java.util.List;

public interface IOService {

    public List<FirIoDTO> getComplaints(String email);
    public String updateComplaint(String email, Long complaint_id, IOupdateComplaintDTO updateComplaint);

    public List<FirIoDTO> getComplaintByComplaintId(String email, Long complaintId);

    public IoDetailDTO getIoDetails(String email);


}
