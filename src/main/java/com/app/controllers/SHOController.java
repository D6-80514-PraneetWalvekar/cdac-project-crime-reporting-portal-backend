package com.app.controllers;

import com.app.services.SHOService;
import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.app.dtos.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/SHO")
@PreAuthorize("hasRole('SHO')")
public class SHOController {

    @Autowired
    private SHOService shoService;

    @GetMapping()
    public ResponseEntity<ApiResponseData<ShoDTO>> getSHODetails(@AuthenticationPrincipal String principal)
    {
        ApiResponseData<ShoDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.getSHODetails(principal), LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/police-station")
    public ResponseEntity<ApiResponseData<PsDTO>> getPoliceStation(@AuthenticationPrincipal String principal)
    {
        ApiResponseData<PsDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.getPSDetails(principal), LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/police-station/all-IO")
    public ResponseEntity<ApiResponseArray<IoDTO>> getInvestigatingOfficers(@AuthenticationPrincipal String principal)
    {
        ApiResponseArray<IoDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,shoService.getIOs(principal),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/police-station/all-complaints")
    public ResponseEntity<ApiResponseArray<ComplaintsDTO>> getAllComplaints(@AuthenticationPrincipal String principal)
    {
        ApiResponseArray<ComplaintsDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,shoService.getComplaints(principal),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @PutMapping("/police-station/complaint/{complaint_id}")
    public ResponseEntity<?> acceptComplaint(@AuthenticationPrincipal String principal, @PathVariable Long complaint_id, @RequestBody IOEmailDTO ioEmail)
    {
        ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.acceptComplaint(principal, complaint_id, ioEmail),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @PostMapping("/police-station/add-IO")
    public ResponseEntity<?> addIO(@AuthenticationPrincipal String principal, @RequestBody IOPostDTO ioAdd)
    {
        ApiResponseData<IoDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.addIO(principal, ioAdd),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseData);
    }
}
