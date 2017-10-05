<%-- 
    Document   : reportPage
    Created on : Oct 8, 2015, 1:14:04 AM
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
            
            $(document).ready(function() {
                $('#reportPage').DataTable();
            } );

        </script>
    </head>
    <body>
         
            <table id="reportPage" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                    <th>Patient Id</th>    
                    <th>Physio Id</th>
                    <th>Signal type</th>
                    <th>Description</th>
                    <th>Report Date</th>
                    <th>DownLoad Report</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List itemListById = (List) request.getAttribute("reportList");
                        if (itemListById != null && itemListById.size() > 0) {
                            int size = itemListById.size();
                            System.out.println("page--------" + size);
                            PatientVO vo = new PatientVO();
                            for (int index = 0; index < size; index++) {
                                vo = (PatientVO) itemListById.get(index);
                                String downLoadReport = "/doctormainaction?action=downLoadReport&docId=" + vo.getPhysioid();


                    %>
                <tr>
                    <td><%=vo.getPatid()%></td>    
                    <td><%=vo.getPhysioid()%></td>
                    <td><%=vo.getSignaltype()%></td>
                    <td><%=vo.getDescription()%></td>
                    <td><%=vo.getUploadDate()%></td>

                    <td>
                         
                            <html:link action="<%=downLoadReport%>">
                                Download Report
                            </html:link>
                         
                    </td>
                </tr>
                
                
                <% } %>
                </tbody>
 <% } else {%>

                <div class="col-md-6 col-md-offset-3" align="center">
                    <div id="header" class="heading" style="background-image: url(img/color2.jpg);">
                        There is no report available for this patient.
                    </div>
                </div>

                <% }%>

            </table>
         
    </body>
</html>
