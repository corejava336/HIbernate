package com.nt.controller;

import java.io.IOException;



import com.nt.dto.productDTO;
import com.nt.service.ProductMgmSerivce;
import com.nt.service.ProductMgmServiceImpl;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMgmSerivce service;

	@Override
	public void init() throws ServletException {
		service = new ProductMgmServiceImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = 0;
		productDTO dto = null;
		RequestDispatcher rd = null;
		// read from data
		id = Integer.parseInt(req.getParameter("pid"));
		// use service
		try {
			dto = service.fetchProduct(id);
			req.setAttribute("pDTO", dto);
			rd = req.getRequestDispatcher("/result.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
