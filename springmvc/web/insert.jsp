<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/17
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <form:form modelAttribute="pro" action="/pro/add.do">
            产品名称：<form:input path="name"></form:input><form:errors path="name" cssClass="error"></form:errors><br/>
            产品价格：<form:input path="price"></form:input><form:errors path="price" cssClass="error"></form:errors><br/>
            产品类型：<form:select path="ProductType.id"
                                    items="${prolist}"
                                    itemLabel="name"
                                    itemValue="id"></form:select><form:errors path="ProductType.id" cssClass="error"></form:errors><br/>

            <button>确认添加</button>
        </form:form>
    </center>
</body>
</html>
