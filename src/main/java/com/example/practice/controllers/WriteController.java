package com.example.practice.controllers;

import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
@RestController
public class WriteController {

    @GetMapping("/write")
    public ResponseEntity<?> write(HttpSession session) {
        InstrumentList instrument_list = (InstrumentList) session.getAttribute("instrumentList");
        if (instrument_list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Данные не загружены на сайт");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        instrument_list.writeInFile(outputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData("attachment", "File2.json");
        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }
}