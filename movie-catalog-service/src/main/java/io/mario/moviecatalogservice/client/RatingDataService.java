package io.mario.moviecatalogservice.client;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.mario.moviecatalogservice.model.Rating;
import io.mario.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingDataService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "rating-data-service", fallbackMethod = "getDefaultUserRatings")
    @Retry(name = "rating-data-service")
    @Bulkhead(name = "ratingDataBulkhead", type = Bulkhead.Type.THREADPOOL, fallbackMethod = "getDefaultUserRatings")
    public UserRatings getUserRatings(String userId) {
        return restTemplate.getForObject("http://RATINGS-DATA-SERVICE/rating/users/" + userId, UserRatings.class);
    }

    public UserRatings getDefaultUserRatings(String userId, Throwable t) {
        System.err.println("Fallback for UserRatings triggered: " + t.getMessage());
        return new UserRatings(List.of(new Rating(userId, 0)));
    }
}
