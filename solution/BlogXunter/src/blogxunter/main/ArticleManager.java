package blogxunter.main;

import java.io.Serializable;
import java.util.*;

public interface ArticleManager extends Serializable {
	
	public  List<Article> getArticles();
	public void setArticles(List<Article> articles);
	public Article getArticleById(int id);
}
