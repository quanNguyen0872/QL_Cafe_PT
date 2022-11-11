package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDon_PK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String hoaDon;
	private String sanPham;
	
	public ChiTietHoaDon_PK() {
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon_PK other = (ChiTietHoaDon_PK) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}
	
	
	
	
}
