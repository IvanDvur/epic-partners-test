package com.epicpartners.countertest.delegate;

import com.epicpartners.countertest.api.CounterApiDelegate;
import com.epicpartners.countertest.model.Counter;
import com.epicpartners.countertest.model.CounterRequestDTO;
import com.epicpartners.countertest.model.CounterResponseDTO;
import com.epicpartners.countertest.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CounterDelegateImpl implements CounterApiDelegate{

    private final CounterService counterService;

    @Override
    public ResponseEntity<CounterResponseDTO> incrementCount(CounterRequestDTO counterRequestDTO) {
        return counterService.incrementCounter(counterRequestDTO);
    }

    public Counter getCounter(String counterId){
        return counterService.getCounter(counterId);
    }

    public List<Counter> getAllCounters(){
        return counterService.getAllCounters();
    }

    @Override
    public ResponseEntity<CounterResponseDTO> getCount(String counterId) {
        CounterResponseDTO responseDTO = counterService.getCount(counterId);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
