<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>블로그 레이아웃 리스트</h1>
		        <hr>
		              
            </div>
        </div>
       
       <!-- left side layout -->
        <div class="row">
            <div class="col-md-5">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/resources/layoutimg/leftside.png" 
                	class="img-responsive img-hover img-thumbnail" width="200">
                </a>
            </div>
            <div class="col-md-7">
                <h3>왼쪽 사이드 레이아웃 (기본)</h3>
                <p>설명</p>
                <a class="btn btn-primary" href="layoutPick?layoutno=0"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> 선택하기</a>
            </div>
        </div>
        <!-- /.row -->
        
        <hr>
        
        <!-- right side layout -->
        <div class="row">
            <div class="col-md-5">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/resources/layoutimg/rightside.png" 
                	class="img-responsive img-hover img-thumbnail" width="200">
                </a>
            </div>
            <div class="col-md-7">
                <h3>오른쪽  사이드바 레이아웃</h3>
                <p>설명</p>
                <a class="btn btn-primary" href="layoutPick?layoutno=1"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> 선택하기</a>
            </div>
        </div>
        <!-- /.row -->

        <hr>
    </div>
</div>