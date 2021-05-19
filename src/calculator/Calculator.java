package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.sun.net.httpserver.Authenticator.Result;

/***
 * This is a simple calculator application created using Java 
 * @author samruddhi
 *
 */
public class Calculator implements ActionListener {
	// Creating a frame panel and buttons for the calculator
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea textArea=new JTextArea(4,20);
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	JButton button7 = new JButton();
	JButton button8 = new JButton();
	JButton button9 = new JButton();
	JButton button10 = new JButton();
	JButton dotButton=new JButton(".");
	
	JButton addButton = new JButton();
	JButton multiplyButton = new JButton();
	JButton subButton = new JButton();
	JButton divButton = new JButton();
	JButton clearButton = new JButton();
	JButton equalButton=new JButton();
	
	// number1: first operand
	// number2: second operand
	// result: to store the result
	Double number1,number2;
	Double result;
	int add=0,mul=0,sub=0,div=0;
	boolean clearScreen=false;
	
	public Calculator() {
		// TODO Auto-generated constructor stub
		frame.setSize(500,500);
		textArea.setText("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Calculator");
		frame.setResizable(true);
		frame.add(panel);
		panel.setBackground(Color.black);
		Border border = BorderFactory.createLineBorder(Color.blue);
		panel.add(textArea);
		textArea.setBackground(Color.white);
		Font font =  new Font(Font.SANS_SERIF,Font.BOLD,20);
		textArea.setForeground(Color.black);
		textArea.setFont(font);
		Border border2=BorderFactory.createLineBorder(Color.black);
		textArea.setBorder(border2);
		textArea.setPreferredSize(new Dimension(2,10));
		textArea.setLineWrap(true);
		button1.setPreferredSize(new Dimension(100,40));
		button2.setPreferredSize(new Dimension(100,40));
		button3.setPreferredSize(new Dimension(100,40));
		button4.setPreferredSize(new Dimension(100,40));
		button5.setPreferredSize(new Dimension(100,40));
		button6.setPreferredSize(new Dimension(100,40));
		button7.setPreferredSize(new Dimension(100,40));
		dotButton.setPreferredSize(new Dimension(100,40));
		button8.setPreferredSize(new Dimension(100,40));
		button9.setPreferredSize(new Dimension(100,40));
		button10.setPreferredSize(new Dimension(100,40));
		equalButton.setPreferredSize(new Dimension(100,40));
		
		clearButton.setPreferredSize(new Dimension(100, 40));
		addButton.setPreferredSize(new Dimension(100, 40));
		multiplyButton.setPreferredSize(new Dimension(100, 40));
		divButton.setPreferredSize(new Dimension(100, 40));
		subButton.setPreferredSize(new Dimension(100, 40));
		button7.setText("7");
		button7.setMargin(new Insets(5,5,5,5));
		button7.setBackground(Color.white);
		panel.add(button7);

		button8.setText("8");
		button8.setMargin(new Insets(5,5,5,5));
		button8.setBackground(Color.white);
		panel.add(button8);
		button9.setText("9");
		button9.setMargin(new Insets(5,5,5,5));
		button9.setBackground(Color.white);
		panel.add(button9);
		
		divButton.setText("/");
		divButton.setMargin(new Insets(5,5,5,5));
		divButton.setBackground(Color.white);
		panel.add(divButton);

		
		button4.setText("4");
		button4.setMargin(new Insets(5,5,5,5));
		button4.setBackground(Color.white);
		panel.add(button4);
		
		
		button5.setText("5");
		button5.setMargin(new Insets(5,5,5,5));
		button5.setBackground(Color.white);
		panel.add(button5);
		
		button6.setText("6");
		button6.setMargin(new Insets(5,5,5,5));
		button6.setBackground(Color.white);
		panel.add(button6);
		
		multiplyButton.setText("X");
		multiplyButton.setBackground(Color.white);
		multiplyButton.setMargin(new Insets(5,5,5,5));
		panel.add(multiplyButton);
		
		button1.setText("1");
		button1.setMargin(new Insets(5,5,5,5));
		button1.setBackground(Color.white);
		panel.add(button1);
		
		button2.setText("2");
		button2.setMargin(new Insets(5,5,5,5));
		button2.setBackground(Color.white);
		panel.add(button2);
		
		button3.setText("3");
		button3.setMargin(new Insets(5,5,5,5));
		button3.setBackground(Color.white);
		panel.add(button3);
		
		
		addButton.setText("+");
		addButton.setMargin(new Insets(5,5,5,5));
		addButton.setBackground(Color.white);
		panel.add(addButton);
		
		
		
		equalButton.setText("=");
		equalButton.setBackground(Color.white);
		equalButton.setMargin(new Insets(5,5,5,5));
		panel.add(equalButton);	
		
		
		

		button10.setText("0");
		button10.setMargin(new Insets(5,5,5,5));
		button10.setBackground(Color.white);
		panel.add(button10);
		dotButton.setText(".");
		dotButton.setMargin(new Insets(5,5,5,5));
		dotButton.setBackground(Color.white);
		panel.add(dotButton);

		
		subButton.setText("-");
		subButton.setMargin(new Insets(5,5,5 ,5));
		subButton.setBackground(Color.white);
		panel.add(subButton);
		
		
		
		
		clearButton.setText("C");
		clearButton.setMargin(new Insets(5,5,5,5));
		clearButton.setBackground(Color.white);
		panel.add(clearButton);
		button1.addActionListener((ActionListener)this);
		button2.addActionListener((ActionListener)this);
		button3.addActionListener((ActionListener)this);
		button4.addActionListener((ActionListener)this);
		button5.addActionListener((ActionListener)this);
		button6.addActionListener((ActionListener)this);
		button7.addActionListener((ActionListener)this);
		button8.addActionListener((ActionListener)this);
		button9.addActionListener((ActionListener)this);
		button10.addActionListener((ActionListener)this);
		addButton.addActionListener((ActionListener)this);
		multiplyButton.addActionListener((ActionListener)this);
		divButton.addActionListener((ActionListener)this);
		dotButton.addActionListener((ActionListener)this);
		clearButton.addActionListener((ActionListener)this);
		subButton.addActionListener((ActionListener)this);
		equalButton.addActionListener((ActionListener)this);
		 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object sourceObject =  e.getSource();
		System.out.print("HELLO ");
		if(sourceObject==clearButton) {
			number1=0.0;
			number2=0.0;
			textArea.setText("");
			
		}
		if(sourceObject==dotButton) {
			textArea.append(".");
		}
		 if(sourceObject==button1) {
			 if(clearScreen) {
					textArea.setText("1");
				}
			 else
			textArea.append("1");
			
			clearScreen=false;
		}
		 if(sourceObject==button2) {
			 if(clearScreen) {
					textArea.setText("2");
				}
			 else
			textArea.append("2");
			clearScreen=false;
		}
		 if(sourceObject==button3) {
			 if(clearScreen) {
					textArea.setText("3");
				}
			 else
			textArea.append("3");
			clearScreen=false;
		}
		 if(sourceObject==button4) {
			 if(clearScreen) {
					textArea.setText("4");
				}
			 else
			textArea.append("4");
			clearScreen=false;
		}
		 if(sourceObject==button5) {
			 if(clearScreen) {
					textArea.setText("5");
				}
			 else
			textArea.append("5");
			clearScreen=false;
		}
		 if(sourceObject==button6) {
			 if(clearScreen) {
					textArea.setText("6");
				}
			 else
			textArea.append("6");
			clearScreen=false;
		}
		 if(sourceObject==button7) {
			 if(clearScreen) {
					textArea.setText("7");
				}
			 else
			textArea.append("7");
			clearScreen=false;
		}
		 if(sourceObject==button8) {
			 if(clearScreen) {
					textArea.setText("8");
				}
			 else
			textArea.append("8");
			clearScreen=false;
		}
		 if(sourceObject==button9) {
			 if(clearScreen) {
					textArea.setText("9");
				}
			 else
			textArea.append("9");
			clearScreen=false;
		}
		
		 if(sourceObject==button10) {
			 if(clearScreen) {
					textArea.setText("0");
				}
			 else
			textArea.append("0");
			clearScreen=false;
		}
		 if(sourceObject==addButton) {
			 if(add>0) {
				 add=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1+number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 if(sub>0) {
				 sub=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1-number2;
				 number1=result;
				 
				 textArea.setText(String.valueOf(result));
			 }
			 if(div>0) {
				 div=0;
				 number2=Double.valueOf(textArea.getText());
				 if(number2!=0) {
					 result=number1/number2;
					 number1=result;
					 textArea.setText(String.valueOf(result));
				 }
				 else {
					 textArea.setText("Math error ");
				 }
				
			 }
			 
			 if(mul>0) {
				 mul=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1*number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 
//			 
			number1=Double.valueOf(textArea.getText());
			//textArea.append("+");
			add=1;
			mul=0;
			sub=0;
			div=0;
			clearScreen=true;
			
		}
		 if(sourceObject==subButton) {
			 if(add>0) {
				 add=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1+number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 if(sub>0) {
				 sub=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1-number2;
				 number1=result;
				 
				 textArea.setText(String.valueOf(result));
			 }
			 if(div>0) {
				 div=0;
				 number2=Double.valueOf(textArea.getText());
				 if(number2!=0) {
					 result=number1/number2;
					 number1=result;
					 textArea.setText(String.valueOf(result));
				 }
				 else {
					 textArea.setText("Math error ");
				 }
				
			 }
			 
			 if(mul>0) {
				 mul=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1*number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 number1=Double.valueOf(textArea.getText());
			//textArea.append("-");
			 add=0;
				mul=0;
				sub=1;
				div=0;
			clearScreen=true;
			
		}
		 if(sourceObject==multiplyButton) {
			 if(add>0) {
				 add=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1+number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 if(sub>0) {
				 sub=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1-number2;
				 number1=result;
				 
				 textArea.setText(String.valueOf(result));
			 }
			 if(div>0) {
				 div=0;
				 number2=Double.valueOf(textArea.getText());
				 if(number2!=0) {
					 result=number1/number2;
					 number1=result;
					 textArea.setText(String.valueOf(result));
				 }
				 else {
					 textArea.setText("Math error ");
				 }
				
			 }
			 
			 if(mul>0) {
				 mul=0;
				 number2=Double.valueOf(textArea.getText());
				 result=number1*number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 number1=Double.valueOf(textArea.getText());
			//textArea.append("*");
			clearScreen=true;
			add=0;
			mul=1;
			sub=0;
			div=0;

		}
	 if(sourceObject==divButton) {
		 if(add>0) {
			 add=0;
			 number2=Double.valueOf(textArea.getText());
			 result=number1+number2;
			 number1=result;
			 textArea.setText(String.valueOf(result));
		 }
		 if(sub>0) {
			 sub=0;
			 number2=Double.valueOf(textArea.getText());
			 result=number1-number2;
			 number1=result;
			 
			 textArea.setText(String.valueOf(result));
		 }
		 if(div>0) {
			 div=0;
			 number2=Double.valueOf(textArea.getText());
			 if(number2!=0) {
				 result=number1/number2;
				 number1=result;
				 textArea.setText(String.valueOf(result));
			 }
			 else {
				 textArea.setText("Math error ");
			 }
			
		 }
		 
		 if(mul>0) {
			 mul=0;
			 number2=Double.valueOf(textArea.getText());
			 result=number1*number2;
			 number1=result;
			 textArea.setText(String.valueOf(result));
		 }
		 number1=Double.valueOf(textArea.getText());
			//textArea.append("/");
		 add=0;
			mul=0;
			sub=0;
			div=1;
			clearScreen=true;
			
		}
	 if(sourceObject==equalButton) {
		 number2=Double.valueOf(textArea.getText());
		 if(add>0) {
			 add=0;
			 result=number1+number2;
			 textArea.setText(String.valueOf(result));
		 }
		 if(sub>0) {
			 sub=0;
			 result=number1-number2;
			 textArea.setText(String.valueOf(result));
		 }
		 if(div>0) {
			 div=0;
			 if(number2!=0) {
				 result=number1/number2;
				 textArea.setText(String.valueOf(result));
			 }
			 else {
				 textArea.setText("Math error ");
			 }
			
		 }
		 
		 if(mul>0) {
			 mul=0;
			 result=number1*number2;
			 textArea.setText(String.valueOf(result));
		 }
		 
	 }
		
	}}
	