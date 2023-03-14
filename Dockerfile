FROM adoptopenjdk/openjdk11

WORKDIR /usr/src/app

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/news-0.0.1-SNAPSHOT.jar ${JAR_PATH}/news-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","./build/libs/news-0.0.1-SNAPSHOT.jar"]