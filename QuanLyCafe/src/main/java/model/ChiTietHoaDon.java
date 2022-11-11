package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author PC
 * @version 1.0
 * @created 23-Nov-2021 7:53:14 PM
 */
@Entity
@IdClass(ChiTietHoaDon_PK.class)
public class ChiTietHoaDon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon", columnDefinition = "VARCHAR(10)")
	private HoaDon hoaDon;

	@Id
	@ManyToOne
	@JoinColumn(name = "maSanPham", columnDefinition = "VARCHAR(10)")
	private SanPham sanPham;

	@Column(name = "soLuong")
	private int soLuong;

	@Column(name = "thanhTien")
	private double thanhTien;

	public double getThanhTien() {
		return 0;
	}

	public ChiTietHoaDon() {

	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", thanhTien="
				+ thanhTien + "]";
	}

}// end OrderDetail