package blogxunter.main.comment;

import java.io.Serializable;
import blogxunter.main.*;
import java.util.*;

public interface Commentable extends Serializable {
	public List<Comment> getComments();
	public void setComments(List<Comment> comments);
}
