package in.mindcraft.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import in.mindcraft.pojos.Product;
import in.mindcraft.utils.dbUtils;

public class productDao {
	
	
	private Connection cn;
	private PreparedStatement pst1,pst2;

	public void addProduct(Product product) throws SQLException, ClassNotFoundException 
	{
		
		
	
		cn=dbUtils.openConnection();
		pst1=cn.prepareStatement("insert into product values(?,?,?,?,?)");
		
		pst1.setInt(1,product.getPid());
		
		pst1.setString(2,product.getName());
		
		pst1.setDouble(3,product.getPrice());
		
		pst1.setInt(4, product.getQty());
		
		pst1.setDouble(5,product.getDiscount());
		
		pst1.execute();
		//cn.commit();
		dbUtils.closeConnection();
	}
	
	public ArrayList<Product> getProducts() throws SQLException
	{

	try {
		cn=dbUtils.openConnection();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	ArrayList<Product> list=new  ArrayList<Product>();
	pst2=cn.prepareStatement("select * from product");
	ResultSet rs=pst2.executeQuery();
	while(rs.next()) {
		list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getDouble(5)));
		
	}
	dbUtils.closeConnection();
		
	return list;	
}

	
}
