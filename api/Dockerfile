FROM flowdocker/play_builder:latest-java13 as builder
COPY . /opt/play
WORKDIR /opt/play
RUN sbt clean stage

FROM flowdocker/play:latest-java13
COPY --from=builder /opt/play/api/target/universal/stage /opt/play
WORKDIR /opt/play
ENTRYPOINT ["java", "-jar", "/root/environment-provider.jar", "--service", "play", "ben-test", "bin/ben-test-api"]
HEALTHCHECK --interval=5s --timeout=5s --retries=10 \
  CMD curl -f http://localhost:9000/_internal_/healthcheck || exit 1
