<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- Основные теги создания циклов, определения условий, вывода информации на страницу и т.д.--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Теги для работы с XML-документами--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%-- Теги для работы с базами данных --%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- Теги для форматирования и интернационализации информации (i10n и i18n)--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>


<table>
    <thead>
    <td>id</td>
    <td>name/td>
    <td>age</td>
    <td>color/td>
    </thead>
    <tbody>
    <c:forEach var="ele" items="${list}">
        <tr>
            <td><c:out value="${ele.id}"></td>
            <td><c:out value="${ele.name}"></td>
            <td><c:out value="${ele.age}"></td>
            <td><c:out value="${ele.color}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>