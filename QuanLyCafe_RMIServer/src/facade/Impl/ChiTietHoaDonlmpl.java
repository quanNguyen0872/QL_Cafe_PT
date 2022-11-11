package facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import business.ChiTietHoaDonBusiness;
import facade.ChiTietHoaDonFacade;
import model.ChiTietHoaDon;

public class ChiTietHoaDonlmpl extends UnicastRemoteObject implements ChiTietHoaDonFacade {

	private static final long serialVersionUID = 1L;
	private ChiTietHoaDonBusiness chiTietHoaDonBusiness;
	
	public ChiTietHoaDonlmpl() throws RemoteException {
		chiTietHoaDonBusiness = new ChiTietHoaDonBusiness();
	}

	@Override
	public boolean addchitiethoaDon(ChiTietHoaDon cthd) throws RemoteException {
		return chiTietHoaDonBusiness.addChiTietHoaDon(cthd);
	}

	@Override
	public boolean updatechitiethoaDon(ChiTietHoaDon cthd) throws RemoteException {
		return chiTietHoaDonBusiness.updateChiTietHoaDon(cthd);
	}

	@Override
	public boolean deletechitiethoaDonById(String id) throws RemoteException {
		return chiTietHoaDonBusiness.deleteChiTietHoaDonById(id);
	}

	@Override
	public ChiTietHoaDon getchitiethoaDonById(String id) throws RemoteException {
		return chiTietHoaDonBusiness.getChiTietHoaDonById(id);
	}

	@Override
	public List<ChiTietHoaDon> getDanhSachCTHD() throws RemoteException {
		return chiTietHoaDonBusiness.getDanhSachCTHD();
	}

	@Override
	public List<ChiTietHoaDon> getDanhSachCTHDByIdHD(String id) throws RemoteException {
		return chiTietHoaDonBusiness.getDanhSachCTHDByIdHD(id);
	}
	
}
