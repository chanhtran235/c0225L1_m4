<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>

<p>${mess}</p>

<table>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Detail1</th>
        <th>Detail2</th>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>
                <a href="/students/detail?id=${student.id}">Detail1</a>
            </td>
            <td>
                <a href="/students/detail/${student.id}">Detail1</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
