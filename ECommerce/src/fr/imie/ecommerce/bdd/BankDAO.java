package fr.imie.ecommerce.bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.imie.ecommerce.presentation.Bean;


public class BankDAO {

	public BankDAO() {
		// TODO Auto-generated constructor stub
	}

	public void addCustomer(Bean customer) {
		String query="INSERT INTO client VALUES(?,?,?,?,?)";
		try {
			PreparedStatement st = EcommerceConnection.getInstance().prepareStatement(query);
			st.setString(1, customer.getId());
			st.setString(2, customer.getNom());
			st.setString(3, customer.getPrenom());
			st.setString(4, customer.getTel());
			st.setString(5, customer.getEmail());
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modify(Bean customer) {
		String query="UPDATE client SET nom=?, tel=? WHERE id=?";
		try {
			PreparedStatement st = EcommerceConnection.getInstance().prepareStatement(query);
			st.setString(1, customer.getId());
			st.setString(2, customer.getNom());
			st.setString(3, customer.getPrenom());
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
		}
	}
	
	public ArrayList<Bean> retrieveAll() throws ClassNotFoundException {
		ArrayList<Bean> list = new ArrayList<>();
		String query="SELECT * FROM client;";
		
		try {
			Statement st = EcommerceConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()) list.add(new Bean(rs.getString("nom"), rs.getString("tel")));
		    st.close();
		    st.close();
		} catch(SQLException e) {
		}
		return list;
	}
	
	public Bean retrieve(String id) throws ClassNotFoundException {
		String query="SELECT * FROM client WHERE client_id=?";
		Bean customer = null;
		try {
			System.out.println(id);
			PreparedStatement st = EcommerceConnection.getInstance().prepareStatement(query);
			st.setString(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
				customer = new Bean( rs.getString("nom"), rs.getString("tel"));
		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	public void delete(String id) throws ClassNotFoundException {
		String query="DELETE FROM client WHERE client_id=?";
		
		try {
			PreparedStatement st = EcommerceConnection.getInstance().prepareStatement(query);
			st.setString(1, id);
			st.executeUpdate();
			st.close();
		} catch(SQLException e) {
		}
	}
}


