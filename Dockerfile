FROM adoptopenjdk/openjdk11:jre-11.0.6_10-debianslim
EXPOSE 80
WORKDIR /app
COPY _#{Build.Repository.Name}#/Artifact-#{Build.Repository.Name}#/*.jar /app/app.jar
CMD java -XX:MaxRAMPercentage=90 \
            -XX:OnOutOfMemoryError="kill -9 %p" \
            -jar /app/app.jar

