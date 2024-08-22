package myTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Cong extends SimpleTagSupport {
	private int a;
	private int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//<mt:cong a="2" b="3">Tổng : </mt:cong> --> Tổng: 2+3=5
		JspWriter out = getJspContext().getOut();
		JspFragment f = getJspBody();
		if(f!=null) f.invoke(out);
		out.print(String.format(" %d + %d = %d", a,b,a+b));
	}
}
