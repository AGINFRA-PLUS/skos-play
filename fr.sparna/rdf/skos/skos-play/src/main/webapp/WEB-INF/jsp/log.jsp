<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 	prefix="fmt" 	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c" 		%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- setup the locale for the messages based on the language in the session -->
<fmt:setLocale value="${sessionScope['fr.sparna.rdf.skosplay.SessionData'].userLocale.language}"/>
<fmt:setBundle basename="fr.sparna.rdf.skosplay.i18n.Bundle"/>

<c:set var="data" value="${requestScope['fr.sparna.rdf.skosplay.log.LogData']}" />
<c:set var="applicationData" value="${applicationScope.applicationData}" />

<html>
	<head>
		<title><c:out value="${applicationData.skosPlayConfig.applicationTitle}" /></title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="bootstrap-fileupload/jasny-bootstrap.min.css" rel="stylesheet" />
		<link href="css/skos-play.css" rel="stylesheet" />
		<link href="style/custom.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/jquery-editable-select.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script src="bootstrap-fileupload/jasny-bootstrap.min.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
    <script type="text/javascript">
    
	 google.charts.load('current', {'packages': ['table','corechart']});
	 google.charts.setOnLoadCallback(drawHistogramme);
	 google.charts.setOnLoadCallback(drawCamembert);
	
	 
     function drawHistogramme() {
   	  var data = new google.visualization.DataTable();
   	  data.addColumn('string', 'Jour/Mois/Année');
   	  data.addColumn('number', 'Print/Visualize');
   	  data.addColumn('number', 'Convert');  
   	  data.addRows(${data.jsonHistogrammeData});
   	  
   	  var view = new google.visualization.DataView(data);
   	  view.setColumns([0, 1, 2]);  
   	  var options = {
 	            title: 'Nombre de print et convert par jour/mois/année',
 	            colors: ['#FF7F50','#008B8B'],
 	            is3D: true,
 	            isStacked : true,
 	            legend : 'top',

 	          };
   	   var chart = new google.visualization.ColumnChart(document.getElementById('histogramme'));
       chart.draw(view, options);
       
       google.visualization.events.addListener(chart, 'select', function() {
    	   var selection = chart.getSelection();
    	   for (var i = 0; i < selection.length; i++) {
    		    var item = selection[i];
    		    if (item.row != null && item.column != null) {
    		    	 var jour = data.getValue(item.row,0);
    		    	 
    		    	 if(jour.includes('-')){
    		    		
    		    		 if(item.column===1){
        		    		 location.href = "listingprint?periode=alltime&indexDebut=0&jour="+jour; 
        		    	 }else if(item.column===2){
        		    		 location.href = "listingconvert?periode=alltime&indexDebut=0&jour="+jour; 
        		    	 }
    		    		 
    		    	 }
    		    	 
    		    
    		    }
    		  }
    		  
       });  
    }     
     
     function drawCamembert1() {
    	 var data = google.visualization.arrayToDataTable(
			    			 [['TYPE', 'NOMBRE'],
			    	    		 <c:forEach items="${data.format}" var="format">        				
			    	    					["${format.key}",${format.value}],
			    	    		</c:forEach>
							]);
			var options = {
                     is3D: true,
        };
    	var chart = new google.visualization.PieChart(document.getElementById('format'));
    	chart.draw(data, options); 
     }
     function drawCamembert2() {
    	 var data = google.visualization.arrayToDataTable(
			    			 [['TYPE', 'NOMBRE'],
			    	    		 <c:forEach items="${data.rendu}" var="rendu">        				
			    	    					["${rendu.key}",${rendu.value}],
			    	    		</c:forEach>
							]);
			var options = {
                     is3D: true,
        };
    	var chart = new google.visualization.PieChart(document.getElementById('rendu'));
    	chart.draw(data, options); 
     }
     function drawCamembert3() {
    	 var data = google.visualization.arrayToDataTable(
			    			 [['TYPE', 'NOMBRE'],
			    	    		 <c:forEach items="${data.printLangue}" var="langue">        				
			    	    					["${langue.key}",${langue.value}],
			    	    		</c:forEach>
							]);
			var options = {
                     is3D: true,
                     title: 'Repartition des langues pour les print/visualize',
        };
    	var chart = new google.visualization.PieChart(document.getElementById('langueprint'));
    	chart.draw(data, options); 
     }
     function drawCamembert4() {
    	 var data = google.visualization.arrayToDataTable(
			    			 [['TYPE', 'NOMBRE'],
			    	    		 <c:forEach items="${data.convertLangue}" var="langue">        				
			    	    					["${langue.key}",${langue.value}],
			    	    		</c:forEach>
							]);
			var options = {
                     is3D: true,
                     title: 'Repartition des langues pour les conversions',
        };
    	var chart = new google.visualization.PieChart(document.getElementById('langueconvert'));
    	chart.draw(data, options); 
     }
     
    function drawCamembert() {
    	      drawCamembert1();
    	      drawCamembert2();
    	      drawCamembert3();
    	      drawCamembert4();
		    }      
</script>
</head>
	<body style="text-align:center; margin:auto;">
		
		<div class="container">
			<%-- see http://stackoverflow.com/questions/19150683/passing-parameters-to-another-jsp-file-in-jspinclude --%>
			<jsp:include page="header.jsp"/>
					 
				<div class="col-sm-7 navbar-fixed-left" style="margin-top:10px;" >
					<a href="log"> Résumé des logs</a>|<a href="listingconvert">Listing des conversions </a>|<a href="listingprint"> Listing des prints</a><br/><br/>
					<form method="post" action="log" name="formulaire">
						 <label for="satistique">Choix de la période</label>	
						 <select style=" width:20%;" name="statistique" class="fixed-left" id="statistique">
								<option value="alltime" <c:if test="${data.choixperiode == 'alltime'}">selected</c:if>>Jour</option>
								<option value="month" <c:if test="${data.choixperiode == 'month'}">selected</c:if>>Mois</option>
								<option value="year"<c:if test="${data.choixperiode == 'year'}">selected</c:if>>Année</option>   
						 </select>
						 <button class="btn btn-default " type="submit">Valider</button>
						 
					</form>			
				</div><br/>
			    
				
			<div id="histogramme"  style="align: center;  margin-top:70px; width:100%; height: 300px;"></div><br/>
			<p>
				<em>Depuis toujours : </em>
				<c:forEach items="${data.allprintAndConvert}" var="liste">        				
			    	 ${liste.value}  ${liste.key} |
			    </c:forEach>
			</p>
			<p><em>Dernièrs 365 jours :</em> 
				<c:forEach items="${data.printConvertLast365Days}" var="liste">        				
			    	 ${liste.value}  ${liste.key} |
			    </c:forEach>
		    </p><br/>
		   	<h4><a style="text-decoration: underline;"><em>Statistiques globales sur les rendus</em></a></h4>
				<div id="global">
					<div id="format"  style="align:center; display:inline-block; height: 200px;"></div>
				
					<div id="rendu"   style="align: center; display:inline-block; height: 200px;"></div>	
				</div>
				<div id="global">
					<div id="langueprint"  style="align: center; width:100%; height: 300px;"></div>	
					<div id="langueconvert"  style="align: center; width:100%; height: 300px;"></div>
				</div>
				
				
				
		    
 		</div>		
	</body>
</html>