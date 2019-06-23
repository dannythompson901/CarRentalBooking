package com.dannythompsondev.bookings.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
    @Id
    @Column(name = "VEHICLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;
    @Column(name = "VEHICLE_MODEL")
    private String vehicleModel;
    @Column(name = "NUMBER_OF_PASSENGERS")
    private String numberOfPassangers;
    @Column(name = "NUMBER_OF_KILOMETERS")
    private String numberOfKilometers;
    @Column(name = "PRODUCTION_YEAR")
    private String productionYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getNumberOfPassangers() {
        return numberOfPassangers;
    }

    public void setNumberOfPassangers(String numberOfPassangers) {
        this.numberOfPassangers = numberOfPassangers;
    }

    public String getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(String numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }
}
