package com.columnhack.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialties = new HashSet<>();

    public Vet(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    public Vet() {
    }

    public static VetBuilder builder() {
        return new VetBuilder();
    }

    public Set<Speciality> getSpecialties() {
        return this.specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    public static class VetBuilder {
        private Set<Speciality> specialties;

        VetBuilder() {
        }

        public VetBuilder specialties(Set<Speciality> specialties) {
            this.specialties = specialties;
            return this;
        }

        public Vet build() {
            return new Vet(specialties);
        }

        public String toString() {
            return "Vet.VetBuilder(specialties=" + this.specialties + ")";
        }
    }
}
