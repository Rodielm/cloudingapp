#!/bin/bash

# ./script.sh nombre_red rango_subred nombre_fichero_clave_privada octeto
# Ej: ./script.sh lab1 10.201.1.0/24 twcam 20

## Preparar nombre de variables
NETWORK_NAME="selfservice"
SUBNET_NAME="subred"
SUBNET_RANGE="10.2.0.0/24"
SECURITY_GROUP_NAME="lab1"
FLAVOR="lab1"
KEYPAIR_NAME="twcam"
VMDOCKER="vmdocker"
EXTERNAL_NETWORK="external-network"
OPENSTACK="proyecto2-openrc.sh"
OS_PROJECT_ID="ac24b36d8f464bcf8adfa8868976cc14"
OS_TENANT_ID="ac24b36d8f464bcf8adfa8868976cc14"
OS_TENANT_NAME="proyecto2"
VOL="volume"


## Limpiar proyecto
ip=$(openstack floating ip list -c "Floating IP Address" -f value)
openstack floating ip delete $ip
openstack security group delete $SECURITY_GROUP_NAME
FLOATING_IP=$(openstack floating ip list -c "Floating IP Address" -f value)
openstack floating ip delete $FLOATING_IP
openstack router remove subnet router subred
openstack router delete router
openstack network delete $NETWORK_NAME
openstack volume delete $VOL
openstack volume delete $VOL

openstack network create $NETWORK_NAME

## Crear subred
openstack subnet create --subnet-range $SUBNET_RANGE --network $NETWORK_NAME --dns-nameserver 8.8.4.4 $SUBNET_NAME

## Crear router
openstack router create router
openstack router add subnet router $SUBNET_NAME
openstack router set router --external-gateway external-network

openstack security group create $SECURITY_GROUP_NAME

openstack security group rule create --proto icmp $SECURITY_GROUP_NAME
openstack security group rule create --proto tcp --dst-port 22 $SECURITY_GROUP_NAME
openstack security group rule create --proto tcp --dst-port 2376 $SECURITY_GROUP_NAME

# openstack security group rule create --proto tcp --dst-port 8080 $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 8761 $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 8081 $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 8080 $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 27017 $SECURITY_GROUP_NAME

# openstack security group rule create --proto tcp --dst-port 80 $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 53 $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 3306 --remote-ip $SUBNET_RANGE $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 5001 --remote-ip $SUBNET_RANGE $SECURITY_GROUP_NAME
# openstack security group rule create --proto tcp --dst-port 2375 


openstack volume create $VOL --size 1

openstack floating ip create external-network
ip=$(openstack floating ip list -c "Floating IP Address" -f value)
