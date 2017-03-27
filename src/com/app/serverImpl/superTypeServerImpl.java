package com.app.serverImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.app.entities.superType;
import com.app.server.jdbcutil;
import com.app.server.superTypeServer;

public class superTypeServerImpl implements superTypeServer {
	@Override
	public void add(superType supertype) {
		        Connection conn=null;
		        Statement stmt=null;
		        conn=jdbcutil.getConection();
		        String addSql= "insert into super_type(type_id,type_name) values("+
		        		supertype.getTypeId()+",'"+supertype.getTypeName()+"')";
	
		        try {
		            stmt=conn.createStatement();
		            stmt.execute(addSql);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        jdbcutil.close(conn);
	}

	@Override
	public List<superType> getAll() {
		List<superType> supertypelist = new LinkedList<superType>();
		
			       Connection conn=null;//定义为空值
			       Statement stmt=null;
			       ResultSet rs=null;
			       String sql="select * from super_type";//sql语句
			       conn=jdbcutil.getConection();
			       try {
			        stmt=conn.createStatement();//创建一个Statement语句对象
			        rs=stmt.executeQuery(sql);//执行sql语句
			        while(rs.next()){
			        	superType supertype = new superType();
			        	supertype.setTypeId(rs.getInt(1));
			            supertype.setTypeName(rs.getString(2));
			            supertypelist.add(supertype);
			            }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }finally{
			        jdbcutil.close(conn);//关闭数据库
			    }
			       return supertypelist;
	}

	@Override
	public superType getById(Integer id) {
		superType supertype = new superType();
		 Connection conn=null;//定义为空值
	       Statement stmt=null;
	       ResultSet rs=null;
	       String sql="select * from super_type where type_id="+id;//sql语句
	       conn=jdbcutil.getConection();
	       try {
	        stmt=conn.createStatement();//创建一个Statement语句对象
	        rs=stmt.executeQuery(sql);//执行sql语句 
	        while(rs.next()){
	        	supertype.setTypeId(rs.getInt(1));
	            supertype.setTypeName(rs.getString(2));
	            }
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
	       return supertype;
	}

	@Override
	public String deleteTypeById(Integer id) {
		 Connection conn=null;//定义为空值
	       Statement stmt=null;
	       ResultSet rs=null;
	       String sql1="select * from supermarket where super_type_id="+id;//sql语句
	       
	       String sql="delete  from super_type where type_id="+id;//sql语句
	       conn=jdbcutil.getConection();
	       
	       try {
	        stmt=conn.createStatement();//创建一个Statement语句对象
	        rs=stmt.executeQuery(sql1);//执行sql语句 
	        while(rs.next()){
	        	return "有关联的商品不能删除";
	            }
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
	       return "删除成功";
	}

	@Override
	public String updateTypeById(Integer id, superType supertype) {
		superType supertype1 = new superType();
		Connection conn=null;//定义为空值
		 PreparedStatement stmt=null;	       
	       String sql="update super_type set type_name=? where type_id="+id;//sql语句
	       conn=jdbcutil.getConection();
	       
	       try {
	    	   stmt = conn.prepareStatement(sql);
	    	   stmt.setString(1, supertype.getTypeName());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        jdbcutil.close(conn);//关闭数据库
	    }
		return "更新成功";
	}
}
