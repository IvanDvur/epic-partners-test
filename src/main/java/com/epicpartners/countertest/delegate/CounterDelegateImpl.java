package com.epicpartners.countertest.delegate;

import com.epicpartners.countertest.api.CounterApiDelegate;
import com.epicpartners.countertest.model.CounterRequestDTO;
import com.epicpartners.countertest.model.CounterResponseDTO;
import com.epicpartners.countertest.repositories.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounterDelegateImpl implements CounterApiDelegate {

    private final CounterRepository counterRepository;

    @Override
    public ResponseEntity<CounterResponseDTO> incrementCount(CounterRequestDTO counterRequestDTO) {
        return CounterApiDelegate.super.incrementCount(counterRequestDTO);
    }

    @Override
    public ResponseEntity<CounterResponseDTO> getCount(String counterId) {
        return CounterApiDelegate.super.getCount(counterId);
    }
}
