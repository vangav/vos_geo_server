/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * no license, I know you already got more than enough to worry about
 * keep going, never give up
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
 * Countries represents
 *   Table [countries]
 *   in Keyspace [gs_top]
 * 
 * Name: countries
 * Description:
 *   this table keeps track of how many times each country was queried 
 * 
 * Columns:
 *   country : varchar
 *   counter_value : counter

 * Partition Keys: country
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: update_counter_value
 *   Description:
 *     updates the counter_value of a country every time it gets queried 
 *   Prepared Statement:
 *     UPDATE gs_top.countries SET counter_value = counter_value + 1 WHERE 
 *     country = :country; 
 *   - Name: select_counter_value
 *   Description:
 *     selects a country's counter_value 
 *   Prepared Statement:
 *     SELECT counter_value FROM gs_top.countries WHERE country = 
 *     :country; 
 * */
public class Countries extends Table {

  private static final String kKeySpaceName =
    "gs_top";
  private static final String kTableName =
    "countries";

  public static final String kCountryColumnName =
    "country";
  public static final String kCounterValueColumnName =
    "counter_value";

  /**
   * Query:
   * Name: update_counter_value
   * Description:
   *   updates the counter_value of a country every time it gets queried 
   * Prepared Statement:
   *   UPDATE gs_top.countries SET counter_value = counter_value + 1 WHERE 
   *   country = :country; 
   */
  private static final String kUpdateCounterValueName =
    "update_counter_value";
  private static final String kUpdateCounterValueDescription =
    "updates the counter_value of a country every time it gets queried ";
  private static final String kUpdateCounterValuePreparedStatement =
    "UPDATE gs_top.countries SET counter_value = counter_value + 1 WHERE "
    + "country = :country; ";

  /**
   * Query:
   * Name: select_counter_value
   * Description:
   *   selects a country's counter_value 
   * Prepared Statement:
   *   SELECT counter_value FROM gs_top.countries WHERE country = 
   *   :country; 
   */
  private static final String kSelectCounterValueName =
    "select_counter_value";
  private static final String kSelectCounterValueDescription =
    "selects a country's counter_value ";
  private static final String kSelectCounterValuePreparedStatement =
    "SELECT counter_value FROM gs_top.countries WHERE country = :country; ";

  /**
   * Constructor Countries
   * @return new Countries Object
   * @throws Exception
   */
  private Countries () throws Exception {

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

  private static Countries instance = null;

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

      instance = new Countries();
    }
  }

  /**
   * i
   * @return singleton static instance of Countries
   * @throws Exception
   */
  public static Countries i () throws Exception {

    if (instance == null) {

      instance = new Countries();
    }

    return instance;
  }

  // Query: UpdateCounterValue
  // Description:
  //   updates the counter_value of a country every time it gets queried 
  // Parepared Statement:
  //   UPDATE gs_top.countries SET counter_value = counter_value + 1 WHERE 
  //   country = :country; 

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
   * @param country
   * @return UpdateCounterValue Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableUpdateCounterValue (
    Object country) throws Exception {

    return
      this.getQueryDispatchable(
        kUpdateCounterValueName,
        country);
  }

  /**
   * getBoundStatementUpdateCounterValue
   * @param country
   * @return UpdateCounterValue Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementUpdateCounterValue (
    Object country) throws Exception {

    return
      this.getQuery(kUpdateCounterValueName).getBoundStatement(
        country);
  }

  /**
   * executeAsyncUpdateCounterValue
   * executes UpdateCounterValue Query asynchronously
   * @param country
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncUpdateCounterValue (
    Object country) throws Exception {

    return
      this.getQuery(kUpdateCounterValueName).executeAsync(
        country);
  }

  /**
   * executeSyncUpdateCounterValue
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes UpdateCounterValue Query synchronously
   * @param country
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncUpdateCounterValue (
    Object country) throws Exception {

    return
      this.getQuery(kUpdateCounterValueName).executeSync(
        country);
  }

  // Query: SelectCounterValue
  // Description:
  //   selects a country's counter_value 
  // Parepared Statement:
  //   SELECT counter_value FROM gs_top.countries WHERE country = 
  //   :country; 

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
   * @param country
   * @return SelectCounterValue Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectCounterValue (
    Object country) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectCounterValueName,
        country);
  }

  /**
   * getBoundStatementSelectCounterValue
   * @param country
   * @return SelectCounterValue Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectCounterValue (
    Object country) throws Exception {

    return
      this.getQuery(kSelectCounterValueName).getBoundStatement(
        country);
  }

  /**
   * executeAsyncSelectCounterValue
   * executes SelectCounterValue Query asynchronously
   * @param country
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectCounterValue (
    Object country) throws Exception {

    return
      this.getQuery(kSelectCounterValueName).executeAsync(
        country);
  }

  /**
   * executeSyncSelectCounterValue
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectCounterValue Query synchronously
   * @param country
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectCounterValue (
    Object country) throws Exception {

    return
      this.getQuery(kSelectCounterValueName).executeSync(
        country);
  }

}
