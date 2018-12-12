<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../partials/head.jsp"/>
<body>
    <jsp:include page="../partials/navbar.jsp"/>

    <c:forEach items="${ads}" var="ad">
        <div>
            <h1> ${ad.title} </h1>
            <p> ${ad.description} </p>
        </div>
    </c:forEach>
</body>
</html>
