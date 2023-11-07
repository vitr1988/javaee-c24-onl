<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="h" uri="/example" %>
<html>
<head>
  <title>JSTL</title>
  <c:if test="${flag}">
    <script>
      <%--window.location.href = '<c:url value="/"/>';--%>
      <c:redirect url="/"/>
    </script>
  </c:if>
  <c:if test="${!flag}">
    <meta charset="UTF-8">
  </c:if>
</head>
<body>
  JSTL
  <c:choose>
    <c:when test = "${type != null && type.equals('TEXT')}">
      <input type="text" name="field1"/>
    </c:when>
    <c:when test = "${type != null && type.equals('TEXTAREA')}">
      <textarea></textarea>
    </c:when>
    <c:otherwise>
      <label>Ваша надпись!</label>
    </c:otherwise>
  </c:choose>

  <select name="combobox">
  <c:forEach items="${elems}" var="elem">
    <option value="${elem.value}">${elem.name}</option>
<%-- НЕ ИСПОЛЬЗОВАТЬ c:out   <option value="<c:out value="${elem.value}"/>">${elem.name}</option>--%>
  </c:forEach>
  </select>

  <img src='<c:url value="/img/black.gif"/>' width="100px" height="100px"/>
<%--  <img src='<%= request.getContextPath() + "/img/black.gif"%>' width="100px" height="100px"/>--%>

  <c:catch var ="catchException">
    <% int x = 5/0;%>
  </c:catch>

  <c:if test = "${catchException != null}">
    <p>The exception is : ${catchException} <br />
      There is an exception: ${catchException.message}</p>
  </c:if>

  Today is <fmt:formatDate value="${now}" pattern="dd.MM.yyyy HH:mm:ss"/>
  Today is ${formattedNow}

  <fmt:formatNumber value="${money}" type="currency"/>

  <h:hello/>

</body>
</html>
