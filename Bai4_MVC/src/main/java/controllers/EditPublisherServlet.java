package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;
import javaBeans.Publisher;

/**
 * Servlet implementation class EditPublisherServlet
 */
@WebServlet("/EditPublisherServlet")
public class EditPublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPublisherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Publisher p = PublisherBL.docTheoId(id);
		request.setAttribute("p", p);
		request.getRequestDispatcher("views/edit-publisher.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * người ta sửa save xong đi vào doPosst này
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		//tạo đối tượng
		Publisher p = new Publisher();
		p.setPublisherId(id);
		p.setPublisherName(name);
		//truyền vào
		PublisherBL.edit(p);
		//xong phải quay về publisher
		response.sendRedirect("PublisherServlet");
	}

}
