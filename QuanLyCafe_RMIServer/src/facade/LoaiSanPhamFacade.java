package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.LoaiSanPham;

public interface LoaiSanPhamFacade extends Remote{
	public boolean addLoaiSanPham(LoaiSanPham loaiSP) throws RemoteException;
	public boolean updateLoaiSanPham(LoaiSanPham loaiSP) throws RemoteException;
	public boolean deleteLoaiSanPham(String id) throws RemoteException;
	public LoaiSanPham getLoaiSanPhamById(String id) throws RemoteException;
	public List<LoaiSanPham> getDSLoaiSPByName(String name) throws RemoteException;
	public List<LoaiSanPham> getDanhSachLoaiSP() throws RemoteException;
	public String getMaLoaiTheoTen(String tenLoai) throws RemoteException;
}
