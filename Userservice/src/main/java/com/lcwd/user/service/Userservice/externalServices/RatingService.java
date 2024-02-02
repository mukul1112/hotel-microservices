package com.lcwd.user.service.Userservice.externalServices;

import com.lcwd.user.service.Userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICES")
public interface RatingService {
    @GetMapping("ratings/user/{userId}")
    Rating[] GetRating(@PathVariable("userId") String userId);

}
