package blogxunter.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import blogxunter.main.*;
import blogxunter.main.comment.Comment;
import blogxunter.main.data.DataProvider;
import blogxunter.web.forms.Reply;

import java.util.*;
import java.lang.*;


@SuppressWarnings("deprecation")
public class ArticleController extends SimpleFormController /*implements Controller*/ {
	private DataProvider blogDataProvider;
	private int idArticle;
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		int id = Integer.parseInt(arg0.getParameter("id"));	
		Article article = blogDataProvider.getArticle(id);
		return new ModelAndView("article", "article", article);
	}*/
	
	@Override
    protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
		
        this.idArticle = Integer.parseInt(request.getParameter("id"));
	 	Article article = blogDataProvider.getArticle(this.idArticle);
		model.put("article", article);
		return model; 		
    }
	
	public ModelAndView onSubmit(Object command) throws ServletException {
		Comment comment = new Comment();
		comment.setIdArticle(((Reply) command).getIdArticle());
		comment.setIdRoot(((Reply) command).getIdRoot());
		comment.setAuthor(((Reply) command).getAuthor());
		comment.setDateTime(((Reply) command).getDateTime());
		comment.setText(((Reply) command).getText());
		blogDataProvider.saveComment(comment);
		return new ModelAndView(new RedirectView("article.htm?id="+String.valueOf(this.idArticle)));
	}

	protected Object formBackingObject(HttpServletRequest request) throws ServletException {
		Reply reply = new Reply();
		reply.setIdArticle(this.idArticle);
		int idRoot = -1;
		try {
			idRoot = Integer.parseInt(request.getParameter("reply"));
		} finally {
			reply.setIdRoot(idRoot);
			reply.setDateTime(Comment.getNowDate());
			return reply;
		}
	}

	public void setBlogDataProvider(DataProvider blogDataProvider) {
		this.blogDataProvider = blogDataProvider;
	}
}
