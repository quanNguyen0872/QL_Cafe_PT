package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import facade.ChiTietHoaDonFacade;
import facade.HoaDonFacade;
import facade.KhachHangFacade;
import facade.LoaiSanPhamFacade;
import facade.NhanVienFacade;
import facade.SanPhamFacade;
import helpers.Config;
import helpers.ShareData;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.LoaiSanPham;
import model.NhanVien;
import model.SanPham;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnl_BanHang extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> cmbKichCo;
	private Dialog_QuanLyHoaDon dialog_QuanLyHoaDon;

	private JTextField txtTimSDT;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtEmail;
	private JTextField txtSDT;

	private JLabel lblNewLabel_2;

	private JTable tblKhachHang;
	private JTable tblChiTietHoaDon;

	private JTextField txtSoLuong;
	private JTextArea txaDiaChi;

	private JComboBox<String> cmbSanPham;
	private JComboBox<String> cmbLoai;

	private JButton btnTimSDT;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnXemHoaDon;
	private JButton btnThanhToan;

	private DefaultTableModel dfModelKH;
	private DefaultTableModel dfModelCTHD;

	private SanPhamFacade sanPhamFacade;
	private KhachHangFacade khachHangFacade;
	private LoaiSanPhamFacade loaiSanPhamFacade;
	private HoaDonFacade hoaDonFacade;
	private NhanVienFacade nhanVienFacade;
	private ChiTietHoaDonFacade chiTietHoaDonFacade;

	private String tenKhachHang;

	/**
	 * Create the panel.
	 */
	public pnl_BanHang() {

		try {
			sanPhamFacade = (SanPhamFacade) Naming.lookup("rmi://" + Config.getAddress() + "/sanPhamFacade");
			khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://" + Config.getAddress() + "/khachHangFacade");
			loaiSanPhamFacade = (LoaiSanPhamFacade) Naming
					.lookup("rmi://" + Config.getAddress() + "/loaiSanPhamFacade");
			hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://" + Config.getAddress() + "/hoaDonFacade");
			chiTietHoaDonFacade = (ChiTietHoaDonFacade) Naming
					.lookup("rmi://" + Config.getAddress() + "/chiTietHoaDonFacade");
			nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://" + Config.getAddress() + "/nhanVienFacade");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);

		JLabel lblNewLabel = new JLabel("Nhập số điện thoại:");
		lblNewLabel.setFont(tahoma14);

		txtTimSDT = new JTextField();
		txtTimSDT.setFont(tahoma14);
		txtTimSDT.setColumns(10);

		btnTimSDT = new JButton("Tìm");
		btnTimSDT.setIcon(new ImageIcon(getClass().getResource("/imgs/search.png")));
		btnTimSDT.setFocusable(false);
		btnTimSDT.setFont(tahoma14);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(tahoma14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setFont(tahoma14);
		txtMaKH.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(tahoma14);

		txtTenKH = new JTextField();
		txtTenKH.setFont(tahoma14);
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(tahoma14);

		txtEmail = new JTextField();
		txtEmail.setFont(tahoma14);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1_2_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(tahoma14);

		txtSDT = new JTextField();
		txtSDT.setFont(tahoma14);
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);

		lblNewLabel_2 = new JLabel("Địa chỉ:");
		lblNewLabel_2.setFont(tahoma14);

		txaDiaChi = new JTextArea();
		txaDiaChi.setEditable(false);
		txaDiaChi.setFont(tahoma14);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();

		JScrollPane scrollPane_1 = new JScrollPane();

		JPanel panel_1 = new JPanel();

		btnXemHoaDon = new JButton("Xem hóa đơn");
		btnXemHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(0)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(5).addComponent(lblNewLabel_1_1,
										GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(20).addComponent(lblNewLabel_1)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtMaKH, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150,
												Short.MAX_VALUE)
										.addComponent(txtTenKH, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150,
												Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_2_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
												96, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
												45, GroupLayout.PREFERRED_SIZE))
								.addGap(4)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3)
								.addComponent(txtTimSDT, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnTimSDT).addGap(168)
								.addComponent(btnXemHoaDon))
						.addGroup(groupLayout.createSequentialGroup().addGap(6)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 174,
												Short.MAX_VALUE)
										.addComponent(txtSDT, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 174,
												Short.MAX_VALUE))
								.addGap(80)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txaDiaChi, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
				.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(
										txtTimSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTimSDT).addComponent(btnXemHoaDon))
						.addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(txaDiaChi, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(
												txtEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211,
										Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211,
										Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
						.addContainerGap()));

		JLabel lblNewLabel_3 = new JLabel("Chọn loại hàng:");
		lblNewLabel_3.setFont(tahoma14);

		cmbLoai = new JComboBox<String>();
		cmbLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenLoai = cmbLoai.getSelectedItem().toString();
				try {
					List<SanPham> dsSanPham = sanPhamFacade.getDSSanPhamByCategoryName(tenLoai);
					cmbSanPham.removeAllItems();
					for (SanPham sanPham : dsSanPham) {
						cmbSanPham.addItem(sanPham.getTenSanPham());
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel lblNewLabel_3_1 = new JLabel("Sản phẩm:");
		lblNewLabel_3_1.setFont(tahoma14);

		cmbSanPham = new JComboBox<String>();

		JLabel lblNewLabel_3_1_1 = new JLabel("Số lượng:");
		lblNewLabel_3_1_1.setFont(tahoma14);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setFont(tahoma14);

		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnSua.setFont(tahoma14);

		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);
		btnXoa.setFont(tahoma14);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFocusable(false);
		btnLamMoi.setFont(tahoma14);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Kích cỡ:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cmbKichCo = new JComboBox<String>();
		cmbKichCo.addItem("Nhỏ");
		cmbKichCo.addItem("Vừa");
		cmbKichCo.addItem("Lớn");
		cmbKichCo.addItem("Đặt biệt");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
						.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtSoLuong, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
								.addComponent(cmbSanPham, 0, 122, Short.MAX_VALUE)
								.addComponent(cmbLoai, 0, 122, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 107,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
										.addComponent(btnXoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97,
												Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 96,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cmbKichCo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						cmbLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3_1).addComponent(
						cmbSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1_1))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(
						gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbKichCo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addComponent(btnThem).addGap(18).addComponent(btnSua))
						.addGroup(gl_panel.createSequentialGroup().addComponent(btnXoa).addGap(18)
								.addComponent(btnLamMoi)))
				.addContainerGap()));
		panel.setLayout(gl_panel);

		btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFocusable(false);
		btnThanhToan.setFont(tahoma14);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addGap(36)
						.addComponent(btnThanhToan, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE).addGap(27)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(161, Short.MAX_VALUE)
						.addComponent(btnThanhToan, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		tblChiTietHoaDon = new JTable();
		tblChiTietHoaDon.setFont(tahoma14);
		tblChiTietHoaDon.setRowHeight(28);
		tblChiTietHoaDon.setAutoCreateRowSorter(true);
		tblChiTietHoaDon.getTableHeader().setFont(tahoma14);

		tblChiTietHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tblChiTietHoaDon);

		tblKhachHang = new JTable();
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblKhachHang.getSelectedRow();
				if (row >= 0) {
					// set thong tin khach hang
					txtMaKH.setText(tblKhachHang.getValueAt(row, 0).toString());
					txtTenKH.setText(tblKhachHang.getValueAt(row, 1).toString());
					txtEmail.setText(tblKhachHang.getValueAt(row, 2).toString());
					txtSDT.setText(tblKhachHang.getValueAt(row, 3).toString());
					txaDiaChi.setText(tblKhachHang.getValueAt(row, 4).toString());

					// set chi tiet hoa don

				}
			}
		});
		tblKhachHang.setFont(tahoma14);
		tblKhachHang.setRowHeight(28);
		tblKhachHang.setAutoCreateRowSorter(true);
		tblKhachHang.getTableHeader().setFont(tahoma14);

		tblKhachHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblKhachHang);

		setLayout(groupLayout);

		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimSDT.addActionListener(this);
		btnXemHoaDon.addActionListener(this);
		btnXoa.addActionListener(this);

		initTableKH();
		initTableCTHD();
		loadDataComboboxLoaiSP();
		loadDataComboboxSP();
		loadDataTableKH();

		if (ShareData.taiKhoanDangNhap.getQuyen().equals("NhanVien")) {
			btnXemHoaDon.setVisible(false);
		}
	}

	private void initTableKH() {
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

	private void initTableCTHD() {
		dfModelCTHD = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		dfModelCTHD.setColumnIdentifiers(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Đơn giá",
				"Kích thước", "Số lượng", "Thành tiền" });
		tblChiTietHoaDon.setModel(dfModelCTHD);
	}

	private void loadDataComboboxLoaiSP() {
		try {
			List<LoaiSanPham> dsLSP = loaiSanPhamFacade.getDanhSachLoaiSP();
			cmbLoai.removeAllItems();
			for (LoaiSanPham lsp : dsLSP) {
				cmbLoai.addItem(lsp.gettenLoaiSanPham().toString());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void loadDataComboboxSP() {
		try {
			List<SanPham> dsSP = sanPhamFacade.getDanhSachSanPham();
			cmbSanPham.removeAllItems();
			for (SanPham sp : dsSP) {
				cmbSanPham.addItem(sp.getTenSanPham().toString());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void loadDataTableKH() {
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

	private void thanhToan() {
		String maKH, maNV;
		double tongTien = 0;
		DefaultTableModel model = (DefaultTableModel) tblChiTietHoaDon.getModel();
		maKH = txtMaKH.getText();
		maNV = ShareData.taiKhoanDangNhap.getNhanVien().getMaNhanVien();

		for (int i = 0; i < model.getRowCount(); i++) {
			tongTien += Double.parseDouble(model.getValueAt(i, 6).toString());
		}

		HoaDon hoaDon = new HoaDon();
		hoaDon.setNgayLapHoaDon(LocalDate.now());
		hoaDon.setTongTien(tongTien);

		try {
			hoaDon.setKhachHang(khachHangFacade.getKhachHangById(maKH));
			hoaDon.setNhanVien(nhanVienFacade.getNhanVienById(maNV));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			hoaDon = hoaDonFacade.addhoaDon(hoaDon);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		dfModelCTHD.setRowCount(0);
		JOptionPane.showMessageDialog(null, "Lập hóa đơn thành công");
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			String ten, kichthuoc, loai;
			ten = cmbSanPham.getSelectedItem().toString();
			loai = cmbLoai.getSelectedItem().toString();
			kichthuoc = cmbKichCo.getSelectedItem().toString();
			int soluong = Integer.parseInt(txtSoLuong.getText());

			try {
				SanPham sp = sanPhamFacade.getDSSanPhamByTenVaKichCo(ten, kichthuoc);

//				KhachHang kh = khachHangFacade.getKhachHangById(txtMaKH.getText());
//				NhanVien nv = ShareData.taiKhoanDangNhap.getNhanVien();
//				HoaDon hoaDon = new HoaDon(LocalDate.now(), soluong * sp.getDonGia(), kh, nv);
//				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
//				chiTietHoaDon.setHoaDon(hoaDon);
//				chiTietHoaDon.setSoLuong(soluong);
//				chiTietHoaDon.setThanhTien(soluong * sp.getDonGia());
//				chiTietHoaDon.setSanPham(sp);

//				int rowCount = tblChiTietHoaDon.getRowCount();
//				System.out.println(rowCount);

				if (sp == null) {
					JOptionPane.showMessageDialog(null, "Kích thước không có");
					return;
				} else {
					dfModelCTHD.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(), loai,
							sp.getDonGia() + "", sp.getKichCo(), soluong, sp.getDonGia() * soluong });
					return;
				}

			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

		if (o.equals(btnXemHoaDon)) {
			dialog_QuanLyHoaDon = new Dialog_QuanLyHoaDon();
			dialog_QuanLyHoaDon.setVisible(true);
		}

		if (o.equals(btnThanhToan)) {
			if (tblChiTietHoaDon.getRowCount() > 0 && !txtMaKH.getText().equals("")) {
				thanhToan();
			} else {
				JOptionPane.showMessageDialog(null, "Hóa đơn chưa có sản phẩm hoặc khách hàng");

			}
		}

		if (o.equals(btnLamMoi)) {
			clearText();
			dfModelCTHD.setRowCount(0);
			dfModelKH.setRowCount(0);
			loadDataTableKH();
		}

		if (o.equals(btnTimSDT)) {
			try {
				KhachHang kh = khachHangFacade.getKhachHangByPhone(txtTimSDT.getText());
				dfModelKH.setRowCount(0);
				dfModelKH.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getEmail(),
						kh.getsoDienThoai(), kh.getDiaChi() });
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void clearText() {
		txtEmail.setText("");
		txtMaKH.setText("");
		txtSDT.setText("");
		txtSoLuong.setText("");
		txtTenKH.setText("");
		txtTimSDT.setText("");
	}

}
