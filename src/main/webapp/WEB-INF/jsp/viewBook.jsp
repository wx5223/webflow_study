<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>book</title>
</head>
<body>
<p>
书列表：
</p>
<c:forEach items="${books }" var="book">
${book.id } : ${book.name } : ${book.price}
<a href="${flowExecutionUrl}&_eventId=addToCart&bookId=${book.id}">添加</a>
<a href="${flowExecutionUrl}&_eventId=addOrder&bookId=${book.id}">添加订单</a>
<br/>
</c:forEach>
<br/>
<br/>
<table style="width:500px;">
<tr>
	<th>书号</th>
	<th>书名</th>
	<th>单价</th>
	<th>数量</th>
	<th>总价</th>
	<th></th>
</tr>
<c:forEach items="${carts }" var="order">
<tr>
<td>${order.book.id }</td>
<td>${order.book.name }</td>
<td>${order.book.price}</td>
<td>${order.size }</td>
<td>${order.totalPrice }</td>
<td>
<a href="${flowExecutionUrl}&_eventId=dropOrder&orderId=${order.id}">删除</a>
</td>
</tr>
</c:forEach>
</table>


<!-- 下面是三种最常用的流程中转方式 -->
<!-- 1
<form action="">
<input type="submit" name="_eventId_proceed" value="Proceed" />
<input type="submit" name="_eventId_cancel" value="Cancel" />	
</form> 
-->

<!-- 2
<form action="">
<input type="submit" value="Proceed" />
<input type="hidden" name="_eventId" value="proceed" />	
</form> 
-->


<%-- 3
<a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
--%>
</body>
</html>