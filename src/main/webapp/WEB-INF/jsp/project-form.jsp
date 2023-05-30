<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Adicionar project</title>
        <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
          rel="stylesheet">
        <style>
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
          -webkit-appearance: none;
          margin: 0;
        }

        /* Firefox */
        input[type=number] {
          -moz-appearance: textfield;
        }
        </style>
    </head>
    <body>
        <%@ include file="/WEB-INF/includes/navbar.jsp"%>

        <!-- Begin Container -->
        <div class="container">

            <!-- Begin Card -->
            <div class="card">

                <!-- Begin Card Header -->
                <h5 class="card-header text-center">
                    New Project
                </h5>
                <!-- End Card Header -->

                <!-- Begin Card Body -->
                <div class="card-body">

                    <!-- Begin Project Form -->
                    <c:url var="addProjectUrl" value="/project/add"/>
                    <form:form action="${addProjectUrl}" method="post" modelAttribute="project">

                        <!-- Hidden Form Input - id  -->
                        <form:hidden path="id" />

                        <!-- Begin first row  -->
                        <div class="row mb-3">
                            <!-- Begin Project Form Input - name  -->
                            <div class="col-sm-8">
                                <form:label path="name" class="form-label">Name</form:label>
                                <form:input type="text" placeholder="Name" class="form-control" path="name" required="required"/>
                            </div>
                            <!-- End Project Form Input - name  -->

                            <!-- Begin Project Form Input - totalBudget  -->
                            <div class="col-sm-4">
                                <form:label path="totalBudget" class="form-label">Total Budget</form:label>
                                <form:input placeholder="0000.00" class="form-control" path="totalBudget" type="number" required="required"/>
                                <form:errors path="totalBudget" cssClass="text-bg-danger"/>
                            </div>
                            <!-- End Project Form Input - totalBudget   -->
                        </div>
                        <!-- End first row  -->

                        <!-- Begin second row  -->
                        <div class="row mb-3">
                            <!-- Begin Project Form Input - status  -->
                            <div class="col">
                                <form:label path="status" class="form-label">Status</form:label>
                                <form:select class="form-select" path="status" required="required">
                                    <form:option value="" label="Choose..."/>
                                    <form:options items="${statusList}"  itemValue="name" itemLabel="description"/>
                                </form:select>
                            </div>
                            <!-- End Project Form Input - status  -->

                            <!-- Begin Project Form Input - risk  -->
                            <div class="col">
                                <form:label path="" class="form-label">Risk</form:label>
                                <form:select class="form-select" path="risk">
                                    <form:option value="" label="Choose..."/>
                                    <form:options items="${riskList}"  itemValue="name" itemLabel="classification"/>
                                </form:select>
                            </div>
                            <!-- End Project Form Input - risk  -->

                            <!-- Begin Project Form Input - managerId  -->
                            <div class="col">
                                <form:label path="managerId" class="form-label">Manager</form:label>
                                <form:select class="form-select" path="managerId" required="required">
                                    <form:option value="" label="Choose..."/>
                                    <form:options items="${managerList}"  itemValue="id" itemLabel="name"/>
                                </form:select>
                            </div>
                            <!-- End Project Form Input - managerId  -->
                        </div>
                        <!-- End second row  -->


                        <!-- Begin third row  -->
                        <div class="row mb-3">
                                <!-- Begin Project Form Input - beginDate  -->
                                <div class="col">
                                        <form:label path="beginDate" class="form-label">Begin Date</form:label>
                                        <form:input type="date" class="form-control" path="beginDate" required="required"/>
                                        <form:errors path="beginDate" cssClass="error"/>
                                </div>
                                <!-- End Project Form Input - beginDate  -->

                                <!-- Begin Project Form Input - expectedEndDate  -->
                                <div class="col">
                                        <form:label path="expectedEndDate" class="form-label">Expected End Date</form:label>
                                        <form:input type="date" class="form-control" path="expectedEndDate" required="required"/>
                                </div>
                                <!-- End Project Form Input - expectedEndDate  -->

                                <!-- Begin Project Form Input - endDate  -->
                                <div class="col">
                                        <form:label path="endDate" class="form-label">End Date</form:label>
                                        <form:input type="date" class="form-control" path="endDate" required="required"/>
                                        <form:errors path="endDate" cssClass="text-bg-danger"/>
                                </div>
                                <!-- End Project Form Input - endDate  -->
                        </div>
                        <!-- End third row  -->

                        <!-- Begin Project Form Input - description  -->
                        <div class="form-group mb-3">
                            <form:label path="description" class="form-label">Description</form:label>
                            <form:textarea placeholder="Description..." rows="3" class="form-control" path="description" required="required"/>
                        </div>
                        <!-- End Project Form Input - description  -->
                        <div class="d-grid gap-2 col-4 mx-auto">
                            <input type="submit" class="btn btn-primary"  value="Create"/>
                        </div>
                    </form:form>

                    <!-- End Project Form -->

                </div>
                <!-- End Card Body -->

              </div>
              <!-- End Card -->

        </div>
        <!-- End Container -->

    </body>

    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"/>"></script>
</html>