package blogxunter.web.forms;

public class Reply {
	private String author;
	private String text;
	private String dateTime;
	private int idArticle;
	private int idRoot;
	
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
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getDateTime() {
		return this.dateTime;
	}
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public int getIdArticle() {
		return this.idArticle;
	}
	
	public void setIdRoot(int idRoot) {
		this.idRoot = idRoot;
	}
	
	public int getIdRoot() {
		return this.idRoot;
	}
}
