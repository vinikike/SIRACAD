/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.procesos;

import com.infosgroup.prueba.model.estructuras.FormatoReporte;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * @author Vinicio Enrique Mercado
 * @version 1.2
 */
@Stateless(name = "ReportesStatelessBean")
@LocalBean
public class ReportesStatelessBean
{

    @Resource(name = "jdbc/SIRACADDatasource")
    private DataSource planillaJDBCDatasource;

    @PermitAll
    public Boolean generarReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, FormatoReporte type)
    {
        JRExporter exporter = null;
        Connection conexion = null;
        String rutaReporte = null;
        HttpServletResponse response = null;
        Boolean resultado = null;
        List<Object> arr = null;
        try
            {
            conexion = planillaJDBCDatasource.getConnection();
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

            arr = new ArrayList<Object>();
            arr.add("Reporte SQL");
            arr.add(nombreArchivoReporte);
            arr.add(String.format("%1$tY-%<tm-%<td %<tT", Calendar.getInstance().getTime()));
            arr.add(rutaReporte);
            arr.add(parametros);
            arr.add(conexion);
            Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.INFO, "[{0} : {1} : {2} : {3} : {4} : {5}]", arr.toArray());

            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, conexion);

            switch (type)
                {
                case PDF:
                    exporter = new JRPdfExporter();
                    response.setContentType("application/pdf");
                    break;
                case XLS:
                    exporter = new JRXlsExporter();
                    response.setContentType("application/vnd.ms-excel");
                    break;
                }
            response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + "." + type.name().toLowerCase() + "\";");
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jrPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exporter.exportReport();
            //response.getOutputStream().flush();            
            facesContext.responseComplete();
            resultado = Boolean.TRUE;
            }
        catch (Exception excpt)
            {
            Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.SEVERE, null, excpt);
            resultado = Boolean.FALSE;
            }
        finally
            {
            try
                {
                if ((conexion != null) && !conexion.isClosed())
                    conexion.close();
                }
            catch (Exception ex)
                {
                Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            facesContext.responseComplete();
            }
        return resultado;
    }

    @PermitAll
    public byte[] generarDatosPDFReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte)
    {
        Connection conexion = null;
        String rutaReporte = null;
        byte[] bytesReporte = null;
        List<Object> arr = null;

        try
            {
            conexion = planillaJDBCDatasource.getConnection();
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);

            arr = new ArrayList<Object>();
            arr.add("Reporte Bean");
            arr.add(nombreArchivoReporte);
            arr.add(String.format("%1$tY-%<tm-%<td %<tT", Calendar.getInstance().getTime()));
            arr.add(rutaReporte);
            arr.add(parametros);
            arr.add(conexion);
            Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.INFO, "[{0} : {1} : {2} : {3} : {4} : {5}]", arr.toArray());

            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, conexion);
            bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            }
        catch (Exception excpt)
            {
            bytesReporte = null;
            Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.SEVERE, null, excpt);
            }
        finally
            {
            try
                {
                if ((conexion != null) && !conexion.isClosed())
                    conexion.close();
                }
            catch (SQLException ex)
                {
                Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return bytesReporte;
    }

    @PermitAll
    public Boolean generarReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos)
    {
        String rutaReporte = null;
        HttpServletResponse response = null;
        JRBeanCollectionDataSource ds = null;
        List<Object> arr = null;
        try
            {
            ds = new JRBeanCollectionDataSource(datos);
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

            arr = new ArrayList<Object>();
            arr.add("Reporte SQL (Datos)");
            arr.add(nombreArchivoReporte);
            arr.add(String.format("%1$tY-%<tm-%<td %<tT", Calendar.getInstance().getTime()));
            arr.add(rutaReporte);
            arr.add(parametros);
            arr.add(ds);
            Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.INFO, "[{0} : {1} : {2} : {3} : {4} : {5}]", arr.toArray());

            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, ds);
            byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
            response.getOutputStream().write(bytesReporte);
            response.getOutputStream().flush();
            facesContext.responseComplete();
            return Boolean.TRUE;
            }
        catch (Exception excpt)
            {
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
            return Boolean.FALSE;
            }
    }

    @PermitAll
    public byte[] generarDatosPDFReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos)
    {
        String rutaReporte = null;
        byte[] bytesReporte = null;
        List<Object> arr = null;
        try
            {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);

            arr = new ArrayList<Object>();
            arr.add("Reporte Bean");
            arr.add(nombreArchivoReporte);
            arr.add(String.format("%1$tY-%<tm-%<td %<tT", Calendar.getInstance().getTime()));
            arr.add(rutaReporte);
            arr.add(parametros);
            arr.add(ds);
            Logger.getLogger(ReportesStatelessBean.class.getName()).log(Level.INFO, "[{0} : {1} : {2} : {3} : {4} : {5}]", arr.toArray());

            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, ds);
            bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            }
        catch (Exception excpt)
            {
            bytesReporte = null;
            System.err.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.err.println(excpt.getMessage());
            }
        return bytesReporte;
    }
}
