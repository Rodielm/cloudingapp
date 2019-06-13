IP=$1
curl -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://$IP/mongo/api/purchase/
printf "\n\n"
curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://$IP/mongo/api/purchase/2
printf "\n\n"
curl -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://$IP/mongo/api/airportcontrol/
printf "\n\n"
echo "Petición GET a http://localhost/mysql/vuelos/1: consultar información del vuelo con id 1."
curl -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://$IP/mysql/passengers/1
printf "\n\n"
curl -H "Accept: application/json" -H "Content-Type: application/json" -X DELETE http://$IP/mysql/flight/1