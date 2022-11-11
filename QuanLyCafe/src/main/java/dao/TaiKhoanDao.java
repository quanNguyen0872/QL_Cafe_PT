package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.NhanVien;
import model.Quyen;
import model.TaiKhoan;
import util.HibernateUtil;

public class TaiKhoanDao {
	private SessionFactory sessionFactory;

	public TaiKhoanDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addTaiKhoan(TaiKhoan tk) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}

		return false;
	}

	public TaiKhoan getTaiKhoanById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			TaiKhoan taiKhoan = session.find(TaiKhoan.class, id);

			tr.commit();

			return taiKhoan;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public TaiKhoan CheckLogin(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select tk from TaiKhoan tk where tk.tenTaiKhoan = ?1 and tk.matKhau = ?2";

			TaiKhoan tk = session.createQuery(sql, TaiKhoan.class).setParameter(1, username).setParameter(2, password)
					.getSingleResult();

			tr.commit();
			return tk;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	
	public TaiKhoan taoTaiKhoan(String ma, String string, NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			TaiKhoan taiKhoan = new TaiKhoan(ma, string, Quyen.NhanVien);
			taiKhoan.setNhanVien(nhanVien);
			tr.begin();
			session.save(taiKhoan);
			tr.commit();
			return taiKhoan;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

}
