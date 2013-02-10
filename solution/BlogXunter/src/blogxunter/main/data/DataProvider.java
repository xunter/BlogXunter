package blogxunter.main.data;

import java.io.Serializable;
import blogxunter.main.*;
import blogxunter.main.comment.*;
import java.util.List;

public interface DataProvider extends Serializable {
	public List<Article> getArticles();
	public Article getArticle(int id);
	public List<Comment> getComments(int articleId);
	public void saveComment(Comment comment);
	public void saveArticle(Article article);
}
