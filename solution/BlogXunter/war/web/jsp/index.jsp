<%@ include file="/web/jsp/head.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="blogxunter" %>

<c:forEach items="${articleManager.articles}" var="artes">
	<div style="margin-top: 10px;">
	<a href="<c:url value="/article.htm?id=${artes.id}" />">
	<c:out value="${artes.title}"/><br />
	<c:out value="${artes.author}"/> - <c:out value="${artes.dateTime}"/></a>
	</div>
	<br />
</c:forEach>

<blogxunter:addArticleForm />

<%@ include file="/web/jsp/footer.jsp" %>