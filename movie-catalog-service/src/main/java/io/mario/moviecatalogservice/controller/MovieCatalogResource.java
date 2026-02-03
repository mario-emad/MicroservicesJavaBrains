package io.mario.moviecatalogservice.controller;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.retry.annotation.Retry;
import io.mario.moviecatalogservice.client.MovieInfoService;
import io.mario.moviecatalogservice.client.RatingDataService;
import io.mario.moviecatalogservice.model.CatalogItem;
import io.mario.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private RatingDataService ratingDataService;

//    @Autowired
//    private DiscoveryClient discoveryClient; // to make the loadBalancing in the client side

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRatings userRatings = ratingDataService.getUserRatings(userId);
        return userRatings.getRatings().stream().map(rating -> movieInfoService.getMovieInfo(rating)).toList();
    }

    public List<CatalogItem> getDefaultCatalog(@PathVariable("userId") String userId, Throwable t) {
        System.err.println("Fallback for Catalog triggered: " + t.getMessage());
        return List.of(new CatalogItem("Default Name", "Default Description", 0));
    }
}
