
package relatorios;

import java.io.IOException;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;


@ManagedBean
@SessionScoped
public class RelAnunciosControle {
    
         public String filtro() throws IOException, JRException{
             System.out.println("chegou aqui!");
             
        String arquivo = "C:\\Users\\Rafael\\Documents\\NetBeansProjects\\A\\src\\java\\relatorios\\estados.jasper";
        byte[] bytes = null;
        HashMap parametros = new HashMap();
        bytes = JasperRunManager.runReportToPdf(arquivo, parametros, Conexao.getConexao());
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.setContentType("application/html");
        response.setHeader("Content-Disposition", "attachment; filename=estados.html");;
        response.setContentLength(bytes.length);
        ServletOutputStream outputstream = response.getOutputStream();
        outputstream.write(bytes, 0, bytes.length);
        outputstream.flush();
        outputstream.close();
        context.responseComplete();
        return "";
    }
    
    public RelAnunciosControle() {
    }
    
}
