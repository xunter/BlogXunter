package blogxunter.main;

import java.io.Serializable;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import blogxunter.main.comment.*;
import blogxunter.main.data.DataBaseConnection;

public class Article implements Commentable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -131571066809118504L;
	private int id; //id статьи
	private String author; //Автор статьи
	private String title; //Заголовок
	private String text; //Текст статьи
	private String dateTime; // Дата и время создания статьи
	private List<Comment> comments; //Коллекция комментариев, принадлижащих этой статье
	
	public Article() {
		super();
	}
	
	public Article(int id, String dateTime, String author, String title, String text) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.author = author;
		this.title = title;
		this.text = text;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getDateTime() {
		return this.dateTime;
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}	

	@Override
	public List<Comment> getComments() {		
		return comments;
	}

	@Override
	public void setComments(List<Comment> comments) {
		this.comments = comments;		
	}
}
