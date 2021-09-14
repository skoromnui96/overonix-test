package com.overonix.test.service;

import com.overonix.test.dao.AddressDAO;
import com.overonix.test.dto.AddressDTO;
import com.overonix.test.entity.Address;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    private AddressDAO addressDAO;
    private LocationDetailsService locationDetailsService;

    public AddressService(
            AddressDAO addressDAO,
            LocationDetailsService locationDetailsService
    ) {
        this.addressDAO = addressDAO;
        this.locationDetailsService = locationDetailsService;
    }

    @Cacheable(cacheNames = "address")
    public List<Address> getDetailsByAddress(String address) {
        return this.createAddresses(locationDetailsService.getDetailsByAddress(address));
    }

    @Cacheable(cacheNames = "coordinates")
    public List<Address> getAddressesByCoordinates(double latitude, double longitude) {
        return addressDAO.findAddressesByLatitudeAndLongitude((double) latitude,(double) longitude);
    }

    private List<Address> createAddresses(AddressDTO[] locationsInfoList) {
        ArrayList<Address> addresses = new ArrayList<>();

        for (AddressDTO locationInfo: locationsInfoList) {
            Address address = new Address(
                    locationInfo.getTitle(),
                    locationInfo.getLatitude(),
                    locationInfo.getLongitude()
            );

            addresses.add(address);
        }

        addressDAO.saveAll(addresses);

        return addresses;
    }
}
