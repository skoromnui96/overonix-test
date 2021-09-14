package com.overonix.test.service;

import com.overonix.test.dto.NominatiumAddressDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NominatiumService implements LocationDetailsService {
    private static final String API_URL = "https://nominatim.openstreetmap.org/search?";
    private final RestTemplate restTemplate;

    public NominatiumService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public NominatiumAddressDTO[] getDetailsByAddress(String address) {
        String url = API_URL + "q=" + address +"&format=json";

        return this.restTemplate.getForObject(url, NominatiumAddressDTO[].class);
    }
}
