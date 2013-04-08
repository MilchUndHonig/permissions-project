# Permissions Project

CAUTION: At this time, this project is under development and the first version is not yet released, so look in the source code and use this project as a base, or wait until the first release is released :)

This project contains:

 - a parent maven project
 - a sample maven web application project
 - a maven web application starter proejct
 - the maven permissions main project

The parent maven project only contains a pom file for general settings and multi-moduling and two eclipse launch configurations which does not mean that you have to use eclipse to develop on it.
The sample web application project contains a web application that only contains needed stuff for integrating the permissions project (the web application has to be at least a web application 2.5 and has to include the PermissionsIntegrationListener for database migration and default configuration).
The web application starter project contains a main class setting up a glassfish server instance (setting up a jdbc-pool and a jdbc resource) containing the sample web application which is using the permissions main project dependency.
The permissions main project dependency manages permissions, roles, clients and users and needs a server providing a jdbc resource called "jdbc/permissions", EJB 3 and JPA.

## Setup for development

Check out the whole project, convert it to a maven project, import the other projects inside.
Start "Permissions Project Build.launch" launch configuration (in the root directory) to build the project (if not using eclipse, a maven clean install on the root project will do).
Start "Permissions Webapp Starter.launch" launch configuration to start a glassfish instance containing the permissions main project (if not using eclipse, run the main method in PermissionsWebappStarter.java).

## Setup for usage

To use this project in a web application, simply include the maven dependency "permissions", add the PermissionsIntegrationListener to the web.xml and launch the web application in an application server environment providing a jdbc resource with the name "jdbc/permission", EJB 3 and JPA.