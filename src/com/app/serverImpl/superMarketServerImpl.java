package com.app.serverImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.app.entities.superMarket;
import com.app.entities.superType;
import com.app.server.jdbcutil;
import com.app.server.superMarketServer;

public class superMarketServerImpl implements superMarketServer {

	@Override
	public void add(superMarket supermarket) {
		  Connection conn=null;
	        PreparedStatement stmt=null;
	        conn=jdbcutil.getConection();
	        String addSql= "insert into supermarket(super_name,super_price,super_type_id,super_from,super_condition,super_status)"+
	        		 "values(?,?,?,?,?,?)";
	        try {
	        	stmt = conn.prepareStatement(addSql);
	        	stmt.setString(1, supermarket.getSuperName());
	        	stmt.setDouble(2, supermarket.getSuperPrice());
	        	stmt.setInt(3, supermarket.getSuperType());
	        	stmt.setInt(4, supermarket.getSuperFrom());
	        	stmt.setString(5, supermarket.getSuperCondition());
	        	stmt.setString(6, supermarket.getSuperStatus());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        jdbcutil.close(conn);
	}
	
	public List<superMarket> getAll()
	{
		List<superMarket> supermarketlist = new LinkedList<superMarket>();
		
		  Connection conn=null;//定义为空值
	       Statement stmt=null;
	       ResultSet rs=null;
	       String sql="select * from supermarket  left join super_type on supermarket.super_type_id= super_type.type_id";//sql语句
	       conn=jdbcutil.getConection();
	       try {
	        stmt=conn.createStatement();//创建一个Statement语句对象
	        rs=stmt.executeQuery(sql);//执行sql语句
	        while(rs.next()){
	        	superMarket supermarket = new superMarket();
	        	supermarket.setSuperId(rs.getInt(1));
	        	supermarket.setSuperName(rs.getString(2));
	        	supermarket.setSuperPrice(rs.getDouble(3));
	        	supermarket.setSuperType(rs.getInt(4));
	        	supermarket.setSuperFrom(rs.getInt(5));
	        	supermarket.setSuperCondition(rs.getString(6));
	        	supermarket.setSuperStatus(rs.getString(7));
	        	supermarket.setTypeName(rs.getString(9));
	            supermarketlist.add(supermarket);
	            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
		return supermarketlist;
	}

	@Override
	public superMarket getsuperMarketById(Integer Id) {
		superMarket supermarket = new superMarket();
		 Connection conn=null;//定义为空值
	       Statement stmt=null;
	       ResultSet rs=null;
	       String sql="select * from supermarket  left join super_type on supermarket.super_type_id= super_type.type_id where supermarket.super_id = "+Id;//sql语句
	       conn=jdbcutil.getConection();
	       try {
	        stmt=conn.createStatement();//创建一个Statement语句对象
	        rs=stmt.executeQuery(sql);//执行sql语句
	        while(rs.next()){
	        	supermarket.setSuperId(rs.getInt(1));
	        	supermarket.setSuperName(rs.getString(2));
	        	supermarket.setSuperPrice(rs.getDouble(3));
	        	supermarket.setSuperType(rs.getInt(4));
	        	supermarket.setSuperFrom(rs.getInt(5));
	        	supermarket.setSuperCondition(rs.getString(6));
	        	supermarket.setSuperStatus(rs.getString(7));
	        	supermarket.setTypeName(rs.getString(9));
	            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
		return supermarket;
	}

	@Override
	public String deletesuperMarketById(Integer Id) {
		 Connection conn=null;//定义为空值
	       Statement stmt=null;	 	       
	       String sql="delete  from supermarket where super_id="+Id;//sql语句
	       conn=jdbcutil.getConection();
	       
	       try {
	        stmt=conn.createStatement();//创建一个Statement语句对象
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
	       return "删除成功";
	}

	@Override
	public String updatesuperMarketById(Integer Id,superMarket supermarket) {
		 Connection conn=null;//定义为空值
		 PreparedStatement stmt=null;	       
	       String sql="update supermarket set super_name=?,super_price=?,super_type_id=?,super_from=?,super_condition=?,super_status=? where super_id="+Id;//sql语句
	       conn=jdbcutil.getConection();
	       
	       try {
	    	   stmt = conn.prepareStatement(sql);
	    	   stmt.setString(1, supermarket.getSuperName());
	    	   stmt.setDouble(2, supermarket.getSuperPrice());
	    	   stmt.setInt(3, supermarket.getSuperType());
	    	   stmt.setInt(4, supermarket.getSuperFrom());
	    	   stmt.setString(5, supermarket.getSuperCondition());
	    	   stmt.setString(6, supermarket.getSuperStatus());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
		return "更新成功";
	}

}
