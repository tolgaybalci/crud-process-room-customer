package com.example.crudprocesscustomerroom.customerroomcrudprocess.controller;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Room;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("")
    public String getRoomList(Model model){
        model.addAttribute("rooms", roomRepository.findAll());
        return "rooms/roomList";
    }

    @GetMapping("/new")
    public String getNewRoom(Model model){
        model.addAttribute("room", new Room());
        return "rooms/createRoom";
    }

    @PostMapping("/new")
    public String postNewUser(@ModelAttribute Room room){
        roomRepository.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/{id}")
    public String getShowRoom(@PathVariable Long id, Model model){
        model.addAttribute("room", roomRepository.findById(id).get());
        return "rooms/showRoom";
    }

    @GetMapping("/{id}/update")
    public String getUpdateRoom(@PathVariable Long id, Model model){
        model.addAttribute("room", roomRepository.findById(id).get());
        return "rooms/updateRoom";
    }

    @PostMapping("/{id}/update")
    public String postUpdateRoom(@ModelAttribute Room room){
        roomRepository.save(room);
        return "redirect:/rooms";
    }
}
