package io.mario.ratingsdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UserRatings {
    private List<Rating> ratings;
}
