
<%--Bringing in jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Let's build the login form (*3*)~ !--%>
<html>
<jsp:include page="HeadTag.jsp"/>
<body>

    <form action="/login" method="post">
        <input type="text" placeholder="username" name="username">
        <input type="password" placeholder="password" name="password">
        <button type="submit" formmethod="post"> Login </button>
    </form>


</body>
</html>