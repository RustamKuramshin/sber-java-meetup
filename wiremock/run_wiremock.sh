#!/usr/bin/env bash

java -jar wiremock*.jar --verbose --print-all-network-traffic --enable-stub-cors --port 19966 2>&1 | tee wiremock.log