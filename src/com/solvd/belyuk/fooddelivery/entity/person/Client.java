package com.solvd.belyuk.fooddelivery.entity.person;

import java.time.LocalDate;

public class Client extends Human {

    private long clientId;

    public Client(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return clientId == client.clientId;
    }

    @Override
    public int hashCode() {
        return (int) (clientId ^ (clientId >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("clientId=").append(clientId);
        sb.append('}');
        return sb.toString();
    }
}
