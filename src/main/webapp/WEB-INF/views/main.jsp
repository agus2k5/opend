<%-- 
    Document   : main
    Created on : 28/04/2016, 23:24:59
    Author     : Mariano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="base/Header.jsp"/>
<c:set var="base_url" value="${pageContext.request.contextPath}"/>
<spring:url value="/resources/img/" var="img" />
<spring:url value="/resources/js/Gmap.js" var="GmapJs" />
<script type="text/javascript">var base_url = '${base_url}';var img_url='${img}';var distanciaKM='${distanciaKM}';</script><!--global para Gmap.js-->
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script src="${GmapJs}"></script>
<div class="main">
    <div class="table-responsive" style="overflow:auto; overflow-y:hidden; margin: 0 auto; withe-space: nowrap">
        <div id="googleMap" class="col s12"style="width:1300px;height:550px;margin-top: 10px;margin-bottom: 10px;margin-left: 25px;margin-right: 25px;"></div>
    </div>
</div>
<jsp:include page="base/Footer.jsp"/>