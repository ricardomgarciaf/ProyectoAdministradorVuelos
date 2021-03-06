<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Agregar avi�n</title>
</head>
<body>
	<h1>Agregar avi�n</h1>
	<p>Agrega un nuevo avi�n llenando todos los campos</p>
	<form:form method="POST" modelAttribute="avion">
		<table>
			<tbody>
				<tr>
					<td>Modelo:</td>
					<td><form:input path="modelo" /></td>
				</tr>
				<tr>
					<td>Capacidad:</td>
					<td><form:input path="capacidad" /></td>
				</tr>
				<tr>
					<td>Fabricante:</td>
					<td><form:input path="fabricante" /></td>

				</tr>
				<tr>
					<td>
					<c:choose>
						<c:when test="${!editar}">
							<input type="submit" value="Guardar"/> o <a
								href="${pageContext.request.contextPath}/aviones">Cancelar</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Actualizar"
								class="btn btn-primary btn-sm" /> o <a
								href="${pageContext.request.contextPath}/aviones">Cancelar</a>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/index">Volver al men�
			de inicio</a>
	</p>
</body>
</html>