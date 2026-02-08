# MicroservicesJavaBrains

**Notes:**

- To refresh the configurations server values in runtime just call **http://localhost:8101/actuator/refresh** API with adding the **@RefreshScope** annotation to the controller that have the properties which we need to update its values.
- To check the health of the application is and if it "Up" and running correctly or "Down" due to an issue: http://localhost:8101/actuator/health with adding the (**management.endpoint.health.show-details=always**) to properties file.