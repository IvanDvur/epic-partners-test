package com.epicpartners.countertest.service;

import com.epicpartners.countertest.model.Counter;
import com.epicpartners.countertest.model.CounterRequestDTO;
import com.epicpartners.countertest.model.CounterResponseDTO;
import com.epicpartners.countertest.repositories.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    private final CounterRepository counterRepository;

    public ResponseEntity<CounterResponseDTO> incrementCounter(CounterRequestDTO requestDTO) {
        Optional<Counter> optCounter = counterRepository.findById(requestDTO.getCounterId());
        if (optCounter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Set<ConstraintViolation<CounterRequestDTO>> violations = validator.validate(requestDTO);
        if(!violations.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Counter c = optCounter.get();
        Integer prevValue = c.getValue();
        c.setValue(prevValue + requestDTO.getIncrementCount());
        counterRepository.save(c);
        return ResponseEntity.ok(new CounterResponseDTO().value(c.getValue()));
    }

    public CounterResponseDTO getCount(String counterId){
        Optional<Counter> optCounter = counterRepository.findById(counterId);
        if (optCounter.isEmpty()) {
            return null;
        }
        Counter c = optCounter.get();
        Integer value = c.getValue();
        return new CounterResponseDTO().value(value);
    }

    public Counter getCounter(String counterId){
        Optional<Counter> optCounter = counterRepository.findById(counterId);
        return optCounter.orElse(null);
    }


    public List<Counter> getAllCounters(){
        return counterRepository.findAll();
    }
}
