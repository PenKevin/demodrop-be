package com.example.demodropbe.controller;

import com.example.demodropbe.dto.ProducerDto;
import com.example.demodropbe.service.ProducerService;
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
public class ProducerController {

    private final ProducerService service;

    public ProducerController(ProducerService service) { this.service = service;}

    @GetMapping("/producers")
    public ResponseEntity<Object> getProducer(){
        List<ProducerDto> lp = service.getProducers();
        return new ResponseEntity<>(lp, HttpStatus.OK);
    }

    @PostMapping("/producers")
    public ResponseEntity<Object> createProducer(@Valid @RequestBody ProducerDto pdto, BindingResult br){
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()){
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        else {
            service.createProducer(pdto);
            return new ResponseEntity<>("Account aangemaakt.", HttpStatus.CREATED);
        }
    }
}
