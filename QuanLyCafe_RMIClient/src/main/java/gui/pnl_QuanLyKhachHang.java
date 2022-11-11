package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import facade.KhachHangFacade;
import helpers.Config;
import helpers.MessageDialogHelpers;
import model.KhachHang;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class pnl_QuanLyKhachHang extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTimKH;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKH;
	private JTextField txtEmail;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	private JButton btnTim;
	protected JButton btnThem;
	protected JButton btnCapNhat;
	protected JButton btnLammoi;
	private JTable tblKhachHang;
	private DefaultTableModel dfModelKH;

	private KhachHangFacade khachHangFacade;
	private JComboBox<String> cmbControlSearch;

	/**
	 * Create the panel.
	 */
	public pnl_QuanLyKhachHang() {

		try {
			khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://"+ Config.getAddress() +"/khachHangFacade");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
		);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE).addGap(11)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addContainerGap()));

		tblKhachHang = new JTable();
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblKhachHang.getSelectedRow();
				if (row >= 0) {
					txtMaKhachHang.setText(tblKhachHang.getValueAt(row, 0).toString());
					txtTenKH.setText(tblKhachHang.getValueAt(row, 1).toString());
					txtEmail.setText(tblKhachHang.getValueAt(row, 2).toString());
					txtSoDT.setText(tblKhachHang.getValueAt(row, 3).toString());
					txtDiaChi.setText(tblKhachHang.getValueAt(row, 4).toString());
				}
			}
		});
		tblKhachHang.setFont(tahoma14);
		tblKhachHang.setRowHeight(28);
		tblKhachHang.setAutoCreateRowSorter(true);
		tblKhachHang.getTableHeader().setFont(tahoma14);

		tblKhachHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblKhachHang);
		panel_1.setLayout(gl_panel_1);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setFont(tahoma14);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFocusable(false);
		btnCapNhat.setFont(tahoma14);

		btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(tahoma14);
		btnLammoi.setFocusable(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(18)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLammoi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
				.addGap(19)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(54).addComponent(btnThem).addGap(18)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnLammoi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(106, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		txtTimKH = new JTextField();
		txtTimKH.setFont(tahoma14);
		txtTimKH.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(getClass().getResource("/imgs/search.png")));
		btnTim.setFocusable(false);
		btnTim.setFont(tahoma14);

		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(tahoma14);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(tahoma14);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(tahoma14);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(tahoma14);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(tahoma14);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setFont(tahoma14);
		txtMaKhachHang.setColumns(10);

		txtTenKH = new JTextField();
		txtTenKH.setFont(tahoma14);
		txtTenKH.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(tahoma14);
		txtEmail.setColumns(10);

		txtSoDT = new JTextField();
		txtSoDT.setFont(tahoma14);
		txtSoDT.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(tahoma14);
		txtDiaChi.setColumns(10);
		
		cmbControlSearch = new JComboBox<String>();
		cmbControlSearch.addItem("Tìm theo tên");
		cmbControlSearch.addItem("Tìm theo số điện thoại");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblaCh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSinThoi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTnKhchHng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cmbControlSearch, 0, 78, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTimKH, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTim)
							.addGap(128))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMaKhachHang, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
								.addComponent(txtTenKH, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
								.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
								.addComponent(txtSoDT, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
								.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTimKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbControlSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtMaKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		btnCapNhat.addActionListener(this);
		btnLammoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);

		initTable();
		loadDataTable();
	}

	private void initTable() {
		dfModelKH = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		dfModelKH.setColumnIdentifiers(
				new String[] { "Mã khách hàng", "Tên khách hàng", "Email", "Số điện thoại", "Địa chỉ" });
		tblKhachHang.setModel(dfModelKH);
	}

	private void loadDataTable() {
		try {
			List<KhachHang> khs = khachHangFacade.getDanhSachKH();
			for (KhachHang khachHang : khs) {
				dfModelKH.addRow(new Object[] { khachHang.getMaKhachHang(), khachHang.getTenKhachHang(),
						khachHang.getEmail(), khachHang.getsoDienThoai(), khachHang.getDiaChi() });
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}

	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();

		if (o.equals(btnThem)) {
			KhachHang kh = createKhachHang();
			try {
				khachHangFacade.addKhachHang(kh);
				clearText();
				dfModelKH.setRowCount(0);
				loadDataTable();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

		if (o.equals(btnCapNhat)) {
			KhachHang kh = createKhachHang();
			try {
				int isSua = MessageDialogHelpers.showConfirmDialog(tblKhachHang, "Cảnh báo","Bạn có chắc muốn cập nhật khách hàng này?");
				if (isSua == JOptionPane.NO_OPTION) {
					return;
				} else if (isSua == JOptionPane.CLOSED_OPTION) {
					return;
				}
				
				kh.setMaKhachHang(txtMaKhachHang.getText().toString());
				khachHangFacade.updateKhachHang(kh);
				clearText();
				dfModelKH.setRowCount(0);
				loadDataTable();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

		if (o.equals(btnLammoi)) {
			clearText();
			dfModelKH.setRowCount(0);
			loadDataTable();
			cmbControlSearch.setSelectedIndex(0);
		}
		
		if (o.equals(btnTim)) {
			try {
				if(cmbControlSearch.getSelectedItem().equals("Tìm theo tên")) {
				List<KhachHang> listKH = khachHangFacade.getDSKhachHangByName(txtTimKH.getText().toString());
				dfModelKH.setRowCount(0);
				for (KhachHang kh : listKH) {
					dfModelKH.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(),
							kh.getEmail(), kh.getsoDienThoai(), kh.getDiaChi() });
				}
				}
				else if(cmbControlSearch.getSelectedItem().equals("Tìm theo số điện thoại")) {
					KhachHang kh = khachHangFacade.getKhachHangByPhone(txtTimKH.getText());
					dfModelKH.setRowCount(0);
					
						dfModelKH.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(),
								kh.getEmail(), kh.getsoDienThoai(), kh.getDiaChi() });
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
		}

	}

	private KhachHang createKhachHang() {
		KhachHang kh = new KhachHang();
		kh.setTenKhachHang(txtTenKH.getText());
		kh.setsoDienThoai(txtSoDT.getText());
		kh.setDiaChi(txtDiaChi.getText());
		kh.setEmail(txtEmail.getText());
		return kh;
	}

	private void clearText() {
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtMaKhachHang.setText("");
		txtSoDT.setText("");
		txtTimKH.setText("");
		txtTenKH.requestFocus();
	}
}
