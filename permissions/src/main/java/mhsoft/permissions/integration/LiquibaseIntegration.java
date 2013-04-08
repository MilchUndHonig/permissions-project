package mhsoft.permissions.integration;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.CompositeResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;

import org.apache.log4j.Logger;

public class LiquibaseIntegration {

  private static final Logger LOG = Logger.getLogger(LiquibaseIntegration.class);

  public static void run(final ServletContext servletContext) {
    LOG.info("Trying to open an sql connection for permissions and execute all liquibase changesets that were not executed...");
    tryToOpenConnectionAndExecuteChangeSetForDataSource("liquibase/permissions_changelogs.xml", "jdbc/pms_permissions");
    LOG.info("Permission liquibase integration finished.");
  }

  private static void tryToOpenConnectionAndExecuteChangeSetForDataSource(final String changeSetPath, final String dataSourceName) {
    try {
      openConnectionAndExecuteChangeSetForDataSource(changeSetPath, dataSourceName);
      LOG.info("Finished executing changeset \"" + changeSetPath + "\" on connection \"" + dataSourceName + "\".");
    } catch (final Exception e) {
      throw new RuntimeException("Liquibase failed. Nested exception was: ", e);
    }
  }

  private static void openConnectionAndExecuteChangeSetForDataSource(final String changeSetPath, final String dataSourceName) throws NamingException, SQLException,
      LiquibaseException {
    final Context context = null;
    Connection connection = null;
    try {
      LOG.info("Opening connection for \"" + dataSourceName + "\" and executing change set \"" + changeSetPath + "\"...");
      connection = initializeConnectionForContextAndDataSource(context, dataSourceName);
      final Database database = initializeDatabaseForConnection(connection);
      executeChangeSetOnDatabase(changeSetPath, database);
    } finally {
      closeContext(context);
      closeConnection(connection);
    }
  }

  private static Connection initializeConnectionForContextAndDataSource(Context context, final String dataSourceName) throws NamingException, SQLException {
    LOG.info("Initializing connection for context and data source \"" + dataSourceName + "\"...");
    context = new InitialContext();
    final DataSource dataSource = (DataSource) context.lookup(dataSourceName);
    return dataSource.getConnection();
  }

  private static Database initializeDatabaseForConnection(final Connection connection) throws DatabaseException {
    LOG.info("Initializing database for connection...");
    final Database result = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
    result.setDefaultSchemaName(null);
    return result;
  }

  private static void executeChangeSetOnDatabase(final String changeSetPath, final Database database) throws LiquibaseException {
    LOG.info("Executing change sets \"" + changeSetPath + "\" on database...");
    final Liquibase liquibase = new Liquibase(changeSetPath, new CompositeResourceAccessor(new ClassLoaderResourceAccessor(), new FileSystemResourceAccessor(),
        new ClassLoaderResourceAccessor(Thread.currentThread().getContextClassLoader())), database);
    liquibase.update(null);
  }

  private static void closeContext(final Context context) throws NamingException {
    if (context != null) {
      LOG.info("Closing context...");
      context.close();
    }
  }

  private static void closeConnection(final Connection connection) throws SQLException {
    if (connection != null) {
      LOG.info("Closing connection...");
      connection.close();
    }
  }

}