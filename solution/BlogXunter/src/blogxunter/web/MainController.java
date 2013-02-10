package blogxunter.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.*;

import blogxunter.main.Article;
import blogxunter.main.ArticleManager;
import blogxunter.main.BlogArticleManager;
import blogxunter.main.comment.Comment;
import blogxunter.main.data.*;
import blogxunter.web.forms.AddArticle;
import blogxunter.web.forms.Reply;

import java.util.*;

public class MainController extends SimpleFormController /*implements Controller*/ {
	//private Article article;
	//private List<Comment> comments;
	private ArticleManager articleManager;
	private DataProvider blogDataProvider;
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		articleManager.setArticles(blogDataProvider.getArticles());		
		return new ModelAndView("index", "model", articleManager);
	}*/
	
	@Override
    protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

		articleManager.setArticles(blogDataProvider.getArticles());
		model.put("articleManager", articleManager);
		return model; 		
    }
	
	public ModelAndView onSubmit(Object command) throws ServletException {
		/*
		Comment comment = new Comment();
		comment.setIdArticle(((Reply) command).getIdArticle());
		comment.setIdRoot(((Reply) command).getIdRoot());
		comment.setAuthor(((Reply) command).getAuthor());
		comment.setDateTime(((Reply) command).getDateTime());
		comment.setText(((Reply) command).getText());
		*/
		
		Article article = (Article)command;
		article.setDateTime(Comment.getNowDate());
		
		
		blogDataProvider.saveArticle(article);
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		return new AddArticle();
	}


	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}
	
	public void setBlogDataProvider(DataProvider blogDataProvider) {
		this.blogDataProvider = blogDataProvider;
	}
}
