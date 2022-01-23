package com.columnhack.sfgpetclinic.services;

import com.columnhack.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
