package com.example.practice.controllers;

import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class InfoController {
    @GetMapping("/info")
    public ResponseEntity<?> Info(HttpSession session) {
        InstrumentList instrumentList = (InstrumentList) session.getAttribute("instrumentList");
        Map<String, Object> information = new HashMap<>();
        information.put("name", "Instrument");
        information.put("author", "Alexandr Titov");
        information.put("email","Sashatitov32@gmail.com");
        if (instrumentList != null) {
            information.put("Instruments", instrumentList.getInstrument_list());
        }
        else {
            information.put("Instruments", "отсутствуют");
        }
        return ResponseEntity.ok(information);
    }
}