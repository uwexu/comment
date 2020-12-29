package com.demo.comment.dao;

import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.dao.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDao {

    @Autowired
    private CommentMapper commentMapper;

    public long save(CommentDO comment) {
        commentMapper.save(comment);
        return comment.getId();
    }

    public List<CommentDO> selectByDocId(long docId, int start, int end) {
        return commentMapper.selectByDocId(docId, start, end);
    }

    public void deleteOneById(long id) {
        commentMapper.deleteOneById(id);
    }

}
