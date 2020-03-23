import org.apache.log4j.Logger;
import org.junit.Test;

public class log4jTest {
    //获取日志记录器，得到本类的字节码文件
    private static Logger logger = Logger.getLogger(log4jTest.class);
    @Test
    public static void test(String [] args){

        logger.debug("这是debug级别的错误");

        logger.info("这是info级别的错误");

        logger.warn("这是warning级别的错误");

        logger.error("这是error级别的错误");

    }
}
