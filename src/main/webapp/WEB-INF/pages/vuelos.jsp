<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de vuelos</title>
</head>
<body>
	<h1>Lista de vuelos</h1>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="10%">Avión</th>
				<th width="15%">Ruta</th>
				<th width="10%">Fecha</th>
				<th width="10%">Hora inicio</th>
				<th width="10%">Hora fin</th>
				<th width="10%">acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vuelo" items="${vuelos}">
				<tr>
					<td>${vuelo.id}</td>
					<td>${vuelo.avion.modelo}</td>
					<td>${vuelo.ruta}</td>
					<td>${vuelo.fecha}</td>
					<td>${vuelo.horainicio}</td>
					<td>${vuelo.horafin}</td>
					<td><a
						href="${pageContext.request.contextPath}/vuelos/editar-${vuelo.id}-vuelo">Editar</a><br />
						<a
						href="${pageContext.request.contextPath}/vuelos/eliminar-${vuelo.id}-vuelo">Eliminar</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/vuelos/agregar">Agregar nuevo vuelo</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/index">Volver al menú
			de inicio</a>
	</p>

</body>
</html>