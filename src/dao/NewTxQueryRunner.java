package dao;

import cn.itcast.jdbc.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewTxQueryRunner extends QueryRunner {

        @Override
        public int[] batch(String sql, Object[][] params) throws SQLException {
            Connection con = JdbcUtils.getConnection();
            int[] result = super.batch(con, sql, params);
            JdbcUtils.releaseConnection(con);
            return result;
        }

        @Override
        //重写  为了判断查找数据为空不报错0.0   发现不用了  算了留在以后看0.0
        public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {

            Connection con = JdbcUtils.getConnection();

           // T result = super.query(con, sql, rsh, params);
            T result = null;

            if (con == null) {
                throw new SQLException("Null connection");
            } else if (sql == null) {
                this.close(con);
                throw new SQLException("Null SQL statement");
            } else if (rsh == null) {
                this.close(con);
                throw new SQLException("Null ResultSetHandler");
            } else {
                PreparedStatement stmt = null;
                ResultSet rs = null;
               // Object result = null;

                try {
                    stmt = this.prepareStatement(con, sql);
                    this.fillStatement(stmt, params);
                    rs = this.wrap(stmt.executeQuery());
                    result = rsh.handle(rs);
                } catch (SQLException var33) {
                    this.rethrow(var33, sql, params);
                } finally {
                    try {
                        this.close(rs);
                    } finally {
                        this.close(stmt);
                        this.close(con);
                    }
                }

            }

            JdbcUtils.releaseConnection(con);
            return result;
        }



        @Override
        public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
            Connection con = JdbcUtils.getConnection();
            T result = super.query(con, sql, rsh);
            JdbcUtils.releaseConnection(con);
            return result;

        }

        @Override
        public int update(String sql) throws SQLException {
            Connection con = JdbcUtils.getConnection();
            int result = super.update(con, sql);
            JdbcUtils.releaseConnection(con);
            return result;
        }

        @Override
        public int update(String sql, Object param) throws SQLException {
            Connection con = JdbcUtils.getConnection();
            int result = super.update(con, sql, param);
            JdbcUtils.releaseConnection(con);
            return result;
        }

        @Override
        public int update(String sql, Object... params) throws SQLException {
            Connection con = JdbcUtils.getConnection();
            int result = super.update(con, sql, params);
            JdbcUtils.releaseConnection(con);
            return result;
        }
}

