<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/16
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品展示</title>
    <script type="text/javascript" src="/jq/jquery.js"></script>
    <script>
        $(function () {
           $("[name='ids']").click(function () {
               var dd=$("[name='id']");
               for(var i=0;i<dd.length;i++){
                   if(dd[i].checked==true){
                      dd[i].checked=false;
                   }else{
                       dd[i].checked=true;
                   }
               }
           })
        })

    </script>
</head>
<body>
<center>
    <h1>产品展示</h1>
    <hr/>
    <form action="/pro/mhcha.do">
    名称：<input type="text" name="mname"/>
          <input type="submit" value="搜索"/>
    </form><br/>
   <form action="/pro/deleteAllPro.do" method="post">
    <table border="1" width="500px">
        <tr>
            <td><input type="checkbox" name="ids"/></td>
            <td>ID</td>
            <td>产品名称</td>
            <td>产品价格</td>
            <td>产品类型</td>
            <td>操作</td>
        </tr>
        <c:forEach var="pro" items="${list}">
            <tr>
                <td><input type="checkbox" name="id" value="${pro.id}"/></td>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td>${pro.price}</td>
                <td>${pro.productType.name}</td>
                <td>
                    <a href="/pro/dele.do?id=${pro.id}" style="text-decoration:none">删除</a>
                    <a href="/pro/update1.do?id=${pro.id}" style="text-decoration:none">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="删除选中项"/>
    <input type="button" value="添加" onclick="add()"/>

   </form>
</center>
<script>
    function add() {
        location.href="/pro/add1.do";
    }

</script>
</body>
</html>
