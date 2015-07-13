<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="col-md-8">
       
		<!-- Horizontal Form -->
		<div class="box box-info">
			<div class="box-header with-border">
				<h2 class="page-header">로그인</h2>
			</div><!-- /.box-header -->

			<!-- form start -->
			<form class="form-horizontal" action="blogLogin" method="POST">
			  <div class="box-body">
			    <div class="form-group">
					<label for="member_id" class="col-sm-2 control-label">아이디</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="member_id" name="member_id" placeholder="아이디">
					</div>
			    </div>
			    <div class="form-group">
					<label for="member_pw" class="col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="member_pw" name="member_pw" placeholder="비밀번호">
					</div>
			    </div>
			    <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					  <div class="checkbox">
					    <label><input type="checkbox"> 아이디 기억하기 </label>
					  </div>
					</div>
			    </div>
			  </div><!-- /.box-body -->
			 <div class="box-footer">
			   <button type="reset" class="btn btn-default col-sm-3">취소</button>
			   <button type="submit" class="btn btn-info pull-right col-sm-3">로그인</button>
			 </div><!-- /.box-footer -->
			</form>
		</div><!-- /.box -->
	</div>
