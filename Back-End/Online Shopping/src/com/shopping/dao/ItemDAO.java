package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.model.Item;
import com.shopping.util.DBConnection;


public class ItemDAO {
	
	Connection connection;
	ItemDAO () {
		try {
			connection = DBConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Item> getItem() throws SQLException {
		List<Item> itemList = new ArrayList<Item>();
		
		String query = "SELECT * FROM \"item\"";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {
			Item item = new Item(resultSet.getLong(1), resultSet.getString(2), resultSet.getLong(3), resultSet.getInt(4), resultSet.getString(5),
					resultSet.getString(6), resultSet.getDate(8), resultSet.getLong(9), resultSet.getLong(10), resultSet.getLong(11));
			itemList.add(item);
		}

		return itemList;
	}

	public void insertItem(Item item) throws SQLException {
		String query = "INSERT INTO \"item\"(id, name , price , saled , describe , img , releaseDate ,id_category ,id_producer ,id_shop) VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setLong(1, item.getId());
		prepareStatement.setString(2, item.getName());
		prepareStatement.setLong(3, item.getPrice());
		prepareStatement.setLong(4, item.getSaled());
		prepareStatement.setString(5, item.getDescribe());
		prepareStatement.setString(6, item.getImg());
		prepareStatement.setDate(7, (Date) item.getReleaseDate());
		prepareStatement.setLong(8, item.getId_category());
		prepareStatement.setLong(9, item.getId_producer());
		prepareStatement.setLong(10, item.getId_shop());

		prepareStatement.executeUpdate();
	}

	public void updateItem(Item item) throws SQLException {
		String query = "UPDATE \"item\" SET id = ?, name = ?, price = ?, saled = ?, describe = ?, img = ?, releaseDate = ?,id_category = ?,id_producer = ?,id_shop = ? WHERE id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setLong(1, item.getId());
		prepareStatement.setString(2, item.getName());
		prepareStatement.setLong(3, item.getPrice());
		prepareStatement.setLong(4, item.getSaled());
		prepareStatement.setString(5, item.getDescribe());
		prepareStatement.setString(6, item.getImg());
		prepareStatement.setDate(7, (Date) item.getReleaseDate());
		prepareStatement.setLong(8, item.getId_category());
		prepareStatement.setLong(9, item.getId_producer());
		prepareStatement.setLong(10, item.getId_shop());
		prepareStatement.setLong(11, item.getId());

		prepareStatement.executeUpdate();
	}

	public Boolean deleteItem(long id) throws SQLException {
		String query = "DELETE FROM \"item\" WHERE id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setLong(1, id);
		int i = prepareStatement.executeUpdate();

		if (i != 0) {
			return true;
		}
		return false;
	}
}
