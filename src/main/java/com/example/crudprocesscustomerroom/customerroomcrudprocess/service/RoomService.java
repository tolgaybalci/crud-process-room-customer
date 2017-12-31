package com.example.crudprocesscustomerroom.customerroomcrudprocess.service;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on December, 2017
 *
 * @author adilcan
 */
@Slf4j
@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

}
