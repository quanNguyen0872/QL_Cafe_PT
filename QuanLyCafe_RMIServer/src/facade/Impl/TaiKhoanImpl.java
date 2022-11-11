package facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import business.TaiKhoanBusiness;
import facade.TaiKhoanFacade;
import model.NhanVien;
import model.TaiKhoan;

public class TaiKhoanImpl extends UnicastRemoteObject implements TaiKhoanFacade {

	private static final long serialVersionUID = 1L;
	private TaiKhoanBusiness taiKhoanBusiness;

	public TaiKhoanImpl() throws RemoteException {
		taiKhoanBusiness = new TaiKhoanBusiness();
	}

	@Override
	public TaiKhoan CheckLogin(String username, String password) throws RemoteException {
		return taiKhoanBusiness.CheckLogin(username, password);
	}

	@Override
	public boolean addTaiKhoan(TaiKhoan tk) throws RemoteException {
		return taiKhoanBusiness.addTaiKhoan(tk);
	}

	@Override
	public TaiKhoan getTaiKhoanById(String id) throws RemoteException {
		return taiKhoanBusiness.getTaiKhoanById(id);
	}

	@Override
	public TaiKhoan taoTaiKhoan(String ma, String string, NhanVien nhanVien) throws RemoteException {
		return taiKhoanBusiness.taoTaiKhoan(ma, string, nhanVien);
	}

}
