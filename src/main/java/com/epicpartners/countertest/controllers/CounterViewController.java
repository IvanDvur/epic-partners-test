package com.epicpartners.countertest.controllers;

import com.epicpartners.countertest.api.CounterApiController;
import com.epicpartners.countertest.api.CounterApiDelegate;
import com.epicpartners.countertest.delegate.CounterDelegateImpl;
import com.epicpartners.countertest.model.CounterRequestDTO;
import com.epicpartners.countertest.model.CounterResponseDTO;
import com.epicpartners.countertest.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/counter")
@RequiredArgsConstructor
public class CounterViewController{

    private final CounterDelegateImpl counterApiDelegate;

    @GetMapping("/view")
    public String getCounterView(Model model, @RequestParam("counterId") String counterId){
        model.addAttribute("counter",counterApiDelegate.getCounter(counterId));
        return "counter";
    }

    @PostMapping
    public String incrementCounter(@ModelAttribute("request") CounterRequestDTO dto){
        counterApiDelegate.incrementCount(dto);
        return "allcounters";
    }

}
