package com.lcwd.rating.RatingServices.repository;

import com.lcwd.rating.RatingServices.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepositories extends MongoRepository<Rating,String> {

      // custom finder Method

      List<Rating> findByUserId(String userId);
      List<Rating> findByHotelId(String hotelId);

}
