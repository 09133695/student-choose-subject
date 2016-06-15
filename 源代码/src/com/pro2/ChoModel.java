/**
 * �����ҵ�һ��SC���ģ��
 */
package com.pro2;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.sql.*;
import java.util.*;

public class ChoModel extends AbstractTableModel{

	Vector rowData,columnNames;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt=null;
	String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=pro2";
	String user="root";
	String pwd="root";

	String Tno;
	
	public void init(String sql){
		if(sql.equals("null")){
			sql="select * from choosecourse where �ον�ʦ��='"+Tno+"' Order by �γ̺� ASC";
		}
		if(sql.equals("")){
			sql="select * from choosecourse Order by �γ̺� ASC";
		}
		columnNames=new Vector();
		columnNames.add("�γ̺�");
		columnNames.add("�γ���");
		columnNames.add("�ον�ʦ��");
		columnNames.add("�ον�ʦ��");
		columnNames.add("ѧ��");
		columnNames.add("�Ƿ�ѡ��");
		columnNames.add("�Ͽ�ʱ��");
		columnNames.add("�Ͽεص�");
		columnNames.add("��ֹʱ��");
		columnNames.add("ѧ����");
		rowData=new Vector();
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url,"root","root");
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				hang.add(rs.getString(9));
				hang.add(rs.getString(10));
				
				rowData.add(hang);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			}catch(Exception e){ 
				e.printStackTrace();
			}
		}
	}
	
	public JTable chooseCur(String sql){
				
		columnNames=new Vector();
		columnNames.add("");
		columnNames.add("�γ̺�");
		columnNames.add("�γ���");
		columnNames.add("�ον�ʦ��");
		columnNames.add("�ον�ʦ��");
		columnNames.add("ѧ��");
		columnNames.add("�Ƿ�ѡ��");
		columnNames.add("�Ͽ�ʱ��");
		columnNames.add("�Ͽεص�");
		columnNames.add("��ֹʱ��");
		columnNames.add("ѧ����");
		rowData=new Vector();
        
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url,"root","root");
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Vector hang=new Vector();
				hang.add(false);
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				hang.add(rs.getString(9));
				hang.add(rs.getString(10));
				
				rowData.add(hang);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			}catch(Exception e){ 
				e.printStackTrace();
			}
		}
		

		DefaultTableModel dtm=new DefaultTableModel(rowData,columnNames);
		JTable jtb=new JTable(dtm);
		
		TableColumnModel tcm = jtb.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));    
        tcm.getColumn(0).setCellRenderer(new TestTableCellRenderer());
		
		
		return jtb;
	}
	


	@Override
	public void fireTableCellUpdated(int row, int column) {
		// TODO Auto-generated method stub
		super.fireTableCellUpdated(row, column);
	}

	public boolean updateCourse(String sql,String []paras){
		boolean b=true;
		try{
			Class.forName(JDriver);
			con=DriverManager.getConnection(url,user,pwd);
			ps=con.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			if(ps.executeUpdate()!=1){
				b=false;
			}
		}catch(Exception e){
			b=false;
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			}catch(Exception e){ 
				e.printStackTrace();
			}
		}
		return b;
	}
	
	public ChoModel(String sql){
		this.init(sql);
	}
	
	
	public ChoModel(String ctrl,String Tno){
		this.Tno=Tno;
		this.init(ctrl);
	}
	
	public ChoModel(){
		this.init("");
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//return super.isCellEditable(rowIndex, columnIndex);
	    return true;
	}

	
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		super.setValueAt(aValue, rowIndex, columnIndex);
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}
	
}
class TestTableCellRenderer extends JCheckBox implements TableCellRenderer{
	  @Override
	  public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row,int column) {
		  Boolean b = (Boolean) value;    
		  this.setSelected(b.booleanValue());    
		  return this;    
	  }
}
