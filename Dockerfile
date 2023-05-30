FROM tomcat:latest
ARG WAR_FILE=target/*.war
ADD ${WAR_FILE} /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]