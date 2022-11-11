package business;

import java.util.List;

import dao.HoaDonDao;
import model.HoaDon;

public class HoaDonBusiness {
	
	private HoaDonDao hoaDonDao;
	
	public HoaDonBusiness() {
		hoaDonDao = new HoaDonDao();
	}
	
	public HoaDon addHoaDon(HoaDon hd) {
		return hoaDonDao.addHoaDon(hd);
	}
	
	public boolean updateHoaDon(HoaDon hd) {
		return hoaDonDao.updateHoaDon(hd);
	}
	
	public boolean deleteHoaDonById(String id) {
		return hoaDonDao.deleteHoaDonById(id);
	}
	
	public HoaDon getHoaDonById(String id) {
		return hoaDonDao.getHoaDonById(id);
	}
	
	public List<HoaDon> getDanhSachHoaDon() {
		return hoaDonDao.getDanhSachHoaDon();
	}
}
