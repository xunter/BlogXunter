package blogxunter.web;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import sun.java2d.pipe.OutlineTextRenderer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;
import blogxunter.main.*;

public class BlogController implements Controller {

	private ArticleManager articleManager;
	
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	String now = (new Date()).toString();
    	Map<String, Object> blogModel = new HashMap<String, Object>();
    	blogModel.put("now", now);
    	blogModel.put("articles", this.articleManager.getArticles());
    	
	    System.out.println("Result returned. test completed. Date: "+now);
        
	    return new ModelAndView("WEB-INF/jsp/hello.jsp", "model", blogModel);
	    
    }
    
    public void setArticleManager(ArticleManager articleManager) {
    	this.articleManager = articleManager;
    }
}