<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ll" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hellow World</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/JQuery/jquery-1.12.4.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>



<script type="text/javascript">

	$(function() {

		$("#quanId").click(function() {

			var num = 0;

			var v = $(this).prop("checked");

			if (v == true) {

				num = -1;
				$(":checkbox").each(function() {

					num += 1;

					$(this).prop("checked", v);
				});
			}
			if (v == false) {
				$(":checkbox").each(function() {
					$(this).prop("checked", v);
				});
			}
			$($("span")[1]).text(num);
		});

		$("input[name='ids']").click(function() {
			//1.获取多少个a = checkbox-1

			var a = $(":checkbox").length - 1;

			var num = 0;
			$("input:checked").each(function(index, element) {
				if (element.id != "quanId") {
					num += 1;
				}
			});
			//2.如过num和 a不同,找到上面那个checkbox 去掉
			if (a != num) {
				$("#quanId").prop("checked", false);
			}
			$($("span")[1]).text(num);
		});
	});
	

	function deleteVideo(id){
	
		
if(!confirm("亲爱的,忍心抛下我吗？")){ 
			
			window.event.returnValue = false; 
			
		} 
		
		
	}
	
	
	
	/* $.alert({
	    title: '提示',
	    content: 'Simple alert!',
	});
	 */
	
		 /* if(!confirm("亲爱的,忍心抛下我吗？")){ 
			
			window.event.returnValue = false; 
			
		}   */
	
	
	
	
	function deleteAll(){
			 $.confirm({
				    title: '提示',
				    content: '是否确认',
				    buttons: {
				        confirm: {
				        	text:'非常肯定',
				        	action : function(){
				        		
				        		 $("form[name='delete']")[0].submit();
				        	}
				        	
				        },
				        取消: function () {
				          
				        }
				        
				        
				    }
				});

			
		        
	}        
		/* $.confirm({
		    title: '提示',
		    content: '是否确认',
		    buttons: {
		        confirm: {
		        	text:'非常肯定',
		        	action : function(){
		        		
		        	}
		        	
		        },
		        取消: function () {
		          
		        }
		        
		        
		    }
		}); */
		
	/* 	
		if(!confirm("亲爱的,你确定要删除吗??")){
			
			window.event.returnValue = false;
			
		}else{
			
			 $("form[name='delete']")[0].submit();
			 
			 return true;
		} 	
		 */
	
	
</script>

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
				<li><a href="#">视频管理系统</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/adminPage.action">视频管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/speakerList.action">主讲人管理</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/courseList.action">课程管理</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/countMangement.action">统计分析</a></li>
				<li><a target="pageBox" href="#">admin <span
						class="glyphicon glyphicon-log-out" aria-hidden="true"> <!-- <a target="pageBox"  href="#">退出 -->
					</span></a></li>
			</ul>
		</div>
	</nav>
	<div class="jumbotron">
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程列表--课程管理</h2>
	</div>
	<div style="margin-left: 150px;">
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin/addVideo.action">添加视频</a>
		<a  onclick=" deleteAll()"><button class="btn btn-primary"type="button">批量删除 <span class="badge"></span></button> </a>
		<form id="searchForm"action="${pageContext.request.contextPath}/admin/adminPage.action">
			<div style="margin-left: 300px;">
				<input type="text" name="adminVideotitle" placeholder="视频标题">
				<select name="adminSearchSperker">
					<option value="">请选择主讲人</option>
					<c:forEach var="list" items="${list}" varStatus="status">
						<option value="${list.id}">${list.speakerName}</option>
					</c:forEach>
				</select> <select name="adminSearchCourse">
					<option value="">请选择课程</option>
					<c:forEach var="course" items="${course}" varStatus="status">
						<option value="${course.id}">${course.courseName}</option>
					</c:forEach>
				</select> <input type="submit" class="btn btn-primary" value="查询">
			</div>
		</form>

		<div class="bs-example" data-example-id="table-within-panel"></div>


		<form action="${pageContext.request.contextPath}/admin/muiltdeleteVideo.action" name="delete" method="post">
			<table class="table" style="margin-left: 30px; margin-right: 30px; width: 1600px;">
				<thead>
					<tr>
						<th><input type="checkbox" id="quanId"></th>
						<th>序号</th>
						<th>名称</th>
						<th>介绍</th>
						<th>讲师</th>
						<th>课程</th>
						<th>时长(秒)</th>
						<th>播放次数</th>
						<th>编辑</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach var="video" items="${page.rows }" varStatus="status">

						<tr>
							<td><input type="checkbox" name="ids" value="${video.id }"></td>
							<td scope="row">${status.count +((page.page-1)*5)}</td>
							<td>${video.videoTitle}</td>
							<td>${video.videoDescr}</td>
							<td>${video.speakerName}</td>
							<td>${video.courseName}</td>
							<td>${video.videoLength}</td>
							<td>${video.videoPlayTimes}</td>
							<td><a href="<c:url value="/admin/editVideo.action?id="/>${video.id}">
							<span class="glyphicon glyphicon-edit" aria-hidden="blue"> </span></a>
							&nbsp; <a onclick="deleteVideo(this)" href="<c:url value="/admin/deleteVideo.action?id="/>${video.id}">
							
							
							<span   class="glyphicon glyphicon-trash" aria-hidden="blue"></span></a>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
			
		</form>



	</div>
	<ll:page
		url="${pageContext.request.contextPath}/admin/adminPage.action"></ll:page>
</body>
</html>