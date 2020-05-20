package com.example.SpringTestWeb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String owner;
    private int yearOfConstruction;
    private int number;

    public House(){}

    public House(@JsonProperty("owner") String owner,
                 @JsonProperty("year") int yearOfConstruction,
                 @JsonProperty("number") int number) {
        this.owner = owner;
        this.yearOfConstruction = yearOfConstruction;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        return id != null ? id.equals(house.id) : house.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", yearOfConstruction=" + yearOfConstruction +
                ", number=" + number +
                '}';
    }
}
