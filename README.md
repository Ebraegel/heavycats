# Heavycats

Sometimes your vet tells you your cat is a bit on the heavy side, and you might want to keep track of her weight.
Mainly an excuse to mess around with Spring MVC.

## Setup
```
./gradlew build
```

## Run
```
docker-compose up -d
./gradlew bootRun
yarn start
```

## Use
```
# Create a cat
curl -XPOST -H 'content-type: application/json' localhost:8080/cats -d '{ "name": "Fluffy" }'

# Get a cat, or get all the cats
curl localhost:8080/cats
curl localhost:8080/cats/1

# Record a weight for a cat
curl -XPOST -H 'content-type: application/json' localhost:8080/cats/1/weights -d '{ "weight": 15.2 }'

# Get a cat's weight history
curl localhost:8080/cats/1/weights

# Connect to the database
docker-compose exec db mysql --user heavycats heavycats --password
```

## TODO
* Build a docker container to run in docker-compose with the mysql database
* Build a little frontend for viewing and entering cat weights
* Figure out why `@NotNull` + `@Valid` doesn't seem to be working right
* Get better at testing
* Better error responses, e.g. violating name uniqueness constraint currently results in a 500 and a giant stack trace in the response body
