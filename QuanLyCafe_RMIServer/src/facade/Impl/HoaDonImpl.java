package facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import business.HoaDonBusiness;
import facade.HoaDonFacade;
import model.HoaDon;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonFacade {

	private static final long serialVersionUID = 1L;
	private HoaDonBusiness hoaDonBusiness;

	public HoaDonImpl() throws RemoteException {
		hoaDonBusiness = new HoaDonBusiness();
	}

	@Override
	public HoaDon addhoaDon(HoaDon hd) throws RemoteException {
		return hoaDonBusiness.addHoaDon(hd);
	}

	@Override
	public boolean updatehoaDon(HoaDon hd) throws RemoteException {
		return hoaDonBusiness.updateHoaDon(hd);
	}

	@Override
	public boolean deletehoaDonById(String id) throws RemoteException {
		return hoaDonBusiness.deleteHoaDonById(id);
	}

	@Override
	public HoaDon gethoaDonById(String id) throws RemoteException {
		return hoaDonBusiness.getHoaDonById(id);
	}

	@Override
	public List<HoaDon> getDanhSachHoaDon() throws RemoteException {
		return hoaDonBusiness.getDanhSachHoaDon();
	}

}
