package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import facade.NhanVienFacade;
import facade.TaiKhoanFacade;
import helpers.Config;
import helpers.MessageDialogHelpers;
import helpers.ShareData;

import model.TaiKhoan;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;

	private TaiKhoanFacade taiKhoanFacade;
	private NhanVienFacade nhanVienFacade;

	
	
	/**
	 * Create the dialog.
	 */
	public Login() {
		try {
			taiKhoanFacade = (TaiKhoanFacade) Naming.lookup("rmi://"+ Config.getAddress() +"/taiKhoanFacade");
			nhanVienFacade =  (NhanVienFacade) Naming.lookup("rmi://"+ Config.getAddress() +"/nhanVienFacade");
			nhanVienFacade.getDanhSachNV();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);

		setBounds(100, 100, 532, 311);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 518, 274);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Tên Đăng Nhập:");
			lblNewLabel.setFont(tahoma14);
			lblNewLabel.setBounds(37, 76, 105, 38);
			contentPanel.add(lblNewLabel);
		}

		JLabel lblMtKhu = new JLabel("Mật Khẩu:");
		lblMtKhu.setFont(tahoma14);
		lblMtKhu.setBounds(37, 142, 105, 38);
		contentPanel.add(lblMtKhu);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setFont(tahoma14);
		txtTenDangNhap.setBounds(174, 83, 299, 26);
		contentPanel.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(tahoma14);
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(174, 149, 299, 26);
		contentPanel.add(txtMatKhau);

		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					try {
						dangNhap();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				});
			}
		});
		btnDangNhap.setFont(tahoma14);
		btnDangNhap.setBounds(80, 206, 111, 26);
		contentPanel.add(btnDangNhap);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setFont(tahoma14);
		btnHuy.setBounds(325, 206, 111, 26);
		contentPanel.add(btnHuy);

		JLabel lblNewLabel_1 = new JLabel("Đăng Nhập");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(0, 10, 518, 38);
		contentPanel.add(lblNewLabel_1);

		JLabel lblQuenMatKhau = new JLabel("Quên Mật Khẩu?");
		lblQuenMatKhau.setForeground(Color.BLUE);
		lblQuenMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblQuenMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuenMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuenMatKhau.setBounds(0, 242, 518, 22);
		contentPanel.add(lblQuenMatKhau);
	}

	protected void dangNhap() throws RemoteException {
		String user = txtTenDangNhap.getText();
		String password = String.valueOf(txtMatKhau.getPassword());
		TaiKhoan taiKhoan = taiKhoanFacade.CheckLogin(user, password);
		if (taiKhoan != null) {
			ShareData.taiKhoanDangNhap = taiKhoan;
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
			this.dispose();
		} else {
			MessageDialogHelpers.showErrorDialog(contentPanel, "Lỗi", "Sai tên đăng nhập hoặc mật khẩu");
			return;
		}
	}
}
