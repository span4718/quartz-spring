<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add task</title>
<script type="text/javascript">
</script>


</head>
<body>
	<div>
		   <form id="form" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/taskScheduleCfg/addTask">
	  		<input type="hidden" name="id" id="lid" value="${task.jobId}">
	       <div class="panel panel-primary">
	         <div class="panel-heading">
	         </div>
	         <div class="panel-body">
        	   <div class="form-group">
	             <label class="col-sm-2 control-label">定时任务名称: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	             	<div class="col-sm-4">
	             	  <div class="qwe">
		               	  <input type="text" name="jobName" class="form-control"  value="${task.jobName}"><span></span>
	             	  </div>
	             	</div>
	           </div>
	           <div class="form-group">
	             <label class="col-sm-2 control-label">定时任务编码: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	             <div class="col-sm-4">
	              <div class="qwe">
	             	 <input type="text" name="jobCode" class="form-control"  value="${task.jobCode}"><span></span>
	              </div>
	             </div>
	           </div>
	           <div class="form-group">
	             <label class="col-sm-2 control-label">执行定时任务类的方法名: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	             <div class="col-sm-4">
	              <div class="qwe">
	             	 <input type="text" name="jobClassMethodName" class="form-control"  value="${task.jobClassMethodName}"><span></span>
	              </div>
	             </div>
	           </div>
	           <div class="form-group">
	             <label class="col-sm-2 control-label">定时表达方式: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	             <div class="col-sm-4">
	             	<div class="qwe">
	             	  <input type="text" name="cronExpression" class="form-control"  value="${task.cronExpression}"><span></span>
	             	</div>
	             </div>
	           </div>
	            <div class="form-group">
	             <label class="col-sm-2 control-label">启动方式: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	             <div class="col-sm-4">
	             	<div class="qwe">
	             	  <select class="form-control" name="autoStartup">
             	  		<option  value="0"  >手动启动</option>
             	  		<option  value="1" >自动启动</option>
	             	  </select>
	             	</div>
	             </div>
	           </div>
	           <div class="form-group">
	             <label class="col-sm-2 control-label">完整路径: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	              <div class="col-sm-4">
	              	 <div class="qwe">
	              		<input type="text" name="jobClass" class="form-control"  value="${task.jobClass}"><span></span>
	              	 </div>
	             </div>
	           </div>
	            <div class="form-group">
	             <label class="col-sm-2 control-label">是否可用: &nbsp;&nbsp;<span style="color:#FF0000;font-weight: bold;vertical-align: middle;">*</span>	  </label>
	             <div class="col-sm-4">
	             	<div class="qwe">
	             	  <select class="form-control" name="deletedFlag">
             	  		<option  value="0"  >可用</option>
             	  		<option  value="1"  >不可用</option>
	             	  </select>
	             	</div>
	             </div>
	           </div>
	           <div class="form-group ">
	             <label class="col-sm-2 control-label">备注:&nbsp;&nbsp;&nbsp;&nbsp;</label>
	           </div>
	           <div>注：带<div style="color:red;height: 35px; line-height: 37px;font-size:20px;display:inline;">*</div>项为必填项</div>
	         </div>
	         <div class="panel-footer">
	           <button type="submit"  class="btn btn-primary" id="editAdminBtn" onclick="savetask()">保存定时任务</button>
	           <button type="button" class="btn btn-primary" onclick="">返回</button>
	         </div>
	       </div>
	     </form>
	</div>
</body>
</html>