package mhsoft.permissions.webapp.starter;

import java.io.File;

import org.apache.log4j.Logger;
import org.glassfish.embeddable.CommandResult;
import org.glassfish.embeddable.CommandResult.ExitStatus;
import org.glassfish.embeddable.CommandRunner;
import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishRuntime;

public class PermissionsWebappStarter {

  private static final Logger LOG = Logger.getLogger(PermissionsWebappStarter.class);

  private static GlassFish glassFish;
  private static CommandRunner commandRunner;
  private static Deployer deployer;
  private static File permissionsWebappFile;

  public static void main(final String[] args) throws GlassFishException {
    startGlassFish();
  }

  private static void startGlassFish() throws GlassFishException {
    initializePermissionsWebappStarter();
    initializeGlassFishInstance();
    deployPermissionsWebappInGlassFishInstance();
    LOG.info("Everything done.");
  }

  private static void initializePermissionsWebappStarter() throws GlassFishException {
    LOG.info("Trying to initialize the environment for the permissions web application starter...");
    createGlassFishInstance();
    startGlassFishInstace();
    getCommandRunnerServiceFromGlassfishInstance();
    getDeployerServiceFromGlassFishInstance();
    findPermissionsWebappFile();
  }

  private static void createGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to create a new glassfish instance...");
    glassFish = GlassFishRuntime.bootstrap().newGlassFish();
    LOG.info("Glassfish instance successfully created.");
  }

  private static void startGlassFishInstace() throws GlassFishException {
    LOG.info("Trying to start the glassfish instance...");
    glassFish.start();
    LOG.info("Glassfish instance successfully started.");
  }

  private static void getCommandRunnerServiceFromGlassfishInstance() throws GlassFishException {
    LOG.info("Trying to receive the command runner service from the glassfish instance...");
    commandRunner = glassFish.getService(CommandRunner.class);
    LOG.info("Command runner service successfully received.");
  }

  private static void getDeployerServiceFromGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to receive the deployer service from the glassfish instance...");
    deployer = glassFish.getService(Deployer.class);
    LOG.info("Deployer service successfully received.");
  }

  private static void findPermissionsWebappFile() throws GlassFishException {
    LOG.info("Trying to find the permissions web application file...");
    final File permissionsWebappDirectory = new File(".." + File.separator + "permissions-webapp" + File.separator + "target");
    LOG.info("Trying to find the probable parent directory of the permissions web application file to look for the permissions web application file...");
    if (permissionsWebappDirectory.isDirectory()) {
      LOG.info("Found the probable parent directory of the permissions web application file: \"" + permissionsWebappDirectory.getAbsolutePath() + "\".");
      permissionsWebappFile = findPermissionsWebappFileInPermissionsWebappDirectory(permissionsWebappDirectory);
      LOG.info("Permissions web application file \"" + permissionsWebappFile.getAbsolutePath() + "\" found.");
    } else {
      throw new GlassFishException("Could not find the parent directory of the permissions web application file. Tried to look in directory: \""
          + permissionsWebappDirectory.getAbsolutePath() + "\".");
    }
  }

  private static File findPermissionsWebappFileInPermissionsWebappDirectory(final File directory) throws GlassFishException {
    LOG.info("Looking in the probable parent directory of the permissions web application file for the permissions web application file...");
    for (final File fileToCheckForPermissionsWebapp : directory.listFiles()) {
      if (fileIsPermissionsWebapp(fileToCheckForPermissionsWebapp)) {
        return fileToCheckForPermissionsWebapp;
      }
    }
    throw new GlassFishException("Permissions web application file not found in directory \"" + directory.getAbsolutePath() + "\".");
  }

  private static boolean fileIsPermissionsWebapp(final File file) {
    final String fileName = file.getName();
    return file.isFile() && fileName.startsWith("permissions-webapp") && fileName.endsWith(".war");
  }

  private static void initializeGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to initialize the glassfish instance...");
    createHttpListenerForGlassFishInstance();
    createThreadPoolForGlassFishInstance();
    createNetworkListenerForGlassFishInstance();
    createPermissionsJDBCConnectionPoolForGlassFishInstance();
    createPermissionsJDBCResourceForGlassFishInstance();
  }

  private static void createHttpListenerForGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to create a http listener (localhost, port 8080) for glassfish instance...");
    final CommandResult commandResult = commandRunner.run("create-http-listener", "--listenerport=8080", "--listeneraddress=0.0.0.0", "--defaultvs=server",
        "glassfish-http-listener");
    if (commandResult.getExitStatus() != ExitStatus.SUCCESS) {
      throw new GlassFishException("Creating http listener for glassfish instance failed. CommandRunner output was: " + commandResult.getOutput() + "\nFailure cause was: "
          + commandResult.getFailureCause());
    }
    LOG.info("Http listener for glassfish instance successfully created.");
  }

  private static void createThreadPoolForGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to create a thread pool with 200 threads for glassfish instance...");
    final CommandResult commandResult = commandRunner.run("create-threadpool", "--maxthreadpoolsize=200", "--minthreadpoolsize=200", "glassfish-thread-pool");
    if (commandResult.getExitStatus() != ExitStatus.SUCCESS) {
      throw new GlassFishException("Creating thread pool for glassfish instance failed. CommandRunner output was: " + commandResult.getOutput() + "\nFailure cause was: "
          + commandResult.getFailureCause());
    }
    LOG.info("Thread pool for glassfish instance successfully created.");
  }

  private static void createNetworkListenerForGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to create a network listener for glassfish instance by using the previously created thread pool...");
    final CommandResult commandResult = commandRunner.run("set", "server.network-config.network-listeners.network-listener."
        + "glassfish-http-listener.thread-pool=glassfish-thread-pool");
    if (commandResult.getExitStatus() != ExitStatus.SUCCESS) {
      throw new GlassFishException("Creating network listener for glassfish instance failed. CommandRunner output was: " + commandResult.getOutput() + "\nFailure cause was: "
          + commandResult.getFailureCause());
    }
    LOG.info("Network listener for glassfish instance successfully created.");
  }

  private static void createPermissionsJDBCConnectionPoolForGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to create a permissions jdbc connection pool for glassfish instance...");
    final CommandResult commandResult = commandRunner.run("create-jdbc-connection-pool", "--datasourceclassname=org.postgresql.ds.PGSimpleDataSource",
        "--restype=javax.sql.DataSource", "--property=user=permissions:password=permissions:DatabaseName=permissions:ServerName=localhost:port=5432", "pms_permissions-pool");
    if (commandResult.getExitStatus() != ExitStatus.SUCCESS) {
      throw new GlassFishException("Creating permissions jdbc pool for glassfish instance failed. CommandRunner output was: " + commandResult.getOutput() + "\nFailure cause was: "
          + commandResult.getFailureCause());
    }
    LOG.info("Permissions JDBC connection pool for glassfish instance successfully created.");
  }

  private static void createPermissionsJDBCResourceForGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to create a permissions jdbc resource for glassfish instance...");
    final CommandResult commandResult = commandRunner.run("create-jdbc-resource", "--connectionpoolid=pms_permissions-pool", "jdbc/pms_permissions");
    if (commandResult.getExitStatus() != ExitStatus.SUCCESS) {
      throw new GlassFishException("Creating permissions jdbc resource for glassfish instance failed. CommandRunner output was: " + commandResult.getOutput()
          + "\nFailure cause was: " + commandResult.getFailureCause());
    }
    LOG.info("Permissions JDBC resource for glassfish instance successfully created.");
  }

  private static void deployPermissionsWebappInGlassFishInstance() throws GlassFishException {
    LOG.info("Trying to deploy the permissions web application: \"" + permissionsWebappFile.getAbsolutePath() + "\"...");
    deployer.deploy(permissionsWebappFile.toURI(), "--contextroot=permissions-webapp", "--force=true");
    LOG.info("Hopefully deployed the permissions web application - please look for exceptions that might have been caught.");
  }

}