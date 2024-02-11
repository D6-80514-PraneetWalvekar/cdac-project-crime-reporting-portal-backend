package com.app.controllers;

import com.app.services.IOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/IO")
public class IOController {

    @Autowired
    IOService ioService;
    @GetMapping("/{IO_id}/complaints")
    public ResponseEntity<?> getComplaints(@PathVariable Long IO_id)
    {
        return ResponseEntity.ok().body( ioService.getComplaints(IO_id));
    }
    @PutMapping("/{IO_id}/complaints/{complaint_id}/update")
    public ResponseEntity<?> updateComplaint(@PathVariable Long IO_id, @PathVariable Long complaint_id)
    {
        ioService.updateComplaint(IO_id, complaint_id);
        return ResponseEntity.ok().build();
    }

}

