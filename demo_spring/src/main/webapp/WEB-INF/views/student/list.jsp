<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<a href="/students/add">Thêm mới</a>
<p>${mess}</p>
<table>
<tr>
    <th>STT</th>
    <th>ID</th>
    <th>Name</th>
    <th>Gender</th>
    <th>Subject</th>
    <th>Classname</th>
    <th>RP-Detail</th>
    <th>PV-Detail</th>
</tr>
<c:forEach items="${studentList}" var="student" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.gender}</td>
        <td>
            <c:forEach items="${student.subjects}" var="subject">
                <span>${subject} </span>
            </c:forEach>
        </td>
        <td>${student.name}</td>
        <td>${student.className}</td>
        <td><a href="/students/detail?id=${student.id}">Detail1</a></td>
        <td><a href="/students/detail/${student.id}">Detail2</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
