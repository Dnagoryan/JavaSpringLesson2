<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 79160
  Date: 26.11.2021
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>List product</h1>
<br>
<table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.id}"/> </td>
            <td><c:out value="${product.title}"/> </td>
            <td><c:out value="${product.price}"/> </td>

        </tr>
    </c:forEach>

</table>
<br>
<c:url var="addUrl" value="/shop/add">

</c:url>
<a href="${addUrl}">Add Product</a>
</body>
</html>
