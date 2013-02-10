package blogxunter.main.data;

import java.util.*;
import java.sql.*;

import javax.sql.DataSource;

import blogxunter.main.comment.*;
import blogxunter.main.*;

public class BlogDataProvider implements DataProvider {
	/**
	 * 
	 */
	private static final long serialVersionUID = -247320587986476963L;
	private DataBaseConnection connection; // ������ ���� DataBaseConnection
	
	/**
	 * �����, ����������� �� �� ��� ������ � ������������ �� � ������� ���������
	 * 
	 * @return 
	 * ��������� ������
	 */
	public List<Article> getArticles() {
		ResultSet result = connection.getResultSet("SELECT * FROM articles ORDER BY `dateTime` DESC;");
		List<Article> articles = new ArrayList<Article>();
		try {
		while (result.next()) {
			int aId = result.getInt("id");
			String aDateTime = result.getString("dateTime");
			String aAuthor = result.getString("author");
			String aTitle = result.getString("title");
			String aText = result.getString("text");
			Article article = new Article(aId, aDateTime, aAuthor, aTitle, aText);
			article.setComments(getComments(aId));
			articles.add(article);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return articles;
		}		
	}
	
	/**
	 * ����� ��� �������� �� �� ������������ ������
	 * @param id - ������������� ������ � ��
	 * @return ����� ���������� ������
	 */
	public Article getArticle(int id) {
		ResultSet result = connection.getResultSet("SELECT * FROM articles WHERE id="+id+";");
		Article article = new Article();
		try {
		while (result.next()) {
			int aId = result.getInt("id");
			String aDateTime = result.getString("dateTime");
			String aAuthor = result.getString("author");
			String aTitle = result.getString("title");
			String aText = result.getString("text");
			article = new Article(aId, aDateTime, aAuthor, aTitle, aText);
			article.setComments(getComments(id));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return article;
		}
	}
	
	/**
	 * �������� �� �� ���� ������������ ��� �������� ������
	 */
	public List<Comment> getComments(int articleId) {
		String sql = "SELECT * FROM comments WHERE idArticle="+articleId+" ORDER BY dateTime ASC;";
		List<Comment> comments = new ArrayList<Comment>();
		try {
			ResultSet result = connection.getResultSet(sql);
			while (result.next()) {
				int cId = result.getInt("id");
				int cIdRoot = result.getInt("idRoot");
				String cDateTime = result.getString("dateTime");
				String cAuthor = result.getString("author");
				String cText = result.getString("text");
				Comment comment = new Comment(cId, cIdRoot, articleId, cDateTime, cAuthor, cText);				
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return comments;
		}
	}
	
	/**
	 * ���������� ����������� � ��
	 */
	public void saveComment(Comment comment) {
		StringBuilder sql = new StringBuilder("INSERT INTO comments ");
		sql.append("(`id`, `idRoot`,`idArticle`,`author`,`dateTime`,`text`) VALUES ");
		sql.append("(null,"+comment.getIdRoot()+","+comment.getIdArticle()+",");
		sql.append("\""+comment.getAuthor()+"\",\""+comment.getDateTime()+"\",\""+comment.getText()+"\");");
		connection.execute(sql.toString());
	}
	
	/**
	 * ���������� ������ � ��
	 */
	public void saveArticle(Article article) {
		StringBuilder sql = new StringBuilder("INSERT INTO articles ");
		sql.append("(`id`,`title`,`author`,`dateTime`,`text`) VALUES ");
		sql.append("(null,\""+article.getTitle()+"\",\""+article.getAuthor()+"\",\"");
		sql.append(article.getDateTime()+"\",\""+article.getText()+"\");");
		connection.execute(sql.toString());
	}
	
	public DataBaseConnection getConnection() {
		return connection;
	}
	
	public void setConnection(DataBaseConnection connection) {
		this.connection = connection;
	}
}
