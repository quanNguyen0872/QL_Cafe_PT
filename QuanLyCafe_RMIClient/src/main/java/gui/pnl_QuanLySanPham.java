package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import facade.LoaiSanPhamFacade;
import facade.SanPhamFacade;
import helpers.Config;
import helpers.MessageDialogHelpers;
import model.LoaiSanPham;
import model.SanPham;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.ImageIcon;

public class pnl_QuanLySanPham extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JButton btnTim;
	private JTextField txtDonGia;
	private JTextField txtMaSanPham;
	private JTextField txtTenSanPham;
	private JTable tblSanPham;
	private JComboBox<String> cmbLoaiSanPham;
	private DefaultTableModel dfModelSanPham;
	private JButton btnLoaiSanPham;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLammoi;
	private SanPhamFacade sanPhamFacade;
	private LoaiSanPhamFacade loaiSanPhamFacade;
	private JComboBox<String> cmbKichCo;
	private JComboBox<String> cmbTimKiem;


	/**
	 * Create the panel.
	 */
	public pnl_QuanLySanPham() {

		try {
			sanPhamFacade = (SanPhamFacade) Naming.lookup("rmi://"+ Config.getAddress() +"/sanPhamFacade");
			loaiSanPhamFacade = (LoaiSanPhamFacade) Naming.lookup("rmi://"+ Config.getAddress() +"/loaiSanPhamFacade");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addComponent(panel, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)));

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(tahoma14);
		txtTimKiem.setColumns(10);
		
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search(txtTimKiem.getText());
			}
		});

		btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon(getClass().getResource("/imgs/search.png")));
		btnTim.setFont(tahoma14);

		JLabel lblNewLabel = new JLabel("Mã sản phẩm:");
		lblNewLabel.setFont(tahoma14);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(tahoma14);

		JLabel lblLoiSnPhm = new JLabel("Loại sản phẩm:");
		lblLoiSnPhm.setFont(tahoma14);

		JLabel lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(tahoma14);

		JLabel lblKchThc = new JLabel("Kích thước:");
		lblKchThc.setFont(tahoma14);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setEditable(false);
		txtMaSanPham.setFont(tahoma14);
		txtMaSanPham.setColumns(10);

		txtTenSanPham = new JTextField();
		txtTenSanPham.setFont(tahoma14);
		txtTenSanPham.setColumns(10);

		txtDonGia = new JTextField();
		txtDonGia.setFont(tahoma14);
		txtDonGia.setColumns(10);

		cmbLoaiSanPham = new JComboBox<String>();
		cmbLoaiSanPham.setFont(tahoma14);

		btnLoaiSanPham = new JButton("Xem loại sản phẩm");
		btnLoaiSanPham.setFont(tahoma14);
		
		cmbKichCo = new JComboBox<String>();
		cmbKichCo.addItem("Nhỏ");
		cmbKichCo.addItem("Vừa");
		cmbKichCo.addItem("Lớn");
		cmbKichCo.addItem("Đặt biệt");
		cmbKichCo.setFont(tahoma14);
		
		cmbTimKiem = new JComboBox<String>();
		cmbTimKiem.addItem("Tìm kiếm theo tên sản phẩm");
		cmbTimKiem.addItem("Tìm kiếm theo mã sản phẩm");
		cmbTimKiem.setFocusable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblnGi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblLoiSnPhm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTnSnPhm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(cmbTimKiem, 0, 183, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnTim))
								.addComponent(txtMaSanPham, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
								.addComponent(txtTenSanPham, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
								.addComponent(txtDonGia, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(cmbLoaiSanPham, 0, 535, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoaiSanPham))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblKchThc, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbKichCo, 0, 694, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTim)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(cmbTimKiem, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtMaSanPham, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenSanPham, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLoiSnPhm, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbLoaiSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoaiSanPham, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnGi, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKchThc, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbKichCo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setFont(tahoma14);

		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnSua.setFont(tahoma14);

		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);
		btnXoa.setFont(tahoma14);

		btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(tahoma14);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(btnLammoi, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
						.addGap(14)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(51)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnLammoi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(98, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE).addContainerGap()));

		tblSanPham = new JTable();
		tblSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblSanPham.getSelectedRow();
				if (row >= 0) {
					txtMaSanPham.setText(tblSanPham.getValueAt(row, 0).toString());
					txtTenSanPham.setText(tblSanPham.getValueAt(row, 1).toString());
					cmbLoaiSanPham.setSelectedItem(tblSanPham.getValueAt(row, 2));
					txtDonGia.setText(tblSanPham.getValueAt(row, 3).toString());
					cmbKichCo.setSelectedItem(tblSanPham.getValueAt(row, 4));
				}
			}
		});
		tblSanPham.setFont(tahoma14);
		tblSanPham.setRowHeight(28);
		tblSanPham.setAutoCreateRowSorter(true);
		tblSanPham.getTableHeader().setFont(tahoma14);

		tblSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblSanPham);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);

		btnLammoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		btnLoaiSanPham.addActionListener(this);

		initTable();
		loadDataTable();
		loadDataComboboxLoaiSP();
	}

	private void initTable() {
		dfModelSanPham = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		dfModelSanPham.setColumnIdentifiers(
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá",  "Kích thước" });
		tblSanPham.setModel(dfModelSanPham);
	}

	private void loadDataTable() {
		try {
			List<SanPham> dsSanPham = sanPhamFacade.getDanhSachSanPham();
			for (SanPham sp : dsSanPham) {
				dfModelSanPham.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(),
						sp.getLoaiSanPham().gettenLoaiSanPham(), sp.getDonGia(), sp.getKichCo() });
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private void loadDataComboboxLoaiSP() {
		try {
			List<LoaiSanPham> dsLSP = loaiSanPhamFacade.getDanhSachLoaiSP();
			for (LoaiSanPham lsp : dsLSP) {
				cmbLoaiSanPham.addItem(lsp.gettenLoaiSanPham().toString());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}

	private void clearText() {
		txtDonGia.setText("");
		txtMaSanPham.setText("");
		cmbKichCo.setSelectedIndex(0);
		txtTenSanPham.setText("");
		txtTimKiem.setText("");
		txtTenSanPham.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnLoaiSanPham)) {
			Dialog_LoaiSanPham dialog_LoaiSanPham = new Dialog_LoaiSanPham();
			dialog_LoaiSanPham.setVisible(true);
		}

		if (o.equals(btnThem)) {
			try {
				SanPham sp = createSanPham();
				if (sanPhamFacade.addSanPham(sp)) {
					MessageDialogHelpers.showMessageDialog(tblSanPham, "Thông báo", "Thêm sản phẩm thành công");
					dfModelSanPham.setRowCount(0);
					loadDataTable();
					clearText();
				} else {
					MessageDialogHelpers.showErrorDialog(tblSanPham, "Lỗi", "Thêm không thành công");
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			} // end try
		} // end if

		if (o.equals(btnSua)) {
			int row = tblSanPham.getSelectedRow();
			if (row >= 0) {
				try {
					SanPham sp = createSanPham();
					sp.setMaSanPham(tblSanPham.getValueAt(row, 0).toString());
					
					int isSua = MessageDialogHelpers.showConfirmDialog(tblSanPham, "Cảnh báo","Bạn có chắc muốn sửa sản phẩm này?");
					if (isSua == JOptionPane.NO_OPTION) {
						return;
					} else if (isSua == JOptionPane.CLOSED_OPTION) {
						return;
					}

					if (sanPhamFacade.updateSanPham(sp)) {
						dfModelSanPham.setRowCount(0);
						loadDataTable();
						MessageDialogHelpers.showMessageDialog(tblSanPham, "Thông báo", "Cập nhật sản phẩm thành công");
					} else {
						MessageDialogHelpers.showErrorDialog(tblSanPham, "Lỗi", "Cập nhật không thành công");
					}

				} catch (RemoteException e1) {
					e1.printStackTrace();
				} // end try
			} // end if
			else {
				MessageDialogHelpers.showErrorDialog(tblSanPham, "Lỗi", "Phải chọn 1 dòng trong bảng");
			}
		}

		if (o.equals(btnXoa)) {
			int row = tblSanPham.getSelectedRow();
			if (row >= 0) {
				String maSanPham = tblSanPham.getValueAt(row, 0).toString();
				try {	
					int isXoa = MessageDialogHelpers.showConfirmDialog(tblSanPham, "Cảnh báo","Bạn có chắc muốn xóa sản phẩm này?");
					if (isXoa == JOptionPane.NO_OPTION) {
						return;
					} else if (isXoa == JOptionPane.CLOSED_OPTION) {
						return;
					}

					if (sanPhamFacade.deleteSanPham(maSanPham)) {
						MessageDialogHelpers.showMessageDialog(tblSanPham, "Thông báo", "Xóa sản phẩm thành công");
						dfModelSanPham.setRowCount(0);
						loadDataTable();
					} else {
						MessageDialogHelpers.showErrorDialog(tblSanPham, "Lỗi", "Xóa không thành công");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} // end try
			} // end if
			else {
				MessageDialogHelpers.showErrorDialog(tblSanPham, "Lỗi", "Phải chọn 1 dòng trong bảng");
			}

		} // end if

		if (o.equals(btnLammoi)) {
			clearText();
			dfModelSanPham.setRowCount(0);
			loadDataTable();
			cmbLoaiSanPham.removeAllItems();
			loadDataComboboxLoaiSP();
		}
		
		if (o.equals(btnTim)) {
			try {
				List<SanPham> dsSanPham = sanPhamFacade.getDSSanPhamByName(txtTimKiem.getText());
				dfModelSanPham.setRowCount(0);
				if (dsSanPham != null) {
					for (SanPham sp: dsSanPham) {
						dfModelSanPham.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(),
								sp.getLoaiSanPham().gettenLoaiSanPham(), sp.getDonGia(), sp.getKichCo() });
					}
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	}

	private SanPham createSanPham() {
		SanPham sp = new SanPham();
		try {
			sp.setTenSanPham(txtTenSanPham.getText());
			
			String maLoai = loaiSanPhamFacade.getMaLoaiTheoTen(cmbLoaiSanPham.getSelectedItem().toString());
			LoaiSanPham lsp = loaiSanPhamFacade.getLoaiSanPhamById(maLoai);
			sp.setLoaiSanPham(lsp);
			
			sp.setDonGia(Double.parseDouble(txtDonGia.getText()));
			sp.setKichCo(cmbKichCo.getSelectedItem().toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return sp;
	}
	
	public void search(String str) {
		dfModelSanPham = (DefaultTableModel) tblSanPham.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dfModelSanPham);
		tblSanPham.setRowSorter(trs);
		
		if (cmbTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo mã sản phẩm")) {
			trs.setRowFilter(RowFilter.regexFilter(str, 0));
		}
		
		if (cmbTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên sản phẩm")) {
			trs.setRowFilter(RowFilter.regexFilter(str, 1));
		}
	}
}
