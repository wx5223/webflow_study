<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>viewOrder</title>
</head>
<body>
<p>
订单号：${order.id }
</p>
<p>
书号：${order.book.id }
</p>
<p>
书名：${order.book.name }
</p>
<p>
单价：${order.book.price }
</p>
<p>
数量：${order.size }
</p>
<p>
总价：${order.totalPrice }
</p>
<a href="${flowExecutionUrl}&_eventId=confirm">确定</a>
<a href="${flowExecutionUrl}&_eventId=revise">重写</a>
<a href="${flowExecutionUrl}&_eventId=cancel">结束</a>
</body>
</html>