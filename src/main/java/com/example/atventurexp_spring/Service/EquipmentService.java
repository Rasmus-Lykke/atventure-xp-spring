package com.example.atventurexp_spring.Service;

import com.example.atventurexp_spring.Model.Equipment;
import com.example.atventurexp_spring.Repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepo equipmentRepo;

    public List<Equipment> getEquipmentListByActivity(Long activityId) {
        return equipmentRepo.getAllByActivityIDEquals(activityId);
    }
}

