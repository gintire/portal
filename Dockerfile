FROM
MAINTAINER jinwook.im <jinwook@jinwook.kr>

RUN rm -rf /usr/local/tomcat/webapp/ROOT
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/tomcat/webapps/ROOT.war

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]

EXPOSE 58009
EXPOSE 58080