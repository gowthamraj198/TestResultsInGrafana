# Test Reports in Grafana

This sample application uploads test results to influxdb and view them in Grafana

# Pre-requisites

```
a. Scala 2.11
b. sbt
c. scala and sbt plugins in intellij
d. chrome
```


# To setup and run tests in intellij

```
a. Clone the project
b. Run `sbt clean` to clean the project 
c. Run `sbt compile` to download dependencies
d. Run `sbt test` 

```

#After Test Run, Grafana dashboard looks like this

<img width="1791" alt="Screenshot 2020-05-27 at 7 02 55 PM" src="https://user-images.githubusercontent.com/17563629/83011575-af772080-a04c-11ea-9ba3-79048d520c9b.png">
