package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.NhanVien;
import model.TaiKhoan;

public interface TaiKhoanFacade extends Remote {
	public boolean addTaiKhoan(TaiKhoan tk) throws RemoteException;

	public TaiKhoan CheckLogin(String username, String password) throws RemoteException;

	public TaiKhoan getTaiKhoanById(String id) throws RemoteException;
	public TaiKhoan taoTaiKhoan(String ma, String string, NhanVien nhanVien) throws RemoteException;
}
