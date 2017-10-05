<%-- 
    Document   : login
    Created on : Sep 20, 2015, 4:26:05 PM
    Author     : one
--%>

<%@page import="com.cmu.utils.Country"%>
<%@page import="com.amu.doctor.DoctorVo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/fm.selectator.jquery.css" type="text/css"/>
        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/fm.selectator.jquery.js"></script>

        <style>
            body {
                font-family: sans-serif;
                margin: 0;
                padding: 0;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            #wrapper {
                padding: 15px;
            }
            #select1 {
                width: 250px;
                padding: 7px 10px;
            }
            #select2 {
                padding: 5px;
                width: 350px;
                height: 36px;
            }
            #select3 {
                width: 350px;
                height: 36px;
            }		
            #select4 {
                width: 350px;
                height: 36px;
            }		
            #select5 {
                width: 350px;
                height: 50px;
            }		
        </style>
        <script>
            $(function () {
                
                var $activate_selectator1 = $('#activate_selectator1');
                $activate_selectator1.click(function () {
                    var $select1 = $('#select1');
                    if ($select1.data('selectator') === undefined) {
                        $select1.selectator({
                            labels: {
                                search: 'Search here...'
                            }
                        });
                        $activate_selectator1.val('destroy selectator');
                    } else {
                        $select1.selectator('destroy');
                        $activate_selectator1.val('activate selectator');
                    }
                });
                $activate_selectator1.trigger('click');

                var $activate_selectator2 = $('#activate_selectator2');
                
                    $activate_selectator2.click(function () {
                     
                    var $select2 = $('#select2');
                    if ($select2.data('selectator') === undefined) {
                        
                        $select2.selectator({
                            useDimmer: true
                        });
                        $activate_selectator2.val('destroy selectator');
                    } else {
                        $select2.selectator('destroy');
                        $activate_selectator2.val('activate selectator');
                    }
                });
                $activate_selectator2.trigger('click');

               var $activate_selectator3 = $('#activate_selectator3');
                
                    $activate_selectator3.click(function () {
                     
                    var $select3 = $('#select3');
                    if ($select3.data('selectator') === undefined) {
                        
                        $select3.selectator({
                            useDimmer: true
                        });
                        $activate_selectator3.val('destroy selectator');
                    } else {
                        $select2.selectator('destroy');
                        $activate_selectator3.val('activate selectator');
                    }
                });
                $activate_selectator3.trigger('click');

                var $activate_selectator4 = $('#activate_selectator4');
                
                    $activate_selectator4.click(function () {
                     
                    var $select4 = $('#select4');
                    if ($select4.data('selectator') === undefined) {
                        
                        $select4.selectator({
                            useDimmer: true
                        });
                        $activate_selectator4.val('destroy selectator');
                    } else {
                        $select4.selectator('destroy');
                        $activate_selectator4.val('activate selectator');
                    }
                });
                $activate_selectator4.trigger('click');

                var $activate_selectator5 = $('#activate_selectator5');
                $activate_selectator5.click(function () {
                    var $select5 = $('#select5');
                    if ($select5.data('selectator') === undefined) {
                        $select5.selectator({
                            useSearch: false
                        });
                        $activate_selectator5.val('destroy selectator');
                    } else {
                        $select5.selectator('destroy');
                        $activate_selectator5.val('activate selectator');
                    }
                });
                $activate_selectator5.trigger('click');
            });
        </script>
    </head>
    <body>


        <%-- Links --%>    
        <logic:present name="doctormodule" scope="request">

            <div class="intro-header" style="background-image: url(img/doc.jpg);">
                <div class="container voffset4 row"> 
                    
                    <div class="col-md-8 col-md-offset-2"></div>
                    <ul class="nav sign-up-tabs" role="tablist">
                        &nbsp;<li role="presentation" class="active">
                            <html:link action="/mainaction?action=doctorsignin">Doctor Login</html:link>
                            </li>
                            &nbsp;<li role="presentation" class="active">
                            <html:link action="/mainaction?action=doctorregistrationPage">Doctor Register</html:link>
                            </li> 
                        </ul>
                    </div>
                </div>
            </div>

    </logic:present> 

    <logic:present name="patientmodule" scope="request">
        <div class="intro-header" style="background-image: url(img/doc.jpg);">
            <div class="container voffset4 row"> 
                <!-- Nav tabs -->
                <div class="col-md-8 col-md-offset-2"></div>

                <ul class="nav sign-up-tabs" role="tablist">
                    &nbsp;<li role="presentation" class="active">

                        <html:link action="/mainaction?action=patientsignin">Patient Login</html:link>
                        </li>
                        &nbsp;<li role="presentation" class="active">
                        <html:link action="/mainaction?action=patientregistrationPage">Patient Register</html:link>
                        </li> 
                    </ul>
                    </p>
                </div>
            </div>
        </div>
</logic:present> 
<%-- Ends links--%>
<%-- Login page starts---%>
<logic:present name="doctorsignin" scope="request">

    <div class="intro-header-login">
        <div class="container">
            <form class="form-signin" action="mainaction.do" method="post">   
                <!--<h2 class="form-signin-heading">Sign in</h2>-->
                <logic:present name="doctorsignfail" scope="request">
                    <h4 style="background-color: #cc00cc">Sign in fail!Please 
                        enter correct credentials</h4>
                    </logic:present>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" id="inputEmail" required name="email"  class="form-control input-lg" placeholder="Email address" required="" autofocus>
                <input type="password" id="inputPassword"  required name="password" class="form-control input-lg" placeholder="Password" required="">
                <input  name="action" type="hidden" value="doctorlogin">
                <button class="btn btn-lg btn-primary btn-block formSubmit" type="submit">Sign in</button>      
            </form>
        </div>
    </div>

</logic:present>

<logic:present name="patientsignin" scope="request">

    <div class="intro-header-login">
        <div class="container">
            <form class="form-signin" action="mainaction.do" method="post">   
                <!--<h2 class="form-signin-heading">Sign in</h2>-->
                <logic:present name="patientloginFail" scope="request">
                    <h4 style="background-color: #cc00cc;">Sign in fail!Please 
                        enter correct Patient Id
                    </h4>
                </logic:present>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" id="inputEmail" required name="email"  class="form-control input-lg" placeholder="Email address" required="" autofocus>
                <input type="password" id="inputPassword"  required name="password" class="form-control input-lg" placeholder="Password" required="">
                <div class="checkbox">
                </div>
                <input  name="action" type="hidden" value="patientlogin">
                <button class="btn btn-lg btn-primary btn-block formSubmit" type="submit">Sign in</button>      
            </form>
        </div>
    </div>


</logic:present>        
<%-- Login page Ends---%>
<%-- Registration page ends---%>
<logic:present name="doctorregistrationPage" scope="request">
    <!-- Tab panes -->
    <form action="mainaction.do" method="post" class="contact">
        <div class="tab-content voffset4 text-left">
            <div role="tabpanel" class="tab-pane active">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <h3>Doctor Registration</h3>
                        <logic:present name="fail" scope="request">
                            <h4 style="background-color: red;">Registration  fail! Duplicate Email id</h4>
                        </logic:present>
                        <div class="form-group">
                            <input type="email" name="email" required class="form-control" placeholder="Email address">
                        </div>
                        <div class="form-group">
                            <input type="password" required class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required  name="password" type="password" placeholder="Re enter Password" >
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="name" type="text" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="phone" type="text" placeholder="phone">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="registrationId" type="text" placeholder="Registration Number">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField"  required name="organization" type="text" placeholder="organization or Hospital Name" >
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField"  required name="clinic" type="text" placeholder="Clinic Name">
                        </div>
                        <div class="form-group">
                            <h4 class="contact-input">Address</h4>
                        </div>
                        <div class="form-group">    
                        <select id="select4" required name="country">
                                <option value="" selected >...Select Country…</option>
                                <%
                                    List countrydoctorList = (List) request.getAttribute("countryList");
                                    
                                    if (countrydoctorList != null && countrydoctorList.size() > 0) {
                                        int countrydoctorsize = countrydoctorList.size();
                                        System.out.println("countrysize--------" + countrydoctorsize);
                                        Country countrydoctorvo = new Country();
                                        for (int index = 0; index < countrydoctorsize; index++) {
                                            countrydoctorvo = (Country) countrydoctorList.get(index);
                                %>  
                                <option value="<%=countrydoctorvo.getCountryName()%>">
                                    <%=countrydoctorvo.getCountryName()%>
                                </option>  
                                <% }
                                    }%>
                            </select>
                            <input  value="activate selectator" id="activate_selectator4" type="hidden">
                            
                      
                               <%-- <input class="form-control" id="textField" 
                                       required name="country"
                                       value="Canada" type="text" 
                                       placeholder="Country">
                               --%>
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="State/Province"  name="province" id="select" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="city" type="text" placeholder="city">    
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="street" type="text" placeholder="Street">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="zipCode" type="text" placeholder="Postal Code">
                        </div>
                        <%--    
                        <div class="form-group">
                            <textarea class="form-control" id="textField"  name="address" placeholder="Address" required rows="2" cols="2"></textarea>
                        </div>
                        --%>
                        <input name="action" type="hidden" value="docregistration">

                        <div class="form-group">
                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign Up">
                        </div>

                    </div>
                </div> 
            </div>
        </div>	
    </form>


</logic:present>
<logic:present name="patientregistrationPage" scope="request">

    <form action="mainaction.do" method="post" class="contact">
        <div class="tab-content voffset4 text-left">
            <div role="tabpanel" class="tab-pane active">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <h3>Patient Registration</h3>
                        <logic:present name="fail" scope="request">
                            <p class="register-title">Registration fail 
                                ! Duplicate Email id</p>
                            </logic:present>
                        <div class="form-group">
                            <select id="select2"  name="docId">
                                <option value="" selected >...Select Doctor…</option>
                                <%
                                    List itemListById = (List) request.getAttribute("doctorList");
                                    int size = itemListById.size();
                                    if (size != 0) {
                                        System.out.println("page--------" + size);
                                        DoctorVo vo = new DoctorVo();
                                        for (int index = 0; index < size; index++) {
                                            vo = (DoctorVo) itemListById.get(index);
                                %>  
                                <option value="<%=vo.getDocId()%>">
                                    <%=vo.getDocName()%>
                                </option>  
                                <% }
                                    }%>
                            </select>
                            <input  value="activate selectator" id="activate_selectator2" type="hidden">
                            
                        </div>
                        <div class="form-group">
                            <input class="form-control" required id="textField" name="name" type="text" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="phone" type="text" placeholder="phone">
                        </div>
                        <div class="form-group">
                            <input class="form-control" required id="textField" name="email" type="email" placeholder="Email">
                        </div> 
                        <div class="form-group">
                            <input class="form-control" required id="textField" name="password" type="password" placeholder="Password" >
                        </div>
                        <div class="form-group">
                            <input class="form-control" required name="action" type="hidden" value="patientregistration">
                        </div>


                        <div class="form-group">
                            <h4 class="contact-input">Address</h4>
                        </div>
                        <div class="form-group">
                            <p class="contact-input">
                            <select id="select3" required name="country">
                                <option value="" selected >...Select Country…</option>
                                <%
                                    List countryList = (List) request.getAttribute("countryList");
                                    
                                    if (countryList != null && countryList.size() > 0) {
                                        int countrysize = countryList.size();
                                        System.out.println("countrysize--------" + countrysize);
                                        Country countryvo = new Country();
                                        for (int index = 0; index < countrysize; index++) {
                                            countryvo = (Country) countryList.get(index);
                                %>  
                                <option value="<%=countryvo.getCountryName()%>">
                                    <%=countryvo.getCountryName()%>
                                </option>  
                                <% }
                                    }%>
                            </select>
                            <input  value="activate selectator" id="activate_selectator3" type="hidden">
                            
                      
                               <%-- <input class="form-control" id="textField" 
                                       required name="country"
                                       value="Canada" type="text" 
                                       placeholder="Country">
                               --%>
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="State/Province"  name="province" id="select" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="city" type="text" placeholder="city">    
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="street" type="text" placeholder="Street">
                        </div>
                        <div class="form-group">
                            <input class="form-control" id="textField" required name="zipCode" type="text" placeholder="Postal Code">
                        </div>
                        <%--    
                        <div class="form-group">
                            <textarea class="form-control" id="textField"  name="address" placeholder="Address" required rows="2" cols="2"></textarea>
                        </div>
                        --%>
                        <div class="form-group">
                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign Up">
                        </div>

                    </div>
                </div> 
            </div>
        </div>

    </form>

</logic:present>        
<%-- Login page Ends---%>
 
</body>
</html>
