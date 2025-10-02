package com.lgy.item_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.item_oracle.dto.ItemDTO;

public class ItemDAO {
	DataSource ds;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	
	public ItemDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	
	public ArrayList<ItemDTO> content_view(){
		ArrayList<ItemDTO> dto = new ArrayList<ItemDTO>();
		sql = "select name, price, description from item_oracle";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				ItemDTO idto = new ItemDTO(name, price, description);
				dto.add(idto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!= null) rs.close();
				if (ps!= null) ps.close();
				if (con!= null)con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public void item_write(String name, int price, String description) {
		sql = "insert into item_oracle(name,price,description) values(?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2, price);
			ps.setString(3, description);
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!= null) rs.close();
				if (ps!= null) ps.close();
				if (con!= null)con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
