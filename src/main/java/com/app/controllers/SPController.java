package com.app.controllers;

import com.app.dtos.*;
import com.app.services.SPService;
import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/SP/{sp_id}")
public class SPController {

    @Autowired
    private SPService spService;

    @GetMapping("/")
    public ResponseEntity<?> getSPDetails(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/police-staions")
    public ResponseEntity<?> getAllPoliceStations(@PathVariable Long sp_id)
    {
        ApiResponseArray<PsDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,spService.getAllPoliceStations(sp_id), LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }
    @GetMapping("/sho")
    public ResponseEntity<?> getAllSHOs(@PathVariable Long sp_id)
    {

        ApiResponseArray<ShoDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,spService.getAllSHOs(sp_id),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @PostMapping("/addSHO")
    public ResponseEntity<?> addSHO(@PathVariable Long sp_id, @RequestBody SHOPostDTO shoAdd)
    {
        ApiResponseData<ShoDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,spService.addSHO(sp_id,shoAdd),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseData);
    }
    @PostMapping("/addPS")
    public ResponseEntity<?> addPS(@PathVariable Long sp_id, @RequestBody PSPostDTO psAdd)
    {
        ApiResponseData<PsDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,spService.addPS(sp_id, psAdd),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseData);
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> transferSHO(@PathVariable Long sp_id, @RequestBody TransferDTO transferDTO)
    {
        TransferDTO dto = spService.transferSHO(sp_id, transferDTO);

        if(dto==null)
            return ResponseEntity.badRequest().body(new ApiResponseData<String>(ApiResponseStatus.SUCCESS,"Invalid SHO and PS",LocalDateTime.now()));

        return ResponseEntity.ok().body(new ApiResponseData<TransferDTO>(ApiResponseStatus.SUCCESS,dto,LocalDateTime.now()));
    }
}
