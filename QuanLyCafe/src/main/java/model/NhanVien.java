package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author PC
 * @version 1.0
 * @created 23-Nov-2021 7:53:15 PM
 */
@Entity
public class NhanVien implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "VARCHAR(10)")
	@GeneratedValue(generator = "NVGenerator")
	@GenericGenerator(name = "NVGenerator", strategy = "generator.NhanVienGenerator")
	private String maNhanVien;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String tenNhanVien;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String diaChi;

	@Column(nullable = false, columnDefinition = "VARCHAR(30)")
	private String namSinh;

	@Column(nullable = false, columnDefinition = "VARCHAR(30)")
	private String email;

	@Column(nullable = false, columnDefinition = "VARCHAR(10)")
	private String soDienThoai;

	@OneToOne
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ma_tai_khoan",referencedColumnName = "maTaiKhoan")
//	private TaiKhoan taiKhoan;

	public NhanVien() {

	}

	public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, String namSinh, String email,
			String soDienThoai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, String namSinh, String email,
			String soDienThoai, TaiKhoan taiKhoan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

//	@Override
//	public String toString() {
//		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi
//				+ ", namSinh=" + namSinh + ", email=" + email + ", soDienThoai=" + soDienThoai + ", taiKhoan="
//				+ taiKhoan + "]";
//	}

}// end Staff