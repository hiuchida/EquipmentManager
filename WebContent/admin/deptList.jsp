<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ateam.model.*, ateam.util.*"%>
<%
    List<Department> list = (List<Department>) request.getAttribute("deptList");
	String errorMessage = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部署管理</title>
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery.floatThead.min.js"></script>
</head>
<body>
	<%@ include file="../menu.jsp"%>

	<h2>部署管理</h2>

	<% if(errorMessage != null){ %>
	<font color="red">
		<% out.println(errorMessage);%>
	</font>
	<% }%>
	<br>

	<div class="margin">

	<table class="pure-table pure-table-striped deptList">
	<%
	    if (list.size() != 0) {
	%>
			<thead>
				<tr>
					<th>部署ID</th>
					<th>部署名</th>
					<th>部署名（フリガナ）</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<form method="POST" action="DepartmentAddServlet" accept-charset="UTF-8">
					<td><input type="text" name="deptID"></td>
					<td><input type="text" name="deptName"></td>
					<td><input type="text" name="deptKana"></td>
					<td>
							<button type="submit" class="pure-button"
							style="border:2px solid #0000FF;">登録</button>
					</td>
					</form>
				</tr>
				<%
			    for (Department dept : list) {
			%>
				<tr>
					<td><%=dept.getDeptID()%></td>
					<td><%=dept.getDeptName()%></td>
					<td><%=dept.getDeptKana()%></td>

					<td>
						<form method="POST" action="DepartmentDeleteServlet" accept-charset="UTF-8">
							<input type="hidden" name="deptID" value="<%=dept.getDeptID()%>">
							<button type="submit" class="pure-button"
							style="border:2px solid #FF0000;">削除</button>
						</form>
					</td>
				</tr>
				<%
			    }
			%>
			</tbody>
		</table>
	</div>

	<%
	} else {
%>
		<font size="5">検索結果はありません</font>
	<%
	}
%>

<script type="text/javascript">
var $table = $('table.deptList');
$table.floatThead();
</script>

</body>
</html>