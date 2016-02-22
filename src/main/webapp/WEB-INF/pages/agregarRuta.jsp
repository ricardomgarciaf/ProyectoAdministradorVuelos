<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Agregar ruta</title>
</head>
<body>
	<h1>Agregar ruta</h1>
	<p>Agrega una nueva ruta llenando todos los campos</p>
	<form:form method="POST" modelAttribute="ruta">
		<table>
			<tbody>
				<tr>
					<td>Aeropuerto-Origen:</td>
					<td><form:select path="aeropuertoByAeropuertoOrigen" items="${aeropuertos}" itemValue="id" itemLabel="nombre"/>
						</td>
				</tr>
				<tr>
					<td>Aeropuerto-Destino</td>
					<td><form:select path="aeropuertoByAeropuertoDestino" items="${aeropuertos}" itemValue="id" itemLabel="nombre"/></td>
				</tr>
				<tr>
					<td>Duración:</td>
					<td><form:input path="duracion" /></td>

				</tr>
				<tr>
					<td><c:choose>
							<c:when test="${!editar}">
								<input type="submit" value="Guardar" /> o <a
									href="${pageContext.request.contextPath}/rutas">Cancelar</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Actualizar" /> o <a
									href="${pageContext.request.contextPath}/rutas">Cancelar</a>
							</c:otherwise>
						</c:choose></td>
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