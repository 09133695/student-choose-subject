package com.pro2;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class updateTime extends JDialog implements ActionListener{
	JLabel jbl1,jbl2,jbl3,jbl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2;
	
	JPanel jp1,jp2,jp3,jp4,jp5;

	
	//Frame ���ĸ�����
	//title ��������
	//model ģʽ���ڻ��Ƿ�ģʽ����
	public updateTime(Frame owner,String title,boolean modal,SCModel scm,int rowNums){
		super(owner,title,modal);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();

		jp4=new JPanel();
		jp5=new JPanel();

		jbl1=new JLabel("����ѧ��*");
		jbl2=new JLabel("���γ̺�*");
		jbl3=new JLabel("�γ�����*");
		jbl4=new JLabel("����ʱ��*");

		jtf1=new JTextField(20);
		jtf1.setText((String)scm.getValueAt(rowNums,0));
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf2.setText((String)scm.getValueAt(rowNums,1));
		jtf2.setEditable(false);
		jtf3=new JTextField(20);
		jtf3.setText((String)scm.getValueAt(rowNums,2));
		jtf3.setEditable(false);
		jtf4=new JTextField(20);
		jtf4.setText((String)scm.getValueAt(rowNums,8));
		
		jb1=new JButton("ȷ��");
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);

		jp1.add(jbl1);
		jp1.add(jtf1);

		jp2.add(jbl2);
		jp2.add(jtf2);
		
		jp3.add(jbl3);
		jp3.add(jtf3);

		jp4.add(jbl4);
		jp4.add(jtf4);
		
		jp5.add(jb1);
		jp5.add(jb2);
		
		this.setLayout(new GridLayout(5,1));
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		
		this.setSize(300,200);
		this.setLocation(400,150);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			int i=JOptionPane.showConfirmDialog(this, "�Ƿ���Ϊ�ÿγ̵Ŀ���ʱ��");
			SCModel temp=new SCModel();
			String sql=null;
			boolean success=true;
			if(i==0){
				sql="update SC set ����ʱ��=? where �γ̺�=?";
				String[] paras={jtf4.getText(),jtf2.getText()};
				success=temp.updateSC(sql, paras);
			}else if(i==1){
				sql="update SC set ����ʱ��=? where ѧ��=? and �γ̺�=?";
				String[] paras={jtf4.getText(),jtf1.getText(),jtf2.getText()};
				success=temp.updateSC(sql, paras);
			}
			else if(i==2){
				this.dispose();
			}
			this.dispose();
		}else{
			this.dispose();
		}
	}
}
