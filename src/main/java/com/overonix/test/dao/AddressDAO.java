package com.overonix.test.dao;

import com.overonix.test.entity.Address;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AddressDAO extends CrudRepository<Address, Long> {

    public List<Address> findAddressesByLatitudeAndLongitude(double latitude, double longitude);
}
