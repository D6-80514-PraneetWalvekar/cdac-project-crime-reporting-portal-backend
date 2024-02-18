package com.app.services;

import com.app.dtos.*;

import java.util.List;

public interface SHOService {
    public ShoDTO getSHODetails(String email);
    public PsDTO getPSDetails(String email);
    public List<ComplaintsDTO> getComplaints(String email);

    public List<IoDTO> getIOs(String email);

    public String acceptComplaint(String email,Long complaint_id, Long io_id);

    IoDTO addIO(String email, IOPostDTO ioAdd);
}

