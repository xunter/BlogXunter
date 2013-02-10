package blogxunter.web.forms;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ReplyValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Reply.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Reply reply = (Reply)arg0;
		
		if (reply.getAuthor() == "") {
			arg1.rejectValue("author", "required", "Author requried!");
		}
		
		if (reply.getText() == "") {
			arg1.rejectValue("text", "required", "Comment requried!");
		}
	}

}
