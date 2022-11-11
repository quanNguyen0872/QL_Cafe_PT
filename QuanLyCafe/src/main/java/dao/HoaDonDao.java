package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.HoaDon;
import util.HibernateUtil;

public class HoaDonDao {
	private SessionFactory sessionFactory;

	public HoaDonDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public HoaDon addHoaDon(HoaDon hd) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(hd);
			tr.commit();
			return hd;
		} catch (Exception e) {
			tr.rollback();
		}

		return null;
	}

	public boolean updateHoaDon(HoaDon hd) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.update(hd);

			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	public boolean deleteHoaDonById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.delete(session.find(HoaDon.class, id));

			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	public HoaDon getHoaDonById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			HoaDon hd = session.find(HoaDon.class, id);

			tr.commit();

			return hd;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

	public List<HoaDon> getDanhSachHoaDon() {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<HoaDon> dsHoaDon = session.createQuery("select hd from HoaDon hd", HoaDon.class).getResultList();
			
			tr.commit();

			return dsHoaDon;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
