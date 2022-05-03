export PYENV_ROOT="$HOME/.pyenv"
command -v pyenv >/dev/null || export PATH="$PYENV_ROOT/bin:$PATH"

# eval "$(pyenv init -)"  # should work, doesn't

eval "$(pyenv init --path)"
eval "$(pyenv virtualenv-init -)"
