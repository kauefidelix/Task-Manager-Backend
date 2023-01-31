package com.taskmanager.backend.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("cards")
public class Card {
    @PrimaryKey
    @Column("card_id")
    private UUID cardId;

    @Column("name")
    private String name;

    @Column("content")
    private String content;

    @Column("creation_date")
    private LocalDate creationDate;

    @Column("last_modified")
    private LocalDate lastModified;

    @Column("column")
    private String column;

    @Column("assignee")
    private String assignee;

    @Column("card_type")
    private String cardType;

    @Column("epic_link")
    private UUID epicLink;

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = LocalDate.parse(creationDate);
    }

    public void setLastModified(String lastModified) {
        this.lastModified = LocalDate.parse(lastModified);
    }


    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public String getColumn() {
        return column;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getCardType() {
        return cardType;
    }

    public UUID getEpicLink() {
        return epicLink;
    }

    public Object getId() {
        return cardId;
    }
}
