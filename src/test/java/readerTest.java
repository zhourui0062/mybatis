import com.dao.PersonMapper;
import com.model.Person;
import com.model.Reader;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class readerTest {

    SqlSession sqlSession ;

    @Test
    public void selectReader(){
        sqlSession = MybatisUtil.getSqlSession();
        Reader reader = new Reader();
        reader.setMoney(300);
        try{
            List<Reader> readers= sqlSession.selectList("selectReadermoney",reader);
            sqlSession.commit();
            for(Reader readerr : readers)
                System.out.println(readerr.getReaderId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }
}
