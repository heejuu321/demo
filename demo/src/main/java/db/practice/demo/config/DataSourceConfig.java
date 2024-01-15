package db.practice.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig implements EnvironmentAware {

    Environment env;
    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }
    @Primary
    @Bean
    public DataSource dataSourceBasic() throws Exception {
        DataSource dataSource = null;
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("demo.oracle.datasource.driverClassName"));
        config.setJdbcUrl(env.getProperty("demo.oracle.datasource.url"));
        config.setUsername(env.getProperty("demo.oracle.datasource.username"));
        config.setPassword(env.getProperty("demo.oracle.datasource.password"));
        config.setMaximumPoolSize(10);
        config.setAutoCommit(true);
        dataSource = new HikariDataSource(config);
        return dataSource;
    }


    @Primary
    @Bean
    public DataSource dataSourceMaria() throws Exception {
        DataSource dataSource = null;
        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(env.getProperty("demo.oracle.datasource.driverClassName"));
//        config.setJdbcUrl(env.getProperty("demo.oracle.datasource.url"));
//        config.setUsername(env.getProperty("demo.oracle.datasource.username"));
//        config.setPassword(env.getProperty("demo.oracle.datasource.password"));
//        config.setMaximumPoolSize(10);
//        config.setAutoCommit(true);
        dataSource = new HikariDataSource(config);
        return dataSource;
    }

    // 오라클 - 일반
    @Primary
    @Bean(name="sqlSessionBasicOracle")
    public SqlSessionFactoryBean sqlSessionFactoryOracleBasic(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(false);
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        configuration.setLazyLoadingEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setCallSettersOnNulls(true);
        configuration.setDefaultExecutorType(ExecutorType.SIMPLE);      //BATCH 세션으로 할 경우 처리 카운트를 얻을 수 있다.
        sessionFactoryBean.setConfiguration(configuration);
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/sqlmap/mapper/*.xml"));
        sessionFactoryBean.setTypeAliasesPackage("demo.practice.demo.");        //???????

        return sessionFactoryBean;
    }

    // 오라클 - 배치
    @Primary
    @Bean(name="sqlSessionBatchOracle")
    public SqlSessionFactoryBean sqlSessionFactoryOracleBatch(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(false);
//        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        configuration.setLazyLoadingEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setCallSettersOnNulls(true);
        configuration.setDefaultExecutorType(ExecutorType.BATCH);      //BATCH 세션으로 할 경우 처리 카운트를 얻을 수 있다.
        sessionFactoryBean.setConfiguration(configuration);
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/sqlmap/mapper/*.xml"));
        sessionFactoryBean.setTypeAliasesPackage("demo.practice.demo.");        //???????

        return sessionFactoryBean;
    }

}
