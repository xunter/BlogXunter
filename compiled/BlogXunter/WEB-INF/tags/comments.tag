<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="blogxunter" %>
<%@ attribute name="parentId" required="true" type="java.lang.String" %>
<%@ attribute name="indent" required="true" type="java.lang.Integer" %>
<%@ attribute name="reply" required="true" type="java.lang.Integer" %>
<%@ attribute name="items" required="true" type="java.util.List" %>
<%@ variable name-given="comments" %>
 
<c:forEach var="comments" items="${items}" >
    <c:if test="${comments.idRoot eq parentId}">
    	<div style="margin: ${indent}px;">
    	<jsp:doBody /> 
    	<blogxunter:comments reply="${reply}" items="${items}" indent="${indent}" parentId="${comments.id}">
    		<jsp:body>
    			<blogxunter:comment divClass="comment" reply="${reply}" comment="${comments}"></blogxunter:comment>
    		</jsp:body>
    	</blogxunter:comments>
    	</div>
    </c:if>
</c:forEach>