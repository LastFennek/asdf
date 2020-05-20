package com.example.SpringTestWeb.Service;

import com.example.SpringTestWeb.model.House;
import com.example.SpringTestWeb.repositories.HouseRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouseService {
    private final HouseRepository planeRepository;

    public HouseService(HouseRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    List<House> getAllPlanes(){
        return (List<House>) planeRepository.findAll();
    }

    void addNewPlane(House plane){
        planeRepository.save(plane);
    }

}
