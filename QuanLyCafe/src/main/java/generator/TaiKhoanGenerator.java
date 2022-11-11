package generator;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TaiKhoanGenerator implements IdentifierGenerator{
	
	private String prefix = "TK";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String query = "SELECT TK.maTaiKhoan FROM TaiKhoan TK";
	    Stream<String> ids = session.createQuery(query, String.class).stream();
	    
	    Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
	    
	    return prefix + (String.format("%05d", max + 1));
	}

}