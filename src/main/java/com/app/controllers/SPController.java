package com.app.controllers;

import com.app.dtos.*;
import com.app.services.SPService;
import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/SP")
@PreAuthorize("hasRole('SP')")
public class SPController {

    @Autowired
    private SPService spService;

    @GetMapping("/")
    public ResponseEntity<?> getSPDetails(@AuthenticationPrincipal String principal)
    {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/police-staions")
    public ResponseEntity<?> getAllPoliceStations(@AuthenticationPrincipal String principal)
    {
        ApiResponseArray<PsDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,spService.getAllPoliceStations(principal), LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }
    @GetMapping("/sho")
    public ResponseEntity<?> getAllSHOs(@AuthenticationPrincipal String principal)
    {

        ApiResponseArray<ShoDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,spService.getAllSHOs(principal),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @PostMapping("/addSHO")
    public ResponseEntity<?> addSHO(@AuthenticationPrincipal String principal, @RequestBody SHOPostDTO shoAdd)
    {
        ApiResponseData<ShoDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,spService.addSHO(principal,shoAdd),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseData);
    }
    @PostMapping("/addPS")
    public ResponseEntity<?> addPS(@AuthenticationPrincipal String principal, @RequestBody PSPostDTO psAdd)
    {
        ApiResponseData<PsDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,spService.addPS(principal, psAdd),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseData);
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> transferSHO(@AuthenticationPrincipal String principal, @RequestBody TransferDTO transferDTO)
    {
        TransferDTO dto = spService.transferSHO(principal, transferDTO);

        if(dto==null)
            return ResponseEntity.badRequest().body(new ApiResponseData<String>(ApiResponseStatus.SUCCESS,"Invalid SHO and PS",LocalDateTime.now()));

        return ResponseEntity.ok().body(new ApiResponseData<TransferDTO>(ApiResponseStatus.SUCCESS,dto,LocalDateTime.now()));
    }
}
