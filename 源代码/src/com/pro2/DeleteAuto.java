package com.pro2;
import javax.swing.JOptionPane;
import javax.swing.table.*;

import java.sql.*;
import java.util.*;


public class DeleteAuto extends JOptionPane{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteAuto da=new DeleteAuto("T011302103");
	}
	public DeleteAuto(String Tno){
		int year=Calendar.getInstance().get(Calendar.YEAR);
		int month=Calendar.getInstance().get(Calendar.MONTH)+1;
		int date=Calendar.getInstance().get(Calendar.DATE);
		String insdate=year+"-"+month+"-"+date;
		
		String sql="delete from sc2 where �γ̺� in (select �γ̺� from choosecourse where ��ֹʱ��<'"+insdate+"' and ѧ����<60 and �ον�ʦ��='"+Tno+"')";
		String sql2="delete from choosecourse where ��ֹʱ��<'"+insdate+"' and ѧ����<60 and �ον�ʦ��='"+Tno+"'";
		String sql3="select �γ̺�,�γ��� from choosecourse where ��ֹʱ��<'"+insdate+"' and ѧ����<60 and �ον�ʦ��='"+Tno+"'";
	
		String JDriver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pro2";
		String user="root";
		String password="root";
		try{
			Class.forName(JDriver);
		}catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog( null , "���ݿ����Ӵ���" ,"��ʾ" , JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			Connection con=DriverManager.getConnection(connectDB,user,password);
			PreparedStatement ps=con.prepareStatement(sql3);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String message="�γ̺�: "+rs.getString(1)+"���γ���: "+rs.getString(2)+" ����ѧ����������60�ˣ����迪��";
				JOptionPane.showMessageDialog(this,message);
			}

			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps=con.prepareStatement(sql2);
			ps.executeUpdate();
			
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog( null , "���ݿ����Ӵ���" ,"��ʾ" , JOptionPane.ERROR_MESSAGE);
		}
	}

}
