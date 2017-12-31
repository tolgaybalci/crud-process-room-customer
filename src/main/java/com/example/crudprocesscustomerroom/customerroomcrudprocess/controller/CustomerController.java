package com.example.crudprocesscustomerroom.customerroomcrudprocess.controller;

import com.example.crudprocesscustomerroom.customerroomcrudprocess.domain.Customer;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.CustomerRepository;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.repository.RoomRepository;
import com.example.crudprocesscustomerroom.customerroomcrudprocess.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/customerList";
    }

    @GetMapping("/new")
    public String getNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("rooms", roomRepository.findAll());
        return "customers/newCustomer";
    }

    @PostMapping("/new")
    public String postNewCustomer(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.warn("Customer with {} id is not found", customer.getId());
            return "customers/newCustomer";
        } else {
            customerService.create(customer);
        }
        return "redirect:/customers";
    }

    @GetMapping("/{id}")
    public String getShowCustomer(@PathVariable Long id, Model model) {
        if (!customerRepository.findById(id).isPresent()) {
            log.warn("Customer with {} id is not found.", id);
        } else {
            model.addAttribute("customer", customerRepository.findById(id).get());
        }
        return "customers/showCustomer";
    }

    @GetMapping("/{id}/update")
    public String getUpdateCustomer(@PathVariable Long id, Model model) {
        if (!customerRepository.findById(id).isPresent()) {
            log.warn("Customer with {} id is not found", id);
        } else {
            model.addAttribute("customer", customerRepository.findById(id).get());
        }
        return "customers/updateCustomer";
    }

    @PostMapping("/{id}/update")
    public String postUpdateCustomer(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.warn("Customer with {} id is not found", customer.getId());
            return "customers/updateCustomer";
        } else {
            customerRepository.save(customer);
        }
        return "redirect:/customers";
    }
}
