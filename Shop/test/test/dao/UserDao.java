package test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import test.entity.User;

@Component
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<User> getAllUser() {
        String hsql="from USER";
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hsql);
        List<User> list = query.list();
        list.get(0).setAge(99);
        session.update(list.get(0));
        return list;
    }
    
    public void getUserBySQL(String sql) {
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("name"));
                System.out.println(rs.isFirst());
            }
        });
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
