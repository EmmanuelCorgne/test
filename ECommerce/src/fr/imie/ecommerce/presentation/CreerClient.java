package fr.imie.ecommerce.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.ecommerce.bdd.BankDAO;
import fr.imie.ecommerce.metier.Util;


/**
 * Servlet implementation class CreerClient
 */
public class CreerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Bean> tabbean = null;
	private ArrayList<Bean> tabbean2 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doWork(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doWork(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException {
		
		HttpSession s = request.getSession();
		Bean bean = new Bean();
		BankDAO BK = new BankDAO();
		if(tabbean==null){
			tabbean = new ArrayList<Bean>();
			tabbean2 = new ArrayList<Bean>();
			s.setAttribute("tabbean", tabbean);
		}
		
		if(request.getParameter("nom")!= null){
			//bean = (Bean)s.getAttribute("bean");
			
			bean.setNom(request.getParameter("nom"));
			bean.setPrenom(request.getParameter("prenom"));
			bean.setTel(request.getParameter("tel"));
			bean.setEmail(request.getParameter("email"));
			bean.setMdp(request.getParameter("mdp"));
			bean.setNb();
			bean.setId();
			BK.addCustomer(bean);
			tabbean.add(bean);
			if(tabbean.size()>=2){
				tabbean2=BK.retrieveAll();
				request.setAttribute("tabbean", tabbean);
				request.setAttribute("tabbean2", tabbean2);
				request.getRequestDispatcher("WEB-INF/Resultat.jsp").forward(request, response);
			}
			else{
				
				request.getRequestDispatcher("WEB-INF/Formulaire.jsp").forward(request, response);
			}
			
		}else {
			if(Util.testIdEtMdp(request.getParameter("mdp"),request.getParameter("pseudo"))){
			
				bean.setMdp(request.getParameter("mdp"));
				bean.setPseudo(request.getParameter("pseudo"));
				s.setAttribute("bean", bean);
				request.getRequestDispatcher("WEB-INF/Formulaire.jsp").forward(request, response);
			
			}else{
				
		
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}
