<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type='text/javascript'>
	window.parent.CKEDITOR.tools.callFunction('${CKEditorFuncNum}', '${file_path}', "전송이 완료되었습니다");
</script>