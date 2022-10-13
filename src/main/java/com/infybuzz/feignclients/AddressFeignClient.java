package com.infybuzz.feignclients;

import com.infybuzz.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address-service", path = "/api/address")
public interface AddressFeignClient {

    @GetMapping("getById/{id}")
    AddressResponse getById(@PathVariable long id);
}
