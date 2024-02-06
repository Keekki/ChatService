### If you only want to run the backend, you can do it with Dockerfile located in /backend/spring-boot directory.

- SpringBackend Docker Deployment Guide

### Building the Docker Image
- To build the Docker image, ensure you're in the root directory of your Spring Boot project where the Dockerfile is located. Then execute the following command in your terminal:

`docker build -t springbackend .`

- This command builds a Docker image named springbackend using the Dockerfile in the current directory.

### Running the Container with Port Mapping

- Tomcat, used by Spring Boot for serving web content, defaults to listening on port 8080. To make your application accessible on your host machine, you need to map a host port to the container's port 8080.

- Run the following command to start a container from the springbackend image, with the appropriate port mapping:

`docker run -p 8081:8080 springbackend`


- Now, you can access your Spring Boot application by navigating to http://localhost:8081 in your web browser.
