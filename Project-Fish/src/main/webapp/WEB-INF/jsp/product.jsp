<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Product List</title>
</head>
<body>
	<h1>List of Car</h1>

	<br />
	<br />  
	<div>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>PRO_CODE</th>
				<th>Name</th>
				<th>Image</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${products}" var="product" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${products.PRO_CODE}</td>
					<td>${products.name} </td>
					<td>${products.image}</td>
					<td>${products.price}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>