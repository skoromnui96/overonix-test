package com.overonix.test.service;

import com.overonix.test.dto.AddressDTO;

public interface LocationDetailsService {

    public AddressDTO[] getDetailsByAddress(String address);
}
