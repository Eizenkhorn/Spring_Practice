package com.example.practice.controllers;

import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {
    @PostMapping("/deleteInstrument")
    public ResponseEntity<?> deleteInstrument(@RequestParam("ID") int ID, HttpSession session) {
        InstrumentList instrumentList = (InstrumentList) session.getAttribute("instrumentList");
        instrumentList.deleteInstrument(ID);
        return ResponseEntity.ok(instrumentList.getInstrument_list());
    }
}