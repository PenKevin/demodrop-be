package com.example.demodropbe.service;

import com.example.demodropbe.dto.ProducerDto;
import com.example.demodropbe.model.Producer;

import java.util.List;

public interface ProducerService {
    public List<ProducerDto> getProducers();
    public Producer createProducer(ProducerDto producerDto);

}
