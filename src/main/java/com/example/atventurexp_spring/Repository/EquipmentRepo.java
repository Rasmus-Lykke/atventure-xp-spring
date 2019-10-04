package com.example.atventurexp_spring.Repository;

import com.example.atventurexp_spring.Model.Activity;
import com.example.atventurexp_spring.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Long> {

    public List<Equipment> getAllByActivityIDEquals(Long activityId);
}
