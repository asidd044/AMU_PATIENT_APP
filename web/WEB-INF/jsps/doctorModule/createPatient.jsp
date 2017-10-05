<%-- 
    Document   : createPatient
    Created on : Oct 7, 2015, 9:37:01 AM
    Author     : one
--%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css"/>
        <title></title>
    </head>
    <%--
    <body style="background-color: whitesmoke;">
        <form action="doctormainaction.do" method="post" class="elegant-aero">
            <table align="center" style="width: 400px;height: 500px;">

                <tr><td><input  required name="name" type="text" placeholder="Name"></td></tr>
                <tr><td> <input required name="email" type="email" placeholder="Email"></td></tr>
                <tr><td><input  required name="emergcon" type="text" placeholder="Emergency Contact" ></td></tr>
                <tr><td><input  required name="gender" type="text" placeholder="Gender" ></td></tr>
                <tr><td>
                        <input  required name="age" type="text" placeholder="Age" >
                        <input  name="action" type="hidden" value="createpatient">
                    </td></tr>
                <tr><td><input type="submit" value="Create Pateint"></td></tr>


            </table>
        </form>         
--%>
      <form action="doctormainaction.do" method="post" class="elegant-aero">
        <div class="tab-content voffset4 text-left">
            <div role="tabpanel" class="tab-pane active">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <h3>Patient Registration</h3>
                        <logic:present name="fail" scope="request">
                            <h4 style="background-color: red;">Registration  fail! Duplicate Email id</h4>
                        </logic:present>
                        <div class="form-group">
                            <input class="form-control"  required name="name" type="text" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <input class="form-control" required name="email" type="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                           <input class="form-control"  required name="emergcon" type="text" placeholder="Emergency Contact" >
                        </div>
                        <div class="form-group">
                           <input class="form-control" required name="gender" type="text" placeholder="Gender" >
                        </div>
                        <div class="form-group">
                            <input  class="form-control" required name="age" type="text" placeholder="Age" >
                        <input  name="action" type="hidden" value="createpatient">
                        </div>
                          <div class="form-group">
                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Creat Patient">
                        </div>

                    </div>
                </div> 
            </div>
        </div>	
    </form>
