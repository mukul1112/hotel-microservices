package com.lcwd.rating.RatingServices.service;

import com.lcwd.rating.RatingServices.entities.Rating;

import java.util.List;

public interface RatingServices {
    // Create

    Rating  create( Rating rating );

    // get all ratings
     List<Rating> getRating();

    // get all by user
    List<Rating> getByuserId(String id);

    // get by hotel
    List<Rating> getByHotelId(String hotelId);


}
