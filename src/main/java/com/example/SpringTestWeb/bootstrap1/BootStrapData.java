package com.example.SpringTestWeb.bootstrap1;

import com.example.SpringTestWeb.model1.Plane1;
import com.example.SpringTestWeb.repositories1.PlaneRepository1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final PlaneRepository1 planeRepository;

    public BootStrapData(PlaneRepository1 planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Plane1 bigPlane = new Plane1("bigPlane",100);
        Plane1 smallPlane = new Plane1("smallPlane",20);

        planeRepository.save(bigPlane);
        planeRepository.save(smallPlane);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Planes: "+ planeRepository.count());
    }
}
