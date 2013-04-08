package mhsoft.permissions.integration;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class PermissionsIntegrationListener implements ServletContextListener {

  private static final Logger LOG = Logger.getLogger(PermissionsIntegrationListener.class);

  @EJB
  private PermissionsDefaultEntriesIntegration permissionsDefaultEntriesIntegration;

  @Override
  public void contextInitialized(final ServletContextEvent servletContextEvent) {
    LOG.info("Integrating liquibase...");
    LiquibaseIntegration.run(servletContextEvent.getServletContext());
    LOG.info("Liquibase integration finished.");
    LOG.info("Integrating permissions default entries...");
    this.permissionsDefaultEntriesIntegration.run();
    LOG.info("Permissions default entry integration finished...");
  }

  @Override
  public void contextDestroyed(final ServletContextEvent servletContextEvent) {
  }

}