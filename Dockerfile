FROM docker.3vjia.com/3vjia/tomcat:8.5-jre8-a
ENV TZ=Asia/Shanghai
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY service/target/demo-1.0.0-SNAPSHOT /usr/local/tomcat/webapps/ROOT
CMD ["catalina.sh", "run"]