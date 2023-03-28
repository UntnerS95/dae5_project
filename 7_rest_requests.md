# REST Client Plugin
* see here: https://marketplace.visualstudio.com/items?itemName=humao.rest-client 
* Should replace the postman collection in the future
* Check also the **swagger ui documentation** for more infos about possible requests: 
    * ``https://dae5-raindrops-ws2022-test-1-production.up.railway.app/swagger-ui.html`` 

# Variables 
* Definition with @ and usage with {{...}}
@url = http://localhost:8080

# Info - Controller
GET {{url}}/info HTTP/1.1

# Driver Controller
# Get all drivers
GET {{url}}/driver HTTP/1.1
# Get driver with username
GET {{url}}/driver/unti95 HTTP/1.1
# Get tracks from driver
GET {{url}}/driver/unti95/track HTTP/1.1
# Get motorcycles from driver
GET {{url}}/driver/unti95/motorcycle HTTP/1.1

# Track Controller
# Get all tracks
GET {{url}}/track HTTP/1.1
# Get tracks with name
GET {{url}}/track/Postalm HTTP/1.1
# Get points from track
GET {{url}}/track/Postalm/points HTTP/1.1

# Points Controller
# Get all points
GET {{url}}/points HTTP/1.1
# Get points with id
GET {{url}}/points/1 HTTP/1.1

# Motorcycle Controller
# Get all motorcycles
GET {{url}}/motorcycle HTTP/1.1
# Get motorcycle with id
GET {{url}}/motorcycle/1 HTTP/1.1