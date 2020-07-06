/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author Rafael
 */
@ManagedBean
@SessionScoped
public class GerenciamentoRelatorio extends HttpServlet{
    
       
    
    public void relatorioEstado(ActionEvent event) throws ServletException, IOException {
        System.err.print("Log ------- Relatorio Estados");
        try {    
          /*URL arquivo = getClass().getResource("estados.jasper");             
           Map<String, Object> map = new HashMap();  
            
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);    
           JasperPrint jasperPrint = JasperFillManager.fillReport("estados.jasper",null);
           HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext();
           ServletOutputStream servletOutputStream = response.getOutputStream();
           
           JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);*/
            
           
          
             
          
         }catch (Exception ex) {    
            JOptionPane.showMessageDialog(null, ex);   
        } 
    }
   
}
