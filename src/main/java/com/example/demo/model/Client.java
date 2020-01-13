package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private int clientID;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientID == client.clientID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID);
    }

    @Override
    public String toString() {
        return "Client [id=" + clientID + ", username=" + username + ", password=" + password + "]";
    }
}