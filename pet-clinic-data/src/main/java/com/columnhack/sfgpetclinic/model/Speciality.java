package com.columnhack.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{
    @Column(name = "description")
    private String description;

    public Speciality(String description) {
        this.description = description;
    }

    public Speciality() {
    }

    public static SpecialityBuilder builder() {
        return new SpecialityBuilder();
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class SpecialityBuilder {
        private String description;

        SpecialityBuilder() {
        }

        public SpecialityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Speciality build() {
            return new Speciality(description);
        }

        public String toString() {
            return "Speciality.SpecialityBuilder(description=" + this.description + ")";
        }
    }
}
