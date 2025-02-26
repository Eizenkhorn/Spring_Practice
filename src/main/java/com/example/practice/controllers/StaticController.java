package com.example.practice.controllers;

import com.example.practice.model.Instrument;
import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StaticController {
    @PostMapping("/statistic")
    public double calculateMoment(@RequestParam("k") int k, HttpSession session) {
        double sum = 0;
        InstrumentList instrumentList = (InstrumentList) session.getAttribute("instrumentList");
        for (Instrument instrument : instrumentList.getInstrument_list()){

            sum += Math.pow(instrument.getMax(), k);
        }
        return sum / instrumentList.getInstrument_list().size();
    }
}