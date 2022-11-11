/**
 * La Vo Minh Quan - 19441111
 */
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.KhachHang;
import util.HibernateUtil;

public class KhachHangDao {
	private SessionFactory sessionFactory;

	public KhachHangDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addKhachHang(KhachHang kh) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	public boolean updateKhachHang(KhachHang kh) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.update(kh);

			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean deleteKhachHangById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.delete(session.find(KhachHang.class, id));

			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public KhachHang getKhachHangById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			KhachHang kh = session.find(KhachHang.class, id);

			tr.commit();

			return kh;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<KhachHang> getDSKhachHangByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			String sql = "select kh from KhachHang kh where kh.tenKhachHang = ?1";

			List<KhachHang> dsKhachHang = session.createQuery(sql, KhachHang.class).setParameter(1, name)
					.getResultList();

			tr.commit();

			return dsKhachHang;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<KhachHang> getDanhSachKH() {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<KhachHang> dsKhachHang = session.createQuery("select kh from KhachHang kh", KhachHang.class).getResultList();
			System.out.println(dsKhachHang);
			tr.commit();

			return dsKhachHang;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public KhachHang getKhachHangByPhone(String phoneNumber) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			KhachHang kh = session.createQuery("Select kh from KhachHang kh where kh.soDienThoai = ?1", KhachHang.class)
					.setParameter(1, phoneNumber).getSingleResult();

			tr.commit();

			return kh;

		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
