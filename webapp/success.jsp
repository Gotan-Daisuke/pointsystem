<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーページ</title>
</head>
<body>
	<div>
		<!-- リクエストスコープからログインユーザーのIDを取得する -->
		<%String userid = (String)session.getAttribute("user_id"); %>
		<%String username = (String)session.getAttribute("user_name"); %>
		<!-- メッセージを表示する -->
		<p>ユーザーID：<%= userid %></p>
		<p>ユーザー名：<%= username %></p>
	</div>
</body>
</html>