/**
 * La Vo Minh Quan - 19441111
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.SanPham;
import util.HibernateUtil;

public class SanPhamDao {
	private SessionFactory sessionFactory;

	public SanPhamDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addSanPham(SanPham sp) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(sp);
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

	public boolean updateSanPham(SanPham sp) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.update(sp);

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

	public boolean deleteSanPham(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.delete(session.find(SanPham.class, id));

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

	public SanPham getSanPhamById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			SanPham sp = session.find(SanPham.class, id);

			tr.commit();

			return sp;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<SanPham> getDSSanPhamByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

//			String sql = "select * from [dbo].[customers]\r\n" + 
//					"where [first_name] = ?1 ";

			String sql = "select sp from SanPham sp where sp.tenSanPham = ?1";

			List<SanPham> dsSanPham = session.createQuery(sql, SanPham.class).setParameter(1, name).getResultList();

			tr.commit();

			return dsSanPham;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<SanPham> getDanhSachSanPham() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<SanPham> dsSanPham = session.createQuery("select sp from SanPham sp", SanPham.class).getResultList();
			tr.commit();

			return dsSanPham;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<SanPham> getDSSanPhamByCategoryName(String categoryName) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			String sql = "select sp from SanPham sp where sp.loaiSanPham.tenLoaiSanPham = ?1";

			List<SanPham> dsSanPham = session.createQuery(sql, SanPham.class).setParameter(1, categoryName)
					.getResultList();

			tr.commit();

			return dsSanPham;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<String> getDSKichCoSanPham() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			String sql = "select sp from SanPham sp";
			List<SanPham> dsSanPham = session.createQuery(sql, SanPham.class).getResultList();
			
			List<String> dsKichCo = new ArrayList<String>();
			for (SanPham sp : dsSanPham) {
				dsKichCo.add(sp.getKichCo());
			}

			tr.commit();

			return dsKichCo;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public SanPham getDSSanPhamByTenVaKichCo(String name,String kichco) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();


			String sql = "select sp from SanPham sp where sp.tenSanPham = ?1 and sp.kichCo = ?2";

			SanPham SanPham = session.createQuery(sql, SanPham.class).setParameter(1, name).setParameter(2, kichco).getSingleResult();

			tr.commit();

			return SanPham;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
