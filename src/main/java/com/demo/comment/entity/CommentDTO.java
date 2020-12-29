package com.demo.comment.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long authorId;
    private String content;
    private Long   docId;
}
