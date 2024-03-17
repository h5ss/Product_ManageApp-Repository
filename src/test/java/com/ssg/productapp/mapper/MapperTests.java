package com.ssg.productapp.mapper;

import com.ssg.productapp.domain.ProductVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class MapperTests {

    @Autowired(required = false)
    private ProductMapper productMapper;

    @Test
    public void testInsert(){
        ProductVO vo = ProductVO.builder()
                .pname("hosang")
                .pprice(1500)
                .pstock(20)
                .build();
        productMapper.insert(vo);
    }

    @Test
    public void testSelectOne(){
        ProductVO vo = productMapper.selectOne(1L);
        log.info(vo);
    }

    @Test
    public void testSelectAll(){
        List<ProductVO> list = productMapper.selectAll();
        list.forEach(log::info);
    }

    @Test
    public void testDelete(){
        productMapper.delete(2L);
    }

    @Test
    public void testUpdate(){
        ProductVO vo = ProductVO.builder()
                .pname("just music")
                .pprice(5000)
                .pstock(200)
                .build();
        productMapper.update(vo);
    }
}