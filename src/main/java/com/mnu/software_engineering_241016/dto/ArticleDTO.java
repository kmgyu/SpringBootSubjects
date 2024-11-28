package com.mnu.software_engineering_241016.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString // Attribute readable stream
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;
}
