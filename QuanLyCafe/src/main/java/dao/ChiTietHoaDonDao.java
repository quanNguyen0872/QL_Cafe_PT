package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietHoaDon;
import util.HibernateUtil;

public class ChiTietHoaDonDao {

	private SessionFactory sessionFactory;

	public ChiTietHoaDonDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(cthd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}

		return false;
	}

	public boolean updateChiTietHoaDon(ChiTietHoaDon cthd) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.update(cthd);

			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	public boolean deleteChiTietHoaDonById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.delete(session.find(ChiTietHoaDon.class, id));

			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	public ChiTietHoaDon getChiTietHoaDonById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			ChiTietHoaDon cthd = session.find(ChiTietHoaDon.class, id);

			tr.commit();

			return cthd;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

	public List<ChiTietHoaDon> getDanhSachCTHD() {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<ChiTietHoaDon> dsCTHD = session.createQuery("select cthd from ChiTietHoaDon cthd", ChiTietHoaDon.class)
					.getResultList();

			tr.commit();

			return dsCTHD;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<ChiTietHoaDon> getDanhSachCTHDByIdHD(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<ChiTietHoaDon> dsCTHD = session
					.createQuery("select cthd from ChiTietHoaDon cthd where cthd.hoaDon.maHoaDon = ?1",
							ChiTietHoaDon.class)
					.setParameter(1, id).getResultList();

			tr.commit();

			return dsCTHD;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
