#!/usr/bin/env bash

fly -t lite set-pipeline -p cloud-native-java-web -c pipeline.yml -l .pipeline-config.yml
