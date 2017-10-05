<%-- 
    Document   : UploadPatientReport
    Created on : Oct 8, 2015, 12:12:11 AM
    Author     : one
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="uploadreport.do" method="post" enctype="multipart/form-data">
    <div class="tab-content voffset4 text-left">
        <div role="tabpanel" class="tab-pane active">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">

                    <div class="form-group">
                        <input class="form-control" size="50" readonly="" value="<%=(String) request.getAttribute("patientId")%>" name="patientId" type="text" placeholder="Patient Id">
                    </div> 
                    <div class="form-group">
                        <input class="form-control" size="50" name="description" type="text" placeholder="description">
                    </div> 
                    <div class="form-group">
                        <input  class="form-control" size="50"  name="signaltype" type="text" placeholder="Signal type">
                    </div>
                    <div class="form-group">  
                        <input class="btn btn-lg btn-primary btn-block" name="report" type="file">
                    </div> 
                    <div class="form-group">   
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Upload Report"> 

                    </div> 

                </div> 
            </div> 
        </div>
    </div>
</form>  