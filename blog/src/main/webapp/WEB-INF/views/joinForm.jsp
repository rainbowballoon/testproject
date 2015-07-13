<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">회원가입
                    <small>가입정보를 입력해주세요</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index">Home</a>
                    </li>
                    <li class="active">Contact</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Contact Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">
            <div class="col-md-8">
                <h3>정보를 입력해주세요</h3>
                
                <form action="join" method="POST" name="sentMessage" id="contactForm" novalidate>
                	<div class="control-group form-group">
                        <div class="controls">
                            <label>아이디:</label>
                            <input type="text" class="form-control" name="id" required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>비밀번호:</label>
                            <input type="password" class="form-control" name="pw" required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>회사명:</label>
                            <input type="text" class="form-control" name="cp" required data-validation-required-message="회사명을 입력해주세요">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>가입자 이름:</label>
                            <input type="text" class="form-control" name="name" required data-validation-required-message="가입자 이름을 입력해주세요">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>전화 번호:</label>
                            <input type="tel" class="form-control" name="tel" required data-validation-required-message="전화번호를 입력해주세요">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>사업자 등록번호:</label>
                            <input type="text" class="form-control" name="num" required data-validation-required-message="사업자 등록번호를 입력해주세요">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>회사주소:</label>
                            <input type="text" class="form-control" name="address" required data-validation-required-message="회사주소를 입력해주세요">
                        </div>
                    </div>
<!--                     <div class="control-group form-group"> -->
<!--                         <div class="controls"> -->
<!--                             <label>도메인이름:</label> -->
<!--                             <input type="text" class="form-control" name="domain" required data-validation-required-message="도메인명을 입력해주세요"> -->
<!--                         </div> -->
<!--                     </div> -->
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" class="btn btn-primary">가입하기</button>
                </form>
            </div>

        </div>
        <!-- /.row -->
	</div>
    <!-- /.container -->
    
<!-- Contact Form JavaScript -->
<!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
<script type="text/javascript" src="js/jqBootstrapValidation.js"></script>
<script type="text/javascript" src="js/contact_me.js"></script>