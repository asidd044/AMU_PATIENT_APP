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
<form action="patientmainaction.do" method="post" class="register">
    <div class="tab-content voffset4 text-left">
        <div role="tabpanel" class="tab-pane active">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <logic:present name="successupdate" scope="request">
                        <div class="col-md-6 col-md-offset-3" >
                            <div id="header" class="heading" style="background-image: url(img/color2.jpg);">
                                <h5 style="color: blue;" align="center"> Record updated.</h5>
                            </div>
                        </div>
                    </logic:present>
                    <%

                        List pListById = (List) request.getAttribute("patientList");
                        int psize = pListById.size();
                        if (psize != 0) {
                            System.out.println("page--------" + psize);
                            PatientVO pvo = new PatientVO();
                            for (int pindex = 0; pindex < psize; pindex++) {
                                pvo = (PatientVO) pListById.get(pindex);

                    %>
                    <div class="form-group">
                        <select class="form-control" required id="textField" name="docId">
                            <option selected="" value="">Select doctor</option>  
                            <%                                List itemListById = (List) request.getAttribute("doctorList");
                                int size = itemListById.size();
                                if (size != 0) {
                                    System.out.println("page--------" + size);
                                    DoctorVo vo = new DoctorVo();
                                    for (int index = 0; index < size; index++) {
                                        vo = (DoctorVo) itemListById.get(index);
                            %>  
                            <%
                                if (pvo.getDocid().equals(vo.getDocId())) {
                            %>
                            <option selected value="<%=vo.getDocId()%>">
                                <%=vo.getDocName()%>
                            </option>  
                            <% } else {%>
                            <option value="<%=vo.getDocId()%>">
                                <%=vo.getDocName()%>
                            </option>  
                            <%}%>
                            <% }
                                }%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input class="form-control" required id="textField" name="name" type="text" placeholder="Name" value="<%=pvo.getPatientName()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="textField" required name="phone" type="text" placeholder="phone" value="<%=pvo.getPhoneNumber()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control" required id="textField" readonly name="email" type="email" placeholder="Email" value="<%=pvo.getEmail()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control" required id="textField"  name="emergcon" type="text" placeholder="emergency contact" value="<%=pvo.getEmergcon()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control" required id="textField"  name="gender" type="text" placeholder="gender" value="<%=pvo.getGender()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control" required id="textField"  name="age" type="text" placeholder="age" value="<%=pvo.getAge()%>">
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
                                          if(countrydoctorvo.getCountryName().equalsIgnoreCase(pvo.getCountry())) {
                                              
                                        %>
                                        <option selected value="<%=countrydoctorvo.getCountryName()%>">
                                            <%=countrydoctorvo.getCountryName()%> </option>
                                        
                                        <% } else {%>
                                         <option value="<%=countrydoctorvo.getCountryName()%>">
                                        <%=countrydoctorvo.getCountryName()%></option>
                                        <% } %>
                                        
                                 
                                <% }
                                    }%>
                            </select>
                            
                        </div>
                    <div class="form-group">
                        
                        <input type="text" placeholder="State/Province"  name="province"  
                               class="form-control"  value="<%=pvo.getProvince()%>"/>
                                                     
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="textField" required name="city" type="text" placeholder="city" value="<%=pvo.getCity()%>" >    
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="textField" required name="street" type="text" placeholder="Street" value="<%=pvo.getStreet()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="textField" required name="zipCode" type="text" placeholder="Postal Code" value="<%=pvo.getZipcode()%>">
                    </div>
                    <div class="form-group">
                        <input class="form-control"  name="action" type="hidden" value="patientupdateaction">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-lg btn-primary btn-block"  value="Update">
                    </div>

                </div>
            </div> 
        </div>
    </div>	
</form>

<% }
    }%>