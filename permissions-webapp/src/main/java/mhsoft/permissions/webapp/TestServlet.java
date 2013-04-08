package mhsoft.permissions.webapp;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mhsoft.permissions.TestEjb;

@WebServlet(urlPatterns = { "/*" })
public class TestServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @EJB
  private TestEjb testEjb;

  @Override
  protected void doGet(final HttpServletRequest arg0, final HttpServletResponse arg1) throws ServletException, IOException {
    this.testEjb.test();
  }

}