<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 style="margin-bottom: 30px;margin-top: 20px;">Congratulations! <br><br> Your order #<c:out value="${orderNumber}"></c:out> is confirmed!</h2>
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
							<td colspan="2" align="right">Total</td>
							<td><c:out value="${order.orderTotal}"></c:out></td>
							<td><c:out value="${order.quantityTotal}"></c:out></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="card">
  					<div class="card-header">
    					Payment Info
  					</div>
  					<div class="card-body">
    					<p class="card-text">Name: <c:out value="${payment.ccHolderName}"></c:out><br>
    					Credit Card #: <c:out value="${payment.ccNumber}"></c:out><br>
    					Exp Date: <c:out value="${payment.ccExpDate}"></c:out><br>
    					CVV: <c:out value="${payment.ccCvvCode}"></c:out><br> 
    					</p>
  					</div>
				</div>
			</div>
			<div class="col-md-1">
				
			</div>
			<div class="col-md-4">
				<div class="card">
  					<div class="card-header">
    					Shipping Info
  					</div>
  					<div class="card-body">
    					<p class="card-text">Name: <c:out value="${shipping.name}"></c:out><br>
    					Address : <c:out value="${shipping.addressLine1}"></c:out><br>
    					Address Cont: <c:out value="${shipping.addressLine2}"></c:out><br>
    					City: <c:out value="${shipping.city}"></c:out><br> 
    					State: <c:out value="${shipping.state}"></c:out><br> 
    					ZIP: <c:out value="${shipping.zip}"></c:out><br> 
    					</p>
  					</div>
				</div>
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