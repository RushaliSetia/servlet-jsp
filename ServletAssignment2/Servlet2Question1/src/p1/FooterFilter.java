package p1;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FooterFilter implements Filter {

    public FooterFilter() {
        
    }
	
	public void destroy() {
	
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	    String d = formatter.format(date);
	    System.out.println(formatter.format(date));  
		req.setAttribute("Date1", d);
		chain.doFilter(req, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
