FROM asdnf/mvn:latest
WORKDIR /src/
COPY / .

RUN cd /src && mvn package

FROM asdnf/tomcat:latest
WORKDIR /target/
COPY --from=0 /src/web/target/ .
RUN mv ./*.war /apache-tomcat-8.5.51/webapps/ && chmod +x /apache-tomcat-8.5.51/bin/*.sh

CMD bash /apache-tomcat-8.5.51/bin/catalina.sh run

