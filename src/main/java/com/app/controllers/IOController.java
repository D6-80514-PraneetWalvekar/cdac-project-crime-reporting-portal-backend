package com.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/IO")
public class IOController {

    @GetMapping("/{IO_id}/complaints")
    public ResponseEntity<?> getComplaints(@PathVariable Long IO_id)
    {
        return ResponseEntity.ok().build();
    }
    @GetMapping("{IO_id}/complaints/{complaint_id}")
    public ResponseEntity<?> getComplaint(@PathVariable Long IO_id, @PathVariable Long complaint_id)
    {
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{IO_id}/complaints/{complaint_id}/update")
    public ResponseEntity<?> updateComplaint(@PathVariable Long IO_id, @PathVariable Long complaint_id)
    {
        return ResponseEntity.ok().build();
    }

}

