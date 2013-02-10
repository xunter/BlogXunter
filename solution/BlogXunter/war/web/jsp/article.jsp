<%@ taglib tagdir="/WEB-INF/tags" prefix="blogxunter" %>
<%@ include file="/web/jsp/head.jsp" %>



<c:set value="<%= request.getParameter("reply") %>" var="reply" />
<div class="article">
	<div class="head">
		<h3><c:out value="${article.title}" /></h3>
		<c:out value="${article.dateTime}" /> - <c:out value="${article.author}" /> say:
	</div>
	<div>
		<c:out value="${article.text}" />
	</div>
</div>
<br />
<div class="comments">
	<blogxunter:comments reply="${reply}" items="${article.comments}" indent="10" parentId="-1">
		<jsp:body>
			<blogxunter:comment divClass="comment" reply="${reply}" comment="${comments}"></blogxunter:comment>	
		</jsp:body>	
	</blogxunter:comments>	
	<c:if test="${reply != -1}">
		<div><a href="<c:url value="/article.htm?id=${article.id}&reply=-1" />">Add comment</a></div>
	</c:if>	
	<c:if test="${reply == -1}">
		<blogxunter:replyForm />
	</c:if>
</div>
<%@ include file="/web/jsp/footer.jsp" %>