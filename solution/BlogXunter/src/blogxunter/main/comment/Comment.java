package blogxunter.main.comment;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4511319251800757900L;
	private int id; //id �����������
	private int idArticle; //id ������, ������� ����������� �����������
	private int idRoot;  //id �����������, �������� ����������� �����������
	private String author; //����� �����������
	private String text; //����� �����������
	private String dateTime; //���� �������� �����������
	
	public Comment() {
		super();
	}
	
	public Comment(int id, int idRoot, int idArticle, String dateTime, String author, String text) {
		super();
		this.id = id;
		this.idRoot = idRoot;
		this.idArticle = idArticle;
		this.dateTime = dateTime;
		this.author = author;
		this.text = text;
	}
	
	/**
	 * ����� ��������� ������� ���� � �����
	 * @return
	 * ���� � �����
	 */
	public static String getNowDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(calendar.getTime());
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public String getDateTime() {
		return this.dateTime;
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdArticle() {
		return this.idArticle;
	}
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public int getIdRoot() {
		return this.idRoot;
	}
	
	public void setIdRoot(int idRoot) {
		this.idRoot = idRoot;
	}
}
