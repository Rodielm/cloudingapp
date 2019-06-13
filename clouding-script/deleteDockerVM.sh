#!/bin/bash
NETWORK_NAME="selfservice"
SUBNET_NAME="subred"
SUBNET_RANGE="10.2.0.0/24"
SECURITY_GROUP_NAME="lab1"
FLAVOR="lab1"
KEYPAIR_NAME="twcam"
VMDOCKER="VMDOCKER"
EXTERNAL_NETWORK="external-network"
OPENSTACK="proyecto2-openrc.sh"

source $OPENSTACK

#Borrar las maquinas virtuales
echo 'server vmdocker  delete...'
openstack server delete manager
openstack server delete worker1 
# sleep 0.2
#done

#Security group
openstack security group delete lab1

#delete floating ip
FLOATING_IP=$(openstack floating ip list -c "Floating IP Address" -f value)

openstack floating ip delete $FLOATING_IP

#delete router and subred
openstack router remove subnet router subred
echo "deleted subred"

#delete router and subred
openstack router delete router
echo "deleted router"

openstack network delete selfservice
echo "deleted selfservice"

#delete router and subred
# neutron lbaas-listener-delete web-listener
# echo "deleted web-listener"

# #delete healthmonitor
# MONITOR_ID=$(neutron lbaas-healthmonitor-list -c "id" -f value) 
# neutron lbaas-healthmonitor-delete $MONITOR_ID
# echo "deteled healthmonitor"

#delete router and subred
# neutron lbaas-pool-delete web-pool
# echo "deleted web-pool"

#neutron lbaas-healthmonitor-delete web-lb
# neutron lbaas-loadbalancer-delete web-lb
# echo "deleted loadbalancer"

#delete router and subred

