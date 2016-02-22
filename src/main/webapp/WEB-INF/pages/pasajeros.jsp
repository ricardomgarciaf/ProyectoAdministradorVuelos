<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de pasajeros</title>
</head>
<body>
	<h1>Lista de pasajeros</h1>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="10%">nombre</th>
				<th width="15%">apellido</th>
				<th width="10%">acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pasajero" items="${pasajeros}">
				<tr>
					<td>${pasajero.id}</td>
					<td>${pasajero.nombre}</td>
					<td>${pasajero.apellido}</td>
					<td><a
						href="${pageContext.request.contextPath}/pasajeros/editar-${pasajero.id}-pasajero">Editar</a><br />
						<a
						href="${pageContext.request.contextPath}/pasajeros/eliminar-${pasajero.id}-pasajero">Eliminar</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/pasajeros/agregar">Agregar nuevo pasajero</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/index">Volver al men�
			de inicio</a>
	</p>

</body>
</html>