package exception;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className UniqueException
 * @author: Mango
 * @date: 2020-09-07 10:58
 */
public class UniqueException extends SQLException {
    public UniqueException(String reason) {
        super(reason);
    }

    public UniqueException() {
    }
}
