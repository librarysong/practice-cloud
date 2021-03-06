package cn.swf.practice.practicemaster.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宋维飞
 * 2019/7/1 15:35
 */
@Configuration
@MapperScan(value = "cn.swf.practice.practicemaster.mapper*", sqlSessionFactoryRef = "practiceSqlSessionFactory")
@Slf4j
public class DataSourceConfig {

    @Bean("practice")
    @Primary
    @ConfigurationProperties(prefix = "practice.datasource")
    public DataSource dataSourceInit() {
        log.info("#################### practice mysqlDatasource create success! ####################");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("practiceJdbcTemplate")
    @Primary
    public JdbcTemplate getJdbcTemplate(@Qualifier("practice") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setQueryTimeout(20);
        return jdbcTemplate;
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    @Bean("practiceSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("practice") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean fb = new MybatisSqlSessionFactoryBean();
        fb.setDataSource(dataSource);
        fb.setTypeAliasesPackage("com.swf.practice.practicemaster.entity");
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        fb.setConfiguration(mybatisConfiguration);
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/practice/*.xml"));
        fb.setPlugins(new Interceptor[]{optimisticLockerInterceptor(), paginationInterceptor()});
        MetaObjectHandler metaObjectHandler = new ComMetaObjectHandler();
        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
        globalConfig.setMetaObjectHandler(metaObjectHandler);
        fb.setGlobalConfig(globalConfig);
        return fb.getObject();
    }

    @Bean("practiceSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("practiceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("practicePlatformTransactionManager")
    @Primary
    public PlatformTransactionManager txManager(@Qualifier("practice") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
