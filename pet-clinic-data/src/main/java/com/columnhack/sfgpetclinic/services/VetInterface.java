package com.columnhack.sfgpetclinic.services;

import com.columnhack.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetInterface {
    Vet findByLastName(String lastName);
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
