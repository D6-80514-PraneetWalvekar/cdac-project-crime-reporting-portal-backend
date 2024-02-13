package com.app.controllers;

import com.app.dtos.PSPostDTO;
import com.app.dtos.SHOPostDTO;
import com.app.dtos.TransferDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SP/{sp_id}")
public class SPController {

    @GetMapping("/")
    public ResponseEntity<?> getSPDetails(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/police-staions")
    public ResponseEntity<?> getAllPoliceStations(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/sho")
    public ResponseEntity<?> getAllSHOs(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addSHO")
    public ResponseEntity<?> addSHO(@PathVariable Long sp_id, @RequestBody SHOPostDTO shoAdd)
    {
        return ResponseEntity.ok().build();
    }
    @PostMapping("/addPS")
    public ResponseEntity<?> addPS(@PathVariable Long sp_id, @RequestBody PSPostDTO psAdd)
    {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> transferSHO(@PathVariable Long sp_id, @RequestBody TransferDTO transferDTO)
    {
        return ResponseEntity.ok().build();
    }
}
