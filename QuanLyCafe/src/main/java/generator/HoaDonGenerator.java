package generator;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class HoaDonGenerator implements IdentifierGenerator {
	
	private String prefix = "HD";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String query = "SELECT HD.maHoaDon FROM HoaDon HD";
	    Stream<String> ids = session.createQuery(query, String.class).stream();
	    
	    Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
	    
	    return prefix + (String.format("%05d", max + 1));
	}
}
