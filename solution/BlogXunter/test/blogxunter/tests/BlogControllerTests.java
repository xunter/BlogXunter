package blogxunter.tests;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import blogxunter.web.BlogController;
import static org.junit.Assert.*;
import org.junit.Test;
import blogxunter.main.*;

public class BlogControllerTests {

    @Test
    public void testHandleRequestView() throws Exception {
        BlogController controller = new BlogController();
        controller.setArticleManager(new BlogArticleManager());
        
        ModelAndView modelAndView = controller.handleRequest(null, null);
        //assertEquals("articlesView", modelAndView.getViewName());
        
        assertEquals("WEB-INF/jsp/hello.jsp", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map<String, Object> modelMap = (Map)modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        System.out.println(nowValue);
        
        ArrayList<Article> articles = (ArrayList)modelMap.get("articles");
        System.out.println(articles.size());
        for (Article article : articles) {
        	System.out.println(article.getAuthor());
        }
        assertNotNull(nowValue);
    }
}