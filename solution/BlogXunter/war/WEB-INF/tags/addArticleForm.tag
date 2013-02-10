<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="replyForm">
	<form:form method="post" commandName="addArticle">		
		<table>
			<tr>
				<td colspan="3">Your article: </td>
			</tr>
			<tr>
				<td width="40px">Name: </td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" cssClass="error" /></td>
			</tr>
			<tr>
				<td width="40px">Title: </td>
				<td><form:input path="title" /></td>
				<td><form:errors path="title" cssClass="error" /></td>
			</tr>
			<tr>
				<td width="40px">Text: </td>
				<td><form:textarea cols="40" rows="10" path="text"/></td>
				<td><form:errors path="text" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add article" /></td>
			</tr>
		</table>		
	</form:form>
</div>