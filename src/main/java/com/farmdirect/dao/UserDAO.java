package com.farmdirect.dao;
import com.farmdirect.model.User; import com.farmdirect.util.DB; import com.farmdirect.util.PasswordUtil;
import java.sql.*;
public class UserDAO {
 public boolean register(String name,String email,String phone,String address,String password,String role)throws Exception{
  String sql="INSERT INTO users(name,email,phone,address,password,role) VALUES(?,?,?,?,?,?)";
  try(Connection c=DB.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,name);p.setString(2,email);p.setString(3,phone);p.setString(4,address);p.setString(5,PasswordUtil.hash(password));p.setString(6,role);return p.executeUpdate()==1;}
 }
 public User login(String email,String password)throws Exception{
  String sql="SELECT * FROM users WHERE email=?";
  try(Connection c=DB.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,email);try(ResultSet r=p.executeQuery()){if(r.next()&&PasswordUtil.matches(password,r.getString("password")))return new User(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("phone"),r.getString("address"),r.getString("role"));}}
  return null;
 }
}