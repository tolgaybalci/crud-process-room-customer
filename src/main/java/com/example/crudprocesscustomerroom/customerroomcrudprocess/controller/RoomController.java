package com.example.crudprocesscustomerroom.customerroomcrudprocess.controller;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Room;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;

	@GetMapping("")
	public String getRoomList(Model model) {
		model.addAttribute("rooms", roomRepository.findAll());
		return "rooms/roomList";
	}

	@GetMapping("/new")
	public String getNewRoom(Model model) {
		model.addAttribute("room", new Room());
		return "rooms/createRoom";
	}

	@PostMapping("/new")
	public String postNewRoom(@ModelAttribute @Valid Room room, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.warn("New room has errors on binding result");
			return "rooms/createRoom";
		}
		else {
			roomRepository.save(room);
		}
		return "redirect:/rooms";
	}

	@GetMapping("/{id}")
	public String getShowRoom(@PathVariable Long id, Model model) {
		if (!roomRepository.findById(id).isPresent()) {
			log.warn("room with {} id can not be found", id);
		}
		else {
			model.addAttribute("room", roomRepository.findById(id).get());
		}
		return "rooms/showRoom";
	}

	@GetMapping("/{id}/update")
	public String getUpdateRoom(@PathVariable Long id, Model model) {
		if (!roomRepository.findById(id).isPresent()) {
			log.warn("room with {} id can not be found", id);
		}
		else {
			model.addAttribute("room", roomRepository.findById(id).get());
		}
		return "rooms/updateRoom";
	}

	@PostMapping("/{id}/update")
	public String postUpdateRoom(@ModelAttribute @Valid Room room, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.warn("room with id: {} has errors on binding result", room.getId());
			return "rooms/createRoom";
		}
		else {
			roomRepository.save(room);
		}
		return "redirect:/rooms";
	}
}
