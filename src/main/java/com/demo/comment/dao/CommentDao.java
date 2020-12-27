package com.demo.comment.dao;

import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.dao.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentDao {

    @Autowired
    private CommentMapper commentMapper;

    public long save(CommentDO comment) {
        commentMapper.save(comment);
        return comment.getId();
    }

    public CommentDO selectOneById(Long id) {
        return commentMapper.selectOneById(id);
    }

    public void deleteOneById(Long id) {
        commentMapper.deleteOneById(id);
    }

}
