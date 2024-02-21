package com.app.controllers;

import com.app.dtos.*;
import com.app.entities.end_users.InvestigatingOfficer;
import com.app.services.IOService;
import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@CrossOrigin()
@RequestMapping("/IO")
@PreAuthorize("hasRole('IO')")
public class IOController {

    @Autowired
    IOService ioService;
    @GetMapping("/complaints")
    public ResponseEntity<?> getComplaints(@AuthenticationPrincipal String principal)
    {
        ApiResponseArray<FirIoDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,ioService.getComplaints(principal), LocalDateTime.now());
        return ResponseEntity.ok().body( apiResponseData);
    }
    @PutMapping("/complaints/{complaint_id}/update")
    public ResponseEntity<?> updateComplaint(@AuthenticationPrincipal String principal, @PathVariable Long complaint_id, @RequestBody IOupdateComplaintDTO updateComplaint)
    {
        ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,ioService.updateComplaint(principal, complaint_id, updateComplaint),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/complaints/{complaintId}")
    public ResponseEntity<?> getComplaints(@AuthenticationPrincipal String principal,@PathVariable Long complaintId)
    {
        ApiResponseArray<FirIoDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,ioService.getComplaintByComplaintId(principal,complaintId), LocalDateTime.now());
        return ResponseEntity.ok().body( apiResponseData);
    }


    @GetMapping
    public ResponseEntity<?> getIoDetails(@AuthenticationPrincipal String principal){
        ApiResponseData<IoDetailDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,ioService.getIoDetails(principal),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

}

