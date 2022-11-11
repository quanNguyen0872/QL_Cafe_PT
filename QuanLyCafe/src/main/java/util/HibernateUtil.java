package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.LoaiSanPham;
import model.NhanVien;
import model.Quyen;
import model.SanPham;
import model.TaiKhoan;

public class HibernateUtil {
	private static HibernateUtil instance = null;
	private SessionFactory sessionFactory;
	
	public HibernateUtil() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(NhanVien.class)
				.addAnnotatedClass(TaiKhoan.class)
				.addAnnotatedClass(SanPham.class)
				.addAnnotatedClass(LoaiSanPham.class)
				.addAnnotatedClass(Quyen.class)
				.addAnnotatedClass(KhachHang.class)
				.addAnnotatedClass(HoaDon.class)
				.addAnnotatedClass(ChiTietHoaDon.class)
				.getMetadataBuilder()
				.build();
		
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	
	public static synchronized HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() {
		sessionFactory.close();
	}
}
