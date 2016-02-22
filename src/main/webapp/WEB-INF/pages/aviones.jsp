<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de aviones</title>
</head>
<body>
	<h1>Lista de aviones</h1>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="10%">modelo</th>
				<th width="15%">capacidad</th>
				<th width="10%">fabricante</th>
				<th width="10%">acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="avion" items="${aviones}">
				<tr>
					<td>${avion.id}</td>
					<td>${avion.modelo}</td>
					<td>${avion.capacidad}</td>
					<td>${avion.fabricante}</td>
					<td><a
						href="${pageContext.request.contextPath}/aviones/editar-${avion.id}-avion">Editar</a><br />
						<a
						href="${pageContext.request.contextPath}/aviones/eliminar-${avion.id}-avion">Eliminar</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/aviones/agregar">Agregar nuevo avión</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/index">Volver al menú
			de inicio</a>
	</p>

</body>
</html>