package myTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Chao extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		// sau này mình chèn vào thẻ chào
		// <mt:chao> MaiLan </mt:chao> --> Chào mừng bạn Mai Lan đến với lập trình Custom tag!
		// này JspWriter giống cái PrintWriter, dùng để in ra đối tượng để in ra trnag JSP
		JspWriter out = getJspContext().getOut();
		// tiếp theo
		JspFragment f = getJspBody();
		out.print("Chào mừng bạn ");
		if(f!=null) {
			f.invoke(out);
		}
		out.print(" đến với lập trình hướng java!");
		super.doTag();
	}
}
