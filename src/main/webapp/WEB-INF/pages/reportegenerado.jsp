<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Reporte</title>
</head>
<body>
	<h1>Reporte</h1>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="10%">ruta</th>
				<th width="10%">vuelos</th>
				<th width="15%">pasajeros</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reporte" items="${reportes}">
				<tr>
					<td>${reporte.ruta}</td>
					<td>${avion.cantidadVuelos}</td>
					<td>${avion.cantidadPasajeros}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Funcionalidad en implementación</p>
	<p>
		<a href="${pageContext.request.contextPath}/index">Volver al menú
			de inicio</a>
	</p>

</body>
</html>