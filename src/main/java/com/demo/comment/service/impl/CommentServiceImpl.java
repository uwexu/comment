package com.demo.comment.service.impl;

import com.demo.comment.dao.CommentDao;
import com.demo.comment.dao.entity.CommentDO;
import com.demo.comment.entity.CommentDTO;
import com.demo.comment.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CommentServiceImpl implements CommentService {
    Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentDao commentDao;

    @Override
    public Long makeComment(CommentDTO comment) {
        return commentDao.save(new CommentDO(comment.getAuthorId(), comment.getContent()));
    }

    @PostConstruct
    public void test() {
        logger.info("this is info");
        logger.debug("this is debug");
    }

}
