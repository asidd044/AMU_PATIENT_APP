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
        <link rel="stylesheet" href="css/table.css" type="text/css"/>	
        <title>JSP Page</title>
    </head>
    <body>
        <div class="CSS_Table_Example">
            <table>
                <tr><td colspan="2">My Profile </td> </tr>  
            <%

                List itemListById = (List) request.getAttribute("patientList");
                int size = itemListById.size();
                if (size != 0) {
                    System.out.println("page--------" + size);
                    PatientVO vo = new PatientVO();
                    for (int index = 0; index < size; index++) {
                        vo = (PatientVO) itemListById.get(index);
                        String editUrl = "./patientmainaction.do?action=peditprofile&patientId=" + vo.getPatid();
            %>

            <tr> <td>Id</td><td><%=vo.getPatid()%> <a href="<%=editUrl%>">Edit Profile</a></td> </tr>    
            <tr> <td>Name</td><td><%=vo.getPatientName()%></td></tr>
            <tr><td>Email</td><td><%=vo.getEmail()%></td></tr>
            <tr><td>Emergency Contact</td><td><%=vo.getEmergcon()%></td></tr>
            <tr> <td>Gender</td><td><%=vo.getGender()%></td></tr>
            <tr> <td>Age</td><td><%=vo.getAge()%></td></tr>

            <% }
            } else {%>
            No Patient.
            <% }%>

        </table>
    </div>
    </body>
</html>
