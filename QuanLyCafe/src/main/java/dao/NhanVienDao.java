/**
 * La Vo Minh Quan - 19441111
 */
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.NhanVien;
import util.HibernateUtil;

public class NhanVienDao {
	private SessionFactory sessionFactory;

	public NhanVienDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public NhanVien addNhanVien(NhanVien nv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(nv);
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public boolean updateNhanVien(NhanVien nv) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.update(nv);

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

	public boolean deleteNhanVien(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.delete(session.find(NhanVien.class, id));

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

	public NhanVien getNhanVienById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			NhanVien nv = session.find(NhanVien.class, id);

			tr.commit();

			return nv;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<NhanVien> getDSNhanVienByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

//			String sql = "select * from [dbo].[customers]\r\n" + 
//					"where [first_name] = ?1 ";

			String sql = "select nv from NhanVien nv where nv.tenNhanVien = ?1";

			List<NhanVien> dsNhanVien = session.createQuery(sql, NhanVien.class).setParameter(1, name).getResultList();

			tr.commit();

			return dsNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public NhanVien getNhanVienByPhone(String phoneNumber) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		String query = "Select nv from NhanVien nv where nv.soDienThoai = :x";

		try {
			tr.begin();

			NhanVien nv = session.createNamedQuery(query, NhanVien.class).setParameter("x", phoneNumber)
					.getSingleResult();

			tr.commit();

			return nv;

		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<NhanVien> getDanhSachNV() {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<NhanVien> dsNhanVien = session.createQuery("select nv from NhanVien nv", NhanVien.class)
					.getResultList();
			System.out.println(dsNhanVien);
			tr.commit();

			return dsNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
