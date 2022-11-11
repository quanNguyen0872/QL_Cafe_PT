package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import facade.ChiTietHoaDonFacade;
import facade.HoaDonFacade;
import helpers.Config;
import model.ChiTietHoaDon;
import model.HoaDon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dialog_QuanLyHoaDon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblHoaDon;
	private JTextField txtMaNV;
	private JTextField txtTenKH;
	private JTextField txtNgayLap;
	private JTextField txtTongTien;
	private DefaultTableModel dfModelHD;

	private HoaDonFacade hoaDonFacade;
	private JTextField txtMaHD;
	private JTable tblCTHD;
	private JButton btnLammoi;
	private DefaultTableModel dfModelCTHD;

	private ChiTietHoaDonFacade chiTietHoaDonFacade;

	/**
	 * Create the dialog.
	 */
	public Dialog_QuanLyHoaDon() {
		try {
			hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://" + Config.getAddress() + "/hoaDonFacade");
			chiTietHoaDonFacade = (ChiTietHoaDonFacade) Naming
					.lookup("rmi://" + Config.getAddress() + "/chiTietHoaDonFacade");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		setBounds(100, 100, 765, 543);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		setLocationRelativeTo(null);
		setSize(790, 545);
		setResizable(false);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaHD.setColumns(10);

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);

		JLabel lblNgyLpHa = new JLabel("Ngày lập hóa đơn:");
		lblNgyLpHa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMKhchHng = new JLabel("Tên khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);

		txtNgayLap = new JTextField();
		txtNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayLap.setEditable(false);
		txtNgayLap.setColumns(10);

		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(null);

		btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
				dfModelHD.setRowCount(0);
				loadDataTableHD();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMNhnVin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96,
										Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMaNV, 127, 127, 127)
								.addComponent(txtMaHD, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblMKhchHng, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblNgyLpHa, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTenKH, 142, 142, 142)
								.addComponent(txtNgayLap, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
						.addGap(18).addComponent(lblTngTin, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTongTien, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(btnLammoi, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGap(620))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(txtMaHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgyLpHa, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayLap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTngTin, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTongTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblMNhnVin)
								.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnLammoi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_1,
				GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_1,
				GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE));

		tblCTHD = new JTable();
		tblCTHD.setRowHeight(28);
		tblCTHD.setAutoCreateRowSorter(true);

		tblCTHD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(tblCTHD);

		panel.setLayout(gl_panel);

		tblHoaDon = new JTable();
		tblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblHoaDon.getSelectedRow();
				if (row >= 0) {
					try {
						HoaDon hoaDon = hoaDonFacade.gethoaDonById(tblHoaDon.getValueAt(row, 0).toString());
						txtMaHD.setText(hoaDon.getMaHoaDon());
						txtTenKH.setText(hoaDon.getKhachHang().getTenKhachHang());
						LocalDate ngayLap = hoaDon.getNgayLapHoaDon();
						String ngayLapFormat = ngayLap.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
						txtNgayLap.setText(ngayLapFormat);
						txtMaNV.setText(hoaDon.getNhanVien().getMaNhanVien());
						txtTongTien.setText(String.valueOf(hoaDon.getTongTien()));

						List<ChiTietHoaDon> dsCTHD = chiTietHoaDonFacade.getDanhSachCTHDByIdHD(txtMaHD.getText());
						for (ChiTietHoaDon cthd : dsCTHD) {
							dfModelCTHD.addRow(
									new Object[] { cthd.getSanPham().getMaSanPham(), cthd.getSanPham().getTenSanPham(),
											cthd.getSanPham().getLoaiSanPham().gettenLoaiSanPham(),
											cthd.getSanPham().getDonGia(), cthd.getSanPham().getKichCo(),
											cthd.getSoLuong(), cthd.getThanhTien() });
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		contentPanel.setLayout(gl_contentPanel);
		tblHoaDon.setRowHeight(28);
		tblHoaDon.setAutoCreateRowSorter(true);

		tblHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblHoaDon);
		initTableHD();
		loadDataTableHD();
		initTableCTHD();
	}

	private void initTableHD() {
		dfModelHD = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		dfModelHD.setColumnIdentifiers(
				new String[] { "Mã hóa đơn", "Ngày lập", "Tên khách hàng", "Nhân viên lập", "Tổng tiền" });
		tblHoaDon.setModel(dfModelHD);
	}

	private void loadDataTableHD() {
		try {
			List<HoaDon> listhd = hoaDonFacade.getDanhSachHoaDon();
			for (HoaDon hoaDon : listhd) {
				dfModelHD.addRow(new Object[] { hoaDon.getMaHoaDon(), hoaDon.getNgayLapHoaDon(),
						hoaDon.getKhachHang().getTenKhachHang(), hoaDon.getNhanVien().getTenNhanVien(),
						hoaDon.getTongTien() });
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void clearText() {
		txtMaHD.setText("");
		txtMaNV.setText("");
		txtNgayLap.setText("");
		txtTenKH.setText("");
		txtTongTien.setText("");
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
		tblCTHD.setModel(dfModelCTHD);
	}
}
