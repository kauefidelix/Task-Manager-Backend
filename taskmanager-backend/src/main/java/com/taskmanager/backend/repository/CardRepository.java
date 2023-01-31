package com.taskmanager.backend.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.taskmanager.backend.model.Card;

@Repository
public interface CardRepository extends CassandraRepository<Card, UUID> {

}

