package com.app.controllers;

import com.app.services.SHOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.app.dtos.*;

import java.util.List;

@RestController
@RequestMapping("/SHO")
@PreAuthorize("hasRole('SHO')")
public class SHOController {

    @Autowired
    private SHOService shoService;

    @GetMapping("/{SHO_id}")
    public ResponseEntity<ShoDTO> getSHODetails(@PathVariable Long SHO_id)
    {
        return ResponseEntity.ok().body(shoService.getSHODetails(SHO_id));
    }

    @GetMapping("/{SHO_id}/police-station")
    public ResponseEntity<PsDTO> getPoliceStation(@PathVariable Long SHO_id)
    {
        return ResponseEntity.ok().body(shoService.getPSDetails(SHO_id));
    }

    @GetMapping("/{SHO_id}/police-station/IO")
    public ResponseEntity<List<IoDTO>> getInvestigatingOfficers(@PathVariable Long SHO_id)
    {
        return ResponseEntity.ok().body(shoService.getIOs(SHO_id));
    }

    @GetMapping("/{SHO_id}/police-station/complaints")
    public ResponseEntity<List<complaintsDTO>> getAllComplaints(@PathVariable Long SHO_id)
    {
        return ResponseEntity.ok().body(shoService.getComplaints(SHO_id));
    }

    @PutMapping("/{SHO_id}/police-station/complaints/{complaint_id}")
    public ResponseEntity<?> acceptComplaint(@PathVariable Long SHO_id, @PathVariable Long complaint_id, @RequestBody Long io_id)
    {
        return ResponseEntity.ok().body(shoService.acceptComplaint(complaint_id, io_id));
    }

    @PostMapping("{SHO_id}/police-station/IO/add")
    public ResponseEntity<?> addIO(@PathVariable Long SHO_id, @RequestBody IOPostDTO ioAdd)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(shoService.addIO(SHO_id, ioAdd));
    }
}
