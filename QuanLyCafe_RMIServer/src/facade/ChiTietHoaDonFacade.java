package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.ChiTietHoaDon;

public interface ChiTietHoaDonFacade extends Remote {
	public boolean addchitiethoaDon(ChiTietHoaDon cthd) throws RemoteException;
	public boolean updatechitiethoaDon(ChiTietHoaDon cthd) throws RemoteException;
	public boolean deletechitiethoaDonById(String id) throws RemoteException;
	public ChiTietHoaDon getchitiethoaDonById(String id) throws RemoteException;
	public List<ChiTietHoaDon> getDanhSachCTHD() throws RemoteException;
	public List<ChiTietHoaDon> getDanhSachCTHDByIdHD(String id) throws RemoteException;
}
