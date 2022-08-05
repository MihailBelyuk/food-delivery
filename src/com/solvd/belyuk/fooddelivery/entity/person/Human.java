package com.solvd.belyuk.fooddelivery.entity.person;

import com.solvd.belyuk.fooddelivery.entity.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Human implements ICountTimePeriod {

    private String name;
    private LocalDate dateOfBirth;
    private Address address;

    public Human(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int countYears() {
        return LocalDateTime.now().getYear() - getDateOfBirth().getYear();
    }

    @Override
    public int countMonths() {
        return 0;
    }

    @Override
    public int countDays() {
        return 0;
    }

    @Override
    public int countHours() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(human.dateOfBirth) : human.dateOfBirth != null) return false;
        return address != null ? address.equals(human.address) : human.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Human{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}


