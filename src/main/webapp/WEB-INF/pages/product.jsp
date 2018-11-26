<%@ include file="/WEB-INF/includes/header.jsp"%>
<div class="col-sm-12">
	<c:forEach var="cprod" items="${Category_Product }" varStatus="status">
	<div class="card col-sm-3">
		<img class="card-img-top" src="https://via.placeholder.com/150" alt="Card image cap">
		<div class="card-body">
			<h5 class="card-title"><c:out value="${cprod.gp_name }" /></h5>
			<p class="card-text"><c:out value="${cprod.gp_description }" /></p>
		</div>
		<div class="card-footer">
			<small class="text-muted"><button class="btn btn-default">Add to Cart</button></small>
		</div>
	</div>
	</c:forEach>
</div>
</body>
</html>