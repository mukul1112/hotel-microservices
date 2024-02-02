package com.lcwd.hotel.HotelServices.controller;

import com.lcwd.hotel.HotelServices.Services.HotelService;
import com.lcwd.hotel.HotelServices.Services.imp.HotelServiceImpl;
import com.lcwd.hotel.HotelServices.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hotels")
public class Hotelcontroller {

    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping()
    public ResponseEntity<Hotel> CreateHotel(@RequestBody Hotel hotel){
        Hotel hotel1=hotelService.Create(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

    }

    //getHotel
    @GetMapping()
    public ResponseEntity<List<Hotel>> getHotel(){
        List<Hotel> hotel2=hotelService.GetAll();

        return ResponseEntity.ok(hotel2);

    }
    //getByid
    @GetMapping("/{HoteId}")
    public ResponseEntity<Hotel> CreateHotel(@PathVariable  String HoteId){
        Hotel hotel1=hotelService.GetHotelByID(HoteId);

        return ResponseEntity.ok(hotel1);

    }
    @DeleteMapping("/{HoteId}")
        public ResponseEntity<Hotel> DeleteHotel(@PathVariable  String HoteId){
            hotelService.Deltebyid(HoteId);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }


}
