package db.practice.demo.comn;

import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class OracleAbstarctMapper extends SqlSessionDaoSupport {

    /**
     * Simple Type의 SqlSessionFactory를 설정하는 메서드
     */
    @Override
    @Resource(name="sqlSessionBasicOracle")
    public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
        super.setSqlSessionFactory(sqlSession);
    }
}
