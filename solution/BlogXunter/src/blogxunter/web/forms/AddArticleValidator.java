package blogxunter.web.forms;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AddArticleValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return AddArticle.class.equals(arg0);
	}

	@Override
	public void validate(Object sender, Errors errors) {
		AddArticle addArticle = (AddArticle)sender;
		if (addArticle.getAuthor() == "") {
			errors.rejectValue("author", "required", "Name required!");
		} else if (addArticle.getAuthor().length() < 2) {
			errors.rejectValue("author", "required", "Name length must be more then 2!");
		} if (addArticle.getAuthor().length() > 50) {
			errors.rejectValue("author", "required", "Very long name!");
		}
		if (addArticle.getTitle() == "") {
			errors.rejectValue("title", "required", "Title required!");
		} else if (addArticle.getTitle().length() < 2) {
			errors.rejectValue("title", "required", "Title length must be more then 2!");
		} if (addArticle.getTitle().length() > 50) {
			errors.rejectValue("title", "required", "Very long title!");
		}
		if (addArticle.getText() == "") {
			errors.rejectValue("text", "required", "Text required!");
		}
	}

}
