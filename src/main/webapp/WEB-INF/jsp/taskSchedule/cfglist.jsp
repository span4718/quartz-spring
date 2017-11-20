<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定时任务列表</title>

<script type="text/javascript">

</script>
</head>
<body>
<div>
	<div>
		<td class="">
			<button type="button" name="addTask" onclick="window.location.href='${pageContext.request.contextPath}/taskScheduleCfg/toaddtask'">添加</button>
			<button type="button" name="addTask" onclick="window.location.href='${pageContext.request.contextPath}/taskScheduleCfg/stopAllTsk'">全部停止</button>
		</td>
	</div>
	<div>
		<table class="" action="" border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;">
				<thead class="" style="; color:">
					 <tr>
                        <th>序号</th>
                        <th>定时任务名称</th>
                        <th>任务编码</th>
                        <th>trigger表达式</th>
                        <th>启动方式</th>
                        <th>备注</th>
                        <th>状态</th>
                        <th>是否可用</th>
                        <th>操作</th>
                  				</tr>
				</thead>
				<tbody>
					 <c:if test="${not empty tasks}">
                 				<c:forEach items="${tasks}" var="Task" varStatus="s" begin="0">
							<tr>
		                         <td>${s.index + 1}</td>
		                         <td>${Task.jobName}</td>
		                         <td>${Task.jobCode}</td>
		                         <td>${Task.cronExpression}</td>
		                         <td>${Task.autoStartup}</td>
		                         <td>${Task.memo}</td>
		                         <td>${Task.status}</td>
		                         <td>${Task.deleteFlag}</td>
		                         <td id="${Task.jobId}">
		                         		<button type="button" name="start" onclick="window.location.href='${pageContext.request.contextPath}/taskScheduleCfg/startTask/${Task.jobId}'">启动</button>
		                         		<button type="button" name="stop" onclick="window.location.href='${pageContext.request.contextPath}/taskScheduleCfg/stopTask/${Task.jobId}'" class="btn btn-primary btn-sm" >停止</button>
		                         	    <button type="button" name="update"class="btn btn-primary btn-sm">修改</button>
		                         		<button type="button" name="bankLimit" class="btn btn-primary btn-sm" >执行一次</button>
		                         		<c:if test="${Task.status == 1}">
		                             		<button type="button" name="deletebank"class="btn btn-primary btn-sm" isUsed=0>禁用</button>
		                         		</c:if>
		                         		<c:if test="${Task.status == 0}">
		                             		<button type="button" name="deletebank"class="btn btn-primary btn-sm" isUsed=1>恢复</button>
		                         		</c:if>
		                         </td>
                    		 	</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty tasks}">
						<tr>
							<td colspan="10"><label class="col-sm-1 control-label text-center">无记录</label></td>
						</tr>
					</c:if>
				</tbody>
		</table>
	</div>
</div>
</body>
</html>