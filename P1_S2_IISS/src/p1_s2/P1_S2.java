package p1_s2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/P1_S2")
public class P1_S2 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
HttpSession sesion = request.getSession(true);
sesion.setMaxInactiveInterval(10);
response.setContentType("text/html");
PrintWriter html = response.getWriter();
html.print("<strong>");
Date date = (Date)sesion.getAttribute("date");
if(date != null) {
html.print("�ltimo acceso de la sesi�n: " + date + "<br>");
}
else {
html.print("Este es el primer acceso de la sesi�n <br>");
}
date = new Date();
sesion.setAttribute("date", date);
html.print("Fecha actual: " + date);
html.print("</strong>");

}
}