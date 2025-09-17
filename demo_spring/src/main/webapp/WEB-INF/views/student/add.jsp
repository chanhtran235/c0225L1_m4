<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>
<form:form action="/students/add" method="post" modelAttribute="student">
    Id:
    <form:input path="id"/><br>
    Name:
    <form:input path="name"/><br>
    Gender
    <form:radiobutton path="gender" value="1"/>Male
    <form:radiobutton path="gender" value="0"/>Female<br>
    Subjects
    <form:checkboxes path="subjects" items="${subjects}"/><br>
    <form:select path="className">
        <form:option value="C02">C02</form:option>
        <form:option value="C03">C03</form:option>
        <form:option value="C04">C04</form:option>
    </form:select><br>
    <form:button>Lưu</form:button>
</form:form>






















<%--<form:form action="/students/add" method="post" modelAttribute="student">--%>
<%--    <h3> Add new student</h3>--%>
<%--    <form:input path="id"/><br>--%>
<%--    <form:input path="name"/><br>--%>
<%--    <form:radiobutton path="gender" value="1"/>Male--%>
<%--    <form:radiobutton path="gender" value="0"/>Female<br>--%>

<%--    <form:checkboxes path="subjects" items="${subjects}"/>--%>
<%--    <form:select path="className">--%>
<%--        <form:option value="C02"/>C02--%>
<%--        <form:option value="C03"/>C03--%>
<%--        <form:option value="C04"/>C04--%>
<%--    </form:select><br>--%>
<%--    <button>save</button>--%>
<%--</form:form>--%>
</body>
</html>
