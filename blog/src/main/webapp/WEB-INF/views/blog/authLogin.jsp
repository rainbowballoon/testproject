<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Naver OAuth</TITLE>
</head>
<body>
    <form method="GET" action="https://nid.naver.com/oauth2.0/token">
        <input type="hidden" name="client_id" value="${client_id}"/>
        <input type="hidden" name="response_type" value="${response_type}"/>
        <input type="hidden" name="redirect_uri" value="${redirect uri}"/>
        <input type="hidden" name="state" value="${state}"/>
        <button type="submit">Request Athorization Code</button>
    </form>
</body>
</html>