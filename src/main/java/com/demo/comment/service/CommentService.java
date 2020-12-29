package com.demo.comment.service;

import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.entity.CommentDTO;

import java.util.List;

public interface CommentService {
    Long makeComment(CommentDTO comment);

    List<CommentDO> listByDocId(long docId, int pageNum, int pageSize);

    void delete(long id);
}
