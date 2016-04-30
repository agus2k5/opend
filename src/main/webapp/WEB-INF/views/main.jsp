<%-- 
    Document   : main
    Created on : 28/04/2016, 23:24:59
    Author     : Mariano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="base/Header.jsp"/>
<c:set var="base_url" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img/" var="img" />
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
    var lugar = new google.maps.LatLng(-27.477900,-58.819607);//centro de corrientes
    function initialize() {
        var mapProp = {
            center: lugar,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
        var marker;
        var infowindow;
        var content;
        var pinIcon;
        $.get("${base_url}/establecimiento/get", function (data) {
            var json = JSON.parse(JSON.stringify(data));
            $.each(json, function (i) {
                pinIcon = new google.maps.MarkerImage('${img}'+data[i].categoria.descripcion+'.png',null,null,null, new google.maps.Size(60, 60));
                lugar = new google.maps.LatLng(data[i].latitud, data[i].longitud);
                marker = new google.maps.Marker({position: lugar, title: data[i].nombre,icon: pinIcon});
                marker.setMap(map);
                content = "<h5>" + data[i].nombre + "</h5><p>" + data[i].direccionDescripcion + "</p>";
                infowindow = new google.maps.InfoWindow({content: content});
                google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow) {
                    return function () {
                        infowindow.setContent(content);
                        infowindow.open(map, marker);
                    };
                })(marker, content, infowindow));
            });
        });
        //var infoWindow = new google.maps.InfoWindow({map: map}); para mensajes
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                map.setCenter(pos);
                pinIcon = new google.maps.MarkerImage('${img}Person.png',null,null,null, new google.maps.Size(60, 60));
                marker = new google.maps.Marker({position: new google.maps.LatLng(pos.lat,pos.lng),icon: pinIcon});
                marker.setMap(map);
            });
        }
    }
    google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div class="main">
    <div class="table-responsive" style="overflow:auto; overflow-y:hidden; margin: 0 auto; withe-space: nowrap">
        <div id="googleMap" class="col s12"style="width:1300px;height:550px;margin-top: 10px;margin-left: 25px;margin-right: 25px;"></div>
    </div>
</div>
<jsp:include page="base/Footer.jsp"/>


