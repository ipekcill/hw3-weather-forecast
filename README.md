Kullandığım Free Weather API: [Visual Crossing Weather](https://www.visualcrossing.com/resources/documentation/weather-api/timeline-weather-api/)

Request sample :
`localhost:8080/api/v1/weather?city=Izmir&country=Turkey&choice=daily`

Response sample : 
``` {
    "data": {
        "address": {
            "latitude": 38.4262,
            "longitude": 27.1419,
            "address": "Izmir,Turkey",
            "resolvedAddress": "İzmir, Türkiye"
        },
        "days": [
            {
                "currTemp": 18.2,
                "avgTemp": 18.299999999999997,
                "maxTemp": 22.9,
                "minTemp": 13.7,
                "feelslike": 18.2,
                "humidity": 58.8,
                "conditions": "Partially cloudy",
                "description": "Partly cloudy throughout the day."
            }
        ]
    },
    "success": true,
    "message": "Weather forecast taken",
    "dateTime": "2024-04-03",
    "statusCode": 200
}
```
Application config :
```
server.port=8080
spring.application.name=weather-forecast-client-api
visualCrossingAPI.apiKey=S8ANPUW3FS6EU89SMJCHB9LFF
visualCrossingAPI.apiUrl=https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/
```
