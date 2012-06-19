<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<form action="<portlet:actionURL />" method="post">
	<p>メッセージ入力</p>
	<input type="text" name="message" value="${message}" /><br /> <input
		type="submit" name="send" value="Send" />
	<p>${message}</p>
</form>
