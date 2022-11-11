package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class HoaDon implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "VARCHAR(10)")
	@GeneratedValue(generator = "HDGenerator")
	@GenericGenerator(name = "HDGenerator", strategy = "generator.HoaDonGenerator")
	private String maHoaDon;
	
	@Column(name = "ngayLapHoaDon")
	private LocalDate ngayLapHoaDon;
	
	@Column(name = "tongTien")
	private double tongTien;
	
	@OneToMany(mappedBy = "hoaDon")
	private List<ChiTietHoaDon> listChiTietHD;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "ma_khach_hang")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(nullable = false,name = "ma_nhan_vien")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "hoaDon")
	private Set<ChiTietHoaDon> listChiTietHoaDon = new HashSet<ChiTietHoaDon>();
	
	public HoaDon(){
	}



	public HoaDon(LocalDate ngayLapHoaDon, double tongTien, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tongTien = tongTien;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}


	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public List<ChiTietHoaDon> getListChiTietHD() {
		return listChiTietHD;
	}

	public void setListChiTietHD(List<ChiTietHoaDon> listChiTietHD) {
		this.listChiTietHD = listChiTietHD;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Set<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(Set<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public double getOrderTotal(){
		return 0;
	}
}//end Order