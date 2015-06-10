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
	   * ���ö���
	   */
	BusinessObject bo;
	
	/*
	   * �û���Ϣ
	   */
	JTextField txtNum;//���
	JTextField txtName;//����
	JTextField txtAge ;//����
	
	JRadioButton rBtnMale;//��
	JRadioButton rBtnFemale;//Ů
	
	JTextField txtTel;//��ϵ��ʽ
	
	JTextField txtPhotoAddr;//��Ƭ·��
	JLabel lblPhotoShow;//��Ƭ
	
	/*
	   * �����ť�������ť
	   */
        JButton btnFirst;//��һ��
        JButton btnPrevious;//��һ��
        JButton btnNext;//��һ��
        JButton btnLast;//���һ��

        JButton btnAdd ;//���� 	
        JButton btnSave;//����
        JButton btnExit ;//�˳�
        JButton btnAbout ;//����
        
        JLabel lblSaved;//��ʾ�ѱ���ı�ǩ
        JButton btnPhoto;//���ͼƬ�İ�ť
	
        /**
           * ���췽��
         */
        public MainWindow(){
		this.setSize(349, 380);
		this.setLocationRelativeTo(null);//���ھ���
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		bo = new BusinessObject();
		
		//�������
		Container con = this.getContentPane();
		con.setLayout(null);
		
		JLabel lblNum = new JLabel("�û����:");
		lblNum.setBounds(20, 20, 60, 25);
		con.add(lblNum);
		txtNum = new JTextField();
		txtNum.setBounds(90, 20, 100, 25);
		txtNum.setEditable(false);
		con.add(txtNum);
		
		JLabel lblName = new JLabel("��        ��:");
		lblName.setBounds(20, 55, 60, 25);
		con.add(lblName);
		txtName = new JTextField();
		txtName.setBounds(90, 55, 100, 25);
		//txtName.getDocument().addDocumentListener(new TextChange());
		con.add(txtName);
		
		JLabel lblAge = new JLabel("��        ��:");
		lblAge.setBounds(20, 90, 60, 25);
		con.add(lblAge);
		txtAge = new JTextField();
		txtAge.setBounds(90, 90, 50, 25);
		//txtAge.getDocument().addDocumentListener(new TextChange());
		con.add(txtAge);
		
		JLabel lblSex = new JLabel("��        ��:");
		lblSex.setBounds(20, 125, 60, 25);
		con.add(lblSex);	
		rBtnMale = new JRadioButton("��");
		rBtnMale.setBounds(90, 125, 50, 25);
		rBtnMale.setSelected(true);
		con.add(rBtnMale);
		rBtnFemale = new JRadioButton("Ů");
		rBtnFemale.setBounds(150, 125, 50, 25);
		con.add(rBtnFemale);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rBtnMale);
		btnGroup.add(rBtnFemale);
		
		JLabel lblTel = new JLabel("��ϵ��ʽ:");
		lblTel.setBounds(20, 160, 60, 25);
		con.add(lblTel);
		txtTel = new JTextField();
		txtTel.setBounds(90, 160, 150, 25);
		//txtTel.getDocument().addDocumentListener(new TextChange());
		con.add(txtTel);
		
		JLabel  lblPhoto = new JLabel("��Ƭ·��:");
		lblPhoto.setBounds(20, 195, 60, 25);
		con.add(lblPhoto);
		txtPhotoAddr = new JTextField();
		txtPhotoAddr.setBounds(90, 195, 150, 25);
		//txtPhotoAddr.getDocument().addDocumentListener(new TextChange());
		con.add(txtPhotoAddr);
		
		lblPhotoShow = new JLabel("            ��Ƭ");
		lblPhotoShow.setBounds(233, 20, 100, 120);
		lblPhotoShow.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		con.add(lblPhotoShow);
		
		//�����ť���
		JPanel panelScan = new JPanel();
		panelScan.setBounds(5, 225, 340, 60);
		panelScan.setBorder(BorderFactory.createTitledBorder("  ���"));
		con.add(panelScan);
		
		//������ť���
		JPanel panelOperation = new JPanel();
		panelOperation.setBounds(5, 285, 340, 60);
		panelOperation.setBorder(BorderFactory.createTitledBorder("  ����"));
		con.add(panelOperation);
		
		btnFirst = new JButton("��һ��");
		btnPrevious = new JButton("��һ��");
		btnNext = new JButton("��һ��");
		btnLast = new JButton("��һ��");
		
		panelScan.setLayout(new FlowLayout());
		panelScan.add(btnFirst);
		panelScan.add(btnPrevious);
		panelScan.add(btnNext);
		panelScan.add(btnLast);
		
		btnAdd = new JButton("����(A)");	
		btnAdd.setMnemonic('A');
		btnAdd.setToolTipText("���Ӽ�¼");
		btnSave = new JButton("����(S)");
		btnSave.setMnemonic('S');
		btnSave.setToolTipText("�����¼");
		btnExit = new JButton("�˳�(E)");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setMnemonic('E');
		btnAbout = new JButton("����(H)");
		btnAbout.setMnemonic('H');
		btnAbout.setToolTipText("������Ϣ");
		
                panelOperation.setLayout(new FlowLayout());
                panelOperation.add(btnAdd);
                panelOperation.add(btnSave);
                panelOperation.add(btnExit);
                panelOperation.add(btnAbout);
	    
                /*
                        * �¼�����
                        */
	        btnFirst.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		
		btnAdd.addActionListener(this);
		btnSave.addActionListener(this);
		btnAbout.addActionListener(this);
		/**
		       * ����ʱ��ʾ��һ��
		       */
		displayUserInfo(bo.first());
	        
		//����ɹ�
		lblSaved = new JLabel();
		lblSaved.setBounds(249, 163, 66, 18);
		con.add(lblSaved);

		btnPhoto = new JButton("���");
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
	  * ��ʾ�û���Ϣ
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
	   * �¼�ʵ��
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
                                lblSaved.setText("����ɹ�");
			}
		}else if(e.getSource() == btnAbout){
			JOptionPane.showMessageDialog(this,"                 By ����","����",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	    * �����ı������ݸı�
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
