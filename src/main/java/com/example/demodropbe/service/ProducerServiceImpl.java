package com.example.demodropbe.service;

import com.example.demodropbe.dto.ProducerDto;
import com.example.demodropbe.model.Producer;
import com.example.demodropbe.repository.ProducerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService{

    private ProducerRepository repos;


    public ProducerServiceImpl(ProducerRepository repos) {this.repos = repos;}

    @Override
    public List<ProducerDto> getProducers() {
        List<Producer> lp = this.repos.findAll();
        List<ProducerDto> producers = new ArrayList<>();

        lp.forEach(p -> producers.add(new ProducerDto(p.getId(),p.getFirstName(),p.getLastName(),p.getAdres(),p.getPostcode(),p.getCity(),p.getCountry(),p.getEmail(),p.getUsername(),p.getPassword())));

        return producers;
    }

    @Override
    public Producer createProducer(ProducerDto producerDto) {
        Producer p = new Producer();
        p.setFirstName(producerDto.getFirstName());
        p.setLastName(producerDto.getLastName());
        p.setAdres(producerDto.getAdres());
        p.setPostcode(producerDto.getPostcode());
        p.setCity(producerDto.getCity());
        p.setCountry(producerDto.getCountry());
        p.setEmail(producerDto.getEmail());
        p.setUsername(producerDto.getUsername());
        p.setPassword(producerDto.getPassword());
        return this.repos.save(p);
    }

}
