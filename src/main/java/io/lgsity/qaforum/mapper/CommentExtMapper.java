package io.lgsity.qaforum.mapper;

import io.lgsity.qaforum.pojo.Comment;

public interface CommentExtMapper {
    void incCommentCount(Comment comment);
}