package com.example.practice.controllers;

import com.example.practice.model.Instrument;
import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.*;

@RestController
public class ViewController {
    @PostMapping("/view")
    public Instrument viewInstrument(@RequestParam("ID") int ID, HttpSession session) {
        InstrumentList instrumentList = (InstrumentList) session.getAttribute("instrumentList");
        return instrumentList.findInstrument(ID);
    }
}
