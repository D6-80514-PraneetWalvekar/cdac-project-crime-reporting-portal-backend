package com.app.services;

import com.app.daos.SPDao;
import com.app.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface SPService {
    ResponseEntity<?> getSPDetails(String email);
    List<PsDTO> getAllPoliceStations(String email);
    List<ShoDTO> getAllSHOs(String email);
    ShoDTO addSHO(String email, SHOPostDTO shoAdd);
    PsDTO addPS(String email, PSPostDTO psAdd);
    TransferDTO transferSHO(String email, TransferDTO transferDTO);
}
