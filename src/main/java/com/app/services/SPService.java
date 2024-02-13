package com.app.services;

import com.app.daos.SPDao;
import com.app.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SPService {
    ResponseEntity<?> getSPDetails(Long sp_id);
    List<PsDTO> getAllPoliceStations(Long sp_id);
    List<ShoDTO> getAllSHOs(Long sp_id);
    ShoDTO addSHO(Long sp_id, SHOPostDTO shoAdd);
    PsDTO addPS(Long sp_id, PSPostDTO psAdd);
    TransferDTO transferSHO(Long sp_id, TransferDTO transferDTO);
}
