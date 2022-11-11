package facade.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import business.SanPhamBusiness;
import facade.SanPhamFacade;
import model.SanPham;

public class SanPhamImpl extends UnicastRemoteObject implements SanPhamFacade {

	private static final long serialVersionUID = 1L;
	private SanPhamBusiness sanPhamBusiness;

	public SanPhamImpl() throws RemoteException {
		sanPhamBusiness = new SanPhamBusiness();
	}

	@Override
	public boolean addSanPham(SanPham sp) throws RemoteException {
		return sanPhamBusiness.addSanPham(sp);
	}

	@Override
	public boolean updateSanPham(SanPham sp) throws RemoteException {
		return sanPhamBusiness.updateSanPham(sp);
	}

	@Override
	public boolean deleteSanPham(String id) throws RemoteException {
		return sanPhamBusiness.deleteSanPham(id);
	}

	@Override
	public SanPham getSanPhamById(String id) throws RemoteException {
		return sanPhamBusiness.getSanPhamById(id);
	}

	@Override
	public List<SanPham> getDSSanPhamByName(String name) throws RemoteException {
		return sanPhamBusiness.getDSSanPhamByName(name);
	}

	@Override
	public List<SanPham> getDanhSachSanPham() throws RemoteException {
		return sanPhamBusiness.getDanhSachSanPham();
	}

	@Override
	public List<SanPham> getDSSanPhamByCategoryName(String categoryName) throws RemoteException {
		return sanPhamBusiness.getDSSanPhamByCategoryName(categoryName);
	}

	@Override
	public List<String> getDSKichCoSanPham() throws RemoteException {
		return sanPhamBusiness.getDSKichCoSanPham();
	}

	@Override
	public SanPham getDSSanPhamByTenVaKichCo(String name, String kichco) throws RemoteException {
		return sanPhamBusiness.getDSSanPhamByTenVaKichCo(name, kichco);
	}

}
