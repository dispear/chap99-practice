package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    private ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {

        SqlSession sqlSession = getSqlSession();
        ProductDAO productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectAllProductList();

        return productList;
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectProductByCondition(searchCondition);

        return productList;

    }

    public boolean registNewProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.insertProduct(product);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        return result > 0;

    }

    public boolean modifyProductInfo(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.updateProduct(product);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        return result > 0;
    }

    public boolean deleteProduct(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.deleteProduct(parameter);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        return result > 0;

    }
}
