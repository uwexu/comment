package com.demo.comment.controller;

import com.demo.comment.constant.ResponseCode;
import com.demo.comment.entity.CommentDTO;
import com.demo.comment.entity.ResponseDTO;
import com.demo.comment.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



@RequestMapping("/comment")
@RestController
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/makeComment", produces = APPLICATION_JSON_VALUE)
    public ResponseDTO savePushContent(@RequestBody CommentDTO comment) {
        if (logger.isDebugEnabled()) {
            logger.debug("CommentDTO: {}",comment);
        }
        try {
            long id = commentService.makeComment(comment);
            return ResponseDTO.success(id);
        } catch (Exception e) {
            logger.error("serverError when save pushContent", e);
            return ResponseDTO.fail(ResponseCode.SERVER_ERROR.getCode(), ResponseCode.SERVER_ERROR.getMessage());
        }
    }


}
