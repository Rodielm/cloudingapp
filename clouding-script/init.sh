#!/bin/bash
# ./init.sh lab1 

NETWORK="selfservice"
SUBNET="subnet"
ROUTER="router"
GROUPSECURITY="lab1"
SUBNETRANGE="10.2.0.0/24"
VOL="volume"
NOD="nodoT"

function initInstance {
	docker pull twcammaster.uv.es/ocata-cli:latest
    docker stop openstackCLI &&
    docker rm openstackCLI &&
    docker run -d -it -e OS_PASSWORD="7becec832" -e OS_AUTH_URL="http://controller:5000/v3/" -e OS_PROJECT_ID="ac24b36d8f464bcf8adfa8868976cc14" -e OS_PROJECT_NAME="proyecto2" -e OS_USER_DOMAIN_NAME="Default" -e OS_USERNAME="romarji" -e OS_PASSWORD="7becec832" -e OS_REGION_NAME="RegionOne" -e OS_INTERFACE="public" -e OS_IDENTITY_API_VERSION="3" -e OS_TENANT_ID="ac24b36d8f464bcf8adfa8868976cc14" --name openstackCLI --add-host controller:147.156.84.206 -v $(pwd):/tmp/tempdir twcammaster.uv.es/ocata-cli /bin/bash &&
    docker exec -ti openstackCLI bash -c "./generate-infa.sh $NETWORK $SUBNET $ROUTER $GROUPSECURITY $SUBNETRANGE $VOL "

    export OS_TENANT_ID="ac24b36d8f464bcf8adfa8868976cc14";
    echo "7becec832" | source proyecto2-openrc.sh &&
    
    # docker-machine rm -y $nod &&

    docker-machine create -d openstack \
    --openstack-ssh-user ubuntu \
    --openstack-domain-name Default \
    --openstack-username romarji \
    --openstack-password 7becec832 \
    --openstack-net-name $NETWORK \
    --openstack-floatingip-pool external-network \
    --openstack-auth-url http://controller:5000/v3/ \
    --openstack-flavor-name lab1 \
    --openstack-image-name ubuntu-4-docker \
    --openstack-sec-groups $GROUPSECURITY,default \
    $NOD
}

function serviceLaunch {
    eval $(docker-machine env "$NOD") &&
    docker-compose up -d
}

function swarmLaunch {
    ip=$(docker-machine ssh "$NOD" ifconfig ens3  | grep -Eo 'inet (addr:)?([0-9]*\.){3}[0-9]' | cut -c 11-);
    docker swarm init --advertise-addr 10.2.0.9 && sudo docker swarm join-token worker | grep 'docker swarm*' | sudo sh;
}

initInstance &&
serviceLaunch;
