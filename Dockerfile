FROM adoptopenjdk/openjdk11
EXPOSE 8080
ARG JAR_FILE=target/person_jar/person.jar
ADD ${JAR_FILE} demoProject.jar
ENTRYPOINT {"java","-jar","/demoProject.jar"}