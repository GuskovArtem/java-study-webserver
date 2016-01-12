package executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Guskov Artem
 *         on 10.01.2016.
 */
public interface ResultHandler<T> {

  T handle(ResultSet resultSet) throws SQLException;

}
