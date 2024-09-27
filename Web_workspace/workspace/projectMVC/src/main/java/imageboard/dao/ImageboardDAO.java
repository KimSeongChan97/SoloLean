package imageboard.dao;

import imageboard.bean.ImageboardDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ImageboardDAO {
    private static ImageboardDAO instance = new ImageboardDAO();
    private SqlSessionFactory sqlSessionFactory;

    public static ImageboardDAO getInstance() {
        return instance;
    }

    public ImageboardDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imageboardWrite(ImageboardDTO imageboardDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<ImageboardDTO> getImageboardList(int startNum, int endNum) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Integer> map = new HashMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        List<ImageboardDTO> list = sqlSession.selectList("imageboardSQL.getImageboardList", map);
        sqlSession.close();
        return list;
    }

    public int getTotalA() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int totalA = sqlSession.selectOne("imageboardSQL.getTotalA");
        sqlSession.close();
        return totalA;
    }

    public ImageboardDTO getImageboardBySeq(int seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ImageboardDTO imageboardDTO = sqlSession.selectOne("imageboardSQL.getImageboardBySeq", seq);
        sqlSession.close();
        return imageboardDTO;
    }

    public void updateImage(ImageboardDTO imageboardDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("imageboardSQL.updateImage", imageboardDTO);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteImage(int seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("imageboardSQL.deleteImage", seq);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteImages(List<Integer> seqs) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("imageboardSQL.deleteImages", seqs);
        sqlSession.commit();
        sqlSession.close();
    }
}