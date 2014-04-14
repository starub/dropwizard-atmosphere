## Dropwizard 0.7.0 with atmosphere 2.1.2 example

## Overview

This is just a simple dropwizard project, which shows how to intergrate the atmosphere websocket framework in dropwizard

# How to run the app

To test the example run the following commands.

*   To package the example run.

        mvn clean package

*   To run the server run.
        
        use ./run 
        or manually
        java -jar target/dropwizard-atmosphere-1.0.0.jar server config.yml

*   Adress for your websocket client

        ws://localhost:8080/socket


