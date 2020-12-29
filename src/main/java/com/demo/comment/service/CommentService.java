package com.demo.comment.service;

import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.entity.CommentDTO;

public interface CommentService {
    Long makeComment(CommentDTO comment);

    CommentDO listByDocId(Long docId);

    void delete(Long id);
}
