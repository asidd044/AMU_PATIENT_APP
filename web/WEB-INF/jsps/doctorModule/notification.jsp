<%-- 
    Document   : patientList
    Created on : Oct 7, 2015, 11:40:03 PM
    Author     : one
--%>

<%@page import="com.amu.patient.PatientVO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/dataTables.bootstrap.min.css" type="text/css"/>	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>

        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap.min.js"></script>
        <script>

            $(document).ready(function () {
                $('#patientList').DataTable();
            });

        </script>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }
            .td1{
                text-align: left;
            }

            p,span{
                color: #00aced;    
            }
            .td1{
                text-align: left;
                color: #00aced;
                font-size: 18px;
            }
            .td1.orange {color: #ff9933;} 

            th, td {
                padding: 8px;   
                border-bottom: 1px solid #ddd;
                font-family: 'dax-regularregular', sans-serif;

            }
        </style>
    </head>
    <body>
        <form action="doctormainaction.do" method="post">
        <table align="center"> 
           
            <tr>
                <td>
                    
                    <logic:present name="acceptall" scope="request">
                    <h1> All the Patient Accepted. </h1>
                    </logic:present>
                    <logic:present name="declineall" scope="request">
                    <h1> All the Patient Declined</h1>
                    </logic:present>
                    
                    <logic:present name="decline" scope="request">
                    <h1> Selected Patient is Declined</h1>
                    </logic:present>
                    <logic:present name="accept" scope="request">
                    <h1> Selected Patient is Accepted</h1>
                    </logic:present>
                </td>
            </tr>
            <tr>
                
                <td>
                    
                    <html:link styleClass="btn btn-primary" action="/doctormainaction?action=acceptall">Accept all</html:link>
                    <html:link styleClass="btn btn-primary" action="/doctormainaction?action=declineall">Decline all</html:link>
                    <input class="btn btn-primary" type="Submit" name="action" value="Accept"/>
                    <input class="btn btn-primary" type="Submit" name="action" value="Decline"/>
                           
                   <%-- <html:link styleClass="btn btn-primary" action="/doctormainaction?action=accept">Accept</html:link>
                    <html:link styleClass="btn btn-primary" action="/doctormainaction?action=decline">Decline</html:link>
                   --%>
                </td>
                </tr>
                
                <%
                List itemListById2 = (List) request.getSession().getAttribute("notificationpatientList");
                if(itemListById2 == null || itemListById2.size() == 0) {
                    %>
                 <tr>
                    <td>
                    No record.
                 </td>
                </tr>
                <% }%>    
                
            <%

                List itemListById = (List) request.getSession().getAttribute("notificationpatientList");
                if(itemListById != null && itemListById.size() > 0) {
                int size = itemListById.size();
                if (itemListById != null && itemListById.size() > 0) {
                    System.out.println("page--------" + size);
                    PatientVO vo = new PatientVO();
                    for (int index = 0; index < size; index++) {
                        vo = (PatientVO) itemListById.get(index);
                        String reportUrl = "/doctormainaction?action=patientreport&patientId=" + vo.getPatid();
                        String viewReportUrl = "/doctormainaction?action=viewReportUrl&patientId=" + vo.getPatid();
            %>
            <tr>
                <td class="td1">

                    <input type="checkbox" name="patIdnotification" value="<%=vo.getPatid()%>">
                    <b> &nbsp;</b><%=vo.getPatientName()%> <b>,</b>
                    <%=vo.getPhoneNumber()%><b>, <%=vo.getCity()%>, <%=vo.getProvince()%></b>

                </td>

            </tr>



            <% } 
                
             %>

            <% } } else {%>
             
            <% }%>
            
        </table>
       </form>

    </body>
</html>
