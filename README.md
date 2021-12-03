# Repro for [ring-clojure/ring-447](https://github.com/ring-clojure/ring/pull/447)

## Issue

``` sh
➜  graalvm-ring-resource-repro git:(master) ✗ ./test.sh 
Compiling example.core ...
2021-12-03 13:38:47.771:INFO::main: Logging initialized @2079ms to org.eclipse.jetty.util.log.StdErrLog

Building uber jar: output.jar
Warning: Ignoring server-mode native-image argument --no-server.
Executing [
/home/fierycod/.graalvm/bin/java \
-XX:+UseParallelGC \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-Dsubstratevm.IgnoreGraalVersionCheck=true \
--add-exports=java.base/com.sun.crypto.provider=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.event=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.loader=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.logger=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.module=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.org.objectweb.asm=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.org.xml.sax.helpers=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.perf=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.ref=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.reflect=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.util.xml.impl=ALL-UNNAMED \
--add-exports=java.base/jdk.internal.util.xml=ALL-UNNAMED \
--add-exports=java.base/sun.invoke.util=ALL-UNNAMED \
--add-exports=java.base/sun.nio.ch=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.annotation=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.generics.reflectiveObjects=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.generics.repository=ALL-UNNAMED \
--add-exports=java.base/sun.reflect.generics.tree=ALL-UNNAMED \
--add-exports=java.base/sun.security.jca=ALL-UNNAMED \
--add-exports=java.base/sun.security.provider=ALL-UNNAMED \
--add-exports=java.base/sun.security.util=ALL-UNNAMED \
--add-exports=java.base/sun.text.spi=ALL-UNNAMED \
--add-exports=java.base/sun.util.calendar=ALL-UNNAMED \
--add-exports=java.base/sun.util.locale.provider=ALL-UNNAMED \
--add-exports=java.base/sun.util.resources=ALL-UNNAMED \
--add-exports=java.xml.crypto/org.jcp.xml.dsig.internal.dom=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.aarch64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.amd64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.site=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code.stack=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.code=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.common=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.aarch64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.amd64=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot.sparc=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.hotspot=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.meta=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.runtime=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.services=ALL-UNNAMED \
--add-exports=jdk.internal.vm.ci/jdk.vm.ci.sparc=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.events=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal.consumer=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal.handlers=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal.jfc=ALL-UNNAMED \
--add-exports=jdk.jfr/jdk.jfr.internal=ALL-UNNAMED \
-XX:+UseJVMCINativeLibrary \
-Xss10m \
-Xms1g \
-Xmx13095960576 \
-Duser.country=US \
-Duser.language=en \
-Djava.awt.headless=true \
-Dorg.graalvm.version=21.3.0 \
-Dorg.graalvm.config=CE \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Dclojure.spec.skip.macros=true \
-Dclojure.compiler.direct-linking=true \
-Xmx5g \
-javaagent:/home/fierycod/.graalvm/lib/svm/builder/svm.jar \
-cp \
/home/fierycod/.graalvm/lib/svm/builder/svm.jar:/home/fierycod/.graalvm/lib/svm/builder/objectfile.jar:/home/fierycod/.graalvm/lib/svm/builder/pointsto.jar:/home/fierycod/.graalvm/lib/svm/builder/svm-llvm.jar:/home/fierycod/.graalvm/lib/svm/builder/llvm-wrapper-shadowed.jar:/home/fierycod/.graalvm/lib/svm/builder/javacpp-shadowed.jar:/home/fierycod/.graalvm/lib/svm/builder/llvm-platform-specific-shadowed.jar \
--module-path \
/home/fierycod/.graalvm/lib/truffle/truffle-api.jar \
'com.oracle.svm.hosted.NativeImageGeneratorRunner$JDK9Plus' \
-watchpid \
54969 \
-imagecp \
/home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar:/home/fierycod/.graalvm/lib/svm/library-support.jar \
-H:Path=/home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro \
'-H:Class@manifest from file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar=example.core' \
'-H:Name@manifest from file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar=output' \
'-H:ClassInitialization@jar:file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar!/META-INF/native-image/ring/ring-jetty-adapter/native-image.properties=org.eclipse.jetty:build_time' \
'-H:ReflectionConfigurationResources@jar:file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar!/META-INF/native-image/ring/ring-jetty-adapter/native-image.properties=META-INF/native-image/ring/ring-jetty-adapter/reflect-config.json' \
'-H:ResourceConfigurationResources@jar:file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar!/META-INF/native-image/ring/ring-jetty-adapter/native-image.properties=META-INF/native-image/ring/ring-jetty-adapter/resource-config.json' \
'-H:ReflectionConfigurationResources@jar:file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar!/META-INF/native-image/ring/ring-jetty-adapter/reflect-config.json=META-INF/native-image/ring/ring-jetty-adapter/reflect-config.json' \
'-H:ResourceConfigurationResources@jar:file:///home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/output.jar!/META-INF/native-image/ring/ring-jetty-adapter/resource-config.json=META-INF/native-image/ring/ring-jetty-adapter/resource-config.json' \
-H:ClassInitialization=example:build_time \
-H:FallbackThreshold=0 \
-H:IncludeResources=index.html \
-H:+ReportExceptionStackTraces \
-H:Name=native-test \
-H:CLibraryPath=/home/fierycod/.graalvm/lib/svm/clibraries/linux-amd64
]
[native-test:54988]    classlist:   1,619.88 ms,  0.96 GB
[native-test:54988]        (cap):     635.87 ms,  0.96 GB
[clj-easy/graal-build-time] Registering packages for build time initialization: clojure, clj_easy, example, ring.adapter, ring.core, ring.util
[native-test:54988]        setup:   3,099.43 ms,  0.96 GB
2021-12-03 13:38:55.739:INFO::ForkJoinPool-2-worker-5: Logging initialized @6100ms to org.eclipse.jetty.util.log.StdErrLog
[native-test:54988]     (clinit):     465.99 ms,  2.66 GB
[native-test:54988]   (typeflow):   4,244.21 ms,  2.66 GB
[native-test:54988]    (objects):  16,988.16 ms,  2.66 GB
[native-test:54988]   (features):   2,814.83 ms,  2.66 GB
[native-test:54988]     analysis:  25,460.06 ms,  2.66 GB
[native-test:54988]     universe:   1,741.56 ms,  2.66 GB
[native-test:54988]      (parse):   2,034.02 ms,  2.68 GB
[native-test:54988]     (inline):   3,372.75 ms,  2.69 GB
[native-test:54988]    (compile):  17,492.24 ms,  2.81 GB
[native-test:54988]      compile:  24,824.52 ms,  2.81 GB
[native-test:54988]        image:   2,363.98 ms,  2.81 GB
[native-test:54988]        write:     478.56 ms,  2.81 GB
[native-test:54988]      [total]:  59,911.39 ms,  2.81 GB
# Printing build artifacts to: /home/fierycod/Workspace/Clojure/Personal/graalvm-ring-resource-repro/native-test.build_artifacts.txt
2021-12-03 13:39:50.162:INFO:oejs.Server:main: jetty-9.4.42.v20210604; built: 2021-06-04T17:33:38.939Z; git: 5cd5e6d2375eeab146813b0de9f19eda6ab6e6cb; jvm 11.0.13
2021-12-03 13:39:50.163:INFO:oejs.AbstractConnector:main: Started ServerConnector@21599cf3{HTTP/1.1, (http/1.1)}{0.0.0.0:3000}
2021-12-03 13:39:50.163:INFO:oejs.Server:main: Started @1ms
2021-12-03 13:40:00.976:WARN:oejs.HttpChannel:qtp141774845-68: /
java.lang.IllegalArgumentException: No method in multimethod 'resource-data' for dispatch value: :resource
        at clojure.lang.MultiFn.getFn(MultiFn.java:156)
        at clojure.lang.MultiFn.invoke(MultiFn.java:229)
        at ring.util.response$url_response.invokeStatic(response.clj:304)
        at ring.util.response$resource_response.invokeStatic(response.clj:341)
        at ring.util.response$resource_response.invoke(response.clj:324)
        at ring.util.response$resource_response.invokeStatic(response.clj:333)
        at example.core$home_handler.invokeStatic(core.clj:7)
        at example.core$home_handler.invoke(core.clj:7)
        at ring.adapter.jetty$proxy_handler$fn__250.invoke(jetty.clj:27)
        at ring.adapter.jetty.proxy$org.eclipse.jetty.server.handler.AbstractHandler$ff19274a.handle(Unknown Source)
        at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:127)
        at org.eclipse.jetty.server.Server.handle(Server.java:516)
        at org.eclipse.jetty.server.HttpChannel.lambda$handle$1(HttpChannel.java:388)
        at org.eclipse.jetty.server.HttpChannel.dispatch(HttpChannel.java:633)
        at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:380)
        at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:277)
        at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:311)
        at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:105)
        at org.eclipse.jetty.io.ChannelEndPoint$1.run(ChannelEndPoint.java:104)
        at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:882)
        at org.eclipse.jetty.util.thread.QueuedThreadPool$Runner.run(QueuedThreadPool.java:1036)
        at java.lang.Thread.run(Thread.java:829)
        at com.oracle.svm.core.thread.JavaThreads.threadStartRoutine(JavaThreads.java:596)
        at com.oracle.svm.core.posix.thread.PosixJavaThreads.pthreadStartRoutine(PosixJavaThreads.java:192)
```

## Fix

1. Uncomment lines <8-15> in `core.clj`.
2. Run `./test.sh` once again.
   
## How to test

1. Make sure to download the latest GraalVM CE and install native-image utility.
2. Set the `GRAALVM_HOME` environment variable.
3. Install `clojure` official tooling.
4. Run 

``` sh
./test.sh
```

