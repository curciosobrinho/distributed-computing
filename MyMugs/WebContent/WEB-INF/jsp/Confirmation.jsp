<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h2 style="margin-bottom: 30px;margin-top: 20px;">Congratulations! <br><br> Your order #<c:out value="${orderNumber}"></c:out> is confirmed!</h2>
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
								<td><c:out value="${item.itemName}"></c:out></td>
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
	</div>
<%@ include file="footer.jsp" %>