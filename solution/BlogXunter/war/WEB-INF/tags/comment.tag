<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="blogxunter" %>
<%@ attribute name="divClass" required="true" type="java.lang.String" %>
<%@ attribute name="reply" required="true" type="java.lang.Integer" %>
<%@ attribute name="comment" required="true" type="blogxunter.main.comment.Comment" %>
 
<div class="${divClass}" id="c<c:out value="${comment.id}"/>">
	<div class="head">		
		<c:out value="${comment.author}"/> - <c:out value="${comment.dateTime}"/> 
		<a href="<c:url value="/article.htm?id=${comment.idArticle}&reply=${comment.id}" />">Reply</a>
	</div>
	<c:out value="${comment.text}"/>	
	<c:if test="${reply == comment.id}">
		<blogxunter:replyForm />
	</c:if>	
</div>