package com.app.controllers;

import com.app.services.SHOService;
import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.app.dtos.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/SHO")
@PreAuthorize("hasRole('SHO')")
public class SHOController {

    @Autowired
    private SHOService shoService;

    @GetMapping("/{SHO_id}")
    public ResponseEntity<ApiResponseData<ShoDTO>> getSHODetails(@PathVariable Long SHO_id)
    {
        ApiResponseData<ShoDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.getSHODetails(SHO_id), LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/{SHO_id}/police-station")
    public ResponseEntity<ApiResponseData<PsDTO>> getPoliceStation(@PathVariable Long SHO_id)
    {
        ApiResponseData<PsDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.getPSDetails(SHO_id), LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/{SHO_id}/police-station/IO")
    public ResponseEntity<ApiResponseArray<IoDTO>> getInvestigatingOfficers(@PathVariable Long SHO_id)
    {
        ApiResponseArray<IoDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,shoService.getIOs(SHO_id),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @GetMapping("/{SHO_id}/police-station/complaints")
    public ResponseEntity<ApiResponseArray<ComplaintsDTO>> getAllComplaints(@PathVariable Long SHO_id)
    {
        ApiResponseArray<ComplaintsDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,shoService.getComplaints(SHO_id),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @PutMapping("/{SHO_id}/police-station/complaints/{complaint_id}")
    public ResponseEntity<?> acceptComplaint(@PathVariable Long SHO_id, @PathVariable Long complaint_id, @RequestBody Long io_id)
    {
        ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.acceptComplaint(complaint_id, io_id),LocalDateTime.now());
        return ResponseEntity.ok().body(apiResponseData);
    }

    @PostMapping("{SHO_id}/police-station/IO/add")
    public ResponseEntity<?> addIO(@PathVariable Long SHO_id, @RequestBody IOPostDTO ioAdd)
    {
        ApiResponseData<IoDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,shoService.addIO(SHO_id, ioAdd),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseData);
    }
}
