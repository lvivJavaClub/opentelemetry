# OpenTelemetry Demo Application

## Run the project
Run `docker-compose` with `jaeger` and `zipkin`
```shell
docker-compose up
```
Build the project with
```shell
mvn clean install
```
Run the project with `opentelemetry-javaagent-all.jar` Java agent
```shell
java -javaagent:opentelemetry-javaagent-all.jar \                                    
  -Dotel.resource.attributes=service.name=demo-service \
  -Dotel.traces.exporter=jaeger \
  -Dotel.metrics.exporter=prometheus \
  -jar target/opentelemetry-0.0.1-SNAPSHOT.jar
```

## Execute queries
Create Person
```http request
POST localhost:8080/person
Content-Type: application/json

{
  "name": "John Doe"
}
```

Get Person by ID
```http request
GET localhost:8080/person/1
```

Generate Person
```http request
GET localhost:8080/person
```
