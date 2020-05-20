package com.example.SpringTestWeb.Service;

import com.example.SpringTestWeb.model.House;
import com.example.SpringTestWeb.repositories.HouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@Service
public class HouseService {

    Queue<Integer> q;

    @Autowired
    private HouseRepository houseRepository;


    public HouseService(){
        q = getPrimes();
    }

    public void addNewHouse(House house){
        house.setNumber(q.remove());


        int year = Calendar.getInstance().get(Calendar.YEAR);

        if(house.getYearOfConstruction() > year || house.getYearOfConstruction() < 1800){
            house.setYearOfConstruction(year);
        }

        houseRepository.save(house);
    }

    public void deleteHouse(Long id){
        List<House> x = (List<House>) houseRepository.findAll();
        House toDelete;
        House fml = new House();
        Boolean set = false;

        for(House y : x){
            if(y.getNumber() == id){
                toDelete = y;
                set = true;
                fml = y;
            }
        }
        if(!set){
            return;
        }else{
            toDelete = fml;
        }
        houseRepository.deleteById(toDelete.getId());
    }

    public House getHouseByID(Long id){
        System.out.println("getHouseByID");
        List<House> x = (List<House>) houseRepository.findAll();

        for(House y : x){
            if(y.getNumber() == id){
                return y;
            }
        }
        return null;
    }

    public void updateHouse(House house){
        House toUpdate;
        House fml = new House();

        List<House> x = (List<House>) houseRepository.findAll();

        Boolean set = false;
        for(House y : x){
            if(y.getNumber() == house.getNumber()){
                toUpdate = y;
                fml = y;
                set = true;
            }
        }
        if(!set){
            return;
        }else{
            toUpdate = fml;
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);
        toUpdate.setOwner(house.getOwner());

        if(house.getYearOfConstruction() > year || house.getYearOfConstruction() < 1800){
            house.setYearOfConstruction(year);
        }
        toUpdate.setYearOfConstruction(house.getYearOfConstruction());
    }

    public List<House> allHouses(){
        return (List<House>) houseRepository.findAll();
    }

    public void showCount(){
        System.out.println(houseRepository.count());
    }



    Queue<Integer> getPrimes(){
        //nicht wirklich getestet.
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        BigInteger bigInteger = new BigInteger("5");
        BigInteger bigInteger2 = new BigInteger("2");

        for(int i = 0; i < 50000; i+=2){
            if(bigInteger.isProbablePrime(1)){
                q.add((bigInteger.intValue()));
            }
            bigInteger.add(bigInteger2);

        }


        return q;
    }
}
