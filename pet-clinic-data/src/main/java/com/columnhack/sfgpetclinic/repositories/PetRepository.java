package com.columnhack.sfgpetclinic.repositories;

import com.columnhack.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
