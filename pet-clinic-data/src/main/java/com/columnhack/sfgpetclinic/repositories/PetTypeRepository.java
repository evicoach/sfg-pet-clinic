package com.columnhack.sfgpetclinic.repositories;

import com.columnhack.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
