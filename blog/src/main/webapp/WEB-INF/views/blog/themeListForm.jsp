<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>블로그 스킨 리스트</h1>
		        <hr>
		              
            </div>
        </div>
       
       <!-- default 스킨 -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/resources/themeimg/default.png" 
                	class="img-responsive img-hover img-thumbnail" width="700px">
                </a>
            </div>
            <div class="col-md-5">
                <h3>기본 스킨</h3>
                <p>설명</p>
                <a class="btn btn-primary" href="themePick?themeno=0"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> 선택하기</a>
            </div>
        </div>
        <!-- /.row -->
        
        <hr>
        
        <!-- Candy Box 스킨 -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/resources/themeimg/candy-box.png" 
                	class="img-responsive img-hover img-thumbnail" width="700px">
                </a>
            </div>
            <div class="col-md-5">
                <h3>Candy Box 스킨</h3>
                <p>설명</p>
                <a class="btn btn-primary" href="themePick?themeno=1"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> 선택하기</a>
            </div>
        </div>
        <!-- /.row -->
	    
	    <hr>

        <!-- Autumn Dawn 스킨 -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                	<img src="${pageContext.request.contextPath }/resources/themeimg/autumn-dawn.png" 
                	class="img-responsive img-hover img-thumbnail" width="700px">
                </a>
            </div>
            <div class="col-md-5">
                <h3>Autumn Dawn 스킨</h3>
                <p>설명</p>
                <a class="btn btn-primary" href="themePick?themeno=2"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> 선택하기</a>
            </div>
        </div>
        <!-- /.row -->

        <hr>
        
        <!-- Pastel Stream 스킨 -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img src="${pageContext.request.contextPath }/resources/themeimg/pastel-stream.png" 
                	class="img-responsive img-hover img-thumbnail" width="700px">
                </a>
            </div>
            <div class="col-md-5">
                <h3>Pastel Stream 스킨</h3>
                <p>설명</p>
                <a class="btn btn-primary" href="themePick?themeno=3"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> 선택하기</a>
            </div>
        </div>
        <!-- /.row -->

        <hr>
    </div>
</div>