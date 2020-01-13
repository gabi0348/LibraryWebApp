package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id")
    private int authorityID;


    @OneToMany(mappedBy = "authority", cascade = CascadeType.ALL)
    private List<Client> clients;

    @Column
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getAuthorityID() {
        return authorityID;
    }

    public void setAuthorityID(int authorityID) {
        this.authorityID = authorityID;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}