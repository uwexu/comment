package com.demo.comment.dao.mapper;

import com.demo.comment.dao.entity.CommentDO;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

    void save(CommentDO  comment);

    CommentDO selectOneById(@Param(value = "id") long id);

    void deleteOneById(@Param(value = "id") long id);

}
