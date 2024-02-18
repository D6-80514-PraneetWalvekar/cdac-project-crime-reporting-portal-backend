package com.app.controllers;

import com.app.dtos.PSPostDTO;
import com.app.dtos.SHOPostDTO;
import com.app.dtos.TransferDTO;
import com.app.services.SPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SP/{sp_id}")
@PreAuthorize("hasRole('SP')")
public class SPController {

    @Autowired
    private SPService spService;

    @GetMapping("/")
    public ResponseEntity<?> getSPDetails(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/police-staions")
    public ResponseEntity<?> getAllPoliceStations(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().body(spService.getAllPoliceStations(sp_id));
    }
    @GetMapping("/sho")
    public ResponseEntity<?> getAllSHOs(@PathVariable Long sp_id)
    {
        return ResponseEntity.ok().body(spService.getAllSHOs(sp_id));
    }

    @PostMapping("/addSHO")
    public ResponseEntity<?> addSHO(@PathVariable Long sp_id, @RequestBody SHOPostDTO shoAdd)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(spService.addSHO(sp_id,shoAdd));
    }
    @PostMapping("/addPS")
    public ResponseEntity<?> addPS(@PathVariable Long sp_id, @RequestBody PSPostDTO psAdd)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(spService.addPS(sp_id, psAdd));
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> transferSHO(@PathVariable Long sp_id, @RequestBody TransferDTO transferDTO)
    {
        TransferDTO dto = spService.transferSHO(sp_id, transferDTO);

        if(dto==null)
            return ResponseEntity.badRequest().body("Invalid SHO and PS");

        return ResponseEntity.ok().body(dto);
    }
}
