/**
 * La Vo Minh Quan - 19441111
 */
package business;

import java.util.List;

import dao.NhanVienDao;
import model.NhanVien;

public class NhanVienBusiness {
	private NhanVienDao nhanVienDao;
	
	public NhanVienBusiness() {
		nhanVienDao = new NhanVienDao();
	}
	
	public NhanVien addNhanVien(NhanVien nv) {
		return nhanVienDao.addNhanVien(nv);
	}
	
	public boolean updateNhanVien(NhanVien nv) {
		return nhanVienDao.updateNhanVien(nv);
	}
	
	public boolean deleteNhanVien(String id) {
		return nhanVienDao.deleteNhanVien(id);
	}
	
	public NhanVien getNhanVienById(String id) {
		return nhanVienDao.getNhanVienById(id);
	}
	
	public List<NhanVien> getDSNhanVienByName(String name) {
		return nhanVienDao.getDSNhanVienByName(name);
	}
	
	public NhanVien getNhanVienByPhone(String phoneNumber) {
		return nhanVienDao.getNhanVienByPhone(phoneNumber);
	}
	
	public List<NhanVien> getDanhSachNV(){
		return nhanVienDao.getDanhSachNV();
	}
}
