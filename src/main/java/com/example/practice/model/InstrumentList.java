package com.example.practice.model;

import java.util.*;
import java.io.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.multipart.MultipartFile;

public class InstrumentList {
    private List<Instrument> Instrument_list = new ArrayList<>();
    public List<Instrument> getInstrument_list() {
        return Instrument_list;
    }
    public void setInstrument_list(List<Instrument> Instrument_list) {
        this.Instrument_list = (ArrayList<Instrument>) Instrument_list;
    }
    public void addInstrument(Instrument instrument) {
        Instrument_list.add(instrument);
    }
    public Instrument findInstrument(int ID) {
        for (Instrument instrument : Instrument_list) {
            if (instrument.getID()==ID) {
                return instrument;
            }
        }
        return null;
    }
    public void deleteInstrument(int ID){
        Instrument foundInstrument = findInstrument(ID);
        if (foundInstrument != null) {
            Instrument_list.remove(foundInstrument);
        } else {
            System.out.println("Прибор не найден");
        }
    }

    public void writeInFile(OutputStream outputStream){
        try {

            if (Instrument_list == null) {
                System.out.println("Список инструментов пуст.");
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            byte[] jsonData = mapper.writeValueAsBytes(Instrument_list);
            outputStream.write(jsonData);
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromFile(MultipartFile file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            InputStream inputStream = file.getInputStream();

            List<Instrument> instruments = mapper.readValue(inputStream, new TypeReference<List<Instrument>>(){});

            Instrument_list.addAll(instruments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instrument_list:\n");
        for (Instrument instrument : Instrument_list) {
            sb.append("ID: ").append(instrument.getID()).append("\n");
            sb.append("Name: ").append(instrument.getName()).append("\n");
            sb.append("Unit: ").append(instrument.getUnit()).append("\n");
            sb.append("Value of Division: ").append(instrument.getValue()).append("\n");
            sb.append("Sensitivity: ").append(instrument.getSensetivity()).append("\n");
            sb.append("Max: ").append(instrument.getMax()).append("\n\n");
        }
        return sb.toString();
    }

}