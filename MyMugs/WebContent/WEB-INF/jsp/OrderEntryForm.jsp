<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Entry Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h2 style="margin-bottom: 30px;margin-top: 20px;">Grab your MUG!</h2>
				<form:form modelAttribute="order" method="post"
					action="purchase/submitItems">

					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Item</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order.items}" var="item" varStatus="loop">
								<tr>
									<th scope="row"><c:out value="${loop.index +1}"></c:out></th>
									<td><c:out value="${item.name}"></c:out> <form:hidden
											path="items[${loop.index}].name" value="${item.name}" /></td>
									<td>$<c:out value="${item.price}"></c:out> <form:hidden
											path="items[${loop.index}].price" value="${item.price}" /></td>
									<td><form:input path="items[${loop.index}].quantity" value="0"/></td>
								</tr>
							</c:forEach>

							<tr>
								<td colspan="4"><input type="submit" value="Purchase"></td>
							</tr>
						</tbody>
					</table>
				</form:form>

			</div>

		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>