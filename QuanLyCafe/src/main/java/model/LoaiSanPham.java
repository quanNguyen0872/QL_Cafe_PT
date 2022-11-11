package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author PC
 * @version 1.0
 * @created 23-Nov-2021 7:53:14 PM
 */
@Entity
public class LoaiSanPham implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "VARCHAR(10)")
	@GeneratedValue(generator = "LSPGenerator")
	@GenericGenerator(name = "LSPGenerator", strategy = "generator.LoaiSanPhamGenerator")
	private String maLoaiSanPham;

	@Column(nullable = false, columnDefinition = "NVARCHAR(30)")
	private String tenLoaiSanPham;

	@OneToMany(mappedBy = "loaiSanPham")
	private List<SanPham> listSanPham;

	public LoaiSanPham() {

	}

	public LoaiSanPham(String maLoaiSanPham, String tenLoaiSanPham, List<SanPham> listSanPham) {
		super();
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.listSanPham = listSanPham;
	}

	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}

	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}

	public String gettenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void settenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public List<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(List<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSanPham=" + maLoaiSanPham + ", tenLoaiSanPham=" + tenLoaiSanPham + ", listSanPham="
				+ listSanPham + "]";
	}

}// end Category