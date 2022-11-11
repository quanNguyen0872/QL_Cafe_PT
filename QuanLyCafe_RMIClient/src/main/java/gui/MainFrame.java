package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import helpers.MessageDialogHelpers;
import helpers.ShareData;
import model.Quyen;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnQuanLy;
	private JButton btnBanHang;
	private JLayeredPane layeredPane;
	private pnl_BanHang banHangPanel;
	private pnl_QuanLy quanLyPanel;
	private JButton btnDangXuat;
	private JLabel lblTittle;
	private JLabel lblTenDangNhap;
	private JLabel lblVaiTro;
	private JLabel lbltime;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setExtendedState(Frame.MAXIMIZED_BOTH);
//		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		layeredPane = new JLayeredPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(8)
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)));
		layeredPane.setLayout(new CardLayout(0, 0));

		lblTittle = new JLabel("PHẦN MỀM QUẢN LÝ CAFE");
		lblTittle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblTittle, "name_9965046455000");

		btnQuanLy = new JButton("Qu\u1EA3n l\u00FD");
		btnQuanLy.setIcon(new ImageIcon(getClass().getResource("/imgs/management.png")));
		btnQuanLy.setFocusable(false);
		btnQuanLy.setFont(tahoma14);

		btnBanHang = new JButton("B\u00E1n h\u00E0ng");
		btnBanHang.setIcon(new ImageIcon(getClass().getResource("/imgs/buy.png")));
		btnBanHang.setFocusable(false);
		btnBanHang.setFont(tahoma14);

		btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnDangXuat.setFocusable(false);

		lblVaiTro = new JLabel("Vai tr\u00F2");
		lblVaiTro.setForeground(Color.RED);
		lblVaiTro.setFont(tahoma14);

		lblTenDangNhap = new JLabel("T\u00EAn");
		lblTenDangNhap.setForeground(Color.RED);
		lblTenDangNhap.setFont(tahoma14);
		
		lbltime = new JLabel("New label");
		lbltime.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnQuanLy, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBanHang, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbltime, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblVaiTro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTenDangNhap, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnDangXuat)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnQuanLy, GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
									.addComponent(btnBanHang, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblTenDangNhap)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblVaiTro)))
									.addGap(18))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(lbltime)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		btnBanHang.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnQuanLy.addActionListener(this);
		
		processLoginSuccessfull();
		
		Clock clock = new Clock();
		clock.start();
		 
	}

	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnBanHang)) {
			banHangPanel = new pnl_BanHang();
			switchPanel(banHangPanel);
		}

		if (o.equals(btnQuanLy)) {
			quanLyPanel = new pnl_QuanLy();
			switchPanel(quanLyPanel);
		}
		
		if (o.equals(btnDangXuat)) {
			int isDangxuat = MessageDialogHelpers.showConfirmDialog(layeredPane, "Cảnh báo",
					"Bạn có chắc muốn đăng xuất");
			if (isDangxuat == JOptionPane.NO_OPTION) {
				return;
			} else if (isDangxuat == JOptionPane.CLOSED_OPTION) {
				return;
			}
			dispose();
			Login login = new Login();
			login.setVisible(true);
		}
 	}

	private void processLoginSuccessfull() {

		lblTenDangNhap.setText("Tên tài khoản: " + ShareData.taiKhoanDangNhap.getTenTaiKhoan());
		String vaiTro = ShareData.taiKhoanDangNhap.getQuyen().toString();
		if (vaiTro.equals(Quyen.QuanLy.toString())) {
			lblVaiTro.setText("Vai trò: Quản lý");
		} else if(vaiTro.equals(Quyen.NhanVien.toString())){
			lblVaiTro.setText("Vai trò: Nhân viên");
		}
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
	public class Clock extends Thread{
	public Clock() {}
	@Override
	public void run(){
		while(true) {
		Calendar calendar = Calendar.getInstance();               
	    String str;  
	    str= sdf.format(calendar.getTime()); 
	    lbltime.setText(str);
	    try{ 
            sleep(1000); 
          } catch(Exception e){ 
             System.out.println(e); 
            } 
	  }
	}
	}
}


	


