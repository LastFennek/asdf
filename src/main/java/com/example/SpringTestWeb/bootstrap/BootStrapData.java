package com.example.SpringTestWeb.bootstrap;

import com.example.SpringTestWeb.Service.HouseService;
import com.example.SpringTestWeb.model.House;
import com.example.SpringTestWeb.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final HouseRepository houseRepository;

    @Autowired
    private HouseService houseService;


    public BootStrapData(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        House bigPlane = new House("hi",2000,11);
        House smallPlane = new House("me",2000,7);

        houseRepository.save(bigPlane);
        houseRepository.save(smallPlane);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Houses: "+ houseRepository.count());

        System.out.println("ShowCount:");
        houseService.showCount();

    }
}
