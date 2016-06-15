package com.pro2;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class updataTeaPwd extends JDialog implements ActionListener{
	JLabel jbl1,jbl2;
	JTextField jtf1;
	JPasswordField jpf;
	JButton jb1,jb2;
	
	JPanel jp1,jp2,jp3;

	
	//Frame ���ĸ�����
	//title ��������
	//model ģʽ���ڻ��Ƿ�ģʽ����
	public updataTeaPwd(Frame owner,String title,boolean modal,TeacherModel tm,int rowNums){
		super(owner,title,modal);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();

		jbl1=new JLabel("ѧ��* ��");
		jbl2=new JLabel("������*");

		jtf1=new JTextField(20);
		jtf1.setText((String)tm.getValueAt(rowNums,0));
		jtf1.setEditable(false);
		jpf=new JPasswordField(20);
		
		jb1=new JButton("ȷ��");
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);

		jp1.add(jbl1);
		jp1.add(jtf1);

		jp2.add(jbl2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);

		this.setLayout(new GridLayout(3,1));
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,120);
		this.setLocation(400,150);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			if(jpf.getPassword().length==0){
				JOptionPane.showMessageDialog(this, "���벻��Ϊ��");
			}else{
				char[] jpfp=jpf.getPassword();
				StringBuffer sb=new StringBuffer();
				for(int i=0;i<jpfp.length;i++){
					sb.append(jpfp[i]);
				}
				String Jpf=sb.toString();
				TeacherModel temp=new TeacherModel();
				String sql="update teacher set ����=? where ��ʦ��=?";
				String[] paras={Jpf,jtf1.getText()};
				if(temp.updateTea(sql, paras)!=true){
					JOptionPane.showMessageDialog(this,"�޸�ʧ��");
				}else{
					JOptionPane.showMessageDialog(this,"�޸ĳɹ�");
				}
				this.dispose();
			}
		}else{
			this.dispose();
		}
	}
}
