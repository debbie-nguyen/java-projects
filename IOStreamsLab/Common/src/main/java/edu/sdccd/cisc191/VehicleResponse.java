package edu.sdccd.cisc191;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleResponse {
    private VehicleRequest request;
    private int milesOnVehicle;
    private int price;
    private int numberOfSeats;
    private int numberOfDoors;
    private String[] options;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSON(VehicleResponse vehicle) throws Exception {
        return objectMapper.writeValueAsString(vehicle);
    }

    public static VehicleResponse fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, VehicleResponse.class);
    }

    protected VehicleResponse() {}

    public VehicleResponse(VehicleRequest request, int milesOnVehicle,int price, int numberOfSeats, int numberOfDoors,String[] options) {
        this.request = request;
        this.milesOnVehicle = milesOnVehicle;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.options = options;
    }

    @Override
    public String toString() {
        return String.format(
                "Vehicle request:[miles=%d, price=%d, number of seats=%d,number of doors=%d, option='%s']",
                milesOnVehicle, price, numberOfSeats, numberOfDoors, options);
    }

    public VehicleRequest getRequest() {
        return request;
    }
    public int getMilesOnVehicle() {
        return milesOnVehicle;
    }
    public int getPrice(){
        return price;
    }
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public String[] getOptions() {
        return options;
    }

    public void setRequest(VehicleRequest request) {
        this.request = request;
    }
    public void setMilesOnVehicle(int milesOnVehicle) {
        this.milesOnVehicle = milesOnVehicle;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}