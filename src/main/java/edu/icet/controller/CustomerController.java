package edu.icet.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.CustomerDto;
import org.springframework.web.bind.annotation.*;
import edu.icet.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@Tag(name = "Customer-Controller",description = "Customer API Collection...")
@CrossOrigin
public class CustomerController {

    final private CustomerService service;

    @PostMapping("/add/details")
    public void addCustomer(@RequestBody CustomerDto customer){
        service.addCustomer(customer);
    }

    @PutMapping("/update/details")
    public void updateCustomer(@RequestBody CustomerDto customer){
        service.updateCustomer(customer);
    }

    @DeleteMapping("/delete/details/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
       service.deleteCustomer(customerId);
    }

    @GetMapping("/searchById/{customerId}")
    public CustomerDto searchById(@PathVariable Integer customerId){
        return service.searchById(customerId);
    }

    @GetMapping("/get/details")
    public List<CustomerDto> getAll(){
        return service.getAll();
    }
}
