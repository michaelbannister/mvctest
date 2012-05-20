<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Script console</title>
</head>
<body>
	<form action="#" method="post">
		<h3>Script</h3>
		<pre id="previousScriptInput">${scriptInput}</pre>
		
		<h3>Return value</h3>
		<pre>${returnValue}</pre>
		
		<h3>Output</h3>
		<pre>${scriptOutput}</pre>
		
		<c:if test="${not empty exception}">
			<h3>Exception</h3>
			<pre>${exception}</pre>
		</c:if>
		<br/>
		<textarea id="scriptInput" rows="30" cols="100" name="scriptInput"></textarea>
		<br/>
		<input type="submit" value="Go">
	</form>
</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
</html>