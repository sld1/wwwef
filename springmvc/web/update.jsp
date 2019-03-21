<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form:form modelAttribute="pro" action="/pro/update2.do">
        <form:hidden path="id"></form:hidden>
        产品名称：<form:input path="name"></form:input><br/>
        产品价格：<form:input path="price"></form:input><br/>
        产品类型：<form:select path="ProductType.id"
                          items="${typelist}"
                          itemLabel="name"
                          itemValue="id"></form:select>

        <button>确认修改</button>
    </form:form>
</center>
</body>
</html>
