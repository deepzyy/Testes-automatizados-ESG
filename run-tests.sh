#!/usr/bin/env bash
# Script to run tests locally. Set BASE_URL if needed.
BASE_URL=${BASE_URL:-http://localhost:8080}
echo "Usando BASE_URL=${BASE_URL}"
mvn test -DBASE_URL="$BASE_URL" "$@"
