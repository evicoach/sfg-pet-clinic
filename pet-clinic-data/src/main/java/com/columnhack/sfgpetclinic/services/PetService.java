package com.columnhack.sfgpetclinic.services;

import com.columnhack.sfgpetclinic.model.Owner;
import com.columnhack.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByLastName(String lastName);
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
