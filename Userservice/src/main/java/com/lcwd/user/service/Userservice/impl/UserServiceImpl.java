package com.lcwd.user.service.Userservice.impl;

import com.lcwd.user.service.Userservice.Services.UserServices;
import com.lcwd.user.service.Userservice.entities.Hotel;
import com.lcwd.user.service.Userservice.entities.Rating;
import com.lcwd.user.service.Userservice.entities.User;
import com.lcwd.user.service.Userservice.exceptions.ResourcesNotfoundeException;
import com.lcwd.user.service.Userservice.externalServices.HotelServices;
import com.lcwd.user.service.Userservice.externalServices.RatingService;
import com.lcwd.user.service.Userservice.repositories.UserReposetories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserReposetories userReposetories;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelServices hotelServices;
    @Autowired
    private RatingService ratingService;

    private Logger logger= LoggerFactory.getLogger(UserServices.class);
    @Override
    public User saveUser(User user) {
       String RandomUserid= UUID.randomUUID().toString();
         user.setId(RandomUserid);
        return userReposetories.save(user);
    }

//    public void Cretaerating(){
//        Rating rating=  Rating.builder().hotelId("").UserId("")
//                        .rating(2).Remark("this fiegn Hotel").build();
//
//
//    }

    @Override
    public User getUser(String UserId) {
        //get user from database

        User user=userReposetories.findById(UserId).orElseThrow(()->
                new ResourcesNotfoundeException("user Id Not Found :"+UserId));

        // Get the ratings
        // http://localhost:8083/user/5af68fda-04af-4853-b1fd-
//        Rating[] forObject =restTemplate.getForObject("http://RATING-SERVICES/ratings/user/"+UserId,
//                Rating[].class);

        Rating[] ratingsArray= ratingService.GetRating(UserId);
        logger.info("{} ",ratingsArray);
        List<Rating> ratings= Arrays.stream(ratingsArray) .map(obj -> (Rating) obj)
                .collect(Collectors.toList());;
        logger.info("{} ",ratings);

        List<Rating> ratingList=ratings.stream().map(rating -> {
            logger.info("hotelId: {}",rating.getHotelId());
            System.out.println("hotelID:is this:---->>>>"+rating.getHotelId());
//            ResponseEntity<Hotel> forEntity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),
//                    Hotel.class);
            Hotel hotel=hotelServices.Gethotel(rating.getHotelId()) ;
            rating.setHotel(hotel);
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);

         return user;

    }

    @Override
    public List<User> getAllUser() {
        return userReposetories.findAll();
    }

    @Override
    public User getbyName(String Name) {
       return null;

    }

    @Override
    public void deletebyid(String userId) {
        userReposetories.deleteById(userId);
    }
}
