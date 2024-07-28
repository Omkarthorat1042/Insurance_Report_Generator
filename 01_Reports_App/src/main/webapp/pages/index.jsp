<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insurance Application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        background: url('images/ins.jpg') no-repeat center center fixed;
        background-size: cover;
    }
    .container {
        background-color: rgba(255, 255, 255, 0.5); /* Transparent white background */
        padding: 20px;
        border-radius: 10px;
        margin-top: 20px;
    }
    .container .table {
        background-color: rgba(255, 255, 255, 0.5); /* Transparent white background for the table */
    }
    .container .table th, .container .table td {
        background-color: rgba(255, 255, 255, 0.7); /* Semi-transparent white background for table headers and cells */
    }
    .container .table-bordered {
        border: 1px solid rgba(0, 0, 0, 0.2); /* Transparent border for the table */
    }
</style>
</head>
<body>

<div class="container">
    <h3 class="pb-3 pt-3">Report Application</h3>

    <form:form action="search" modelAttribute="search" method="POST">
        <table class="table">
            <tr>
                <td>Plan Name:</td>
                <td>
                    <form:select path="planName" class="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Plan Status:</td>
                <td>
                    <form:select path="planStatus" class="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${status}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <form:select path="gender" class="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Start Date:</td>
                <td><form:input path="startDate" type="date" class="form-control"/></td>
            </tr>
            <tr>
                <td>End Date:</td>
                <td><form:input path="endDate" type="date" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: left;">
                    <input type="reset" value="Reset" class="btn btn-secondary mt-3 me-2">
                    <input type="submit" value="Search" class="btn btn-primary mt-3">
                </td>
            </tr>
        </table>
    </form:form>

    <hr/>

    <c:choose>
        <c:when test="${not empty results}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Sr.No</th>
                        <th>Holder Name</th>
                        <th>Gender</th>
                        <th>Plan Name</th>
                        <th>Plan Status</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Benefit Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="result" items="${results}" varStatus="index">
                        <tr>
                            <td><c:out value="${index.index + 1}"/></td>
                            <td><c:out value="${result.citizenName}"/></td>
                            <td><c:out value="${result.gender}"/></td>
                            <td><c:out value="${result.planName}"/></td>
                            <td><c:out value="${result.planStatus}"/></td>
                            <td><c:out value="${result.planStartDate}"/></td>
                            <td><c:out value="${result.planEndDate}"/></td>
                            <td><c:out value="${result.benefitAmt}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div style="text-align: center;">No records found...</div>
        </c:otherwise>
    </c:choose>

    <hr/>

    <div>
        Export:
        <a href="excel" class="btn btn-outline-secondary">Excel</a>
        <a href="pdf" class="btn btn-outline-secondary">PDF</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
