// Keyspace: gs_top

DROP KEYSPACE IF EXISTS gs_top;

CREATE KEYSPACE gs_top
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};


USE gs_top;

DROP TABLE IF EXISTS name_index;

CREATE TABLE name_index (
  index_key varchar,
  index_values set<varchar>,
  PRIMARY KEY (index_key) )
  WITH CACHING = 'ALL';


DROP TABLE IF EXISTS continents;

CREATE TABLE continents (
  continent varchar,
  counter_value counter,
  PRIMARY KEY (continent) )
  WITH CACHING = 'ALL';


DROP TABLE IF EXISTS countries;

CREATE TABLE countries (
  country varchar,
  counter_value counter,
  PRIMARY KEY (country) )
  WITH CACHING = 'ALL';


