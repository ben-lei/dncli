package com.dnmaze.dncli.dnt;

import java.io.Closeable;
import java.sql.Connection;

/**
 * Created by blei on 9/27/16.
 */
public interface Dnt extends Closeable {
  /** Get table name from a name (name is the file name with extension stripped). */
  String normalizeName(String name);

  /** Gets a JDBC connection. */
  Connection getConnection();

  /** Finalizes anything you want to do after DNT data has been propagated to MySQL/H2 server. */
  void process();
}
