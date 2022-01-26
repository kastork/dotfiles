# DOCKER_VM_INSTANCE=$(multipass info docker-vm | grep IPv4 | awk '{split($0,a," "); print a[2]}')
# export DOCKER_HOST="tcp://${DOCKER_VM_INSTANCE}:2375"
# PATH="$PATH:/Users/kirk/Library/Application Support/multipass/bin"