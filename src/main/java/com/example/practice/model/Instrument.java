package com.example.practice.model;

public class Instrument {
    private  int ID;
    private  String name;
    private  String Unit;
    private  double Value_of_division;
    private  double Sensetivity;
    private  int Max;
    public Instrument(int ID, String name, String Unit, double Value_of_division, double Sensetivity, int Max) {
        this.ID = ID;
        this.name = name;
        this.Unit = Unit;
        this.Value_of_division = Value_of_division;
        this.Sensetivity = Sensetivity;
        this.Max = Max;
    }
    public Instrument(){

    }

    public  int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }
    public  double getValue() {
        return Value_of_division;
    }

    public void setValue(double Value_of_division) {
        this.Value_of_division = Value_of_division;
    }
    public  double getSensetivity() {
        return Sensetivity;
    }

    public void setSensetivity(double Sensetivity) {
        this.Sensetivity = Sensetivity;
    }
    public  int getMax() {
        return Max;
    }
    public void setMax(int Max) {
        this.Max = Max;
    }
    public void print(){
        System.out.println(this.ID);
        System.out.println(this.name);
        System.out.println(this.Unit);
        System.out.println(this.Value_of_division);
        System.out.println(this.Sensetivity);
        System.out.println(this.Max);
    }
    public String toString() {
        return "Instrument:"+name+" Id:"+ID+" Unit:"+Unit+" Value_of_division:"+Value_of_division+" Sensevity:"+Sensetivity+" max:"+Max;
    }

}

