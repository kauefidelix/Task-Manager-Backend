package com.taskmanager.backend.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("epics")
public class Epic {
    @PrimaryKey
    @Column("epic_id")
    private UUID epicId;

    @Column("name")
    private String name;

    @Column("content")
    private String content;

    @Column("creation_date")
    private LocalDate creationDate;

    @Column("last_modified")
    private LocalDate lastModified;

    @Column("assignee")
    private String assignee;

    // Getters and Setters
}
