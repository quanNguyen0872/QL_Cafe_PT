package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import facade.ChiTietHoaDonFacade;
import facade.HoaDonFacade;
import facade.KhachHangFacade;
import facade.LoaiSanPhamFacade;
import facade.NhanVienFacade;
import facade.SanPhamFacade;
import facade.TaiKhoanFacade;
import facade.Impl.ChiTietHoaDonlmpl;
import facade.Impl.HoaDonImpl;
import facade.Impl.KhachHangImpl;
import facade.Impl.LoaiSanPhamImpl;
import facade.Impl.NhanVienImpl;
import facade.Impl.SanPhamImpl;
import facade.Impl.TaiKhoanImpl;

public class Server {
	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			LocateRegistry.createRegistry(1099);
			
			KhachHangFacade khachHangFacade = new KhachHangImpl();
			LoaiSanPhamFacade loaiSanPhamFacade = new LoaiSanPhamImpl();
			NhanVienFacade nhanVienFacade = new NhanVienImpl();
			SanPhamFacade sanPhamFacade = new SanPhamImpl();
			ChiTietHoaDonFacade chiTietHoaDonFacade = new ChiTietHoaDonlmpl();
			HoaDonFacade hoaDonFacade = new HoaDonImpl();
			TaiKhoanFacade taiKhoanFacade = new TaiKhoanImpl();
			
			Naming.bind("rmi://"+ Config.getAddress() +"/khachHangFacade", khachHangFacade);
			Naming.bind("rmi://"+ Config.getAddress() +"/loaiSanPhamFacade", loaiSanPhamFacade);
			Naming.bind("rmi://"+ Config.getAddress() +"/nhanVienFacade", nhanVienFacade);
			Naming.bind("rmi://"+ Config.getAddress() +"/sanPhamFacade", sanPhamFacade);
			Naming.bind("rmi://"+ Config.getAddress() +"/chiTietHoaDonFacade", chiTietHoaDonFacade);
			Naming.bind("rmi://"+ Config.getAddress() +"/hoaDonFacade", hoaDonFacade);
			Naming.bind("rmi://"+ Config.getAddress() +"/taiKhoanFacade", taiKhoanFacade);
			
			System.out.println("server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
