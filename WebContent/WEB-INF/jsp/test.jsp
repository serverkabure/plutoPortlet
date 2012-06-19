<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:portlet="http://java.sun.com/portlet_2_0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

	<portlet:actionURL var="viewUrl" portletMode="view" />

	<form action="${viewUrl}" method="post">
		<h3>メッセージ入力</h3>
		<input type="text" name="message" value="${message}" /><br /> <input
			type="submit" name="send" value="Send" />
	</form>

</jsp:root>