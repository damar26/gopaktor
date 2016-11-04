#!/usr/bin/env groovy

node {
    stage 'Build and Deploy'
    docker.image('dr.gopaktor.com/paktor/build-android:latest').inside {
        checkout scm
        sh "ls -al"
        sh "pwd"
        sh "export ANDROID_HOME=/opt/android-sdk-linux"
        sh "ls -al /opt/android-sdk-linux"
        sh "ls -al /opt/android-sdk-linux/build-tools"
        sh "ls -al /opt/android-sdk-linux/extras"

        sh "ls -al /opt/android-sdk-linux/extras"

        sh "export JAVA_HOME=/usr/bin/java"
        sh "java -version"
        sh "android list sdk"
        sh "adb version"
        sh "gcloud init"
        sh "gcloud auth activate-service-account modular-glider-366@appspot.gserviceaccount.com --key-file Paktor-0003db16ce61.p12 --project modular-glider-366"

    }
}
