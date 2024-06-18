package com.sl.docker;

import com.sl.docker.model.Pet;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sl.docker.repository.PetRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DockerDemoApplication {
    @Autowired
    private  PetRepository petRepository;

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

    @PostConstruct
    public String insertDummyData(){
        List<Pet> petList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            petList.add( new Pet(i, "pname"+i, "pbreed"+i,i, new Random().nextFloat() ,"ptype"+i));
        petRepository.saveAll(petList);
        }
        return "data was saved";
    }


}
