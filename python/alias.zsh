alias pip-upgrade="pip freeze | cut -d'=' -f1 | xargs -n1 pip install -U"
