package com.demo.comment.service;

import com.demo.comment.entity.CommentDTO;

public interface CommentService {
    Long makeComment(CommentDTO comment);
}
