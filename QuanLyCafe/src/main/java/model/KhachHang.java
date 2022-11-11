package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author PC
 * @version 1.0
 * @created 23-Nov-2021 7:53:14 PM
 */
@Entity
public class KhachHang implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "VARCHAR(10)")
	@GeneratedValue(generator = "KHGenerator")
	@GenericGenerator(name = "KHGenerator", strategy = "generator.KhachHangGenerator")
	private String maKhachHang;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String tenKhachHang;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String diaChi;

	@Column(nullable = false, columnDefinition = "VARCHAR(10)")
	private String soDienThoai;

	@Column(nullable = false, columnDefinition = "VARCHAR(30)")
	private String email;

	public KhachHang() {

	}

	public KhachHang(String maKhachHang, String tenKhachHang, String diaChi, String soDienThoai, String email) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getsoDienThoai() {
		return soDienThoai;
	}

	public void setsoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}

}// end Customer
