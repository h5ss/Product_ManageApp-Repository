package com.ssg.productapp.service;

import com.ssg.productapp.domain.ProductVO;
import com.ssg.productapp.dto.PageRequestDTO;
import com.ssg.productapp.dto.PageResponseDTO;
import com.ssg.productapp.dto.ProductDTO;
import com.ssg.productapp.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(ProductDTO productDTO) {
        ProductVO vo = modelMapper.map(productDTO, ProductVO.class);
        productMapper.insert(vo);
    }

    @Override
    public ProductDTO getOne(Long pno) {
        ProductVO vo = productMapper.selectOne(pno);
        return modelMapper.map(vo, ProductDTO.class);
    }

//    @Override
//    public List<ProductDTO> getList() {
//        List<ProductVO> list = productMapper.selectAll();
//
//        return list.stream().
//                map(vo->modelMapper.map(vo, ProductDTO.class)).toList();
//    }

    @Override
    public void remove(Long pno) {
        productMapper.delete(pno);
    }

    @Override
    public void modify(ProductDTO productDTO) {
        ProductVO vo = modelMapper.map(productDTO, ProductVO.class);
        productMapper.update(vo);
    }

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        List<ProductVO> vos = productMapper.selectList(pageRequestDTO);
        List<ProductDTO> dtoList = vos.stream()
                .map(vo -> modelMapper.map(vo, ProductDTO.class))
                .toList();

        int total = productMapper.getCount(pageRequestDTO);

        return PageResponseDTO.<ProductDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }

}
