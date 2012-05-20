<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Test page  
</h1>

<div>
${message}
</div>

<f:form commandName="myCommand" method="post">
	<f:input path="myValue"/><f:errors path="*"/>
	<br>
	<input type="submit" name="model" value="Submit with Model"/>
	<input type="submit" name="modelNewCommand" value="Submit with Model and return a new command"/>
	<br>
	<input type="submit" name="mav" value="Submit with MAV"/>
	<input type="submit"  name="mavNewCommand" value="Submit with MAV and return a new command"/>
	<input type="submit"  name="mavReaddCommand" value="Submit with MAV and same command re-added"/>
</f:form>

</body>
</html>
