package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import helpers.ShareData;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class pnl_QuanLy extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnQuanLyNhanVien;
	private JButton btnQuanLySanPham;
	private JButton btnQuanLyKhachHang;

	private pnl_QuanLyKhachHang quanLyKhachHang;
	private pnl_QuanLyNhanVien quanLyNhanVien;
	private pnl_QuanLySanPham quanLySanPham;
	private JLayeredPane layeredPane;

	/**
	 * Create the panel.
	 */
	public pnl_QuanLy() {

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));

		layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
		);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		quanLyNhanVien = new pnl_QuanLyNhanVien();
		layeredPane.add(quanLyNhanVien);
		layeredPane.repaint();
		layeredPane.revalidate();

		btnQuanLyNhanVien = new JButton("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		btnQuanLyNhanVien.setIcon(new ImageIcon(getClass().getResource("/imgs/employee.png")));
		btnQuanLyNhanVien.setFocusable(false);

		btnQuanLySanPham = new JButton("Qu\u1EA3n l\u00FD s\u1EA3n ph\u1EA9m");
		btnQuanLySanPham.setIcon(new ImageIcon(getClass().getResource("/imgs/cafe.png")));
		btnQuanLySanPham.setFocusable(false);

		btnQuanLyKhachHang = new JButton("Qu\u1EA3n l\u00FD kh\u00E1ch h\u00E0ng");
		btnQuanLyKhachHang.setIcon(new ImageIcon(getClass().getResource("/imgs/customer.png")));
		btnQuanLyKhachHang.setFocusable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnQuanLyNhanVien, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnQuanLySanPham, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnQuanLyKhachHang, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(btnQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnQuanLySanPham, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnQuanLyKhachHang, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		btnQuanLyKhachHang.addActionListener(this);
		btnQuanLyNhanVien.addActionListener(this);
		btnQuanLySanPham.addActionListener(this);
		
		processLoginSuccessfull();
	}

	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnQuanLyNhanVien)) {
			quanLyNhanVien = new pnl_QuanLyNhanVien();
			switchPanel(quanLyNhanVien);
		}

		if (o.equals(btnQuanLySanPham)) {
			quanLySanPham = new pnl_QuanLySanPham();
			switchPanel(quanLySanPham);
		}


		if (o.equals(btnQuanLyKhachHang)) {
			quanLyKhachHang = new pnl_QuanLyKhachHang();
			switchPanel(quanLyKhachHang);
		}
	}
	
	private void processLoginSuccessfull() {

		if (ShareData.taiKhoanDangNhap.getQuyen().equals("NhanVien")) {
			btnQuanLyNhanVien.setVisible(false);
			quanLySanPham = new pnl_QuanLySanPham();
			switchPanel(quanLySanPham);
		}
		
		

	}
}
