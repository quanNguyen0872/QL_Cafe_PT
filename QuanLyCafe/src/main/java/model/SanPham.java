package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author PC
 * @version 1.0
 * @created 23-Nov-2021 7:53:14 PM
 */
@Entity
public class SanPham implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "VARCHAR(10)")
	@GeneratedValue(generator = "SPGenerator")
	@GenericGenerator(name = "SPGenerator", strategy = "generator.SanPhamGenerator")
	private String maSanPham;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String tenSanPham;

	@Column(name = "donGia", nullable = false)
	private double donGia;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String kichCo;

	@ManyToOne
	@JoinColumn(name = "maLoaiSanPham", nullable = false)
	private LoaiSanPham loaiSanPham;

	@OneToMany(mappedBy = "sanPham")
	private List<ChiTietHoaDon> listChiTietHoaDon;

	public SanPham() {

	}

	public SanPham(String maSanPham, String tenSanPham, double donGia, String kichCo, LoaiSanPham loaiSanPham,
			List<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.kichCo = kichCo;
		this.loaiSanPham = loaiSanPham;
		this.listChiTietHoaDon = listChiTietHoaDon;
	}
	
	
	public SanPham(String tenSanPham, double donGia, String kichCo, LoaiSanPham loaiSanPham,
			List<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.kichCo = kichCo;
		this.loaiSanPham = loaiSanPham;
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public List<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(List<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", donGia=" + donGia + ", kichCo="
				+ kichCo + ", loaiSanPham=" + loaiSanPham + ", listChiTietHoaDon=" + listChiTietHoaDon + "]";
	}

}// end Product