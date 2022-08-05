package com.solvd.belyuk.fooddelivery.entity.person;

import com.solvd.belyuk.fooddelivery.entity.vehicle.Car;

import java.time.LocalDate;

public class Director extends Employee {

    private Car car;

    public Director(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Director director = (Director) o;

        return car != null ? car.equals(director.car) : director.car == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
