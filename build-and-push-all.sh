#!/bin/bash

# 🔧 Configurations
DOCKER_NAMESPACE="yadibrahim"
VERSION="1.1"

# 📦 Liste des noms exacts de tes microservices (correspondent aux noms de dossier et du service)
SERVICES=(
  discovery-service
  config-service
  gateway-service
  customer-service
  account-service
)

# ✅ Connexion Docker Hub (si non encore fait)
echo "🔐 Docker login (nécessaire si pas encore fait)"
docker login || { echo " Login échoué. Arrêt."; exit 1; }

# 🔁 Build et Push
for SERVICE in "${SERVICES[@]}"; do
  IMAGE_NAME="${DOCKER_NAMESPACE}/${SERVICE}:${VERSION}"
  SERVICE_DIR="./${SERVICE}"

  if [ ! -d "$SERVICE_DIR" ]; then
    echo " Dossier $SERVICE_DIR introuvable. Skip..."
    continue
  fi

  echo "--------------------------------------------"
  echo " Building image for ${SERVICE}..."
  docker build -t $IMAGE_NAME $SERVICE_DIR || {
    echo " Échec du build pour $SERVICE"
    continue
  }

  echo " Pushing $IMAGE_NAME to Docker Hub..."
  docker push $IMAGE_NAME || {
    echo " Échec du push pour $SERVICE"
    continue
  }

  echo " $SERVICE pushed successfully!"
done

echo " Tous les services sont buildés et poussés sur Docker Hub !"
