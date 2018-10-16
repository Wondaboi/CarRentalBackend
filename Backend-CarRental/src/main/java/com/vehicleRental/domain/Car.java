package com.vehicleRental.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String make;
    private String model;
    private int year;
    private String numberPlate;
    private String status;
    private String category;


    //@ManyToOne
    //private Category category;

    private Car(){

    }

    public Car(Builder builder) {
        this.id = builder.id;
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.numberPlate = builder.numberPlate;
        this.category = builder.category;
        this.status = builder.status;
    }

    public static class Builder{
        private Integer id;
        private String make;
        private String model;
        private int year;
        private String numberPlate;
        private String status;
        //private Category category;
        private String category;

        public Builder id(Integer value)
        {
            this.id = value;
            return this;
        }
        public Builder make(String value)
        {
            this.make = value;
            return this;
        }
        public Builder model(String value)
        {
            this.model = value;
            return this;
        }
        public Builder year(int value)
        {
            this.year = value;
            return this;
        }
        public Builder numberPlate(String value)
        {
            this.numberPlate = value;
            return this;
        }
        public Builder status(String value)
        {
            this.status = value;
            return this;
        }
        public Builder category(String value)
        {
            this.category = value;
            return this;
        }
        public Car build()
        {
            return new Car(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String isStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
