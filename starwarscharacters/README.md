# How to run without docker
 - Run ```mvn spring-boot:run```
 
# How to run tests
 - Run ```mvn test```
 
# How to run with docker
 - Build ```docker build -t sp-starwarscharacters .```
 - Run ```docker run -p 7002:7002 --name sp-starwarscharacters -d sp-starwarscharacters```
 
# How to test end-point
 - Run ```curl --location --request GET 'http://localhost:7002/characters?search=anakin'```