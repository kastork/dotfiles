# init according to man page
if (( $+commands[rbenv] ))
then
  eval "$(rbenv init -)"
fi

export PATH="/usr/local/opt/ruby/bin:$PATH"