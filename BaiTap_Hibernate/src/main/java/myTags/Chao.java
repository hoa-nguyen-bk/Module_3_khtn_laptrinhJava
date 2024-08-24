package myTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Chao extends SimpleTagSupport {
@Override
public void doTag() throws JspException, IOException {
	// sau này mình sẽ chèn vào đây câu lệnh
	// <mt:chao>Mai Lan</mt:chao> --> Chào mừng mai lan đến lạp trình lalala
	
	// nội dung để suy ra ccasi 
	JspWriter out = getJspContext().getOut();
	JspFragment f = getJspBody();
	//từ 2 đối tương đã có thể hình dung cái body ròi
	out.print("Chào mừng bạn");
	if(f!=null) f.invoke(out);
	out.print(" đến với lập trình custom tag");
	super.doTag();
}
}
