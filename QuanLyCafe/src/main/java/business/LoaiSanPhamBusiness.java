/**
 * La Vo Minh Quan - 19441111
 */
package business;

import java.util.List;

import dao.LoaiSanPhamDao;
import model.LoaiSanPham;

public class LoaiSanPhamBusiness {
	private LoaiSanPhamDao loaiSanPhamDao;

	public LoaiSanPhamBusiness() {
		loaiSanPhamDao = new LoaiSanPhamDao();
	}

	public boolean addLoaiSanPham(LoaiSanPham loaiSP) {
		return loaiSanPhamDao.addLoaiSanPham(loaiSP);
	}

	public boolean updateLoaiSanPham(LoaiSanPham loaiSP) {
		return loaiSanPhamDao.updateLoaiSanPham(loaiSP);
	}

	public boolean deleteLoaiSanPham(String id) {
		return loaiSanPhamDao.deleteLoaiSanPham(id);
	}

	public LoaiSanPham getLoaiSanPhamById(String id) {
		return loaiSanPhamDao.getLoaiSanPhamById(id);
	}

	public List<LoaiSanPham> getDSLoaiSPByName(String name) {
		return loaiSanPhamDao.getDSLoaiSPByName(name);
	}
	
	public List<LoaiSanPham> getDanhSachLoaiSP() {
		return loaiSanPhamDao.getDanhSachLoaiSP();
	}
	
	public String getMaLoaiTheoTen(String tenLoai) {
		return loaiSanPhamDao.getMaLoaiTheoTen(tenLoai);
	}
}
