alias d='docker $*'
alias d-c='docker-compose $*'
alias d-purge-containers="docker rm $(docker ps -a | grep Exited | awk '{print $1}')"
alias d-purge-images='docker rmi $(docker images -q --filter "dangling=true")'