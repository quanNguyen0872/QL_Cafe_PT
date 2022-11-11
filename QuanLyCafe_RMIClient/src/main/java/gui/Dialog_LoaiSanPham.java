package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import facade.LoaiSanPhamFacade;
import helpers.Config;
import helpers.MessageDialogHelpers;
import model.LoaiSanPham;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Dialog_LoaiSanPham extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTable tblLoaiSanPham;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnDong;
	private LoaiSanPhamFacade loaiSanPhamFacade;

	private DefaultTableModel dfModelLsp;
	private JButton btnLammoi;

	/**
	 * Create the dialog.
	 */
	public Dialog_LoaiSanPham() {

		try {
			loaiSanPhamFacade = (LoaiSanPhamFacade) Naming.lookup("rmi://"+ Config.getAddress() +"/loaiSanPhamFacade");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		Font tahoma14 = new Font("Tahoma", Font.PLAIN, 14);
		setBounds(100, 100, 450, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Mã loại sản phẩm:");
		lblNewLabel.setFont(tahoma14);

		txtMaLoai = new JTextField();
		txtMaLoai.setEditable(false);
		txtMaLoai.setFont(tahoma14);
		txtMaLoai.setColumns(10);

		JLabel lblTnLoiSn = new JLabel("Tên loại sản phẩm:");
		lblTnLoiSn.setFont(tahoma14);

		txtTenLoai = new JTextField();
		txtTenLoai.setFont(tahoma14);
		txtTenLoai.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		btnDong = new JButton("Đóng");
		btnDong.setFocusable(false);
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDong.setFont(tahoma14);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiSanPham lsp = new LoaiSanPham();
				lsp.settenLoaiSanPham(txtTenLoai.getText());
				try {
					if (loaiSanPhamFacade.addLoaiSanPham(lsp)) {
						MessageDialogHelpers.showMessageDialog(scrollPane, "Thông báo", "Thêm thành công");
						dfModelLsp.setRowCount(0);
						loadDataTable();
						txtTenLoai.setText("");
						txtTenLoai.requestFocus();
					} else {
						MessageDialogHelpers.showErrorDialog(scrollPane, "Lỗi", "Thêm thất bại");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnThem.setFont(tahoma14);

		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiSanPham lsp = new LoaiSanPham();
				int row = tblLoaiSanPham.getSelectedRow();
				if (row >= 0) {
					lsp.setMaLoaiSanPham(tblLoaiSanPham.getValueAt(row, 0).toString());
					lsp.settenLoaiSanPham(txtTenLoai.getText());
					try {
						int isSua = MessageDialogHelpers.showConfirmDialog(scrollPane, "Cảnh báo",
								"Bạn có chắc muốn sửa loại sản phẩm này?");
						if (isSua == JOptionPane.NO_OPTION) {
							return;
						} else if (isSua == JOptionPane.CLOSED_OPTION) {
							return;
						}

						if (loaiSanPhamFacade.updateLoaiSanPham(lsp)) {
							MessageDialogHelpers.showMessageDialog(scrollPane, "Thông báo", "Sửa thành công");
							dfModelLsp.setRowCount(0);
							loadDataTable();
						} else {
							MessageDialogHelpers.showErrorDialog(scrollPane, "Lỗi", "Sửa thất bại");
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				} else {
					MessageDialogHelpers.showErrorDialog(scrollPane, "Lỗi", "Phải chọn 1 loại sản phẩm");
				}
			}
		});
		btnSua.setFont(tahoma14);

		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tblLoaiSanPham.getSelectedRow();
				if (row >= 0) {
					try {
						int isXoa = MessageDialogHelpers.showConfirmDialog(scrollPane, "Cảnh báo",
								"Bạn có chắc muốn xóa loại sản phẩm này?");
						if (isXoa == JOptionPane.NO_OPTION) {
							return;
						} else if (isXoa == JOptionPane.CLOSED_OPTION) {
							return;
						}

						if (loaiSanPhamFacade.deleteLoaiSanPham(tblLoaiSanPham.getValueAt(row, 0).toString())) {
							MessageDialogHelpers.showMessageDialog(scrollPane, "Thông báo", "Xóa thành công");
							dfModelLsp.setRowCount(0);
							loadDataTable();
						} else {
							MessageDialogHelpers.showErrorDialog(scrollPane, "Lỗi", "Xóa thất bại");
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				} else {
					MessageDialogHelpers.showErrorDialog(scrollPane, "Lỗi", "Phải chọn 1 loại sản phẩm");
				}
			}
		});
		btnXoa.setFont(tahoma14);

		btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaLoai.setText("");
				txtTenLoai.setText("");
				dfModelLsp.setRowCount(0);
				loadDataTable();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLammoi.setFocusable(false);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtMaLoai, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblTnLoiSn, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTenLoai, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
								.addComponent(btnDong, Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnThem)
							.addGap(18)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLammoi)
							.addContainerGap())))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtMaLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTnLoiSn, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnThem)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLammoi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDong)
					.addContainerGap())
		);

		tblLoaiSanPham = new JTable();
		tblLoaiSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblLoaiSanPham.getSelectedRow();
				if (row >= 0) {
					txtMaLoai.setText(tblLoaiSanPham.getValueAt(row, 0).toString());
					txtTenLoai.setText(tblLoaiSanPham.getValueAt(row, 1).toString());
				}
			}
		});
		scrollPane.setColumnHeaderView(tblLoaiSanPham);
		contentPanel.setLayout(gl_contentPanel);

		initTable();
		loadDataTable();
	}

	private void initTable() {
		dfModelLsp = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		dfModelLsp.setColumnIdentifiers(new String[] { "Mã loại sản phẩm", "Tên loại sản phẩm" });
		tblLoaiSanPham.setModel(dfModelLsp);
	}

	private void loadDataTable() {
		try {
			List<LoaiSanPham> dsLoaiSanPham = loaiSanPhamFacade.getDanhSachLoaiSP();
			for (LoaiSanPham lsp : dsLoaiSanPham) {
				dfModelLsp.addRow(new Object[] { lsp.getMaLoaiSanPham(), lsp.gettenLoaiSanPham() });
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
