package com.demo.comment.dao.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class CommentDO {
    private Long id;
    private String content;
    private Long authorId;
    private Long docId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public CommentDO(Long authorId, Long docId, String content) {
        this.authorId = authorId;
        this.docId = docId;
        this.content = content;
    }

    public CommentDO(Long id, String content, Long authorId, Long docId, Date createTime) {
        this.id = id;
        this.content = content;
        this.authorId = authorId;
        this.docId = docId;
        this.createTime = createTime;
    }

}
