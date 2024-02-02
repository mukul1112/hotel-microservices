package com.lcwd.user.service.Userservice.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private  String ratingId;
    private String UserId;
    private String hotelId;
    private String Remark;
    private int rating;
    private Hotel hotel;

}
