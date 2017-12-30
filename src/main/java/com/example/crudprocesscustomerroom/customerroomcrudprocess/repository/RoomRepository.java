package com.example.crudprocesscustomerroom.customerroomcrudprocess.repository;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
}
