<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/wordcount.css" rel="stylesheet">

<html>
<head>
    <title>list texts</title>
</head>
<body>
<h1>Here are list of your texts:</h1>
    <table>
        <tr>
            <th>Text</th>
            <th>Ordered Words Count</th>
        </tr>
    <c:forEach items="${insertedTexts}" var="text">
        <tr>
                <td>${text.textValue}</td>
                <td>${text.orderedWordsCount}</td>

        </tr>
    </c:forEach>
    </table>
<p>${message}</p>
<input type="button" value="Back" onClick="history.back()">
</body>
</html>
