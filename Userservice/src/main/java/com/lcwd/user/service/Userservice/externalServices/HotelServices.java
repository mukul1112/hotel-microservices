package com.lcwd.user.service.Userservice.externalServices;

import com.lcwd.user.service.Userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {

    @GetMapping("/hotels/{hotelId}")
    Hotel Gethotel(@PathVariable("hotelId") String hotelId);


}
