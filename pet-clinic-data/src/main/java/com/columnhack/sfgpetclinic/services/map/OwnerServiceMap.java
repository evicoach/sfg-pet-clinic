package com.columnhack.sfgpetclinic.services.map;

import com.columnhack.sfgpetclinic.model.Owner;
import com.columnhack.sfgpetclinic.model.Pet;
import com.columnhack.sfgpetclinic.services.OwnerService;
import com.columnhack.sfgpetclinic.services.PetService;
import com.columnhack.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) return null;
        if (object.getPets() == null) return null;
        object.getPets().forEach(pet -> {
            if (pet.getPetType() == null) throw new RuntimeException("Pet Type is required");
            if (pet.getPetType().getId() == null) {
                pet.setPetType(petTypeService.save(pet.getPetType()));
            }
            if (pet.getId() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });

        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
//        return this.findAll().stream()
//                .filter(owner -> owner.getLastName()
//                        .equals(lastName)).toList().get(0);
        return this.findAll().stream()
                .filter(owner -> owner.getLastName()
                        .equalsIgnoreCase(lastName))
                .findFirst().orElse(null);

    }
}
