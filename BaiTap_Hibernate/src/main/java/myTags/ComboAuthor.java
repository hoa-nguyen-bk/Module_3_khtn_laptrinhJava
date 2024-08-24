package myTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import businessLogic.AuthorBL;
import entity.Author;

public class ComboAuthor extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		// <mt:cboAuthor> Author: </mt:cboAuthor> --> Author: <ComboBox Authors>
		List<Author> authors = AuthorBL.getAuthors();
		JspWriter out = getJspContext().getOut();
		JspFragment f = getJspBody();
		if (f != null) {
			f.invoke(out);
		}
		out.print("<select name='cboAuthor'>");
		//lấy cái nội dung ra
		for(Author at:authors) {
			out.print("<option value='"+at.getAuthorId()+"'>"+at.getAuthorName()+"</option>");
		}
		out.print("</select>");
	}
}
