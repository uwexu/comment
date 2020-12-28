package com.demo.comment.service.impl;

import com.demo.comment.dao.CommentDao;
import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.entity.CommentDTO;
import com.demo.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Long makeComment(CommentDTO comment) {
        return commentDao.save(new CommentDO(comment.getAuthorId(), comment.getContent()));
    }

    @Override
    public void delete(Long id) {
        commentDao.deleteOneById(id);
    }

}
