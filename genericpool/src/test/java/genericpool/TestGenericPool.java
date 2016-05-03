package genericpool;

import com.tp.pool.BoundedBlockingPool;
import com.tp.pool.impl.JDBCConnectionFactory;
import com.tp.pool.impl.JDBCConnectionValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) 
public class TestGenericPool {

	private int size=20;
	

	private BoundedBlockingPool < Connection > ConnectionPool;

	@Mock
	private LinkedBlockingQueue<Connection> objects;
	
	@Mock
	JDBCConnectionValidator jdbcConnectionValidator;

	@Mock
	JDBCConnectionFactory jdbcConnectionFactory;

	@Mock
	Connection connection;
	
	@Test
	public void getFromPooltest() {
		when(jdbcConnectionFactory.createNew()).thenReturn(connection);
		ConnectionPool = new BoundedBlockingPool<Connection>(size,jdbcConnectionValidator,jdbcConnectionFactory);
		assertEquals(ConnectionPool.get(), connection);
	}

}
