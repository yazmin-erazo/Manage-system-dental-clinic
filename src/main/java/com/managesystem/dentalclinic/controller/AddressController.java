package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.Address;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
import com.managesystem.dentalclinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address){
        addressService.createAddress(address);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddress(@PathVariable Integer id) throws ResourceNotFoundException {
        return addressService.readAddress(id);
    }

    @PutMapping
    public ResponseEntity<?> modifyAddress(@RequestBody Address address) throws ResourceNotFoundException {
        addressService.updateAddress(address);
        return ResponseEntity.ok("Dirección actualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAddress(@PathVariable Integer id) throws ResourceNotFoundException {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Dirección eliminada");
    }

    @GetMapping
    public Collection<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

}
