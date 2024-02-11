package com.app.services;

import com.app.dtos.*;

import java.util.List;

public interface SHOService {
    public ShoDTO getSHODetails(Long sho_id);
    public PsDTO getPSDetails(Long sho_id);
    public List<complaintsDTO> getComplaints(Long sho_id);

    public List<IoDTO> getIOs(Long sho_id);

    public void acceptComplaint(Long complaint_id, Long io_id);
}

