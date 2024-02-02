package com.lcwd.rating.RatingServices.impl;

import com.lcwd.rating.RatingServices.entities.Rating;
import com.lcwd.rating.RatingServices.repository.RatingRepositories;
import com.lcwd.rating.RatingServices.service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RatingServiceImpl implements RatingServices {

   @Autowired
       private RatingRepositories ratingRepositories;

    @Override
    public Rating create(Rating rating) {
        return ratingRepositories.save(rating);
    }

    @Override
    public List<Rating> getRating() {

        return ratingRepositories.findAll();
    }

    @Override
    public List<Rating> getByuserId(String id) {

        return  ratingRepositories.findByUserId(id);
    }

    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return ratingRepositories.findByHotelId(hotelId);
    }
}
