package business;

import dao.TaiKhoanDao;
import model.NhanVien;
import model.TaiKhoan;

public class TaiKhoanBusiness {
	private TaiKhoanDao taiKhoanDao;

	public TaiKhoanBusiness() {
		taiKhoanDao = new TaiKhoanDao();
	}

	public boolean addTaiKhoan(TaiKhoan tk) {
		return taiKhoanDao.addTaiKhoan(tk);
	}

	public TaiKhoan CheckLogin(String username, String password) {
		return taiKhoanDao.CheckLogin(username, password);
	}

	public TaiKhoan getTaiKhoanById(String id) {
		return taiKhoanDao.getTaiKhoanById(id);
	}
	public TaiKhoan taoTaiKhoan(String ma, String string, NhanVien nhanVien) {
		return taiKhoanDao.taoTaiKhoan(ma, string, nhanVien);
	}

}
