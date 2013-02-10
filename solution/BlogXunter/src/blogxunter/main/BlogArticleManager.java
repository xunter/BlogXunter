package blogxunter.main;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogArticleManager implements ArticleManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7154522558815060392L;
	private List<Article> articles;
	
	
	@Override
	public List<Article> getArticles() {
		return this.articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		
		return null;
	}
}
