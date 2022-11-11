package business;

import java.util.List;

import dao.ChiTietHoaDonDao;
import model.ChiTietHoaDon;

public class ChiTietHoaDonBusiness {
	private ChiTietHoaDonDao chiTietHoaDonDao;
	
	public ChiTietHoaDonBusiness() {
		chiTietHoaDonDao = new ChiTietHoaDonDao();
	}
	
	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) { 
		return chiTietHoaDonDao.addChiTietHoaDon(cthd);
	}
	
	public boolean updateChiTietHoaDon(ChiTietHoaDon cthd) {
		return chiTietHoaDonDao.updateChiTietHoaDon(cthd);
	}
	
	public boolean deleteChiTietHoaDonById(String id) {
		return chiTietHoaDonDao.deleteChiTietHoaDonById(id);
	}
	
	public ChiTietHoaDon getChiTietHoaDonById(String id) {
		return chiTietHoaDonDao.getChiTietHoaDonById(id);
	}
	
	public List<ChiTietHoaDon> getDanhSachCTHD() {
		return chiTietHoaDonDao.getDanhSachCTHD();
	}
	
	public List<ChiTietHoaDon> getDanhSachCTHDByIdHD(String id) {
		return chiTietHoaDonDao.getDanhSachCTHDByIdHD(id);
	}
}
