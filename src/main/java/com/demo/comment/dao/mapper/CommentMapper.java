package com.demo.comment.dao.mapper;

import com.demo.comment.dao.entity.CommentDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    void save(CommentDO  comment);

    List<CommentDO> selectByDocId(@Param(value = "docId") long docId, @Param(value = "start") int start, @Param(value = "end") int end);

    void deleteOneById(@Param(value = "id") long id);

}
