package com.mnu.software_engineering_241016.service;

import com.mnu.software_engineering_241016.Mapper.ArticleMapper;
import com.mnu.software_engineering_241016.dto.ArticleDTO;
import com.mnu.software_engineering_241016.entity.ArticleEntity;
import com.mnu.software_engineering_241016.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleSerivce {
    private final ArticleRepository articleRepository;

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream().map(ArticleMapper:: toDTO).collect(Collectors.toList());
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = ArticleMapper.toEntity(articleDTO);
        return ArticleMapper.toDTO(articleRepository.save(articleEntity));
    }

    public Optional<ArticleDTO> getArticleById(Long id) {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        ArticleDTO result = null;
        if (articleEntity.isPresent()) {
            result = ArticleMapper.toDTO(articleEntity.get());
        }
        return Optional.ofNullable(result);
    }

    public boolean removeArticleById(Long id) {
        Optional<ArticleEntity> targetArticle = articleRepository.findById(id);
        if (targetArticle.isPresent()) {
            articleRepository.delete(targetArticle.get());
            return true;
        }
        return false;
    }
}
