<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sistemas OB3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/docs.css" rel="stylesheet">
<link href="css/prettify.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="img/logo4e.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="img/logo4e.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="img/logo4e.png">
<link rel="apple-touch-icon-precomposed" href="img/logo4e.png">
<link rel="shortcut icon" href="img/logo4e.png">
   <!-- JavaScripts -->   
    <script src="js/templatemo_custom.js"></script> <!-- lightbox -->
    <script src="js/jquery.lightbox.js"></script>
    <script src="js/bootstrap-collapse.js"></script> 
  <link rel="stylesheet" href="css/jquery-ui.css">
  <script src="js/jquery-1.11.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script>
  $(function() {	
	  $('#Descripcion').keypress(function () {
		  $.ajax({
			  url:"Auto",
			  type:"post",
			  data:'',
			  success:function(data){
				  $( "#Descripcion" ).autocomplete({			
				      source: data
				    });
				
			  },error:  function(data, status, er){
		            console.log(data+"_"+status+"_"+er);
		        },		        
		  });		 
	   });
  });
  </script>
  <script>
  $(function() {	
	  $('#Upc').keypress(function () {
		  $.ajax({
			  url:"AutoTwo",
			  type:"post",
			  data:'',
			  success:function(data){
				  $( "#Upc" ).autocomplete({			
				      source: data
				    });
				
			  },error:  function(data, status, er){
		            console.log(data+"_"+status+"_"+er);
		        },		        
		  });		 
	   });
  });
  </script>

<script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-146052-10']);
      _gaq.push(['_trackPageview']);
      (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
    </script>
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">

	<!-- Navbar
    ================================================== -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="http://4eglobal.com/" target="_blank">4E
					GLOBAL</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class=""><a href="./index.jsp">FICHAS TÉCNICAS</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- Subhead
================================================== -->
	<header class="jumbotron subhead" id="overview">
		<div>
			<div align="right">
				<img alt="LOGO4E" class="img-responsive" src="img/logo4eBLANCO.png"
					width="100" height="100">
			</div>
			<div class="container">
				<i><font face="Bitstream Vera Sans Mono" size="11550"
					color="FFFFFF">SISTEMAS</font><font size="11550"
					face="Bitstream Vera Sans Mono" color=#FFFFFF> OB3</font></i> <br>
				<font face="Comic Sans MS">4E GLOBAL</font>
			</div>
		</div>
	</header>


	<div class="container">

		<!-- Docs nav
    ================================================== -->
		<div class="row">
			<div class="span3 bs-docs-sidebar">
				<ul class="nav nav-list bs-docs-sidenav">
					<li><a href="#instrucciones"><i class="icon-chevron-right"></i>
							Instrucciones</a></li>
					<li><a href="#codigo"><i class="icon-chevron-right"></i>
							Ficha por Código OB3</a></li>
					<li><a href="#upc"><i class="icon-chevron-right"></i>
							Ficha por UPC</a></li>
					<li><a href="#descripcion"><i class="icon-chevron-right"></i>
							Ficha por Descripción</a></li>
					<li><a href="#contacto"><i class="icon-chevron-right"></i>
							Contacto</a></li>
				</ul>
			</div>
			<div class="span9">
				<!-- Typography "NOV1-12"
        ================================================== -->
				<section id="instrucciones">
					<div class="page-header">
						<h1>Instrucciones:</h1>
						<p>INDIQUE EL CODIGO DE PRODUCTO</p>
					</div>
					<h2 id="codigo">...</h2>
					<form class="bs-docs-example" style="padding-bottom: 15px;"
						action="fichas" method="post" target="_blank">
						<div class="controls docs-input-sizes">
							<input class="span3" name="reportID" type="hidden" value="1"
								required> <span class="help-inline">OB3:</span><input
								class="span3" name="Codigo" type="text" placeholder="FOLIO"
								required>
								INSTRUCCIONES DE EMBALAJE 
								<input type="checkbox" name="SI" value="1"><BR>
								
								FACT SHEET 
								<input type="checkbox" name="FS" value="1">
								<BR>
								
							<button type="submit" class="btn btn-primary">Aceptar</button>
							<!-- <button type="reset" class="btn">Limpiar</button>  -->
						</div>
					</form>
					<pre class="prettyprint linenums">
Presione Aceptar.
</pre>

				</section>
			</div>
			<div class="span9">
				<!-- Typography "NOV1-12"
        ================================================== -->
				<section id="instrucciones">
					<div class="page-header">
						<h1>Instrucciones:</h1>
						<p>INDIQUE EL UPC DEL PRODUCTO</p>
					</div>
					<h2 id="upc">...</h2>
					<form class="bs-docs-example" style="padding-bottom: 15px;"
						action="fichas_upc" method="post" target="_blank">
						<div class="controls docs-input-sizes">
							<input class="span3" name="reportID" type="hidden" value="1"
								required> <span class="help-inline">UPC:</span><input
								class="span3" name="Upc" type="text" id="Upc"
								required> <input type="checkbox" name="SI" value="1">

							<button type="submit" class="btn btn-primary">Aceptar</button>
							<!-- <button type="reset" class="btn">Limpiar</button>  -->
						</div>
					</form>
										<pre class="prettyprint linenums">
Presione Aceptar.
</pre>

				</section>
			</div>
			<div class="span9">
				<!-- Typography "NOV1-12"
        ================================================== -->
				<section id="instrucciones">
					<div class="page-header">
						<h1>Instrucciones:</h1>
						<p>INDIQUE LA DESCRIPCIÓN DEL PRODUCTO</p>
					</div>
					<h2 id="descripcion">...</h2>
					<form class="bs-docs-example" style="padding-bottom: 15px;"
						action="fichas_descripcion" method="post" target="_blank">
						<div class="controls docs-input-sizes">
							<input class="span3" name="reportID" type="hidden" value="1"
								required> 
								<span class="help-inline"><label>DESCRIPCIÓN:</label></span>	
								
								<input class="span3" name="Descripcion" type="text" id="Descripcion" required="required"/> 
								<input type="checkbox" name="SI" value="1">

							<button type="submit" class="btn btn-primary">Aceptar</button>
							<!-- <button type="reset" class="btn">Limpiar</button>  -->
						</div>
					</form>
					<pre class="prettyprint linenums">
Presione Aceptar.
</pre>

				</section>
			</div>
		</div>
	</div>




	<!-- Footer
    ================================================== -->
	<section id="contacto">
		<footer class="footer">
			<div class="container">
				<p>Copyright Sistemas</p>
				<ul class="footer-links">
					<li><a href="http://4eglobal.com/">4E Global</a></li>
					<li class="muted">&middot;</li>
					<li>Jovani Farias</li>
					<li class="muted">&middot;</li>
				</ul>
			</div>
		</footer>
	</section>


	<!-- Analytics
    ================================================== -->
	<script>
      var _gauges = _gauges || [];
      (function() {
        var t   = document.createElement('script');
        t.type  = 'text/javascript';
        t.async = true;
        t.id    = 'gauges-tracker';
        t.setAttribute('data-site-id', '4f0dc9fef5a1f55508000013');
        t.src = '//secure.gaug.es/track.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(t, s);
      })();
    </script>

</body>
</html>
