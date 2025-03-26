#  IoT Device Management API with Kafka Integration(RTU)
This is a backend application built with Spring boot.<br />
Integrated Kafka for messaging.<br />
JWT tocken for security.<br />
Docker compose for easy deploment.<br />

# Technologies used
    Spring Boot
    Kafka
    JWT
    Docker

# Technologies used

1.Run docker docker-compose.yml file

    Command: docker compose up

2.You can import the postman collection or follow the below

3.Register user

    API: http://localhost:8080/user/register
    Body: {
        "username":"Master",
        "password":"masterpass"
    }

4.Get authorization tocken

    API: http://localhost:8080/authenticate
    Body: {
        "username":"Master",
        "password":"masterpass"
    }

    Will get a bearer tocken from this api use this tocken in the authorisation header for the below requests

5: http://localhost:8080/devices

    This request will save a device and call the "thingwire.devices.events" topic

6: http://localhost:8080/devices/d84987f3-99c1-44d1-9107-629626dcb06a

    Get the device by id

7: http://localhost:8080/devices/d84987f3-99c1-44d1-9107-629626dcb06a/send-command-status   

    This request will save a device and call the "thingwire.devices.commands" topic

8: http://localhost:8080/devices/d84987f3-99c1-44d1-9107-629626dcb06a/OFFLINE/send-command-status   
    
    This request will trigger kafka topic "thingwire.devices.responses" 
    and update device status to offline


