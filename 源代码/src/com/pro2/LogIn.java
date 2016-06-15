/**
 * ���ܣ���½����
 */
package com.pro2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogIn extends JFrame implements ActionListener{
	
	JPanel jp1,jp2,jp3,jp4,jp5;//���
	JLabel jbl1,jbl2,jbl3;//��ǩ
	JTextField jtf;//�ı���
	JPasswordField jpf;//�����
	JButton jb1,jb2;
	//JTable JScrollPane;
	JRadioButton jrb1,jrb2,jrb3,jrb;//��ѡ
	ButtonGroup bg;//��ť��
	
	JOptionPane jop;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogIn login=new LogIn();
	}
	public LogIn(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		

		jbl1=new JLabel("ѧ��ѡ�ι���ϵͳ");
		jbl1.setFont(new Font("����",Font.BOLD,30));
		jbl1.setForeground(Color.BLUE);
		jbl2=new JLabel("�û���");
		jbl2.setFont(new Font("����",Font.BOLD,15));
		jbl2.setForeground(Color.BLUE);
		jbl3=new JLabel("���롡");
		jbl3.setFont(new Font("����",Font.BOLD,15));
		jbl3.setForeground(Color.BLUE);
		jb1=new JButton("login");
		jb1.setForeground(Color.BLUE);
		jb2=new JButton("cancel");
		jb2.setForeground(Color.BLUE);
		jtf=new JTextField(15);
		jpf=new JPasswordField(15);
		jrb1=new JRadioButton("��������Ա");
		jrb1.setFont(new Font("����",Font.BOLD,15));
		jrb1.setForeground(Color.BLUE);
		jrb2=new JRadioButton("��ʦ");
		jrb2.setFont(new Font("����",Font.BOLD,15));
		jrb2.setForeground(Color.BLUE);
		jrb3=new JRadioButton("ѧ��");
		jrb3.setFont(new Font("����",Font.BOLD,15));
		jrb3.setForeground(Color.BLUE);
		
		bg=new ButtonGroup();
		bg.add(jrb1);
		jrb1.setSelected(true);
		bg.add(jrb2);
		bg.add(jrb3);
		
		this.setLayout(new GridLayout(5,1));
		jp1.add(jbl1);
		
		
		jp2.add(jbl2);
		jp2.add(jtf);
		
		jp3.add(jbl3);
		jp3.add(jpf);
		
		jp4.add(jrb1);
		jp4.add(jrb2);
		jp4.add(jrb3);
		
		jp5.add(jb1);
		jp5.add(jb2);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		
		this.setBackground(Color.gray);
		this.setTitle("��ӭ����ѧ��ѡ��ϵͳ");
		//this.setIconImage((new ImageIcon("images/xiuxiu.jpg")).getImage());
		this.setSize(400,250);
		this.setLocation(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		jb1.addActionListener(this);//�¼�����
		jb1.setActionCommand("login");//����
		jb2.addActionListener(this);
		jb2.setActionCommand("close");		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getActionCommand().equals("close")){
			System.exit(0);
		}else{
			if(jrb1.isSelected()==true){
				jrb=jrb1;
			}else if(jrb2.isSelected()==true){
				jrb=jrb2;
			}else if(jrb3.isSelected()==true){
				jrb=jrb3;
			}else{
				jrb=null;
			}
			
			if(jtf.getText().length()!=0 && jpf.getPassword().length!=0 && jrb!=null){
				char[] jpfp=jpf.getPassword();
				StringBuffer sb=new StringBuffer();
				for(int i=0;i<jpfp.length;i++){
					sb.append(jpfp[i]);
				}
				String Jpf=sb.toString();
				String JRB=jrb.getText();
				String JDriver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";//��������
				String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=pro2";//���ݿ�·��
				String user="root";//�˺�
				String password="root";//����
				try{
					Class.forName(JDriver);
				}catch (ClassNotFoundException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog( null , "���ݿ����Ӵ���" ,"��ʾ" , JOptionPane.ERROR_MESSAGE);
				}
				
				try {
					Connection con=DriverManager.getConnection(connectDB,user,password);
					Statement stmt=con.createStatement();
					ResultSet rs=null;
					if(JRB.equals("��������Ա")){
						rs=stmt.executeQuery("SELECT * FROM ROOTMAN where ����='"+jtf.getText() +"' and ����='"+Jpf+"'");
					}else if(JRB.equals("��ʦ")){
						rs=stmt.executeQuery("SELECT * FROM TEACHER where ��ʦ��='"+jtf.getText() +"' and ����='"+Jpf+"'");
					}else{
						rs=stmt.executeQuery("SELECT * FROM student where ѧ��='"+jtf.getText() +"' and ����='"+Jpf+"'");
					}
					
					if(rs.next()){
						if(JRB.equals("��������Ա")){
							new RootView(jtf.getText());
						}else if(JRB.equals("��ʦ")){
							new TeacherView(jtf.getText());
						}else{
							new StuView(jtf.getText());
						}
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null,"�û������������","��ʾ",JOptionPane.ERROR_MESSAGE);
					}
					stmt.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog( null , "���ݿ����Ӵ���" ,"��ʾ" , JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				if(jtf.getText().length()==0){
					JOptionPane.showMessageDialog( null , "�������û���");
				}else if(jpf.getPassword().length==0){
					JOptionPane.showMessageDialog( null , "����������");
				}else{
					JOptionPane.showMessageDialog( null , "��ѡ���ɫ");
				}
			}
		}
	}

}