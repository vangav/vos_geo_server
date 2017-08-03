
> **why?** geo server is a next level template for [vangav backend](https://github.com/vangav/vos_backend) where database and geo services utility are used

# geo server

+ geo server service is generated using [vangav backend](https://github.com/vangav/vos_backend)

## prerequisite

+ [vangav backend tutorials](https://github.com/vangav/vos_backend)

## functionality

+ transforms geo coordinates (latitude and longitude) into reverse geo code and geo hash
+ it also offers getting top queried continents and countries

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

## covered topics

+ generate a service with multi-entry-point api
+ generate a database
+ use the geo services utility

## features

| controller(s) | feature |
| ---------- | ------- |
| [reverse geo code](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/reverse_geo_code) | transforms request's latitude and longitude into reverse geo code (continent, country, city, ...) and geo hash |
| [top continents](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/top_continents) and [top countries](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers/top_countries) | returns the top queried continents and countries |

## service references

| reference | explanation |
| --------- | ----------- |
| [routes](https://github.com/vangav/vos_geo_server/blob/master/conf/routes) | api routes |
| [reverse_geo_coding](https://github.com/vangav/vos_geo_server/tree/master/conf/data/geo/reverse_geo_coding) | reverse geo coding data |
| [controllers.json](https://github.com/vangav/vos_geo_server/blob/master/generator_config/controllers.json) | api request/response's elements |
| [gs_top.keyspace](https://github.com/vangav/vos_geo_server/blob/master/generator_config/gs_top.keyspace) | `gs_top` is the keysapce for all the tables keeping track of the most queried continents and countries |
| [Global.java](https://github.com/vangav/vos_geo_server/blob/master/app/Global.java#L98) | reverse geo coding initialization |
| [common](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/common) | handles common operations like initializing the continents/countries names index |
| [controllers](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers) | api implementation |
| [gs_top](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/cassandra_keyspaces/gs_top) | `gs_top` keyspace cassandra client |

## change log

+ this section lists the 10-% code added after vangav backend generated 90+% of the code

| file/dir | change |
| -------- | ------ |
| [conf/data](https://github.com/vangav/vos_geo_server/tree/master/conf/data/geo/reverse_geo_coding) | added reverse geo coding data from vangav backend's [data](https://github.com/vangav/vos_backend/tree/master/data) |
| [Global.java](https://github.com/vangav/vos_geo_server/blob/master/app/Global.java) | added reverse geo coding initialization in `beforeStart` method |
| [common](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/common) | contains common operations like initializing the continents/countries names index |
| [controllers](https://github.com/vangav/vos_geo_server/tree/master/app/com/vangav/vos_geo_server/controllers) | added the implementation of request processing logic under `controller_name/HandlerControllerName.java` classes and nested response json structures under `controller_name/response_json` packages |
