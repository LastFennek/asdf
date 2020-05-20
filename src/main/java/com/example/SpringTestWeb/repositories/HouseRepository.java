package com.example.SpringTestWeb.repositories;

import com.example.SpringTestWeb.model.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Long> {
}
