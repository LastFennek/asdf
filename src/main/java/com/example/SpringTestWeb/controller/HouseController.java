package com.example.SpringTestWeb.controller;

import com.example.SpringTestWeb.Service.HouseService;
import com.example.SpringTestWeb.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class HouseController {

    @Autowired
    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService){
        this.houseService = houseService;
    }

    @GetMapping("/house/{id}")
    public House getHousebyID(@PathVariable("id") Long id){
        System.out.println(houseService.getHouseByID(id));
        return houseService.getHouseByID(id);
    }

    @DeleteMapping("/house/{id}")
    public void deleteHouseByID(@PathVariable("id") Long id){
        houseService.deleteHouse(id);
    }

    @PostMapping(path = "/house/")
    public void createHouse (@RequestBody House house){
        houseService.addNewHouse(house);
    }

    @PutMapping("/house/")
    public void updateHouse(@RequestBody House house){
        houseService.updateHouse(house);
    }

    @GetMapping("/houses")
    public List<House> showAllHouses(){
        return houseService.allHouses();
    }

}
