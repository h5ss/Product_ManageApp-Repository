package com.ssg.productapp.service;


import com.ssg.productapp.dto.PageRequestDTO;
import com.ssg.productapp.dto.PageResponseDTO;
import com.ssg.productapp.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void register(ProductDTO productDTO);
    ProductDTO getOne(Long pno);
//    List<ProductDTO> getList();
    void remove(Long pno);
    void modify(ProductDTO productDTO);
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
}
