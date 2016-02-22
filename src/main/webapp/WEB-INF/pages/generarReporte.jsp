<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Generar reporte</title>
</head>
<body>
	<h1>Generar reporte</h1>
	<p>Genera un reporte a partir de los campos</p>
	<form:form method="POST" modelAttribute="parametros">
		<table>
			<tbody>
				<tr>
					<td>Fecha inicial:</td>
					<td><form:input path="fechaInicial" /></td>
				</tr>
				<tr>
					<td>Fecha final</td>
					<td><form:input path="fechaFinal" /></td>
				</tr>
				<tr>
					<td>Avión:</td>
					<td><form:select path="avion" items="${aviones}"
							itemValue="id" itemLabel="modelo" /></td>

				</tr>
				<tr>
					<td><input type="submit" value="Generar reporte" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/index">Volver al menú
			de inicio</a>
	</p>
</body>
</html>