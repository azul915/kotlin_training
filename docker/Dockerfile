FROM openjdk:15-slim AS dev

ENV PATH /root/.sdkman/candidates/kotlin/current/bin:$PATH
ENV SRC /usr/local/src

RUN apt-get update && \
    apt-get install -y \
    git unzip zip curl && \
    curl -s https://get.sdkman.io | bash
RUN /bin/bash -l -c "chmod a+x $HOME/.sdkman/bin/sdkman-init.sh;$HOME/.sdkman/bin/sdkman-init.sh;sdk install kotlin"

CMD ["/bin/bash"]


FROM dev AS builder
COPY ./src $SRC
RUN kotlinc $SRC -include-runtime -d $SRC/main.jar
CMD ["/bin/sh", "-c", "$JAVA_HOME/bin/java -jar $SRC/main.jar"]


FROM adoptopenjdk/openjdk11:alpine-slim AS exe
ENV SRC /usr/local/src
COPY --from=builder $SRC/main.jar $SRC/main.jar
CMD ["/bin/sh", "-c", "$JAVA_HOME/bin/java -jar $SRC/main.jar"]
