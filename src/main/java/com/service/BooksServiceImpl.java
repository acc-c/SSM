package com.service;

import com.mapper.BooksMapper;
import com.pojo.Books;
import com.pojo.BooksExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @BelongsProject: SSM_CRUD
 * @BelongsPackage: com.service
 * @Date: 2022/4/17 21:53
 * @Description: TODO
 * @return
 */
@Service
public class BooksServiceImpl implements BooksService{


    @Autowired
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    //    InputStream resourceAsStream = null;
//    BooksMapper mapper=null;
//        try {
//        resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = build.openSession();
//        mapper = sqlSession.getMapper(BooksMapper.class);
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
    @Override
    public int countByExample(BooksExample example) {

        return booksMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BooksExample example) {
        return booksMapper.deleteByExample(example);
    }

    @Override
    public int insert(Books record) {
        return booksMapper.insert(record);
    }

    @Override
    public int insertSelective(Books record) {
        return booksMapper.insertSelective(record);
    }

    @Override
    public List<Books> selectByExample(BooksExample example) {
        return booksMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Books record, BooksExample example) {
        return booksMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Books record, BooksExample example) {
        return booksMapper.updateByExample(record, example);
    }
}
