package com.columnhack.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Owner(String address, String city, String telephone, Set<Pet> pets) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public Owner() {
    }

    public static OwnerBuilder builder() {
        return new OwnerBuilder();
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public static class OwnerBuilder {
        private String address;
        private String city;
        private String telephone;
        private Set<Pet> pets;

        OwnerBuilder() {
        }

        public OwnerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public OwnerBuilder city(String city) {
            this.city = city;
            return this;
        }

        public OwnerBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public OwnerBuilder pets(Set<Pet> pets) {
            this.pets = pets;
            return this;
        }

        public Owner build() {
            return new Owner(address, city, telephone, pets);
        }

        public String toString() {
            return "Owner.OwnerBuilder(address=" + this.address + ", city=" + this.city + ", telephone=" + this.telephone + ", pets=" + this.pets + ")";
        }
    }
}
