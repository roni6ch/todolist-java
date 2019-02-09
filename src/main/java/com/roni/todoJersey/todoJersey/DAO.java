package com.roni.todoJersey.todoJersey;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	public DAO() {
		super();
		System.out.println("DAO Constructor");
	}

	public ArrayList<Item> getItems() {
		DBConnect db = new DBConnect("root","");
		String query = "SELECT * FROM items ORDER BY id DESC";
		ArrayList<Item> listOfItems = new ArrayList<Item>();
		try{
			db.connect();
			// execute the query, and get a java result set
			ResultSet rs = db.getStatement().executeQuery(query);

			// iterate through the java result set
			while (rs.next())
			{
				int id = rs.getInt("id");
				String date = rs.getString("date").toString();
				String note = rs.getString("note");
				boolean status = rs.getBoolean("status");
				Item item = new Item(id,date,note,status);
				listOfItems.add(item);
			}
			rs.close();
			db.closeConnection();
			return listOfItems;
		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public boolean addItem(String date, String note) {
		DBConnect db = new DBConnect("root","");
		String query = "INSERT INTO items (date,note,status) VALUES (?,?,false)";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = db.connect().prepareStatement(query);
			preparedStmt.setString (1, date);
			preparedStmt.setString (2, note);

			
			preparedStmt.executeUpdate();
			db.closeConnection();
			return true;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	public boolean deleteItem(String id) {
		DBConnect db = new DBConnect("root","");
		String query = "DELETE FROM items WHERE ID=?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = db.connect().prepareStatement(query);
			preparedStmt.setString (1, id);
			preparedStmt.executeUpdate();
			db.closeConnection();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateItem(String id,String updatedNote) {
		DBConnect db = new DBConnect("root","");
		String query = "UPDATE items SET note=? WHERE id=?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = db.connect().prepareStatement(query);
			preparedStmt.setString (1, updatedNote);
			preparedStmt.setString (2, id);
			preparedStmt.executeUpdate();
			db.closeConnection();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean doneItem(String id, String checked) {
		DBConnect db = new DBConnect("root","");
		String query = "UPDATE items SET status=? WHERE id=?";
		PreparedStatement preparedStmt = null;
		System.out.println("doneItem");
		try {
			preparedStmt = db.connect().prepareStatement(query);
			preparedStmt.setString (1, checked);
			preparedStmt.setString (2, id);
			preparedStmt.executeUpdate();
			db.closeConnection();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}

}
