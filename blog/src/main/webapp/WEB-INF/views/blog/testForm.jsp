<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Blog Entries Column -->
            <div class="col-md-8">
<!--                다른 블로그에 접근해보기 -->
<!--                <a href="61/readPost">61번사람 블로그</a> -->
<!-- 			   <a href="62/readPost">62번사람 블로그</a> -->
			   
		<!-- Navbar -->
        <div class="row">
            <div class="col-lg-12">
                <div class="page-header">
                    <h1>Candy Box 스킨</h1>
                </div>
                <div class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">블로그</a>
                    </div>
                    <div class="navbar-collapse collapse navbar-responsive-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">회원가입</a></li>
                            <li><a href="#">로그인</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">방명록 <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Dropdown header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left">
                            <input type="text" class="form-control col-lg-8" placeholder="Search">
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Link</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
               
            </div>
        </div>

			<button type="button" class="btn btn-lg btn-danger" data-toggle="popover" title="Popover title" 
			data-content="And here's some amazing content. It's very engaging. Right?">Click to toggle popover</button>
			
			
			<!-- Large modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      ...
    </div>
  </div>
</div>

<!-- Small modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      ...
    </div>
  </div>
</div>


        <!-- Buttons -->
        <div class="page-header">
            <div class="row">
                <div class="col-lg-12">
                    <h1>버튼 모양</h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <p>
                    <button type="button" class="btn btn-default">버튼1</button>
                    <button type="button" class="btn btn-primary">버튼2</button>
                    <button type="button" class="btn btn-success">버튼3</button>
                    <button type="button" class="btn btn-info">버튼4</button>
                    <button type="button" class="btn btn-warning">버튼5</button>
                    <button type="button" class="btn btn-danger">버튼6</button>
                    <button type="button" class="btn btn-link">링크7</button>
                </p>
            </div>
		</div>
	</div>            
<!-- <hr> -->
<!-- AOP 테스트중 -->
<!-- <hr> -->
