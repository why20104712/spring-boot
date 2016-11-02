package com.why.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据库连接配置
 * Created by why on 2016/11/2.
 */
@Configuration
public class DruidDataSourceConfiguration {

    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class);

    @Value("${spring.druidDataSource.url}")
    private String url;

    @Value("${spring.druidDataSource.username}")
    private String username;

    @Value("${spring.druidDataSource.password}")
    private String password;

    @Value("${spring.druidDataSource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.druidDataSource.initialSize}")
    private int initialSize;

    @Value("${spring.druidDataSource.minIdle}")
    private int minIdle;

    @Value("${spring.druidDataSource.maxActive}")
    private int maxActive;

    @Value("${spring.druidDataSource.maxWait}")
    private int maxWait;

    @Value("${spring.druidDataSource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.druidDataSource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.druidDataSource.validationQuery}")
    private String validationQuery;

    @Value("${spring.druidDataSource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.druidDataSource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.druidDataSource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.druidDataSource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.druidDataSource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.druidDataSource.filters}")
    private String filters;

    @Bean//声明其为Bean实例,为Spring容器所管理
    @Primary//在同样的DataSource中，首先使用被标注的DataSource
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        //configuration
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }

        return druidDataSource;
    }


}
