package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.NhanVien;

public interface NhanVienFacade extends Remote{
	public NhanVien addNhanVien(NhanVien nv) throws RemoteException;
	public boolean updateNhanVien(NhanVien nv) throws RemoteException;
	public boolean deleteNhanVien(String id) throws RemoteException;
	public NhanVien getNhanVienById(String id) throws RemoteException;
	public List<NhanVien> getDSNhanVienByName(String name) throws RemoteException;
	public NhanVien getNhanVienByPhone(String phoneNumber) throws RemoteException;
	public List<NhanVien> getDanhSachNV() throws RemoteException;
}
