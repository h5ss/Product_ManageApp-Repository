package com.ssg.productapp.service;

import com.ssg.productapp.domain.ProductVO;
import com.ssg.productapp.dto.PageRequestDTO;
import com.ssg.productapp.dto.PageResponseDTO;
import com.ssg.productapp.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class ServiceTests {

    @Autowired(required = false)
    private ProductServiceImpl productService;

    @Test
    public void testRegister(){
        ProductDTO dto = ProductDTO.builder()
                .pname("hoho")
                .pprice(200)
                .pstock(10)
                .build();
        productService.register(dto);
    }

    @Test
    public void testGetOne(){
        ProductDTO dto = productService.getOne(1L);
        log.info(dto);
    }

    @Test
    public void testGetList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<ProductDTO> responseDTO = productService.getList(pageRequestDTO);
        log.info(responseDTO);
        responseDTO.getDtoList().forEach(log::info);
    }

    @Test
    public void testRemove(){
        productService.remove(2L);
    }

    @Test
    public void testModify(){
        ProductDTO dto = ProductDTO.builder()
                .pname("hehe")
                .pprice(200)
                .pstock(10)
                .build();
        productService.modify(dto);
    }
}