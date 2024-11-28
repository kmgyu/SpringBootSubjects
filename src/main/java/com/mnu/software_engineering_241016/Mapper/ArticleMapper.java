package com.mnu.software_engineering_241016.Mapper;

import com.mnu.software_engineering_241016.dto.ArticleDTO;
import com.mnu.software_engineering_241016.entity.ArticleEntity;

public class ArticleMapper {
    public static ArticleDTO toDTO(ArticleEntity articleEntity) {
        return ArticleDTO.builder()
                .id(articleEntity.getId())
                .author(articleEntity.getAuthor())
                .password(articleEntity.getPassword())
                .title(articleEntity.getTitle())
                .content(articleEntity.getContent())
                .build();
    }

//    id는 db에 생성 권한 이양. 안넣어줘도 됨.
    public static ArticleEntity toEntity(ArticleDTO articleDTO) {
        return ArticleEntity.builder()
                .id(articleDTO.getId())
                .author(articleDTO.getAuthor())
                .password(articleDTO.getPassword())
                .title(articleDTO.getTitle())
                .content(articleDTO.getContent())
                .build();
    }
}
