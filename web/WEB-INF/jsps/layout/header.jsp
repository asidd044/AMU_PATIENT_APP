<%-- 
    Document   : header
    Created on : Aug 18, 2015, 5:24:39 PM
    Author     : one
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css">

<div id="page-header" style="background-image: url(img/color2.jpg);">
  <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
  <div class="container topnav" style="background-image: url(img/white.jpg);">
    <div class="navbar-header"> 
        <a class="navbar-brand topnav" href="mainaction.do"><h4>Home</h4></a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <div class="nav navbar-nav navbar-right nav-top-btns">        
        <html:link styleClass="btn btn-primary" action="/mainaction?action=doctormodule">Doctor</html:link>
        <html:link styleClass="btn btn-primary" action="/mainaction?action=patientmodule">Patient</html:link>
      </div>
    </div>
  </div>
</nav>
</div>
     