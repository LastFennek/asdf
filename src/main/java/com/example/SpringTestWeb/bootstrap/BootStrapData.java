package com.example.SpringTestWeb.bootstrap;

import com.example.SpringTestWeb.model.House;
import com.example.SpringTestWeb.repositories.HouseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final HouseRepository planeRepository;

    public BootStrapData(HouseRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        House bigPlane = new House("bigPlane",100);
        House smallPlane = new House("smallPlane",20);

        planeRepository.save(bigPlane);
        planeRepository.save(smallPlane);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Planes: "+ planeRepository.count());
    }
}
