<!DOCTYPE html>
<html>

<head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my-style.css">

<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

</head>

<body>

<h2>Spring MVC Demo - Home Page</h2>

<br><br>

<a href="hello/showForm">Plain Hello World form</a>
<br><br>

<a href="student/showForm">Student form</a>
<br><br>

<a href="customer/showForm">Customer form</a>

<br><br>

<img src="${pageContext.request.contextPath}/resources/images/spring_logo.png" />

<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>

</body>

</html>