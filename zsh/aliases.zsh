alias reload!='. ~/.zshrc'

alias cls='clear' # Good 'ol Clear Screen command

alias buildenv='while read requirement; do conda install --yes $requirement; done < requirements.txt'
