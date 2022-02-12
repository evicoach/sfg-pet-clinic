package com.columnhack.sfgpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{
    private LocalDate date;
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit(LocalDate date, String description, Pet pet) {
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    public Visit() {
    }

    public static VisitBuilder builder() {
        return new VisitBuilder();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public static class VisitBuilder {
        private LocalDate date;
        private String description;
        private Pet pet;

        VisitBuilder() {
        }

        public VisitBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public VisitBuilder description(String description) {
            this.description = description;
            return this;
        }

        public VisitBuilder pet(Pet pet) {
            this.pet = pet;
            return this;
        }

        public Visit build() {
            return new Visit(date, description, pet);
        }

        public String toString() {
            return "Visit.VisitBuilder(date=" + this.date + ", description=" + this.description + ", pet=" + this.pet + ")";
        }
    }
}
