package com.vehicleRental.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.persistence.criteria.Order;


@Entity
public class Rent implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String model;
    private String category;
    private String rentDate;
    private String customerName;
    private BigDecimal totalPrice;
    private int rentalDays;
    private String status;
    
    private Rent(){};

    public Integer getId() {
        return id;
    }
    public String getRentDate() {
        return rentDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public int getRentalDays() {
        return rentalDays;
    }
    public String getStatus() {
        return status;
    }

    public Rent(Builder builder)
    {

        this.id = builder.id;
        this.model = builder.model;
        this.category = builder.category;
        this.rentDate = builder.rentDate;
        this.customerName = builder.customerName;
        this.totalPrice = builder.totalPrice;
        this.rentalDays = builder.rentalDays;
        this.status = builder.status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public void setCustomerName(String customerName) {
        customerName = customerName;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public void setStatus(String status) {
        status = status;
    }

    public static  class Builder {
        private Integer id;
        private String model;
        private String category;
        private String rentDate;
        private String customerName;
        private BigDecimal totalPrice;
        private int rentalDays;
        private String status;

        public Builder status(String value)
        {
            this.status = value;
            return this;
        }
        public Builder model(String value)
        {
            this.model = value;
            return this;
        }
        public Builder category(String value)
        {
            this.category = value;
            return this;
        }
        public Builder rentalDays(int value)
        {
            this.rentalDays = value;
            return this;
        }

        public Builder id(Integer value) {
            this.id = value;
            return this;
        }

        public Builder rentDate(String value) {
            this.rentDate = value;
            return this;
        }

        public Builder customerName(String value) {
            this.customerName = value;
            return this;
        }

        public Builder totalPrice(BigDecimal value) {
            this.totalPrice = value;
            return this;
        }

        public Rent build() {
            return new Rent(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        return id.equals(rent.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
