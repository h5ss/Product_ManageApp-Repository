package com.ssg.productapp.controller;

import com.ssg.productapp.dto.PageRequestDTO;
import com.ssg.productapp.dto.ProductDTO;
import com.ssg.productapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info("product list..........");

        if (bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        model.addAttribute("responseDTO",productService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register(){
        log.info("register.....");
    }

    @PostMapping("/register")
    public String registerPost(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("post product register......");
        log.info(productDTO);

        if (bindingResult.hasErrors()){
            log.info("has errors....");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/product/list";
        }

        log.info(productDTO);
        productService.register(productDTO);

        return "redirect:/product/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long pno, PageRequestDTO pageRequestDTO, Model model){
        ProductDTO dto = productService.getOne(pno);
        log.info("read.....");
        log.info(dto);

        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String modify(ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("modify.....");

        if(bindingResult.hasErrors()){
            log.info("has errors.....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("pno",productDTO.getPno());
            return "redirect:/product/modify";
        }

        productService.modify(productDTO);
        return "redirect:/product/list";
    }

    @PostMapping("/remove")
    public String remove(Long pno, RedirectAttributes redirectAttributes){
        log.info("remove.....");

        productService.remove(pno);
        return "redirect:/product/list";
    }



}
