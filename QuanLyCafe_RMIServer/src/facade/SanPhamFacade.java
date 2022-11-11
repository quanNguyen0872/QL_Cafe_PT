package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.SanPham;

public interface SanPhamFacade extends Remote{
	public boolean addSanPham(SanPham sp) throws RemoteException;
	public boolean updateSanPham(SanPham sp) throws RemoteException;
	public boolean deleteSanPham(String id) throws RemoteException;
	public SanPham getSanPhamById(String id) throws RemoteException;
	public List<SanPham> getDSSanPhamByName(String name) throws RemoteException;
	public List<SanPham> getDanhSachSanPham() throws RemoteException;
	public List<SanPham> getDSSanPhamByCategoryName(String categoryName) throws RemoteException;
	public List<String> getDSKichCoSanPham() throws RemoteException;
	public SanPham getDSSanPhamByTenVaKichCo(String name,String kichco) throws RemoteException;
}
