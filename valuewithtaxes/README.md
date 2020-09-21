# How to run without docker
 - Run ```mvn spring-boot:run```
 
# How to run tests
 - Run ```mvn test```
 
# How to run with docker
 - Build ```docker build -t sp-valuewithtaxes .```
 - Run ```docker run -p 7001:7001 --name sp-valuewithtaxes -d sp-valuewithtaxes```
 
# How to test end-point
 - Run ```curl --location --request POST 'http://localhost:7001/valueWithTaxes' --header 'Content-Type: application/json' --data-raw '{ "tax": 2.2, "amount": 10000 }'```
 
