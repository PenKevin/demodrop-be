package com.example.demodropbe.controller;

import com.example.demodropbe.dto.ManagementDto;
import com.example.demodropbe.service.ManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ManagementController {

    private final ManagementService mservice;

    public ManagementController(ManagementService mservice) { this.mservice = mservice;}

    @GetMapping("/management")
    public ResponseEntity<Object> getManagers(){
        List<ManagementDto> lm = mservice.getManagement();
        return new ResponseEntity<>(lm, HttpStatus.OK);
    }

    @PostMapping("/management")
    public ResponseEntity<Object> createManagement(@Valid @RequestBody ManagementDto mdto, BindingResult br){
        if (br.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()){
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(),HttpStatus.BAD_REQUEST);
        }
        else {
            mservice.createManagement(mdto);
            return new ResponseEntity<>("Manager aangemaakt", HttpStatus.CREATED);
        }
    }

}
