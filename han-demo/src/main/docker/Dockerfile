FROM openjdk:11.0.3-jdk-stretch
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
VOLUME /tmp
ADD /Users/xt/Desktop/data/workspace/han-workspace/han/han-demo/target/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]