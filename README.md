
> **why?** geo server is a next level template for [vangav backend](https://github.com/vangav/vos_backend) where database and geo services utility are used

# geo server

+ geo server service is generated using [vangav backend](https://github.com/vangav/vos_backend)

## index

## prerequisite

+ [vangav backend tutorials](https://github.com/vangav/vos_backend)

## functionality

+ this service handles getting reverse geo code and geo hash from geo coordinates (latitude and longitude); it also offers getting top queried continents and countries

## overview

+ this service is based on vangav backend's [geo server template](https://github.com/vangav/vos_backend/tree/master/vangav_backend_templates/vos_geo_server)
+ this service has the 90+% of the vangav backend's generated code + the 10-% of the logic code needed to complete the service

## try this service

1. *for first timers* - follow the steps in the [system requirements tutorial](https://github.com/vangav/vos_backend#system-requirements)
2. *for first timers* - follow the steps in the [workspace initialization tutorial](https://github.com/vangav/vos_backend#init)
3. download this `vos_geo_server.zip` project (from the green `clone or download` button up there) inside the workspace directory created previously (`my_services`) and unzip it
4. **rename** unzipped `vos_geo_server-master` to `vos_geo_server`
5. in the terminal `cd` to `vos_geo_server/cassandra/cql/`
6. execute `./_start_cassandra.sh` to start cassandra
7. `cd` to `vos_geo_server/cassandra/cql/drop_and_create/`
8. execute the command `./_execute_cql.sh gs_top_dev.cql` to initialize the service's database tables
9. `cd` to `vos_geo_server`
10. start the service: `./_run.sh`
11. from your prefered client (*we recommned* [postman](https://www.getpostman.com/docs/postman/launching_postman/installation_and_updates)) start trying the service; refer to the [features](https://github.com/vangav/vos_geo_server#features) and [api](https://github.com/vangav/vos_geo_server#api) sections for reference
+ at the end to stop the service: press `control + d` in the terminal session where the service was started in (10)
+ to stop cassandra: execute `ps auwx | grep cassandra` to get cassandra's `(pid)` then `kill -9 (pid)` to stop cassandra

## features

| controller(s) | feature |
| ---------- | ------- |
| [reverse geo code](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/reverse_geo_code) | transforms request's latitude and longitude into reverse geo code (continent, country, city, ...) and geo hash |
| [top continents](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/top_continents) and [top countries](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/top_countries) | returns the top queried continents and countries |

## database

### [name_index](https://github.com/vangav/vos_geo_server/blob/master/app/com/vangav/vos_geo_server/cassandra_keyspaces/gs_top/NameIndex.java)

+ this table keeps track of all the queried continents and countries; index_key values are continents and countries

| column | type |
| ------ | ---- |
| index_key | varchar |
| index_values | set<varchar> |

### [continents](https://github.com/vangav/vos_geo_server/blob/master/app/com/vangav/vos_geo_server/cassandra_keyspaces/gs_top/Continents.java)

+ this table keeps track of how many times each continent was queried

| column | type |
| ------ | ---- |
| continent | varchar |
| counter_value | counter |

### [countries](https://github.com/vangav/vos_geo_server/blob/master/app/com/vangav/vos_geo_server/cassandra_keyspaces/gs_top/Countries.java)

+ this table keeps track of how many times each country was queried

| column | type |
| ------ | ---- |
| country | varchar |
| counter_value | counter |

## api

### [reverse geo code](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/reverse_geo_code)

#### brief

+ transforms request's latitude and longitude into reverse geo code (continent, country, city, ...) and geo hash

#### request

```json
  "type": "GET",
  "request_params": [
    {
      "name": "latitude",
      "type": "LATITUDE",
      "is_array": false,
      "optionality": "MANDATORY"
    },
    {
      "name": "longitude",
      "type": "LONGITUDE",
      "is_array": false,
      "optionality": "MANDATORY"
    }
  ]
```

#### response

```json
  "response_type": "JSON",
  "response_params": [
    {
      "name": "latitude",
      "type": "double",
      "is_array": false
    },
    {
      "name": "longitude",
      "type": "double",
      "is_array": false
    },
    {
      "name": "geo_hash",
      "type": "String",
      "is_array": false
    },
    {
      "name": "city",
      "type": "String",
      "is_array": false
    },
    {
      "name": "major_city",
      "type": "String",
      "is_array": false
    },
    {
      "name": "country_code",
      "type": "String",
      "is_array": false
    },
    {
      "name": "country",
      "type": "String",
      "is_array": false
    },
    {
      "name": "continent_code",
      "type": "String",
      "is_array": false
    },
    {
      "name": "continent",
      "type": "String",
      "is_array": false
    }
  ]
```













