package com.pro2;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class stuAddDialog extends JDialog implements ActionListener{
	JLabel jbl1,jbl2,jbl3,jbl4,jbl5,jbl6,jbl7,jbl8,jbl9,jbl10,jbl11,jbl12;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11;
	JPasswordField jpf;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11,jp12,jp13;

	
	//Frame ���ĸ�����
	//title ��������
	//model ģʽ���ڻ��Ƿ�ģʽ����
	public stuAddDialog(Frame owner,String title,boolean modal){
		super(owner,title,modal);
		
		Font font=new Font("����",Font.BOLD,15);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		jp7=new JPanel();
		jp8=new JPanel();
		jp9=new JPanel();
		jp10=new JPanel();
		jp11=new JPanel();
		jp12=new JPanel();
		jp13=new JPanel();

		
		jbl1=new JLabel("����ѧ��*");
		jbl2=new JLabel("��������*");
		jbl3=new JLabel("��������*");
		jbl4=new JLabel("�����Ա�*");
		jbl5=new JLabel("��������*");
		jbl6=new JLabel("��������*");
		jbl7=new JLabel("��ѧʱ��*");
		jbl8=new JLabel("�������*");
		jbl9=new JLabel("������ò*");
		jbl10=new JLabel("���֤��*");
		jbl11=new JLabel("����ѧԺ*");
		jbl12=new JLabel("��������*");
		

		jbl1.setFont(font);
		jbl1.setForeground(Color.blue);

		jbl2.setFont(font);
		jbl2.setForeground(Color.blue);

		jbl3.setFont(font);
		jbl3.setForeground(Color.blue);

		jbl4.setFont(font);
		jbl4.setForeground(Color.blue);

		jbl5.setFont(font);
		jbl5.setForeground(Color.blue);

		jbl6.setFont(font);
		jbl6.setForeground(Color.blue);

		jbl7.setFont(font);
		jbl7.setForeground(Color.blue);

		jbl8.setFont(font);
		jbl8.setForeground(Color.blue);

		jbl9.setFont(font);
		jbl9.setForeground(Color.blue);

		jbl10.setFont(font);
		jbl10.setForeground(Color.blue);

		jbl11.setFont(font);
		jbl11.setForeground(Color.blue);

		jbl12.setFont(font);
		jbl12.setForeground(Color.blue);

		

		jtf1=new JTextField(20);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		jtf5=new JTextField(20);
		jtf6=new JTextField(20);
		jtf7=new JTextField(20);
		jtf8=new JTextField(20);
		jtf9=new JTextField(20);
		jtf10=new JTextField(20);
		jtf11=new JTextField(20);
		jpf=new JPasswordField(20);
		

		jtf1.setFont(font);
		jtf1.setForeground(Color.blue);
		jtf2.setFont(font);
		jtf2.setForeground(Color.blue);
		jtf3.setFont(font);
		jtf3.setForeground(Color.blue);
		jtf4.setFont(font);
		jtf4.setForeground(Color.blue);
		jtf5.setFont(font);
		jtf5.setForeground(Color.blue);
		jtf6.setFont(font);
		jtf6.setForeground(Color.blue);
		jtf7.setFont(font);
		jtf7.setForeground(Color.blue);
		jtf8.setFont(font);
		jtf8.setForeground(Color.blue);
		jtf9.setFont(font);
		jtf9.setForeground(Color.blue);
		jtf10.setFont(font);
		jtf10.setForeground(Color.blue);
		jtf11.setFont(font);
		jtf11.setForeground(Color.blue);
		jpf.setFont(font);
		jpf.setForeground(Color.blue);
		
		
		
		
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
		

		jp5.add(jbl5);
		jp5.add(jtf5);

		jp6.add(jbl6);
		jp6.add(jtf6);

		jp7.add(jbl7);
		jp7.add(jtf7);

		jp8.add(jbl8);
		jp8.add(jtf8);

		jp9.add(jbl9);
		jp9.add(jtf9);
		
		jp10.add(jbl10);
		jp10.add(jtf10);
		
		jp11.add(jbl11);
		jp11.add(jtf11);

		jp12.add(jbl12);
		jp12.add(jpf);
		
		jp13.add(jb1);
		jp13.add(jb2);

		this.setLayout(new GridLayout(13,1));

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jp7);
		this.add(jp8);
		this.add(jp9);
		this.add(jp10);
		this.add(jp11);
		this.add(jp12);
		this.add(jp13);
		
		this.setSize(300,400);
		this.setLocation(400,150);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			//
			char[] jpfp=jpf.getPassword();
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<jpfp.length;i++){
				sb.append(jpfp[i]);
			}
			String Jpf=sb.toString();
			RootModel temp=new RootModel();
			String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)";
			String[] paras={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf8.getText(),jtf9.getText(),jtf10.getText(),jtf11.getText(),Jpf};
			if(temp.updateStu(sql, paras)!=true){
				JOptionPane.showMessageDialog(this,"���ʧ��");
			}
			this.dispose();
		}else{
			this.dispose();
		}
	}
}
