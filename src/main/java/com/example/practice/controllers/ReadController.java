package com.example.practice.controllers;


import com.example.practice.model.InstrumentList;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller

public class ReadController {
    private InstrumentList instrument_list;
    @PostMapping("/read")
    public ResponseEntity<String> read(@RequestParam("file") MultipartFile File, HttpSession session) {
        if (!File.isEmpty()) {
            if (File.getOriginalFilename().endsWith(".json")) {
                try {
                    byte[] bytes = File.getBytes();

                    instrument_list = new InstrumentList();
                    instrument_list.readFromFile(File);
                    session.setAttribute("instrumentList", instrument_list);
                    return ResponseEntity.status(HttpStatus.FOUND).body("Чтение прошло успшно");
                } catch (IOException e) {
                    e.printStackTrace();

                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при загрузке файла.");
                }
            } else {

                return ResponseEntity.badRequest().body("Ошибка при загрузке файла.");
            }
        } else {

            return ResponseEntity.badRequest().body("Файл не был выбран.");
        }
    }
}