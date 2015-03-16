<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><title>JSP Templates</title></head>
<body background='graphics/background.jpg'>
<table>
   <tr valign='top'><td><%@include file='sidebar.html'%></td>
      <td><table>
         <tr><td><%@include file='header.html'%></td></tr>
         <tr><td><%@include file='introduction.html'%></td></tr>
         <tr><td><%@include file='footer.html'%></td></tr>
         </table>
      </td>
   </tr>
</table>
</body></html>