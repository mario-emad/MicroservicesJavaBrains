package io.mario.moviecatalogservice.client;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.mario.moviecatalogservice.model.CatalogItem;
import io.mario.moviecatalogservice.model.Movie;
import io.mario.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "movie-info-service", fallbackMethod = "getDefaultMovieInfo")
    @Retry(name = "movie-info-service")
    @Bulkhead(name = "movieInfoBulkhead", type = Bulkhead.Type.THREADPOOL, fallbackMethod = "getDefaultMovieInfo")
    public CatalogItem getMovieInfo(Rating rating) {
        Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem getDefaultMovieInfo(Rating rating, Throwable t) {
        System.err.println("Fallback for MovieInfo triggered: " + t.getMessage());
        return new CatalogItem("Default Name", "Default Description", rating.getRating());
    }
}
