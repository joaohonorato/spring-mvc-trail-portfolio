<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Project</title>
        <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">

        
        <link rel="stylesheet" href="<c:url value="/static/node_modules/bootstrap-icons/font/bootstrap-icons.css"/>">
        <style>
            table.table td a.edit {
        color: #FFC107;
        }
        table.table td button.delete {
            color: #F44336;
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
                     Project list
                </h5>
                <!-- End Card Header -->

                <!-- Begin Card Body -->
                <div class="card-body">

                    <!-- Begin Project Table -->
                    <table class="table table-striped" aria-describedby="projectTable">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Risk</th>
                            <th scope="col">Status</th>
                            <th scope="col">Manager</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${projectList}" var="project">
                                <tr>
                                    <td>${project.name}</td>
                                    <td>${project.risk.classification}</td>
                                    <td>${project.status.description}</td>
                                    <td>${project.manager.name}</td>
                                    <td>
                                        <a href="/project/${project.id}" class="btn btn-link edit" ><i class="bi bi-pencil-square" data-toggle="tooltip" title="Edit"></i></a>
                                        <button type="button" class="btn btn-link delete" data-bs-toggle="modal" data-bs-target="#deleteModal" data-bs-whatever="${project.id}">
                                            <i class="bi bi-trash" data-toggle="tooltip" title="Delete"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- End Project Table -->
                </div>
                <!-- End Card Body -->
            </div>
            <!-- End Card -->
        </div>
        <!-- End Container -->

            
            <!-- Modal -->
            <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title alert alert-danger d-flex align-items-center" role="alert" id="deleteModalLabel">Are you sure you want to <strong>DELETE</strong> this project?</h5>
                    </div>
                    <div class="modal-footer justify-content-md-center">
                        <a href="/project/delete/0" class="btn btn-primary">Yes</a>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    </div>
                </div>
                </div>
            </div>

            <!-- Toast Added Project -->
            <c:if test="${addedProject}">
                <div class="toast-container position-fixed bottom-0 end-0 p-3 ">
                    <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-body">
                            <p class="alert alert-success d-flex align-items-center" role="alert"> Project <strong>${savedProject.name}</strong> saved </p>
                            <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                    </div>
                </div>
            </c:if>


            <!-- Toast Deleted Project -->
            <c:if test="${deletedProject}">
                <div class="toast-container position-fixed bottom-0 end-0 p-3 ">
                    <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-body">
                            <p class="modal-title alert alert-danger d-flex align-items-center" role="alert" > Projeto com status "${projectStatus}" não pode ser apagado.</p>
                            <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                    </div>
                </div>
            </c:if>


            <script>
                const modal = document.getElementById('deleteModal')
                modal.addEventListener('show.bs.modal', event => {
                    const target = event.relatedTarget
                    const recipient = target.getAttribute('data-bs-whatever')
                    const anchor = modal.querySelector('.modal-footer a')
                    anchor.href= '/project/delete/' + recipient
                })
            </script>

    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="/static/node_modules/bootstrap-icons/font/bootstrap-icons.min.css"/>"></script>

</html>