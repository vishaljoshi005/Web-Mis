package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AlumniBean;
import dao.ViewAlumniDao;

/**
 * Servlet implementation class ViewAlumni
 */
@WebServlet("/viewalumni")
public class ViewAlumni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAlumni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		int start=0;
		String page=request.getParameter("page");  
		int pageId=Integer.parseInt(page);
		if(pageId==1) {}
		else {
			start=(pageId*12)-12;
			start+=1;
		}
		int rows = ViewAlumniDao.getRows();
		System.out.println(rows);
		List<AlumniBean> alumniRecords = ViewAlumniDao.getAlumni(start);
		if(alumniRecords.size()>0) {
			//Only then use c:if to show the data or the no records found 
		}
	}


}