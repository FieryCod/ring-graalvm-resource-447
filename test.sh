#!/usr/bin/env bash

clojure -X:uberjar

$GRAALVM_HOME/bin/native-image -jar output.jar \
    --initialize-at-build-time=example \
    --verbose \
    --no-fallback \
    --no-server \
    -H:IncludeResources=index.html \
    -J-Dclojure.spec.skip.macros=true \
    -J-Dclojure.compiler.direct-linking=true \
    -J-Xmx5g \
    -H:+ReportExceptionStackTraces \
    -H:Name=native-test

chmod +x native-test

./native-test
