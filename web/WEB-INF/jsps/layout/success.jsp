<%-- 
    Document   : success
    Created on : Sep 20, 2015, 6:41:39 PM
   
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<title>JSP Page</title>

<div class="col-md-6 col-md-offset-3">
    <div id="header" class="heading" style="background-image: url(img/color2.jpg);">
        <logic:present name="success" scope="request">
            <h1>Successfully Registered.</h1>

        </logic:present>

        <logic:present name="patientId" scope="request">        
            <h4>patient Id <%=(String) request.getAttribute("patientId")%></h4> 
            <p style="color: inherit"> Please note the Registered patient id for future reference. </p>        
        </logic:present>

        <logic:present name="fail" scope="request">

            <h1> Registration failed.</h1>
        </logic:present>

        <logic:present name="reportSuccess" scope="request">        
            <h1> Report Uploaded Successfully.</h1>
        </logic:present>     
    </div>
</div>
