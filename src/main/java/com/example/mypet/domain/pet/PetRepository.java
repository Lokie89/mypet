package com.example.mypet.abandoned.domain.pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findAllById(int id);
}
