package in.mindcraft.controllers;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.daos.productDao;
import in.mindcraft.pojos.Product;

@Controller
public class ProductController {
	
	
	
	private productDao productDao=new productDao();
	
	@RequestMapping("/insertproduct")
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("name");
		double price=Double .parseDouble(request.getParameter("price"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		double discount=Double.parseDouble(request.getParameter("discount"));
		
		Product product=new Product(pid,name,price,qty,discount);
		try {
			productDao.addProduct(product);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
	
	@RequestMapping("/showprods")
	public ModelAndView showProducts() throws SQLException{
		ModelAndView mv=new ModelAndView();
		try {
		List<Product> list=productDao.getProducts();
		System.out.println(list);
		mv.setViewName("result.jsp");
		mv.addObject("list", list);
	} catch(SQLException e) {
		
	}
		
	return mv;
	
}
   
}
