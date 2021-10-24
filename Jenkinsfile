pipeline {
  parameters {
    string(name: 'DOCKER_HUB_USER_REPO', defaultValue: 'iltaek')
    string(name: 'IMAGE_NAME', defaultValue: 'productreview')
  }

  agent any
  tools {
    jdk 'jdk-11'
  }
  stages {
    stage('Run Unit Test') {
      steps {
        sh "./gradlew test"
      }
    }
    stage('Build Jar') {
      steps {
        sh "./gradlew clean build"
      }
    }
    stage('Build Docker image') {
      steps {
        script {
          app = docker.build("${params.DOCKER_HUB_USER_REPO}/${params.IMAGE_NAME}")
        }
      }
    }
    stage('Push Docker image to DockerHub') {
      steps {
        script {
          docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
            app.push("{env.BUILD_NUMBER}")
            app.push("latest")
          }
        }
      }
    }
  }
}