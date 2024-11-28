package com.mnu.software_engineering_241016.controller;

import com.mnu.software_engineering_241016.dto.ArticleDTO;
import com.mnu.software_engineering_241016.service.ArticleSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
@Slf4j // log4j를 상속받는? 아무튼 log 쓰는 라이브러리
public class ArticleController {
    private final ArticleSerivce articleSerivce;

    @GetMapping("/")
    public String index(Model model) {
        List<ArticleDTO> articleDTOList = articleSerivce.getAllArticles();
        model.addAttribute("articles", articleDTOList);
        return "articles/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "articles/create";
    }

    @PostMapping("/create")
    public String create(
            @ModelAttribute ArticleDTO articleDTO) {
        // log 남기기
        log.info("saved article {}", articleDTO.toString());
        System.out.println(articleDTO.getAuthor()+articleDTO.getPassword()+articleDTO.getContent()+articleDTO.getTitle());
        articleSerivce.createArticle(articleDTO);
        return "redirect:/articles/";
    }

    @RequestMapping("/article/{id}")
    public String showArticle(
            @PathVariable("id") Long id,
            Model model) {
        Optional<ArticleDTO> articleDTO = articleSerivce.getArticleById(id);
        if (articleDTO.isPresent()) {
            model.addAttribute("formData", articleDTO.get());
            return "articles/article";
        }
        return "articles/not_found";
    }
}
