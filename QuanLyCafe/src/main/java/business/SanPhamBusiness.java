/**
 * La Vo Minh Quan - 19441111
 */
package business;

import java.util.List;

import dao.SanPhamDao;
import model.SanPham;

public class SanPhamBusiness {
	private SanPhamDao sanPhamDao;
	
	public SanPhamBusiness() {
		sanPhamDao = new SanPhamDao();
	}
	
	public boolean addSanPham(SanPham sp) {
		return sanPhamDao.addSanPham(sp);
	}
	
	public boolean updateSanPham(SanPham sp) {
		return sanPhamDao.updateSanPham(sp);
	}
	
	public boolean deleteSanPham(String id) {
		return sanPhamDao.deleteSanPham(id);
	}
	
	public SanPham getSanPhamById(String id) {
		return sanPhamDao.getSanPhamById(id);
	}
	
	public List<SanPham> getDSSanPhamByName(String name) {
		return sanPhamDao.getDSSanPhamByName(name);
	}
	
	public List<SanPham> getDanhSachSanPham() {
		return sanPhamDao.getDanhSachSanPham();
	}
	
	public List<SanPham> getDSSanPhamByCategoryName(String categoryName) {
		return sanPhamDao.getDSSanPhamByCategoryName(categoryName);
	}
	
	public List<String> getDSKichCoSanPham() {
		return sanPhamDao.getDSKichCoSanPham();
	}
	public SanPham getDSSanPhamByTenVaKichCo(String name,String kichco) {
		return sanPhamDao.getDSSanPhamByTenVaKichCo(name,kichco);
	}
}
