<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shipping Entry Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Shipping Form</h2>
			<br> <br>
			<div class="col-md-10">

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
								<td><c:out value="${item.name}"></c:out></td>
								<td>$<c:out value="${item.price}"></c:out></td>
								<td><c:out value="${item.quantity}"></c:out></td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="3" align="right"># Items</td>
							<td><c:out value="${order.quantityTotal}"></c:out></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<form:form modelAttribute="shipping" method="post"
					action="submitShipping">
					<div class="card card-outline-secondary">
						<div class="card-body">
							<h3 class="text-center">Shipping</h3>
							<hr>
							<div class="form-group">
								<label for="cc_name">Name</label>
								<form:input path="name" class="form-control" />
							</div>
							<div class="form-group">
								<label>Address</label>
								<form:input path="addressLine1" class="form-control" />
							</div>
							<div class="form-group">
								<label>Address Cont</label>
								<form:input path="addressLine2" class="form-control" />
							</div>
							<div class="form-group row">
								<label class="col-md-6">City</label>
								<label class="col-md-3">State</label>
								<label class="col-md-3">ZIP</label>
								<div class="col-md-6">
									<form:input path="city" class="form-control" />
								</div>
								<div class="col-md-3">
									<form:input path="state" class="form-control" />
								</div>
								<div class="col-md-3">
									<form:input path="zip" class="form-control" />
								</div>
							</div>
							
						
							<hr>
							<div class="form-group row">
								<div class="col-md-6"></div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-success btn-lg btn-block">Submit</button>
								</div>
							</div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
		<!-- /form card cc payment -->

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