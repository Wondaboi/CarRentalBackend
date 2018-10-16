package com.vehicleRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private double price;

    private Category(){

    }

    public static class Builder{
        private Integer id;
        private String name;
        private double price;

        public Builder id(Integer value)
        {
            this.id = value;
            return this;
        }
        public Builder name(String value)
        {
            this.name = value;
            return this;
        }
        public Builder price(double value)
        {
            this.price = value;
            return this;
        }
        public Category build()
        {
            return new Category(this);
        }
    }

    public Category(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id == category.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
