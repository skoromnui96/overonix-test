package com.overonix.test.controller;

import com.overonix.test.entity.Address;
import com.overonix.test.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/search-by-address")
    public List<Address> search(@RequestParam("address") String address) {
        return addressService.getDetailsByAddress(address);
    }

    @GetMapping("/search-by-coordinates")
    public List<Address> searchByCoordinates(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude
    ) {
        return addressService.getAddressesByCoordinates(latitude, longitude);
    }
}
