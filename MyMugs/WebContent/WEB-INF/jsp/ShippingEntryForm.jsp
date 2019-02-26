<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h2 style="margin-bottom: 30px;margin-top: 20px;">Shipping Form</h2>
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

<%@ include file="footer.jsp" %>