package com.example.crudprocesscustomerroom.customerroomcrudprocess.controller;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Customer;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.CustomerRepository;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("")
    public String getCustomerList(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/customerList";
    }

    @RequestMapping("/new")
    public String getNewCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("rooms",roomRepository.findAll());
        return "customers/newCustomer";
    }

    @PostMapping("/new")
    public String postNewCustomer(@ModelAttribute Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}")
    public String getShowCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerRepository.findById(id).get());
        return "customers/showCustomer";
    }

    @GetMapping("/{id}/update")
    public String getUpdateCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer",customerRepository.findById(id).get());
        return "customers/updateCustomer";
    }

    @PostMapping("/{id}/update")
    public String postUpdateCustomer(@ModelAttribute Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}
