package io.mario.movieinfoservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieSummary {
    private String id;
    private String title;
    private String overview;
}
