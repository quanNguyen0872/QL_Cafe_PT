package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.KhachHang;

public interface KhachHangFacade extends Remote{
	public boolean addKhachHang(KhachHang kh) throws RemoteException;
	public boolean updateKhachHang(KhachHang kh) throws RemoteException;
	public boolean deleteKhachHangById(String id) throws RemoteException;
	public KhachHang getKhachHangById(String id) throws RemoteException;
	public List<KhachHang> getDSKhachHangByName(String name) throws RemoteException;
	public List<KhachHang> getDanhSachKH() throws RemoteException; 
	public KhachHang getKhachHangByPhone(String phoneNumber) throws RemoteException;
}
