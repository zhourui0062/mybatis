import com.dao.PersonMapper;
import com.model.Person;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class userTest {

    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        //int id = 10000;
        String userName = "dff";
        int age = 55;
        String mobilePhone = "1854530";
        Person person = new Person();
        //person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            sqlSession.insert("insertPerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{
            Person person = sqlSession.selectOne("queryById",id);

            sqlSession.commit();
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void updatePerson(){
        sqlSession = MybatisUtil.getSqlSession();
        Person person = new Person();
        person.setId(3);
        person.setUserName("llj");
        person.setAge(33);
        person.setMobilePhone("4444");
        try{
            sqlSession.update("updatePerson",person);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }




    }

    @Test
    public void deletePerson(){
        sqlSession = MybatisUtil.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        int id = 3;
        try{
            personMapper.deletePerson(id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }




    }

    @Test
    public void selectPerson1(){
        sqlSession = MybatisUtil.getSqlSession();
        HashMap<String,Object> map = new HashMap<>();
        map.put("username","zr4");
        map.put("age",99);
        map.put("mobilephone","1809000");
        try{
            Person person = sqlSession.selectOne("selectPerson1",map);
            sqlSession.commit();
            if (person!=null)
                System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }


    @Test
    public void selectPerson2(){
        sqlSession = MybatisUtil.getSqlSession();
        Person person = new Person();
        person.setUserName("zr4");
        person.setAge(99);
        person.setMobilePhone("1809000");
        try{
            Person personres = sqlSession.selectOne("selectPerson2",person);
            sqlSession.commit();
            if (personres!=null)
                System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    @Test
    public void selectPerson3(){
        sqlSession = MybatisUtil.getSqlSession();
        try{
            List<Person> persons= sqlSession.selectList("selectPerson3");
            sqlSession.commit();
            for(Person person : persons)
                System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }
}
