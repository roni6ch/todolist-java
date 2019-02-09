<%@ page import="java.util.ArrayList"%>
<%@ page import="com.roni.todoJersey.todoJersey.*"%>
<%
	Todo todo = new Todo();
ArrayList<Item> todos = todo.GetData();
%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<body>

	<div id="wrapper">
		<form action="TodoServlet?action=addItem" method="post">
			<fieldset>
				<legend>
					<span class="h1 d-flex justify-content-center">TodoList - Java Jersey + Maven</span>
				</legend>


				<div class="form-group form-inline d-flex justify-content-center">
					<input type="text" class="form-control" id="note" name="note"
						value="" 
						placeholder="Write Note..."> <input type="button"
						class="btn btn-info m-2" id="addNewItem" value="Add new Item" />
				</div>
			</fieldset>
		</form>

		<table class="table table-hover ">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Note</th>
					<th scope="col">Status</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<%
				if (todos != null) {
					int index = 1;
					for (Item item : todos) {
						
			%>
			<tr  id="<%=item.getId()%>">
				<td scope="row"><%=index++%></td>
				<td class="date"><%=item.getDate()%></td>
				<td class="note"><textarea class="h3"><%=item.getNote()%></textarea></td>
				<td>
					<div class="switch_box box_1">
						<input type="checkbox" 
					class="<%if (item.isStatus())  out.print("checked"); %> switch_1 doneItem"
							<%if (item.isStatus()) {
						out.print("checked=\"checked\"");
					}%> />
					</div>
				</td>
				<td><button class="btn btn-grey updateItem disableBT">Update</button></td>
				<td><button class="btn btn-info deleteItem">Delete</button></td>
			</tr>
			<%
				}
					;
				}
			%>
		</table>

	</div>
</body>
</html>