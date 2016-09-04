<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ateam.model.*, ateam.util.*"%>
<%
    List<Department> list = (List<Department>) request.getAttribute("deptList");
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
				<%
			    for (Department dept : list) {
			%>
				<tr>
					<td><%=dept.getDeptID()%></td>
					<td><%=dept.getDeptName()%></td>
					<td><%=dept.getDeptKana()%></td>

					<td>
						<%-- 申請ボタン
						<form method="POST" action="RequestServlet" accept-charset="UTF-8">
							<input type="hidden" name="bihinName"
								value="<%=bihin.getBihinName()%>"> <input type="hidden"
								name="bihinID" value="<%=bihin.getBihinID()%>">
							<button type="submit" class="pure-button"
							<%if (bihin.getStatus() == Bihin.AVAILABLE) {%>
							style="border:2px solid #0000FF;"
							<% } %>
								<%if (bihin.getStatus() != Bihin.AVAILABLE) {%> disabled <%}%>>申請</button>
						</form>
						--%>
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