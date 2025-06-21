pipeline {
  agent any

  environment {
    IMAGE_PREFIX = 'localhost:5000' // Change-le si tu veux utiliser Docker Hub
    MAVEN_OPTS = '-Dmaven.test.skip=true'
  }

  stages {
    stage('Clean workspace') {
      steps {
        deleteDir()
      }
    }

    stage('Checkout source') {
      steps {
        git url: 'https://ton-repo.git', branch: 'main'
      }
    }

    stage('Build & Dockerize microservices') {
      parallel {
        stage('Discovery Service') {
          steps {
            dir('discovery-service') {
              sh 'mvn clean package $MAVEN_OPTS'
              sh "docker build -t $IMAGE_PREFIX/discovery-service:latest ."
              sh "docker push $IMAGE_PREFIX/discovery-service:latest"
            }
          }
        }
        stage('Config Service') {
          steps {
            dir('config-service') {
              sh 'mvn clean package $MAVEN_OPTS'
              sh "docker build -t $IMAGE_PREFIX/config-service:latest ."
              sh "docker push $IMAGE_PREFIX/config-service:latest"
            }
          }
        }
        stage('Customer Service') {
          steps {
            dir('customer-service') {
              sh 'mvn clean package $MAVEN_OPTS'
              sh "docker build -t $IMAGE_PREFIX/customer-service:latest ."
              sh "docker push $IMAGE_PREFIX/customer-service:latest"
            }
          }
        }
        stage('Account Service') {
          steps {
            dir('account-service') {
              sh 'mvn clean package $MAVEN_OPTS'
              sh "docker build -t $IMAGE_PREFIX/account-service:latest ."
              sh "docker push $IMAGE_PREFIX/account-service:latest"
            }
          }
        }
        stage('Gateway Service') {
          steps {
            dir('gateway-service') {
              sh 'mvn clean package $MAVEN_OPTS'
              sh "docker build -t $IMAGE_PREFIX/gateway-service:latest ."
              sh "docker push $IMAGE_PREFIX/gateway-service:latest"
            }
          }
        }
      }
    }

    stage('Deploy with Docker Compose') {
      steps {
        sh 'docker-compose -f docker-compose.yml down'
        sh 'docker-compose -f docker-compose.yml up -d --build'
      }
    }
  }

  post {
    failure {
      echo "Le pipeline a échoué ❌"
    }
    success {
      echo "Déploiement réussi ✅"
    }
  }
}
