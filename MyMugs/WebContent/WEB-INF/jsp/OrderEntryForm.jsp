<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h2 style="margin-bottom: 30px;margin-top: 20px;">My Cart</h2>
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
<%@ include file="footer.jsp" %>
<script>
var url_string = window.location.href;
var url = new URL(url_string);
var err = url.searchParams.get("error");
if (err.length > 0){
	alert(err)
}
</script>