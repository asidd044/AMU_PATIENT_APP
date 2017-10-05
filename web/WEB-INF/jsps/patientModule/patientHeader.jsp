<%-- 
    Document   : pateintHeader
    Created on : Sep 28, 2015, 10:06:13 PM
    Author     : one
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%
    
String viewReportUrl = "/patientmainaction?action=viewReportUrl&patientId="+(String) session.getAttribute("patientId");
String myProfile = "/patientmainaction?action=myProfile&patientId="+(String) session.getAttribute("patientId");
%>

<div id="page-header" style="background-image: url(img/color2.jpg);">
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav" style="background-image: url(img/white.jpg);">
            <div class="navbar-header"> <a class="navbar-brand topnav" href="#">AMU Project - Patient Module</a> </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="nav navbar-nav navbar-right nav-top-btns">        
                   <html:link styleClass="btn btn-primary" action="<%=viewReportUrl%>">Patient Report &nbsp;</html:link> 
                   <html:link styleClass="btn btn-primary" action="<%=myProfile%>">My Profile &nbsp;</html:link> 
                   <html:link styleClass="btn btn-primary" action="/mainaction?action=logout">Logout</html:link> 
                </div>
            </div>
        </div>
    </nav>
</div>