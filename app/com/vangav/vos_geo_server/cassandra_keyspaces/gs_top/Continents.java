/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * MIT License
 *
 * Copyright (c) 2016 Vangav
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 * */

/**
 * Community
 * Facebook Group: Vangav Open Source - Backend
 *   fb.com/groups/575834775932682/
 * Facebook Page: Vangav
 *   fb.com/vangav.f
 * 
 * Third party communities for Vangav Backend
 *   - play framework
 *   - cassandra
 *   - datastax
 *   
 * Tag your question online (e.g.: stack overflow, etc ...) with
 *   #vangav_backend
 *   to easier find questions/answers online
 * */

package com.vangav.vos_geo_server.cassandra_keyspaces.gs_top;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.vangav.backend.cassandra.keyspaces.Query;
import com.vangav.backend.cassandra.keyspaces.Table;
import com.vangav.backend.cassandra.keyspaces.dispatch_message.QueryDispatchable;

/**
 * GENERATED using JavaClientGeneratorMain.java
 */
/**
 * Continents represents
 *   Table [continents]
 *   in Keyspace [gs_top]
 * 
 * Name: continents
 * Description:
 *   this table keeps track of how many times each continent was queried 
 * 
 * Columns:
 *   continent : varchar
 *   counter_value : counter

 * Partition Keys: continent
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: update_counter_value
 *   Description:
 *     updates the counter_value of a continent every time it gets queried 
 *   Prepared Statement:
 *     UPDATE gs_top.continents SET counter_value = counter_value + 1 
 *     WHERE continent = :continent; 
 *   - Name: select_counter_value
 *   Description:
 *     selects a continent's counter_value 
 *   Prepared Statement:
 *     SELECT counter_value FROM gs_top.continents WHERE continent = 
 *     :continent; 
 * */
public class Continents extends Table {

  private static final String kKeySpaceName =
    "gs_top";
  private static final String kTableName =
    "continents";

  public static final String kContinentColumnName =
    "continent";
  public static final String kCounterValueColumnName =
    "counter_value";

  /**
   * Query:
   * Name: update_counter_value
   * Description:
   *   updates the counter_value of a continent every time it gets queried 
   * Prepared Statement:
   *   UPDATE gs_top.continents SET counter_value = counter_value + 1 
   *   WHERE continent = :continent; 
   */
  private static final String kUpdateCounterValueName =
    "update_counter_value";
  private static final String kUpdateCounterValueDescription =
    "updates the counter_value of a continent every time it gets queried ";
  private static final String kUpdateCounterValuePreparedStatement =
    "UPDATE gs_top.continents SET counter_value = counter_value + 1 WHERE "
    + "continent = :continent; ";

  /**
   * Query:
   * Name: select_counter_value
   * Description:
   *   selects a continent's counter_value 
   * Prepared Statement:
   *   SELECT counter_value FROM gs_top.continents WHERE continent = 
   *   :continent; 
   */
  private static final String kSelectCounterValueName =
    "select_counter_value";
  private static final String kSelectCounterValueDescription =
    "selects a continent's counter_value ";
  private static final String kSelectCounterValuePreparedStatement =
    "SELECT counter_value FROM gs_top.continents WHERE continent = "
    + ":continent; ";

  /**
   * Constructor Continents
   * @return new Continents Object
   * @throws Exception
   */
  private Continents () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kUpdateCounterValueDescription,
        kUpdateCounterValueName,
        kUpdateCounterValuePreparedStatement),
      new Query (
        kSelectCounterValueDescription,
        kSelectCounterValueName,
        kSelectCounterValuePreparedStatement));
  }

  private static Continents instance = null;

  /**
   * loadTable
   * OPTIONAL method
   * instance is created either upon calling this method or upon the first call
   *   to singleton instance method i
   * this method is useful for loading upon program start instead of loading
   *   it upon the first use since there's a small time overhead for loading
   *   since all queries are prepared synchronously in a blocking network
   *   operation with Cassandra's server
   * @throws Exception
   */
  public static void loadTable () throws Exception {

    if (instance == null) {

      instance = new Continents();
    }
  }

  /**
   * i
   * @return singleton static instance of Continents
   * @throws Exception
   */
  public static Continents i () throws Exception {

    if (instance == null) {

      instance = new Continents();
    }

    return instance;
  }

  // Query: UpdateCounterValue
  // Description:
  //   updates the counter_value of a continent every time it gets queried 
  // Parepared Statement:
  //   UPDATE gs_top.continents SET counter_value = counter_value + 1 
  //   WHERE continent = :continent; 

  /**
   * getQueryUpdateCounterValue
   * @return UpdateCounterValue Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryUpdateCounterValue (
    ) throws Exception {

    return this.getQuery(kUpdateCounterValueName);
  }

  /**
   * getQueryDispatchableUpdateCounterValue
   * @param continent
   * @return UpdateCounterValue Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableUpdateCounterValue (
    Object continent) throws Exception {

    return
      this.getQueryDispatchable(
        kUpdateCounterValueName,
        continent);
  }

  /**
   * getBoundStatementUpdateCounterValue
   * @param continent
   * @return UpdateCounterValue Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementUpdateCounterValue (
    Object continent) throws Exception {

    return
      this.getQuery(kUpdateCounterValueName).getBoundStatement(
        continent);
  }

  /**
   * executeAsyncUpdateCounterValue
   * executes UpdateCounterValue Query asynchronously
   * @param continent
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncUpdateCounterValue (
    Object continent) throws Exception {

    return
      this.getQuery(kUpdateCounterValueName).executeAsync(
        continent);
  }

  /**
   * executeSyncUpdateCounterValue
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes UpdateCounterValue Query synchronously
   * @param continent
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncUpdateCounterValue (
    Object continent) throws Exception {

    return
      this.getQuery(kUpdateCounterValueName).executeSync(
        continent);
  }

  // Query: SelectCounterValue
  // Description:
  //   selects a continent's counter_value 
  // Parepared Statement:
  //   SELECT counter_value FROM gs_top.continents WHERE continent = 
  //   :continent; 

  /**
   * getQuerySelectCounterValue
   * @return SelectCounterValue Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectCounterValue (
    ) throws Exception {

    return this.getQuery(kSelectCounterValueName);
  }

  /**
   * getQueryDispatchableSelectCounterValue
   * @param continent
   * @return SelectCounterValue Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectCounterValue (
    Object continent) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectCounterValueName,
        continent);
  }

  /**
   * getBoundStatementSelectCounterValue
   * @param continent
   * @return SelectCounterValue Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectCounterValue (
    Object continent) throws Exception {

    return
      this.getQuery(kSelectCounterValueName).getBoundStatement(
        continent);
  }

  /**
   * executeAsyncSelectCounterValue
   * executes SelectCounterValue Query asynchronously
   * @param continent
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectCounterValue (
    Object continent) throws Exception {

    return
      this.getQuery(kSelectCounterValueName).executeAsync(
        continent);
  }

  /**
   * executeSyncSelectCounterValue
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectCounterValue Query synchronously
   * @param continent
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectCounterValue (
    Object continent) throws Exception {

    return
      this.getQuery(kSelectCounterValueName).executeSync(
        continent);
  }

}
