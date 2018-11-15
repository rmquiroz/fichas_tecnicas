//Facturas por documento
function descarga(archivo){
		document.location = archivo;
}

//Facturas por lineas
function descargarArchivo(contenidoEnBlob, nombreArchivo){
//creamos un FileReader para leer el Blob
	var reader = new FileReader();
//Definimos la función que manejará el archivo una vez haya terminado de leerlo
  	reader.onload = function(event){
	var save = document.createElement('a');
	save.href = event.target.result;
	save.target ='_blank';
 //Truco: así le damos el nombre al archivo 
 	save.download = nombreArchivo || 'reporte_facturacion.xls';
 	var clicEvent = new MouseEvent('click', {
	'view':window,
	'bubbles': true,
	'cancelable': true,
	});
   save.dispatchEvent(clicEvent);
 (window.URL || window.webkitURL).revokeObjectURL(save.href);
};
reader.readAsDataURL(contenidoEnBlob);
document.getElementById('contenidoEnBlob').addEventListener('change', handleFileSelect, false);
};



function generar1(){
	
	 var obj =  document.getElementById( "documento" );

	alert(obj.innerHTML);
	
	
}

