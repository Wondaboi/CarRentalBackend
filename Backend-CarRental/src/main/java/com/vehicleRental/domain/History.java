package com.vehicleRental.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class History implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Rent rent;

    private boolean rented;
    private boolean outstanding;

    private History(){}

    public History(Builder builder)
    {
        this.id = builder.id;
        this.rent = builder.rent;
        this.rented = builder.rented;
        this.outstanding = builder.outstanding;
    }


    public static class Builder{
        private Integer id;
        private Rent rent;
        private boolean rented;
        private boolean outstanding;


        public Builder id(Integer value)
        {
            this.id = value;
            return this;
        }

        public Builder rent(Rent value)
        {
            this.rent = value;
            return this;
        }

        public Builder rented(boolean value)
        {
            this.rented = value;
            return this;
        }

        public Builder outstanding(boolean value)
        {
            this.outstanding = value;
            return this;
        }

        public History build()
        {
            return new History(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public Rent getRent() {
        return rent;
    }

    public boolean isRented() {
        return rented;
    }

    public boolean isOutstanding() {
        return outstanding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        return id == history.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
