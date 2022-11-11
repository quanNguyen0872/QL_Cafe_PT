package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


/**
 * @author PC
 * @version 1.0
 * @created 23-Nov-2021 7:53:14 PM
 */
@Entity
public class TaiKhoan implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
//	@Column(columnDefinition = "VARCHAR(10)")
//	@GeneratedValue(generator = "TKGenerator")
//	@GenericGenerator(name = "TKGenerator", strategy = "generator.TaiKhoanGenerator")
	@Column(columnDefinition = "VARCHAR(10)")
	private String maNhanVien;

	@OneToOne
	@MapsId
	@JoinColumn(name = "maNhanVien", columnDefinition = "VARCHAR(10)")
	private NhanVien nhanVien;

	@Column(nullable = false, columnDefinition = "VARCHAR(30)", unique = true)
	private String tenTaiKhoan;

	@Column(nullable = false)
	private String matKhau;

	@Column(nullable = false, columnDefinition = "VARCHAR(15)")
	private String quyen;

	public TaiKhoan() {

	}

	public TaiKhoan(String tenTaiKhoan, String matKhau, Quyen role) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.quyen = role.name(); 
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

//	@Override
//	public String toString() {
//		return "TaiKhoan [maNhanVien=" + maNhanVien + ", nhanVien=" + nhanVien + ", tenTaiKhoan=" + tenTaiKhoan
//				+ ", matKhau=" + matKhau + ", quyen=" + quyen + "]";
//	}
	

}// end Account