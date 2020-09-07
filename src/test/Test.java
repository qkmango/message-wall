package test;

import Utils.JDBCUtils;
import exception.UniqueException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @version 1.0
 * @Description: //TODO
 * <p>类简介</p>
 * <p>类详细介绍</p>
 * @className Test
 * @author: Mango
 * @date: 2020-09-06 00:51
 */
public class Test {
    public static void main(String[] args) throws UniqueException {

        try {

            Connection connection = JDBCUtils.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into user(email,password) values(?,?)");
            ps.setString(1,"1932101106@axhu.edu.cn");
            ps.setString(2,"a123456");

            int i = ps.executeUpdate();
            System.out.println("=============" + i);
        } catch (SQLException throwables) {
            // throwables.printStackTrace();
            throw new UniqueException("数据库唯一性约束异常");
        }


    }
}
