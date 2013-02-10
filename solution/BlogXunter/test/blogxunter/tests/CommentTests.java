package blogxunter.tests;

import blogxunter.main.*;
import blogxunter.main.comment.Comment;
import junit.framework.TestCase;

public class CommentTests extends TestCase{
	private Comment comment;
	
	protected void setUp() throws Exception {
		comment = new Comment();
	}
	
	public void testGetAndSetCommentTest() {
		String testName = "Xunter";
		assertNull(comment.getAuthor());
		comment.setText("Rerun the Ant tests target and all our tests should pass");
		assertEquals("Rerun the Ant tests target and all our tests should pass", comment.getText());
	}
	
}
