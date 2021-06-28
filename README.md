# framework-demo-mybatis-logging
## log4jdbc사용한 mybatis log 고도화

1. pom.xml에 디펜던시 추가
```
		<!-- log4jdbc -->
		<dependency>
		    <groupId>org.bgee.log4jdbc-log4j2</groupId>
		    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
		    <version>1.16</version>
		</dependency>
```

2. application.yml 파일의 datasource 설정을 변경한다.
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres?currentSchema=x2commerce
    #url: jdbc:log4jdbc:postgresql://localhost:5432/postgres?currentSchema=x2commerce
    driver-class-name: org.postgresql.Driver
    #driver-class-name: net.sf.log4jdbc.sql.jdbcapi.DriverSpy
    username: x2commerce
    password: x2commerce123!
    ...
```

3. log4jdbc.log4j2.properties 을 src/main/resources 폴더아래에 생성한다.
```
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
log4jdbc.dump.sql.maxlinelength=0
```

4. logback 설정파일에 로거 설정을 추가한다.
```
		<logger name="jdbc" level="OFF"/>
		<logger name="jdbc.sqlonly" level="OFF"/>
		<logger name="jdbc.sqltiming" level="DEBUG"/>
		<logger name="jdbc.audit" level="OFF"/>
		<logger name="jdbc.resultset" level="OFF"/>
		<logger name="jdbc.resultsettable" level="DEBUG"/>
		<logger name="jdbc.connection" level="OFF"/>
		<logger name="org.springframework.jdbc.datasource.DataSourceTransactionManager" additivity="false" level='debug'>
			<appender-ref ref="COLOR_STDOUT" />
		</logger>
```

5. 설정완료 출력되는 로그를 확인한다.
```
2021-06-28 16:57:20:396[0;39m [32m[DEBUG][0;39m [2m[                         ][0;39m [36m[     Slf4jSpyLogDelegator.java::sqlTimingOccurred   ( 368)][0;39m [2m:[0;39m  com.zaxxer.hikari.pool.ProxyPreparedStatement.execute(ProxyPreparedStatement.java:44)
1. /* TestMapper.selectSampleById */
		select
			id,
			name,
			description,
			sys_reg_dtime,
			sys_regr_id,
			sys_mod_dtime,
			sys_modr_id
		from sample
		where id = 2
 {executed in 2 msec}
[2m2021-06-28 16:57:20:398[0;39m [32m[INFO ][0;39m [2m[                         ][0;39m [36m[     Slf4jSpyLogDelegator.java::resultSetCollected  ( 610)][0;39m [2m:[0;39m 
|---|-----|--------------------|---------------------------|------------|---------------------------|------------|
|id |name |description         |sys_reg_dtime              |sys_regr_id |sys_mod_dtime              |sys_modr_id |
|---|-----|--------------------|---------------------------|------------|---------------------------|------------|
|2  |장미꽃  |초여름에 피는 강렬한 아름다움의 꽃 |2021-06-24 17:57:14.803721 |admin       |2021-06-24 17:57:14.803721 |admin       |
|---|-----|--------------------|---------------------------|------------|---------------------------|------------|
```

*** 개인적인 생각으로는 기본 로그설정(logging.level.kr.co.ensmart.frameworkdemo.app.dao: debug) 으로 충분하지 않나 싶다.


