package com.example.crudprocesscustomerroom.customerroomcrudprocess.domain;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.CustomerRoomCrudProcessApplication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "room")
    private List<Customer> customers;
}
