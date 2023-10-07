# FROM creates a layer from an existing Java base image that exists locally or in any container registry that runs our container. openjdk:17 will be the one to use.
FROM openjdk:17
# VOLUME creates a specific space to persist some data in your container. The tmp folder will store information.
VOLUME /tmp
# EXPOSE informs Docker that the container listens to the specified network ports at runtime. This is the port to access to the Spring Boot container and will be used to run the container.
EXPOSE 8080
# Define a build argument for the JAR file, defaulting to any JAR in the build/libs directory
ARG JAR_FILE=build/libs/*.jar

# Copy the JAR file specified by the JAR_FILE argument into the image and rename it to app.jar
COPY ${JAR_FILE} app.jar

# Specify the command to run when the container starts, which is to run the app.jar using Java
ENTRYPOINT ["java","-jar","/app.jar"]