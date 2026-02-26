# MicroservicesJavaBrains

**Notes:**

- To refresh the configurations server values in runtime just call <u><B><i>POST</i></B></U> **http://localhost:8101/actuator/refresh** API with adding the **@RefreshScope** annotation to the controller that have the properties which we need to update its values.
- To check the health of the application is and if it "Up" and running correctly or "Down" due to an issue: http://localhost:8101/actuator/health with adding the (**management.endpoint.health.show-details=always**) to properties file.
- Links
  - http://localhost:8761/discoveryServer/testResource
  - http://localhost:8081/actuator
  - http://localhost:8081/actuator/circuitbreakers
  - http://localhost:8080/actuator/health
  - http://localhost:8081/actuator/health
  - https://api.themoviedb.org/3/movie/100?api_key=e6193f59384d5d68fdef6230a6fe2d67