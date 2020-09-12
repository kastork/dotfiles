alias reload!='. ~/.zshrc'

alias cls='clear' # Good 'ol Clear Screen command

alias buildenv='while read requirement; do conda install --yes $requirement; done < requirements.txt'

alias la='ls -alh'

alias tt='tree -pugh'
alias t='tree -D'

# Rsync pushes and dryruns
alias pt_505='rsync -vaz --delete --filter "merge .rsyncfilter" . 505:$(pwd)/'
alias dt_505='rsync -vazn --delete --filter "merge .rsyncfilter" . 505:$(pwd)/'
alias pt_little='rsync -vaz --delete --filter "merge .rsyncfilter" . little:$(pwd)/'
alias dt_little='rsync -vazn --delete --filter "merge .rsyncfilter" . little:$(pwd)/'

# Rsync pulls and dryruns
alias df_505='rsync -vazn --delete --filter "merge .rsyncfilter" 505:$(pwd)/ .'
alias pf_505='rsync -vaz --delete --filter "merge .rsyncfilter" 505:$(pwd)/ .'
alias df_little='rsync -vazn --delete --filter "merge .rsyncfilter" little:$(pwd)/ .'
alias pf_little='rsync -vaz --delete --filter "merge .rsyncfilter" little:$(pwd)/ .'
