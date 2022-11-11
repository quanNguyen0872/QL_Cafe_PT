package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import facade.NhanVienFacade;
import facade.TaiKhoanFacade;
import helpers.Config;
import helpers.MessageDialogHelpers;
import model.NhanVien;
import model.TaiKhoan;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnl_QuanLyNhanVien extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtNamSinh;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;
	private JButton btnThemNhanVien;
	private JButton btnCapNhat;
	private JComboBox<String> cmbTimKiem;
	private DefaultTableModel dfModelNhanVien;
	private JTable tblNhanVien;
	private JButton btnLammoi;
	private JTextArea txaDiaChi;

	private NhanVienFacade nhanVienFacade;
	private TaiKhoanFacade taiKhoanFacade;
	private JTextField txtTim;

	/**
	 * Create the panel.
	 */
	public pnl_QuanLyNhanVien() {
		try {
			nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://" + Config.getAddress() + "/nhanVienFacade");
			taiKhoanFacade = (TaiKhoanFacade) Naming.lookup("rmi://" + Config.getAddress() + "/taiKhoanFacade");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);
		Font tahoma16 = new Font("Tahoma", Font.PLAIN, 16);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
						.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addContainerGap()));

		tblNhanVien = new JTable();
		tblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblNhanVien.getSelectedRow();
				if (row >= 0) {
					txtMaNhanVien.setText(tblNhanVien.getValueAt(row, 0).toString());
					txtTenNhanVien.setText(tblNhanVien.getValueAt(row, 1).toString());
					txtNamSinh.setText(tblNhanVien.getValueAt(row, 2).toString());
					txtEmail.setText(tblNhanVien.getValueAt(row, 3).toString());
					txtSoDienThoai.setText(tblNhanVien.getValueAt(row, 4).toString());
					txaDiaChi.setText(tblNhanVien.getValueAt(row, 5).toString());
				}
			}
		});
		scrollPane.setColumnHeaderView(tblNhanVien);

		tblNhanVien.setFont(tahoma16);
		tblNhanVien.setRowHeight(28);
		tblNhanVien.setAutoCreateRowSorter(true);
		tblNhanVien.getTableHeader().setFont(tahoma16);

		tblNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblNhanVien);

		btnThemNhanVien = new JButton("Thêm");
		btnThemNhanVien.setFocusable(false);
		btnThemNhanVien.setFont(tahoma16);

		btnCapNhat = new JButton("Cập nhật ");
		btnCapNhat.setFocusable(false);
		btnCapNhat.setFont(tahoma16);

		btnLammoi = new JButton("Làm mới");
		btnLammoi.setFocusable(false);
		btnLammoi.setFont(tahoma16);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnLammoi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCapNhat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnThemNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140,
										Short.MAX_VALUE))
						.addContainerGap(24, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(btnThemNhanVien, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnLammoi, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(387, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setFont(tahoma14);

		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1.setFont(tahoma14);

		JLabel lblNewLabel_2 = new JLabel("Năm sinh:");
		lblNewLabel_2.setFont(tahoma14);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(tahoma14);

		JLabel lblNewLabel_3_1 = new JLabel("Số điện thoại:");
		lblNewLabel_3_1.setFont(tahoma14);

		JLabel lblNewLabel_3_1_1 = new JLabel("Đại chỉ:");
		lblNewLabel_3_1_1.setFont(tahoma14);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(tahoma14);
		txtMaNhanVien.setColumns(10);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setFont(tahoma14);
		txtTenNhanVien.setColumns(10);

		txtNamSinh = new JTextField();
		txtNamSinh.setFont(tahoma14);
		txtNamSinh.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(tahoma14);
		txtEmail.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(tahoma14);
		txtSoDienThoai.setColumns(10);

		txaDiaChi = new JTextArea();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104,
										Short.MAX_VALUE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104,
										Short.MAX_VALUE))
						.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addGap(22)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txaDiaChi, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(txtSoDienThoai, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(txtEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(txtNamSinh, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(txtTenNhanVien, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416,
								Short.MAX_VALUE)
						.addComponent(txtMaNhanVien, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(23)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(txtMaNhanVien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txaDiaChi, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(13, Short.MAX_VALUE)));

		panel_1.setLayout(gl_panel_1);

		cmbTimKiem = new JComboBox<String>();
		cmbTimKiem.addItem("Tìm kiếm theo tên nhân viên");
		cmbTimKiem.addItem("Tìm kiếm theo mã nhân viên");
		cmbTimKiem.setFocusable(false);

		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search(txtTim.getText());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(144)
					.addComponent(cmbTimKiem, 0, 1, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTim, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(261))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		btnLammoi.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnThemNhanVien.addActionListener(this);

		initTable();
		loadDataTable();
	}

	private void initTable() {
		dfModelNhanVien = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		dfModelNhanVien.setColumnIdentifiers(
				new String[] { "Mã nhân viên", "Tên nhân viên", "Năm sinh", "Email", "Số điện thoại", "Địa chỉ" });
		tblNhanVien.setModel(dfModelNhanVien);
	}

	private void loadDataTable() {
		try {
			List<NhanVien> nv = nhanVienFacade.getDanhSachNV();
			for (NhanVien NhanVien : nv) {
				dfModelNhanVien.addRow(new Object[] { NhanVien.getMaNhanVien(), NhanVien.getTenNhanVien(),
						NhanVien.getNamSinh(), NhanVien.getEmail(), NhanVien.getSoDienThoai(), NhanVien.getDiaChi() });
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private NhanVien createNhanVien() {
		NhanVien nv = new NhanVien();
		nv.setTenNhanVien(txtTenNhanVien.getText());
		nv.setSoDienThoai(txtSoDienThoai.getText());
		nv.setDiaChi(txaDiaChi.getText());
		nv.setNamSinh(txtNamSinh.getText());
		nv.setEmail(txtEmail.getText());
		return nv;
	}

	private void clearText() {
		txtTenNhanVien.setText("");
		txtNamSinh.setText("");
		txtEmail.setText("");
		txtMaNhanVien.setText("");
		txtSoDienThoai.setText("");
		txaDiaChi.setText("");
		txtTenNhanVien.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnCapNhat)) {
			NhanVien nv = createNhanVien();
			try {
				int isSua = MessageDialogHelpers.showConfirmDialog(tblNhanVien, "Cảnh báo",
						"Bạn có chắc muốn cập nhật khách hàng này?");
				if (isSua == JOptionPane.NO_OPTION) {
					return;
				} else if (isSua == JOptionPane.CLOSED_OPTION) {
					return;
				}

				nv.setMaNhanVien(txtMaNhanVien.getText().toString());
				nhanVienFacade.updateNhanVien(nv);
				clearText();
				dfModelNhanVien.setRowCount(0);
				loadDataTable();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

		if (o.equals(btnLammoi)) {
			clearText();
			dfModelNhanVien.setRowCount(0);
			loadDataTable();
			cmbTimKiem.setSelectedIndex(0);
		}

		if (o.equals(btnThemNhanVien)) {
			try {
				NhanVien nv = createNhanVien();
				nv = nhanVienFacade.addNhanVien(nv);
				TaiKhoan taiKhoan = taiKhoanFacade.taoTaiKhoan(nv.getMaNhanVien(), "a123456", nv);
				nv.setTaiKhoan(taiKhoan);
				dfModelNhanVien.setRowCount(0);
				loadDataTable();
				clearText();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		}

	}

	public void search(String str) {
		dfModelNhanVien = (DefaultTableModel) tblNhanVien.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dfModelNhanVien);
		tblNhanVien.setRowSorter(trs);

		if (cmbTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên nhân viên")) {
			trs.setRowFilter(RowFilter.regexFilter(str, 1));
		}

		if (cmbTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo mã nhân viên")) {
			trs.setRowFilter(RowFilter.regexFilter(str, 0));
		}
	}
}
