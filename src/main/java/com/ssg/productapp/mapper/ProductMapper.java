package com.ssg.productapp.mapper;

import com.ssg.productapp.domain.ProductVO;
import com.ssg.productapp.dto.PageRequestDTO;

import java.util.List;

public interface ProductMapper {
    void insert(ProductVO productVO);
    ProductVO selectOne(Long pno);
//    List<ProductVO> selectAll();
    void delete(Long pno);
    void update(ProductVO productVO);
    List<ProductVO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
}
