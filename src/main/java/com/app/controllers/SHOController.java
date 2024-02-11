package com.app.controllers;

import com.app.services.SHOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dtos.*;

import java.util.List;

@RestController
@RequestMapping("/SHO")
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
        shoService.acceptComplaint(complaint_id, io_id);
        return ResponseEntity.ok().build();
    }
}
