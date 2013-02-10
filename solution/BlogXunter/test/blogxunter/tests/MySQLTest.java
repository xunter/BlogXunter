package blogxunter.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import blogxunter.web.*;


import blogxunter.main.*;
import blogxunter.main.comment.Comment;
import junit.framework.TestCase;
import java.sql.*;


public class MySQLTest extends TestCase {
	private final String URL = "jdbc:mysql://localhost/test?user=root&password=pashok";
	
	public void testArticleLoadDB() throws Exception {
		MainController controller = new MainController();
		ArticleManager articleManager;
		
		/*ArrayList<Article> articles = new ArrayList<Article>();
		Article article = new Article(1,"2010-03-09 12:00", "Pavel Nazarov", "Hello! This is my test article!!!");
		articleManager.setArticles(articles);
        controller.setArticleManager(articleManager);
        
		DataBaseConnection connection = DataBaseConnection.getInstance();
		
		assertNotNull(connection);*/
		
        ModelAndView modelAndView = controller.handleRequest(null, null);
        Map<String, Object> modelMap = (Map)modelAndView.getModel().get("model");
        
        assertNotNull(modelMap);
        
        articleManager = (ArticleManager)modelMap.get("articleManager");
        assertEquals("index", modelAndView.getViewName());
        assertNotNull(articleManager);
        
        //assertEquals("index", modelAndView.getViewName());
       
        
        /*assertNotNull(modelAndView.getModel());
        Map<String, Object> modelMap = (Map)modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        System.out.println(nowValue);
        
        ArrayList<Article> articles = (ArrayList)modelMap.get("articles");
        System.out.println(articles.size());
        for (Article article : articles) {
        	System.out.println(article.getAuthor());
        }
        assertNotNull(nowValue);*/
	}
}
