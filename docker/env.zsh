# DOCKER_HOST=tcp://192.168.0.1:2375
# export DOCKER_HOST
# alias d='docker $*'
# alias d-c='docker-compose $*'
# alias d-purge-containers="docker rm $(docker ps -a | grep Exited | awk '{print $1}')"
# alias d-purge-images='docker rmi $(docker images -q --filter "dangling=true")'

# export DOCKER_HOST="unix:/${HOME}.colima/docker.sock"