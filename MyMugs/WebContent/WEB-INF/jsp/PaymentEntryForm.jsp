<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h2 style="margin-bottom: 30px;margin-top: 20px;">Payment Form</h2>
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
			<div class="col-md-6">
				<form:form modelAttribute="payment" method="post"
					action="submitPayment">
					<div class="card card-outline-secondary">
						<div class="card-body">
							<h3 class="text-center">Credit Card Payment</h3>
							<hr>
							<div class="form-group">
								<label for="cc_name">Card Holder's Name</label>
								<form:input path="ccHolderName" class="form-control" />
							</div>
							<div class="form-group">
								<label>Card Number</label>
								<form:input path="ccNumber" class="form-control" />
							</div>
							<div class="form-group row">
								<label class="col-md-12">Card Exp. Date</label>
								<div class="col-md-8">
									<form:input path="ccExpDate" class="form-control" />
								</div>
								<div class="col-md-4">
									<form:input path="ccCvvCode" class="form-control" />
								</div>
							</div>
							<div class="row">
								<label class="col-md-12">Amount</label>
							</div>
							<div class="form-inline">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">$</span>
									</div>
									<input type="text" class="form-control text-right disabled"
										id="amount" readonly="readonly"
										value="<c:out value="${order.orderTotal}"></c:out>">
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
<%@ include file="footer.jsp" %>