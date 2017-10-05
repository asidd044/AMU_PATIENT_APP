<%-- 
    Document   : doctorHeader
    Created on : Sep 28, 2015, 10:06:44 PM
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<link rel="stylesheet" href="css/style.css">

<div id="page-header" style="background-image: url(img/color2.jpg);">
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav" style="background-image: url(img/white.jpg);">
            <div class="navbar-header"> <a class="navbar-brand topnav" href="#">AMU Project - Doctor Module -- <%=session.getAttribute("docId")%></a> </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="nav navbar-nav navbar-right nav-top-btns">        
                    <%--<html:link styleClass="btn btn-primary" action="/doctormainaction?action=patientregistrationPage">Create Patient</html:link>--%>
                    <html:link styleClass="btn btn-primary" action="/doctormainaction?action=notificationpatientList">Notification</html:link>
                    <html:link styleClass="btn btn-primary" action="/doctormainaction?action=patientList">Patient List</html:link>
                    <html:link styleClass="btn btn-primary" action="/doctormainaction?action=docprofile">My Profile</html:link> 
                    <html:link styleClass="btn btn-primary" action="/mainaction?action=logout">Logout</html:link> 
                </div>
            </div>
        </div>
    </nav>
</div>