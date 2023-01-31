package com.taskmanager.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraTemplate;

@Configuration
public class CassandraConfig {

    @Autowired
    private CassandraClusterFactoryBean cassandraCluster;

    @Bean
    public CassandraTemplate cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

    @Bean
    public CassandraSessionFactoryBean session() throws Exception {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setKeyspaceName("taskmanager");

        return session;
    }

}

