package io.mario.ratingsdataservice.controller;

import io.mario.ratingsdataservice.model.Rating;
import io.mario.ratingsdataservice.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingDataResource {
    @RequestMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 9);
    }

    @RequestMapping("/users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
//                new Rating("1", 5),
                new Rating("100", 6),
                new Rating("200", 7)
        );
        return new UserRatings(ratings);
    }
}
