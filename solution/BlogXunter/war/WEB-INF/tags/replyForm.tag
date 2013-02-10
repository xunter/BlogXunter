<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="replyForm">
	<form:form method="post" commandName="reply">		
		<form:hidden path="dateTime"/>	
		<form:hidden path="idRoot"/>		
		<form:hidden path="idArticle"/>
		<table>
			<tr>
				<td colspan="3">Your comment: </td>
			</tr>
			<tr>
				<td width="40px">Name: </td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" cssClass="error" /></td>
			</tr>
			<tr>
				<td width="40px">Text: </td>
				<td><form:input path="text" /></td>
				<td><form:errors path="text" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add comment" /></td>
			</tr>
		</table>		
	</form:form>
</div>