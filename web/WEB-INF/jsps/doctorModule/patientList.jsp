<%-- 
    Document   : patientList
    Created on : Oct 7, 2015, 11:40:03 PM
    Author     : one
--%>

<%@page import="com.amu.patient.PatientVO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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
    text-align: right;
}

p,span{
    color: #00aced;    
}
.td1{
    text-align: right;
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
        <table align="center"> 
            
                <%

                    List itemListById = (List) request.getAttribute("patientList");
                  
                    if (itemListById != null && itemListById.size() > 0) {
                        int size = itemListById.size();
                        System.out.println("page--------" + size);
                        PatientVO vo = new PatientVO();
                        for (int index = 0; index < size; index++) {
                            vo = (PatientVO) itemListById.get(index);
                            String reportUrl = "/doctormainaction?action=patientreport&patientId=" + vo.getPatid();
                            String viewReportUrl = "/doctormainaction?action=viewReportUrl&patientId=" + vo.getPatid();
                %>
                    <tr>
                        <td class="td1">Patient Id <b>:</b></td><td><%=vo.getPatid()%></td> 
                    </tr>
                    <tr>
                        <td class="td1">Patient Name <b>:</b></td><td><%=vo.getPatientName()%></td>
                    </tr>
                    <tr>
                    <td class="td1">Patient Email <b>:</b></td><td><%=vo.getEmail()%></td>
                    </tr>
                    <tr>
                    <td class="td1">Eme. Contact No <b>:</b></td><td><%=vo.getEmergcon()%></td>
                    </tr>
                    <tr>
                    <td class="td1">Gender <b>:</b></td><td><%=vo.getGender()%></td>
                    </tr>
                    <tr>
                    <td class="td1">Age <b>:</b></td><td><%=vo.getAge()%></td>
                    </tr>
                    <tr>
                    <td class="td1">Reports</td><td>
                        <html:link styleClass="btn btn-primary" action="<%=reportUrl%>">
                             Upload Report
                        </html:link>
                            &nbsp; 
                         <html:link styleClass="btn btn-primary" action="<%=viewReportUrl%>">
                            View Reports
                        </html:link>   

                    </td>
                    </tr>
                    
                <tr>
                    <td colspan="1">&nbsp;</td>
                </tr>
                <% } %>
            
            <% } else {%>
            No record.
            <% }%>

        </table>
    </body>
</html>
