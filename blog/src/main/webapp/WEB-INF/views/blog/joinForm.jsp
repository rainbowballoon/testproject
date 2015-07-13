<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!-- Page Content -->
    <div class="col-md-8">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">회원가입
                    <small>가입정보를 입력해주세요</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index">Home</a>
                    </li>
                    <li class="active">회원가입</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Contact Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">
            <div class="col-md-8">
                <h3>정보를 입력해주세요</h3>
                
                <form action="blogJoin" method="POST">
                	<div class="control-group form-group">
                        <div class="controls">
                            <label>아이디:</label>
                            <input type="text" class="form-control" name="member_id" required placeholder="아이디" maxlength="16">
                            <p class="help-block">4자 이상으로 입력해주세요</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>비밀번호:</label>
                            <input type="password" class="form-control" name="member_pw" required placeholder="비밀번호" maxlength="20">
                            <p class="help-block">8자 이상으로 입력해주세요</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>닉네임:</label>
                            <input type="text" class="form-control" name="member_nickname" required placeholder="닉네임" maxlength="20">
                            <p class="help-block">블로그에서 사용자들에게 보여질 닉네임을 입력해주세요</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>생일:</label>
                            <input type="date" class="form-control" name="member_birthday" required>
                            <p class="help-block">생년월일을 입력해주세요</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>도메인이름:</label>
                            <input type="text" class="form-control" name="member_domain" required placeholder="도메인이름" maxlength="20">
                       		<p class="help-block">블로그에 사용할 도메인 이름을 입력해주세요</p>
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" class="btn btn-primary">가입하기</button>
                    <button type="reset" class="btn btn-default">다시입력</button>
                </form>
            </div>

        </div>
        <!-- /.row -->
	</div>
	
<!-- Contact Form JavaScript -->
<!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
<script type="text/javascript" src="js/jqBootstrapValidation.js"></script>
<script type="text/javascript" src="js/contact_me.js"></script>