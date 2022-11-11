package facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import business.KhachHangBusiness;
import facade.KhachHangFacade;
import model.KhachHang;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangFacade {
	
	private static final long serialVersionUID = 1L;
	private KhachHangBusiness khachHangBusiness;

	public KhachHangImpl() throws RemoteException {
		khachHangBusiness = new KhachHangBusiness();
	}

	@Override
	public boolean addKhachHang(KhachHang kh) throws RemoteException {
		return khachHangBusiness.addKhachHang(kh);
	}

	@Override
	public boolean updateKhachHang(KhachHang kh) throws RemoteException {
		return khachHangBusiness.updateKhachHang(kh);
	}

	@Override
	public boolean deleteKhachHangById(String id) throws RemoteException {
		return khachHangBusiness.deleteKhachHangById(id);
	}

	@Override
	public KhachHang getKhachHangById(String id) throws RemoteException {
		return khachHangBusiness.getKhachHangById(id);
	}

	@Override
	public List<KhachHang> getDSKhachHangByName(String name) throws RemoteException {
		return khachHangBusiness.getDSKhachHangByName(name);
	}

	@Override
	public List<KhachHang> getDanhSachKH() throws RemoteException {
		return khachHangBusiness.getDanhSachKH();
	}

	@Override
	public KhachHang getKhachHangByPhone(String phoneNumber) throws RemoteException {
		return khachHangBusiness.getKhachHangByPhone(phoneNumber);
	}

}
