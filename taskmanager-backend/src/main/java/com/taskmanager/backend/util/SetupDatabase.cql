CREATE KEYSPACE taskmanager
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE taskmanager;

CREATE TABLE Card (
    card_id uuid PRIMARY KEY,
    name text,
    content text,
    creation_date date,
    last_modified date,
    column text,
    assignee text,
    card_type text,
    epic_link uuid,
);

CREATE TABLE Epic (
    epic_id uuid PRIMARY KEY,
    name text,
    content text,
    creation_date date,
    last_modified date,
    assignee text
);
