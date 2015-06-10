import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainWindow extends JFrame implements ActionListener{	
	private static final long serialVersionUID = 1L;
	
	/*
	   * 引用对象
	   */
	BusinessObject bo;
	
	/*
	   * 用户信息
	   */
	JTextField txtNum;//编号
	JTextField txtName;//姓名
	JTextField txtAge ;//年龄
	
	JRadioButton rBtnMale;//男
	JRadioButton rBtnFemale;//女
	
	JTextField txtTel;//联系方式
	
	JTextField txtPhotoAddr;//照片路径
	JLabel lblPhotoShow;//照片
	
	/*
	   * 浏览按钮与操作按钮
	   */
        JButton btnFirst;//第一条
        JButton btnPrevious;//上一条
        JButton btnNext;//下一条
        JButton btnLast;//最后一条

        JButton btnAdd ;//增加 	
        JButton btnSave;//保存
        JButton btnExit ;//退出
        JButton btnAbout ;//关于
        
        JLabel lblSaved;//提示已保存的标签
        JButton btnPhoto;//浏览图片的按钮
	
        /**
           * 构造方法
         */
        public MainWindow(){
		this.setSize(349, 380);
		this.setLocationRelativeTo(null);//窗口居中
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		bo = new BusinessObject();
		
		//内容面板
		Container con = this.getContentPane();
		con.setLayout(null);
		
		JLabel lblNum = new JLabel("用户编号:");
		lblNum.setBounds(20, 20, 60, 25);
		con.add(lblNum);
		txtNum = new JTextField();
		txtNum.setBounds(90, 20, 100, 25);
		txtNum.setEditable(false);
		con.add(txtNum);
		
		JLabel lblName = new JLabel("姓        名:");
		lblName.setBounds(20, 55, 60, 25);
		con.add(lblName);
		txtName = new JTextField();
		txtName.setBounds(90, 55, 100, 25);
		//txtName.getDocument().addDocumentListener(new TextChange());
		con.add(txtName);
		
		JLabel lblAge = new JLabel("年        龄:");
		lblAge.setBounds(20, 90, 60, 25);
		con.add(lblAge);
		txtAge = new JTextField();
		txtAge.setBounds(90, 90, 50, 25);
		//txtAge.getDocument().addDocumentListener(new TextChange());
		con.add(txtAge);
		
		JLabel lblSex = new JLabel("性        别:");
		lblSex.setBounds(20, 125, 60, 25);
		con.add(lblSex);	
		rBtnMale = new JRadioButton("男");
		rBtnMale.setBounds(90, 125, 50, 25);
		rBtnMale.setSelected(true);
		con.add(rBtnMale);
		rBtnFemale = new JRadioButton("女");
		rBtnFemale.setBounds(150, 125, 50, 25);
		con.add(rBtnFemale);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rBtnMale);
		btnGroup.add(rBtnFemale);
		
		JLabel lblTel = new JLabel("联系方式:");
		lblTel.setBounds(20, 160, 60, 25);
		con.add(lblTel);
		txtTel = new JTextField();
		txtTel.setBounds(90, 160, 150, 25);
		//txtTel.getDocument().addDocumentListener(new TextChange());
		con.add(txtTel);
		
		JLabel  lblPhoto = new JLabel("照片路径:");
		lblPhoto.setBounds(20, 195, 60, 25);
		con.add(lblPhoto);
		txtPhotoAddr = new JTextField();
		txtPhotoAddr.setBounds(90, 195, 150, 25);
		//txtPhotoAddr.getDocument().addDocumentListener(new TextChange());
		con.add(txtPhotoAddr);
		
		lblPhotoShow = new JLabel("            照片");
		lblPhotoShow.setBounds(233, 20, 100, 120);
		lblPhotoShow.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		con.add(lblPhotoShow);
		
		//浏览按钮面板
		JPanel panelScan = new JPanel();
		panelScan.setBounds(5, 225, 340, 60);
		panelScan.setBorder(BorderFactory.createTitledBorder("  浏览"));
		con.add(panelScan);
		
		//操作按钮面板
		JPanel panelOperation = new JPanel();
		panelOperation.setBounds(5, 285, 340, 60);
		panelOperation.setBorder(BorderFactory.createTitledBorder("  操作"));
		con.add(panelOperation);
		
		btnFirst = new JButton("第一条");
		btnPrevious = new JButton("上一条");
		btnNext = new JButton("下一条");
		btnLast = new JButton("后一条");
		
		panelScan.setLayout(new FlowLayout());
		panelScan.add(btnFirst);
		panelScan.add(btnPrevious);
		panelScan.add(btnNext);
		panelScan.add(btnLast);
		
		btnAdd = new JButton("新增(A)");	
		btnAdd.setMnemonic('A');
		btnAdd.setToolTipText("增加记录");
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnSave.setToolTipText("保存记录");
		btnExit = new JButton("退出(E)");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setMnemonic('E');
		btnAbout = new JButton("关于(H)");
		btnAbout.setMnemonic('H');
		btnAbout.setToolTipText("帮助信息");
		
                panelOperation.setLayout(new FlowLayout());
                panelOperation.add(btnAdd);
                panelOperation.add(btnSave);
                panelOperation.add(btnExit);
                panelOperation.add(btnAbout);
	    
                /*
                        * 事件监听
                        */
	        btnFirst.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		
		btnAdd.addActionListener(this);
		btnSave.addActionListener(this);
		btnAbout.addActionListener(this);
		/**
		       * 启动时显示第一条
		       */
		displayUserInfo(bo.first());
	        
		//保存成功
		lblSaved = new JLabel();
		lblSaved.setBounds(249, 163, 66, 18);
		con.add(lblSaved);

		btnPhoto = new JButton("浏览");
		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if(fileChooser.showOpenDialog(null) == 0){
                                    File selectedFile = fileChooser.getSelectedFile();
                                    lblPhotoShow.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
                                    txtPhotoAddr.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		btnPhoto.setBounds(246, 193, 74, 28);
		con.add(btnPhoto);
                this.setVisible(true);
	}
	
	
	public static void main(String[] args){
		new MainWindow();
	}
	
	/**
	  * 显示用户信息
	  */
	public  void displayUserInfo(User user){
                txtNum.setText(user.getNo());
                txtName.setText(user.getName());
                txtAge.setText(user.getAge().toString());
                if(user.getSex().equals("M")){
                        rBtnMale.setSelected(true);
                }else if(user.getSex().equals("F")){
                        rBtnFemale.setSelected(true);
                }
                txtTel.setText(user.getPhone());
                txtPhotoAddr.setText(user.getImagePath());
                lblPhotoShow.setIcon(new ImageIcon(user.getImagePath()));
	}
	
	/**
	   * 事件实现
	   */
	public void actionPerformed(ActionEvent e) {
		lblSaved.setText("");		
		if(e.getSource() == btnFirst){	
			displayUserInfo(bo.first());
		}else if(e.getSource() == btnPrevious){
			displayUserInfo(bo.previous());
		}else if(e.getSource() == btnNext){
			displayUserInfo(bo.next());
		}else if(e.getSource() == btnLast){
			displayUserInfo(bo.last());
		}else if(e.getSource() == btnAdd){
			txtNum.setText(""+(bo.users.length+1));
			txtName.setText("");
			txtAge.setText("");
			rBtnMale.setSelected(true);
			txtTel.setText("");
			txtPhotoAddr.setText("");
			lblPhotoShow.setIcon(null);
		}else if(e.getSource() == btnSave){
			if(txtNum.getText() != null){		
                                User u =  new User();
                                u.setNo(txtNum.getText());
                                u.setName(txtName.getText());
                                u.setAge( Integer.parseInt(txtAge.getText()));
                                if(rBtnMale.isSelected()){
                                        u.setSex("M");
                                }else{
                                        u.setSex("F");
                                }
                                u.setPhone(txtTel.getText());                                
                                u.setImagePath(txtPhotoAddr.getText());                            
                                bo.saveUser(u);
                                lblSaved.setText("保存成功");
			}
		}else if(e.getSource() == btnAbout){
			JOptionPane.showMessageDialog(this,"                 By 龚刚","关于",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	    * 监听文本框内容改变
	   private class TextChange implements DocumentListener{
		public void changedUpdate(DocumentEvent e) {
			btnSave.setEnabled(true);
		}
		public void insertUpdate(DocumentEvent e) {
			btnSave.setEnabled(true);
		}
		public void removeUpdate(DocumentEvent e) {
			btnSave.setEnabled(true);
		}
	 } 
	 */
}
