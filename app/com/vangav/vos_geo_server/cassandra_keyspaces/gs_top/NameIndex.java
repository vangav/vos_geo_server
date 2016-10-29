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
 * NameIndex represents
 *   Table [name_index]
 *   in Keyspace [gs_top]
 * 
 * Name: name_index
 * Description:
 *   This table keeps track of all the queried continents and countries. 
 *   index_key values are continents and countries. 
 * 
 * Columns:
 *   index_key : varchar
 *   index_values : set<varchar>

 * Partition Keys: index_key
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: insert
 *   Description:
 *     used to init the table's index_keys upon first run 
 *   Prepared Statement:
 *     INSERT INTO gs_top.name_index (index_key) VALUES (:index_key); 
 *   - Name: update
 *   Description:
 *     updates the index_values for an index_key 
 *   Prepared Statement:
 *     UPDATE gs_top.name_index SET index_values = index_values + 
 *     :index_values WHERE index_key = :index_key; 
 *   - Name: select
 *   Description:
 *     selects an index_key's index_values 
 *   Prepared Statement:
 *     SELECT index_values FROM gs_top.name_index WHERE index_key = 
 *     :index_key; 
 * */
public class NameIndex extends Table {

  private static final String kKeySpaceName =
    "gs_top";
  private static final String kTableName =
    "name_index";

  public static final String kIndexKeyColumnName =
    "index_key";
  public static final String kIndexValuesColumnName =
    "index_values";

  /**
   * Query:
   * Name: insert
   * Description:
   *   used to init the table's index_keys upon first run 
   * Prepared Statement:
   *   INSERT INTO gs_top.name_index (index_key) VALUES (:index_key); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "used to init the table's index_keys upon first run ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO gs_top.name_index (index_key) VALUES (:index_key); ";

  /**
   * Query:
   * Name: update
   * Description:
   *   updates the index_values for an index_key 
   * Prepared Statement:
   *   UPDATE gs_top.name_index SET index_values = index_values + 
   *   :index_values WHERE index_key = :index_key; 
   */
  private static final String kUpdateName =
    "update";
  private static final String kUpdateDescription =
    "updates the index_values for an index_key ";
  private static final String kUpdatePreparedStatement =
    "UPDATE gs_top.name_index SET index_values = index_values + "
    + ":index_values WHERE index_key = :index_key; ";

  /**
   * Query:
   * Name: select
   * Description:
   *   selects an index_key's index_values 
   * Prepared Statement:
   *   SELECT index_values FROM gs_top.name_index WHERE index_key = 
   *   :index_key; 
   */
  private static final String kSelectName =
    "select";
  private static final String kSelectDescription =
    "selects an index_key's index_values ";
  private static final String kSelectPreparedStatement =
    "SELECT index_values FROM gs_top.name_index WHERE index_key = "
    + ":index_key; ";

  /**
   * Constructor NameIndex
   * @return new NameIndex Object
   * @throws Exception
   */
  private NameIndex () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kInsertDescription,
        kInsertName,
        kInsertPreparedStatement),
      new Query (
        kUpdateDescription,
        kUpdateName,
        kUpdatePreparedStatement),
      new Query (
        kSelectDescription,
        kSelectName,
        kSelectPreparedStatement));
  }

  private static NameIndex instance = null;

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

      instance = new NameIndex();
    }
  }

  /**
   * i
   * @return singleton static instance of NameIndex
   * @throws Exception
   */
  public static NameIndex i () throws Exception {

    if (instance == null) {

      instance = new NameIndex();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   used to init the table's index_keys upon first run 
  // Parepared Statement:
  //   INSERT INTO gs_top.name_index (index_key) VALUES (:index_key); 

  /**
   * getQueryInsert
   * @return Insert Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryInsert (
    ) throws Exception {

    return this.getQuery(kInsertName);
  }

  /**
   * getQueryDispatchableInsert
   * @param indexkey
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object indexkey) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        indexkey);
  }

  /**
   * getBoundStatementInsert
   * @param indexkey
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object indexkey) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        indexkey);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param indexkey
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object indexkey) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        indexkey);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param indexkey
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object indexkey) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        indexkey);
  }

  // Query: Update
  // Description:
  //   updates the index_values for an index_key 
  // Parepared Statement:
  //   UPDATE gs_top.name_index SET index_values = index_values + 
  //   :index_values WHERE index_key = :index_key; 

  /**
   * getQueryUpdate
   * @return Update Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryUpdate (
    ) throws Exception {

    return this.getQuery(kUpdateName);
  }

  /**
   * getQueryDispatchableUpdate
   * @param indexvalues
   * @param indexkey
   * @return Update Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableUpdate (
    Object indexvalues,
    Object indexkey) throws Exception {

    return
      this.getQueryDispatchable(
        kUpdateName,
        indexvalues,
        indexkey);
  }

  /**
   * getBoundStatementUpdate
   * @param indexvalues
   * @param indexkey
   * @return Update Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementUpdate (
    Object indexvalues,
    Object indexkey) throws Exception {

    return
      this.getQuery(kUpdateName).getBoundStatement(
        indexvalues,
        indexkey);
  }

  /**
   * executeAsyncUpdate
   * executes Update Query asynchronously
   * @param indexvalues
   * @param indexkey
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncUpdate (
    Object indexvalues,
    Object indexkey) throws Exception {

    return
      this.getQuery(kUpdateName).executeAsync(
        indexvalues,
        indexkey);
  }

  /**
   * executeSyncUpdate
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Update Query synchronously
   * @param indexvalues
   * @param indexkey
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncUpdate (
    Object indexvalues,
    Object indexkey) throws Exception {

    return
      this.getQuery(kUpdateName).executeSync(
        indexvalues,
        indexkey);
  }

  // Query: Select
  // Description:
  //   selects an index_key's index_values 
  // Parepared Statement:
  //   SELECT index_values FROM gs_top.name_index WHERE index_key = 
  //   :index_key; 

  /**
   * getQuerySelect
   * @return Select Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelect (
    ) throws Exception {

    return this.getQuery(kSelectName);
  }

  /**
   * getQueryDispatchableSelect
   * @param indexkey
   * @return Select Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelect (
    Object indexkey) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectName,
        indexkey);
  }

  /**
   * getBoundStatementSelect
   * @param indexkey
   * @return Select Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelect (
    Object indexkey) throws Exception {

    return
      this.getQuery(kSelectName).getBoundStatement(
        indexkey);
  }

  /**
   * executeAsyncSelect
   * executes Select Query asynchronously
   * @param indexkey
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelect (
    Object indexkey) throws Exception {

    return
      this.getQuery(kSelectName).executeAsync(
        indexkey);
  }

  /**
   * executeSyncSelect
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Select Query synchronously
   * @param indexkey
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelect (
    Object indexkey) throws Exception {

    return
      this.getQuery(kSelectName).executeSync(
        indexkey);
  }

}
