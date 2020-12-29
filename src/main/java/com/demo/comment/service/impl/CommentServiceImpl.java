package com.demo.comment.service.impl;

import com.demo.comment.dao.CommentDao;
import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.entity.CommentDTO;
import com.demo.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Long makeComment(CommentDTO comment) {
        return commentDao.save(new CommentDO(comment.getAuthorId(), comment.getDocId(), comment.getContent()));
    }

    @Override
    public List<CommentDO> listByDocId(long docId, int pageNum, int pageSize) {
        return commentDao.selectByDocId(docId, (pageNum-1)*pageSize, pageSize);
    }

    @Override
    public void delete(long id) {
        commentDao.deleteOneById(id);
    }

}
