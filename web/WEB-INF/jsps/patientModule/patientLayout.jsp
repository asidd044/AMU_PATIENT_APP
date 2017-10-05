<%-- 
    Document   : patientLayout
    Created on : Sep 28, 2015, 10:48:11 PM
    Author     : one
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:getAsString name="title" ignore="true" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title> AMU-Patient Project - Patient Module</title>

<!-- Bootstrap Core CSS -->
<link href="css/app.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/default.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body>
 
<table class="altrowstable" id="alternatecolor" width="100%" style="height: 100%;" cellpadding="10" cellspacing="0">

<tr>

<!-- ============ HEADER SECTION ============== -->
<td colspan="2" style="height: 100px;" align="right">
    <tiles:insert attribute="header" ignore="true" />
</td>
</tr>


<!-- ============ NAVIGATION BAR SECTION ============== -->
 

<tr>
 
<td width="80%" valign="top" bgcolor="">

 <tiles:insert attribute="body" ignore="true" />

</td>
</tr>

<!-- ============ FOOTER SECTION ============== -->
<tr>
    <td colspan="2" align="center" height="20" >
         <tiles:insert attribute="footer" ignore="true" />
    </td>
</tr>
</table>
   
</body>    
