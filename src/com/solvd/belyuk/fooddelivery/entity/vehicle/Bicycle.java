package com.solvd.belyuk.fooddelivery.entity.vehicle;

public class Bicycle extends Vehicle {

    private String size;

    public Bicycle(String brand) {
        super(brand);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bicycle bicycle = (Bicycle) o;

        return size != null ? size.equals(bicycle.size) : bicycle.size == null;
    }

    @Override
    public int hashCode() {
        return size != null ? size.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bicycle{");
        sb.append("size='").append(size).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
