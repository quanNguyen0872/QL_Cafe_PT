/**
 * La Vo Minh Quan - 19441111
 */
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.LoaiSanPham;
import util.HibernateUtil;

public class LoaiSanPhamDao {
	private SessionFactory sessionFactory;

	public LoaiSanPhamDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addLoaiSanPham(LoaiSanPham loaiSP) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(loaiSP);
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

	public boolean updateLoaiSanPham(LoaiSanPham loaiSP) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.update(loaiSP);

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

	public boolean deleteLoaiSanPham(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			session.delete(session.find(LoaiSanPham.class, id));

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

	public LoaiSanPham getLoaiSanPhamById(String id) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			LoaiSanPham loaiSP = session.find(LoaiSanPham.class, id);

			tr.commit();

			return loaiSP;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		} 
		return null;
	}

	public List<LoaiSanPham> getDSLoaiSPByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

//			String sql = "select * from [dbo].[customers]\r\n" + 
//					"where [first_name] = ?1 ";

			String sql = "select lsp from LoaiSanPham lsp where lsp.tenLoaiSanPham = ?1";

			List<LoaiSanPham> dsLoaiSanPham = session.createQuery(sql, LoaiSanPham.class).setParameter(1, name)
					.getResultList();

			tr.commit();

			return dsLoaiSanPham;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		} 
		return null;
	}
	
	public List<LoaiSanPham> getDanhSachLoaiSP() {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			List<LoaiSanPham> dsLoaiSP = session.createQuery("select lsp from LoaiSanPham lsp", LoaiSanPham.class).getResultList();
		
			tr.commit();

			return dsLoaiSP;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public String getMaLoaiTheoTen(String tenLoai) {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();

			LoaiSanPham lsp = session.createQuery("select lsp from LoaiSanPham lsp where lsp.tenLoaiSanPham = ?1", LoaiSanPham.class)
					.setParameter(1, tenLoai)
					.getSingleResult();
			
			String maLoai = lsp.getMaLoaiSanPham();

			tr.commit();

			return maLoai;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
