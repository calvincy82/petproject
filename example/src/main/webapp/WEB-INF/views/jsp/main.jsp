<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users product List</title>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Product Acquired By User </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Product code</th>
                        <th>Product description</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.productCode}</td>
                        <td>${user.productDescription}</td>
                        <td>${user.ssoId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/newProduct' />">Acquire New Product</a>
        </div>
    </div>
</body>
</html>