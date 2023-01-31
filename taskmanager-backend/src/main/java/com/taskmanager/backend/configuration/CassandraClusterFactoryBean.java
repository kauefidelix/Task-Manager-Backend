package com.taskmanager.backend.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;
import java.util.Arrays;


public class CassandraClusterFactoryBean implements FactoryBean<CqlSession>, InitializingBean {

    private String contactPoints;
    private int port;
    private CqlSession session;



    public void setContactPoints(String contactPoints) {
        this.contactPoints = contactPoints;
    }


    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public CqlSession getObject() throws Exception {
        return session;
    }

    @Override
    public Class<?> getObjectType() {
        return CqlSession.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(contactPoints, port))
                .build();
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9042);
        return cluster;
    }

}
