package sessao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafael
 */
public class Sessao implements Filter{
    
    HttpSession session;
    
   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
  
        HttpServletRequest req = (HttpServletRequest) request;  
        
        HttpServletResponse res = (HttpServletResponse) response;
        session = req.getSession();
        FacesContext fc = FacesContext.getCurrentInstance();
        String contexto = req.getContextPath();
      
       if((req.getRequestURI().endsWith("index.xhtml")) || (session.getAttribute("autenticacao") != null)){
            chain.doFilter(request, response);
        } else {
            res = (HttpServletResponse)response;
            res.sendRedirect(contexto+"/index.xhtml");  
        }
       
    }  
  
    
    public void init(FilterConfig filterConfig) throws ServletException {  
       
    }  
  
      
    public void destroy(){ 
        
    }  
    
}
