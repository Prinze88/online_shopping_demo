<div class="container">
	<div class="row">
		<!-- To display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		
		
		
		
		<!-- To display products -->
		<div class="col-md-9">
			<!-- Added for breadcrumb -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a><span>&nbsp;</span></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a><span>&nbsp;</span></li>
							<li class="active">Category<span>&nbsp;</span></li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>

				</div>
			</div>
		
			<div class="row">
				<div class="col-xs-12">
				<table id=productListTable class="table table-striped table-borderd">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							
						</tr>
					</thead>
				
				</table>
				</div>
			</div>
		
		</div>

	</div>
</div>