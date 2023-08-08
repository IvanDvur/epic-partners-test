package com.epicpartners.countertest.controllers;

import com.epicpartners.countertest.delegate.CounterDelegateImpl;
import com.epicpartners.countertest.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AllCountersControllers {

    private final CounterDelegateImpl counterDelegate;

    @GetMapping
    public String getAllCounters(Model model){
        model.addAttribute("allCounters",counterDelegate.getAllCounters());
        return "allcounters";
    }
}
