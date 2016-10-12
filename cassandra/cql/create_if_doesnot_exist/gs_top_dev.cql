// GENERATED using CqlScriptsGeneratorMain.java
// Keyspace: gs_top

CREATE KEYSPACE IF NOT EXISTS gs_top
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};

USE gs_top;


CREATE TABLE IF NOT EXISTS name_index (
  index_key varchar,
  index_values set<varchar>,
  PRIMARY KEY (index_key) )
  WITH CACHING = 'ALL';


CREATE TABLE IF NOT EXISTS continents (
  continent varchar,
  counter_value counter,
  PRIMARY KEY (continent) )
  WITH CACHING = 'ALL';


CREATE TABLE IF NOT EXISTS countries (
  country varchar,
  counter_value counter,
  PRIMARY KEY (country) )
  WITH CACHING = 'ALL';


