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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宋维飞
 * 2019/8/1 10:21
 */
@Configuration
@Slf4j
@MapperScan(value = "cn.swf.practice.practicemaster.book.mapper*", sqlSessionFactoryRef = "bookSqlSessionFactory")
public class BookDataSourceConfig {

    @Bean("book")
    @ConfigurationProperties(prefix = "book.datasource")
    public DataSource dataSourceInit() {
        log.info("#################### book mysqlDatasource create success! ####################");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("bookJdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Qualifier("book") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setQueryTimeout(20);
        return jdbcTemplate;
    }

    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    @Bean("bookSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("book") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean fb = new MybatisSqlSessionFactoryBean();
        fb.setDataSource(dataSource);
        fb.setTypeAliasesPackage("com.swf.practice.practicemaster.book.entity");
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        fb.setConfiguration(mybatisConfiguration);
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/book/*.xml"));
        fb.setPlugins(new Interceptor[]{optimisticLockerInterceptor(), paginationInterceptor()});
        MetaObjectHandler metaObjectHandler = new ComMetaObjectHandler();
        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
        globalConfig.setMetaObjectHandler(metaObjectHandler);
        fb.setGlobalConfig(globalConfig);
        return fb.getObject();
    }

    @Bean("bookSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("bookSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("bookPlatformTransactionManager")
    public PlatformTransactionManager txManager(@Qualifier("book") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
