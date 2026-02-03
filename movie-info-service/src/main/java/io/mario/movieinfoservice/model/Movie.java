package io.mario.movieinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Movie {
    private String movieId;
    private String name;
    private String description;
}
