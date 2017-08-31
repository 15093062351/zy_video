<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ll" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Hellow World</title>

		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<style>
			.jumbotron {
				margin-left: 150px;
				margin-right: 150px;
				padding-top: 10px;
				padding-bottom: 10px;
			}
			
			form {
				display: inline-block;
			}
		</style>
</head>
<body>

<nav class="navbar navbar-inverse">
			<div style="margin-left: 150px;">
				<ul class="nav navbar-nav">
					<li>
						<a href="#">视频管理系统</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/admin/adminPage.action">视频管理</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/admin/speakerList.action">主讲人管理</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/admin/courseList.action">课程管理</a>
					</li>
					
					<li><a target="pageBox"  href="#">admin
    <span class="glyphicon glyphicon-log-out" aria-hidden="true"><!-- <a target="pageBox"  href="#">退出 --></span></a> </li>
					
				</ul>
			</div>
		</nav>
		<div class="jumbotron">
			<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主讲人列表--主讲人管理</h2>
		</div>
		<div style="margin-left: 150px;">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/addSpeaker.action" >添加主讲人</a>
			<form id="searchForm" action="${pageContext.request.contextPath}/admin/speakerList.action">
				<div style="margin-left: 300px;">
					<span>名称</span>
					<input type="text" name="speakerName" value="" placeholder="主讲人名称">
					<span>职位</span>
					<input type="text" name="speakerJob" value="" placeholder="主讲人职位">
					<input type="submit" class="btn btn-primary" value="查询">
				</div>
			</form>
			<div class="bs-example" data-example-id="table-within-panel"></div>

			<table class="table" style="margin-left: 30px; margin-right: 30px;width: 1600px;">
				<thead>
					<tr>
						<th>序号</th>
						<th>名称</th>
						<th>职位</th>
						<th>简介</th>
						<th>编辑</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach var="speaker" items="${page.rows }" varStatus="status">
					<tr>
						<th scope="row">${status.count}</th>
						<td>${speaker.speakerName}</td>
						<td>${speaker.speakerJob}</td>
						<td>${speaker.speakerDescr }</td>
						<td>
							<a href="<c:url value="/admin/editSpeaker.action?id="/>${speaker.id}"><span class="glyphicon glyphicon-edit" aria-hidden="blue"></span></a>
							&nbsp;
							<a href="<c:url value="/admin/deleteSpeaker.action?id="/>${speaker.id}"><span class="glyphicon glyphicon-trash" aria-hidden="blue"></span></a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
<ll:page url="${pageContext.request.contextPath}/admin/speakerList.action"></ll:page>

</body>
</html>