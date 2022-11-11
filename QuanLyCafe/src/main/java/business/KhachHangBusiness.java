/**
 * La Vo Minh Quan - 19441111
 */
package business;

import java.util.List;

import dao.KhachHangDao;
import model.KhachHang;

public class KhachHangBusiness {
	private KhachHangDao khachHangDao;
	
	public KhachHangBusiness() {
		khachHangDao = new KhachHangDao();
	}
	
	public boolean addKhachHang(KhachHang kh) {
		return khachHangDao.addKhachHang(kh);
	}
	
	public boolean updateKhachHang(KhachHang kh) {
		return khachHangDao.updateKhachHang(kh);
	}
	
	public boolean deleteKhachHangById(String id) { 
		return khachHangDao.deleteKhachHangById(id);
	}
	
	public KhachHang getKhachHangById(String id) {
		return khachHangDao.getKhachHangById(id);
	}
	
	public List<KhachHang> getDSKhachHangByName(String name) {
		return khachHangDao.getDSKhachHangByName(name);
	}
	
	public List<KhachHang> getDanhSachKH() {
		return khachHangDao.getDanhSachKH();
	}
	
	public KhachHang getKhachHangByPhone(String phoneNumber) {
		return khachHangDao.getKhachHangByPhone(phoneNumber);
	}
}
