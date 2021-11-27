<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 79160
  Date: 26.11.2021
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Create new product</h1>
<br>
<%--@elvariable id="product" type="ru.gb.entity.Product"--%>
<form:form  action="create"  modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title:<form:input path="title"/>
    <br>
    Price: <form:input path="price"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
