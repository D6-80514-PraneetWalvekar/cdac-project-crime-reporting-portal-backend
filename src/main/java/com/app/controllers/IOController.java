package com.app.controllers;

import com.app.dtos.ComplaintDTO;
import com.app.dtos.ComplaintsDTO;
import com.app.dtos.IOupdateComplaintDTO;
import com.app.services.IOService;
import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/IO")
@PreAuthorize("hasRole('IO')")
public class IOController {

    @Autowired
    IOService ioService;
    @GetMapping("/{IO_id}/complaints")
    public ResponseEntity<?> getComplaints(@AuthenticationPrincipal String principal)
    {
        ApiResponseArray<ComplaintsDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,ioService.getComplaints(principal), LocalDateTime.now());
        return ResponseEntity.ok().body( apiResponseData);
    }
    @PutMapping("/{IO_id}/complaints/{complaint_id}/update")
    public ResponseEntity<?> updateComplaint(@AuthenticationPrincipal String principal, @PathVariable Long complaint_id, @RequestBody IOupdateComplaintDTO updateComplaint)
    {
        ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,ioService.updateComplaint(principal, complaint_id, updateComplaint),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

}

