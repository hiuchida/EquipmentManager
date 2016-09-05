<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*, ateam.model.*, ateam.util.*"%>
<%
    List<Bihin> list = (List<Bihin>) request.getAttribute("bihinList");
	String errorMessage = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>備品管理</title>
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery.floatThead.min.js"></script>
</head>
<body>
	<%@ include file="../menu.jsp"%>

	<h2>備品管理</h2>

	<% if(errorMessage != null){ %>
	<font color="red">
		<% out.println(errorMessage);%>
	</font>
	<% }%>
	<br>

	<div class="margin">

	<table class="pure-table pure-table-striped bihinList">
	<%
	    if (list.size() != 0) {
	%>
			<thead>
				<tr>
					<th>備品ID</th>
					<th>備品名</th>
					<th>備品名（フリガナ）</th>
					<th>ステータス</th>
					<th>貸出ユーザID</th>
					<th>貸出ユーザ名</th>
					<th>返却予定日</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<form method="POST" action="BihinAddServlet" accept-charset="UTF-8">
					<td><input type="text" name="bihinID"></td>
					<td><input type="text" name="bihinName"></td>
					<td><input type="text" name="bihinKana"></td>
					<td>利用可能</td>
					<td>---</td>
					<td>---</td>
					<td>---</td>
					<td>
							<button type="submit" class="pure-button"
							style="border:2px solid #0000FF;">登録</button>
					</td>
					</form>
				</tr>
				<%
			    for (Bihin bihin : list) {
				%>
				<tr>
					<td><%=bihin.getBihinID()%></td>
					<td><%=bihin.getBihinName()%></td>
					<td><%=bihin.getBihinKana()%></td>

					<!-- ステータス 1:利用可能 2:貸出中 3:返却済み 4:貸出申請中-->
					<td>
						<%
					    out.println(BihinUtil.getStatusStr(bihin.getStatus()));
					%>
					</td>

					<td><%=bihin.getUserID()%></td>
					<!-- ユーザー名がなかったら---を表示 -->
					<td>
						<%
					    out.println(UserUtil.getUserName(bihin.getUserID()));
					%>
					</td>

					<!-- 返却日がなかったら---を表示 -->
					<!-- 返却日を過ぎていたら赤くする -->
 					<td <% if (BihinUtil.isOverdue(bihin)) { %>
					class="text_overdue"
					<% } %>>
						<%
					    out.println(BihinUtil.getReturnDayStr(bihin.getReturnDay()));
					%>
					</td>
					<td>
						<form method="POST" action="BihinDeleteServlet" accept-charset="UTF-8">
							<input type="hidden" name="bihinID" value="<%=bihin.getBihinID()%>">
							<button type="submit" class="pure-button"
							<%if (bihin.getStatus() == Bihin.AVAILABLE) {%>
							style="border:2px solid #FF0000;"
							<% } %>
							<%if (bihin.getStatus() != Bihin.AVAILABLE) {%> disabled <%}%>>削除</button>
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
var $table = $('table.bihinList');
$table.floatThead();
</script>

</body>
</html>