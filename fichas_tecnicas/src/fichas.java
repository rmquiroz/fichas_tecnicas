import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import com.google.api.translate.TranslateV2;



//import com.google.api.translate.*;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
/**
 * Servlet implementation class ReportRequisicion
 */
@WebServlet("/fichas")
public class fichas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map reportes;
	private static String PATH_REPORT;
	private static String IMG_DIR;
	private static String img_dir;	
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public fichas() {
    	reportes = new HashMap();
       	reportes.put("1","reporte");       	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		createReport(request, response);		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		createReport(request, response);		
	}
	@SuppressWarnings("deprecation")
	private void createReport(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	    response.setContentType("application/pdf");	    
	   
	    try {
	    	TranslateV2.setHttpReferrer("http://ajax.googleapis.com/ajax/services/language/translate");
	    	ResultSet rs=null;
	    	String fichas=request.getParameter("Codigo");
	    	Class.forName("org.postgresql.Driver");
	    	
			String url = "jdbc:postgresql://10.1.250.20:5932/openbravo";
			Connection cn = DriverManager.getConnection(url, "postgres", "s3st2m1s4e");

	    	PreparedStatement ps= cn.prepareStatement("SELECT prodt.description AS descripcion,"
+ "prodc.mililitros AS ML,"
+ "prodc.campolaboratoriosiete AS EMPAQUEPRIMARIO,"
+ "prodc.marca AS marca,"
+ "prodc.campolaboratorioocho AS uso,"
+ "string_agg(prodbom.campolaboratoriodos,', ') AS aroma,"
+ "prodc.value AS ob3,"
+ "prodc.upc AS gtin13,"
+ "prodc.campolaboratorionueve AS INSTRUCCIONES,"
+ "prodc.campolaboratoriodies AS ADVERTENCIAS,"
+ "STRING_AGG(prodbom.description,', ') AS ingredientes "
+ "FROM m_product AS prodc,"
+ "m_product AS prodt,"
+ "m_product AS prodci,"
+ "m_product_bom AS bom,"
+ "m_product AS prodbom "
+ "WHERE prodc.value LIKE 4||substring('"+fichas+"',2) "
+ "AND prodci.m_product_id=bom.m_product_id "
+ "AND prodbom.description NOT LIKE '%TARIMA%' "
+ "AND prodt.value LIKE 3||substring('"+fichas+"',2) "
+ "AND prodci.value LIKE 5||substring('"+fichas+"',2) "
+ "AND bom.m_productbom_id=prodbom.m_product_id "
+ "GROUP BY descripcion,ml,prodc.marca,ob3,gtin13,"
+ "EMPAQUEPRIMARIO,INSTRUCCIONES,ADVERTENCIAS,USO");
			  rs=ps.executeQuery();
			  String descripcion = null;
			  String ml = null;
			  String empaqueprimario = null;
			  String marca = null;
			  String uso = null;
			  String aroma = null;
			  String codigo = null;
			  String gtin13 = null;
			  String instrucciones = null;
			  String advertencias = null;
			  String ingredientes = null;
			  
			  while(rs.next()){
				  descripcion=rs.getString(1);
				  ml=rs.getString(2);
				  empaqueprimario=rs.getString(3);
				  marca=rs.getString(4);
				  uso=rs.getString(5);
				  aroma=rs.getString(6);
				  codigo=rs.getString(7);
				  gtin13=rs.getString(8);
				  instrucciones=rs.getString(9);
				  advertencias=rs.getString(10);
				  ingredientes=rs.getString(11);
			  }
			  //TRADUCIMOS Y/O CONVERTIMOS
			  GoogleAPI.setKey("AIzaSyC8sphF53JNnkBYMAlImf3pTBW9CfSDePQ");
            //GoogleAPI.setKey("c4f7924c4e66c48ffaa8e8249eb87b1cb4c359f7");
			  System.out.println("ell"+descripcion);
			  
			/*  descripcion=TranslateV2.DEFAULT.execute(descripcion,Language.SPANISH,Language.ENGLISH);
			  System.out.println(""+descripcion);
			  ml=""+(Double.parseDouble(ml)/ 29.574);
			  empaqueprimario=Translate.DEFAULT.execute(empaqueprimario,Language.SPANISH,Language.ENGLISH);
			  marca=Translate.DEFAULT.execute(marca,Language.SPANISH,Language.ENGLISH);
			  uso=Translate.DEFAULT.execute(uso,Language.SPANISH,Language.ENGLISH);
			  aroma=Translate.DEFAULT.execute(aroma,Language.SPANISH,Language.ENGLISH);
			  codigo=codigo;
			  gtin13=gtin13;
			  instrucciones=Translate.DEFAULT.execute(instrucciones,Language.SPANISH,Language.ENGLISH);
			  advertencias=Translate.DEFAULT.execute(advertencias,Language.SPANISH,Language.ENGLISH);
			  ingredientes=Translate.DEFAULT.execute(ingredientes,Language.SPANISH,Language.ENGLISH);	*/			
			  JasperReport jasperReport = null;
			  Map parameterMap = new HashMap();
			  Map parametros = request.getParameterMap();
			  System.out.println("PARAMETROS .... ");
			  for (Iterator iterator = parametros.keySet().iterator(); iterator.hasNext();) {
				  Object key_ = iterator.next();
				  String key = (String)key_;
				  String valor = request.getParameter(key);
				  System.out.println((new StringBuilder(String.valueOf(key))).append(" ::> ").append(valor).toString());
				  if (!key.equals("reportID")) {
					  parameterMap.put(key, Integer.parseInt(valor));
				  }
			  }  	           
			  parameterMap.put("IMG_DIR",IMG_DIR);
			  parameterMap.put("img_dir",img_dir);
			  parameterMap.put("descripcion",descripcion);
			  parameterMap.put("ml",ml);
			  parameterMap.put("empaqueprimario",empaqueprimario);
			  parameterMap.put("marca",marca);
			  parameterMap.put("uso",uso);
			  parameterMap.put("aroma",aroma);			 
			  parameterMap.put("gtin13",gtin13);
			  parameterMap.put("instrucciones",instrucciones);
			  parameterMap.put("advertencias",advertencias);
			  parameterMap.put("ingredientes",ingredientes);
  	         //parameterMap.put("IMG_DIR", (new StringBuilder(String.valueOf(request.getSession().getServletContext().getRealPath(IMG_DIR)))).append("/").toString());
 	         //parameterMap.put("img_dir", (new StringBuilder(String.valueOf(request.getSession().getServletContext().getRealPath(img_dir)))).append("/").toString());
			  parameterMap.put("SUBREPORT_DIR", request.getSession().getServletContext().getRealPath("/")+PATH_REPORT);
			  System.out.println((new StringBuilder("GENERANDO EL REPORTE  ")).append((String)reportes.get(request.getParameter("reportID"))).toString());
			  String reporteJasper = request.getSession().getServletContext().getRealPath((new StringBuilder(String.valueOf(PATH_REPORT))).append((String)reportes.get(request.getParameter("reportID"))).append(".jasper").toString());
			  jasperReport = (JasperReport)JRLoader.loadObject(new FileInputStream(reporteJasper));
			  net.sf.jasperreports.engine.JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, cn);
			  java.io.OutputStream oS = null;
 	          oS = response.getOutputStream();
 	          JasperExportManager.exportReportToPdfStream(jasperPrint, oS); 	          	         	          	     
  	          cn.close();  	           
	    } catch (SQLException e) {
				// TODO Auto-generated catch block
	    	e.printStackTrace();
	    } catch (Exception ex) {
			// TODO: handle exception
	    	ex.printStackTrace();
	    }	    
	}		
	static  {
		PATH_REPORT = "reportes/";
		IMG_DIR = "http://10.1.250.24/imagenes_fichas/";//(new StringBuilder(String.valueOf(PATH_REPORT))).append("img/").toString();
		img_dir = "http://10.1.250.24/imagenes_fichas/";//(new StringBuilder(String.valueOf(PATH_REPORT))).append("img/").toString();
	}	
}