package com.example.practice.controllers;

import com.example.practice.model.Instrument;
import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateController {
    @PostMapping("/createInstrument")
    public ResponseEntity<?> addInstrument(@RequestBody Instrument instrument, HttpSession session) {
        InstrumentList instrumentList = (InstrumentList) session.getAttribute("instrumentList");
        instrumentList.addInstrument(instrument);
        session.setAttribute("instrumentList", instrumentList);
        return ResponseEntity.ok(instrumentList.getInstrument_list());
    }
}