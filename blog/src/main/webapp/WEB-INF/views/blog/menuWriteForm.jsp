<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴 관리</title>
</head>
<body>
<div id="page-content-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>메뉴 등록</h1>
             <form action="menuWrite" method="post">
               <table class="table table-hover">
               		<tr>
               			<td class="active">메뉴명</td>
               			<td><input type="text" name="name"></td>
               		</tr>
               </table>
             <input type="submit" value="등록완료" class="btn btn-primary">
             <a href="menuList" class="btn btn-default">목록으로</a>
             </form>
             
             <br><br>
             <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">카테고리 숨기기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>