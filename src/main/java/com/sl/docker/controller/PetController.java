package com.sl.docker.controller;

import com.sl.docker.model.Pet;
import com.sl.docker.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetRepository petRepository;


    @PostMapping("/add")
    public ResponseEntity<String> addPet(@RequestBody Pet pet){
        petRepository.save(pet);
        return new ResponseEntity<>("Pet  saved to DB" , HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> petList=petRepository.findAll();
        return new ResponseEntity<>(petList, HttpStatus.OK);
    }

}
