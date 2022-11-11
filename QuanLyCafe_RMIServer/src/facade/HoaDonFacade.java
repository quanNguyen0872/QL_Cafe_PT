package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.HoaDon;

public interface HoaDonFacade extends Remote {
	public HoaDon addhoaDon(HoaDon hd) throws RemoteException;
	public boolean updatehoaDon(HoaDon hd) throws RemoteException;
	public boolean deletehoaDonById(String id) throws RemoteException;
	public HoaDon gethoaDonById(String id) throws RemoteException;
	public List<HoaDon> getDanhSachHoaDon() throws RemoteException;
}
