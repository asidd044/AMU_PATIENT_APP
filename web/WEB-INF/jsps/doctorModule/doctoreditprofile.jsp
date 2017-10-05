<%-- 
    Document   : patienteditprofile
    Created on : Jan 10, 2016, 11:38:20 PM
    Author     : one
--%>
<%@page import="com.cmu.utils.Country"%>
<%@page import="com.amu.patient.PatientVO"%>
<%@page import="com.amu.doctor.DoctorVo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="tab-content voffset4 text-left">
    <div role="tabpanel" class="tab-pane active">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form action="doctormainaction.do" method="post" class="contact">
                    <logic:present name="successupdate" scope="request">
                        <div class="col-md-6 col-md-offset-3" >
                            <div id="header" class="heading" style="background-image: url(img/color2.jpg);">
                                <h5 style="color: blue;" align="center"> Record updated.</h5>
                            </div>
                        </div>
                    </logic:present>
                    <logic:present name="fail" scope="request">
                        <h4 style="background-color: red;">Registration  fail! Duplicate Email id</h4>
                    </logic:present>

                    <%
                        List pListById = (List) request.getAttribute("docList");
                        int psize = pListById.size();
                        if (psize != 0) {
                            System.out.println("page--------" + psize);
                            DoctorVo dvo = new DoctorVo();
                            for (int pindex = 0; pindex < psize; pindex++) {
                                dvo = (DoctorVo) pListById.get(pindex);

                    %>
                    <div class="form-group">
                        <input value="<%=dvo.getEmail()%>" type="email" readonly  name="email" required class="form-control" placeholder="Email address">
                    </div>
                    <div class="form-group">
                        <input value="<%=dvo.getDocName()%>" class="form-control"   required name="name" type="text" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input value="<%=dvo.getPhoneNumber()%>" class="form-control"  required name="phone" type="text" placeholder="phone">
                    </div>
                    <div class="form-group">
                        <input value="<%=dvo.getDocRegistrationId()%>" class="form-control"  required name="registrationId" type="text" placeholder="Registration Number">
                    </div>
                    <div class="form-group">
                        <input value="<%=dvo.getDocorg()%>" class="form-control"   required name="organization" type="text" placeholder="organization or Hospital Name" >
                    </div>
                    <div class="form-group">
                        <input value="<%=dvo.getDoc_clinic_name()%>" class="form-control"   required name="clinic" type="text" placeholder="Clinic Name">

                    </div>

                    <h4 class="contact-input">Address</h4>
                    <div class="form-group">
                         <select required name="country">
                             
                                <%
                                    List countrydoctorList = (List) request.getAttribute("countryList");
                                    
                                    if (countrydoctorList != null && countrydoctorList.size() > 0) {
                                        int countrydoctorsize = countrydoctorList.size();
                                        System.out.println("countrysize--------" + countrydoctorsize);
                                        Country countrydoctorvo = new Country();
                                        for (int index = 0; index < countrydoctorsize; index++) {
                                            countrydoctorvo = (Country) countrydoctorList.get(index);
                                %>  
                                        <%
                                          if(countrydoctorvo.getCountryName().equalsIgnoreCase(dvo.getCountry())) {
                                              
                                        %>
                                        <option selected value="<%=countrydoctorvo.getCountryName()%>">
                                        <%=countrydoctorvo.getCountryName()%>
                                        
                                        <% } else {%>
                                         <option value="<%=countrydoctorvo.getCountryName()%>">
                                        <%=countrydoctorvo.getCountryName()%>
                                        <% } %>
                                        
                                </option>  
                                <% }
                                    }%>
                            </select>
                            
                      
                               <%-- <input class="form-control" id="textField" 
                                       required name="country"
                                       value="Canada" type="text" 
                                       placeholder="Country">
                               --%>
                        </div>
                    <div class="form-group">
                        
                        <input type="text" placeholder="State/Province"  name="province" id="select" 
                               class="form-control"  value="<%=dvo.getProvince()%>"/>
                                                     
                    </div>
                    <div class="form-group">
                        <input class="form-control"  required name="city" type="text" placeholder="city" value="<%=dvo.getCity()%>" >    
                    </div>
                    <div class="form-group">
                        <input class="form-control"  required name="street" type="text" placeholder="Street" value="<%=dvo.getStreet()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control"  required name="zipCode" type="text" placeholder="Postal Code" value="<%=dvo.getZipcode()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control"  name="action" type="hidden" value="doctorupdateaction">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-lg btn-primary btn-block"  value="Update">
                    </div>

                </form>
            </div> 
        </div> 
    </div>
</div>

<% }
        }%>