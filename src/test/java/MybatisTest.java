import com.lmh.bean.Teacher;
import com.lmh.dao.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author LMH
 * @create 2019-12-12 12:04
 */
public class MybatisTest {


    //工厂只需要一个
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void initsqlSessionFactory() throws IOException {
        //1.创建SqlSessionFactory
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    //MBG执行
    // @Test
    // public void test1() throws Exception {
    //     List<String> warnings = new ArrayList<String>();
    //     boolean overwrite = true;
    //     File configFile = new File("src/main/resources/generatorConfig.xml");
    //     ConfigurationParser cp = new ConfigurationParser(warnings);
    //     Configuration config = cp.parseConfiguration(configFile);
    //     DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    //     MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    //     myBatisGenerator.generate(null);
    // }

    /*//批量查询
    @Test
    public void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> list = new ArrayList<>();
        for (int i=0;i<1000;i++){
            Teacher teacher = new Teacher();
            teacher.setTeacherName(UUID.randomUUID().toString().substring(0,5));
            teacher.setClassName(UUID.randomUUID().toString().substring(0,5));
            list.add(teacher);
        }

        System.out.println("批量插入..........");
        teacherMapper.insertBatch(list);
        sqlSession.close();
    }*/

}
