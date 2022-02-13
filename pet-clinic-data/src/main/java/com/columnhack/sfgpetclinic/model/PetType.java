/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.columnhack.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author evi
 */
@Entity
@Table(name = "pet_type")
public class PetType  extends BaseEntity{
    @Column(name = "name")
    private String name;

    public PetType(String name) {
        this.name = name;
    }

    public PetType() {
    }

    public static PetTypeBuilder builder() {
        return new PetTypeBuilder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class PetTypeBuilder {
        private String name;

        PetTypeBuilder() {
        }

        public PetTypeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PetType build() {
            return new PetType(name);
        }

        public String toString() {
            return "PetType.PetTypeBuilder(name=" + this.name + ")";
        }
    }
}
