package com.columnhack.sfgpetclinic.services.springdatajpa;

import com.columnhack.sfgpetclinic.model.Speciality;
import com.columnhack.sfgpetclinic.repositories.SpecialtyRepository;
import com.columnhack.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class VetSpecialitySDJpaService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public VetSpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
