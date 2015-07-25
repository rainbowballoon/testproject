<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">블로그 관리 페이지</h1>
            </div>
            <div class="col-md-4">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4><i class="glyphicon glyphicon-user"></i> 정보 설정 </h4>
                    </div>
                    <div class="panel-body">
                        <p>블로그 제목, 소개글, 프로필사진 설정</p>
                        <a href="profileForm" class="btn btn-default">프로필 정보 관리</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h4><i class="glyphicon glyphicon-wrench"></i> 디자인 설정</h4>
                    </div>
                    <div class="panel-body">
                  	  	<p><a href="themeListForm" class="btn btn-default">블로그 스킨 설정</a></p>
                        <p><a href="#" class="btn btn-default">블로그 레이아웃 설정</a></p>
                        <p><a href="#" class="btn btn-default">사용자 위젯 설정</a></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h4><i class="glyphicon glyphicon-menu-hamburger"></i> 카테고리 설정</h4>
                    </div>
                    <div class="panel-body">
                        <p>블로그 카테고리, 서브 카테고리 설정 </p>
                        <a href="blogCategoryForm" class="btn btn-default">카테고리 관리</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>