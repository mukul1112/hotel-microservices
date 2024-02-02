package com.lcwd.rating.RatingServices.controller;

import com.lcwd.rating.RatingServices.entities.Rating;
import com.lcwd.rating.RatingServices.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingService;

    //Create
    @PostMapping()
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating rating1=ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }


    //get by hotel id
    @GetMapping ("/hotels/{HotelId}")
    public ResponseEntity<List<Rating>>  getRatingByHotelID(@PathVariable String HotelId){
        return ResponseEntity.ok(ratingService.getByHotelId(HotelId));
    }

    //get all ratings
    @GetMapping ()
    public ResponseEntity<List<Rating>>  getAllRatings(){
        return ResponseEntity.ok(ratingService.getRating());
    }


    //get by userid
    @GetMapping ("user/{UserId}")
    public ResponseEntity<List<Rating>>  getRatingByUserId(@PathVariable String UserId){
        return ResponseEntity.ok(ratingService.getByuserId(UserId));
    }
}
