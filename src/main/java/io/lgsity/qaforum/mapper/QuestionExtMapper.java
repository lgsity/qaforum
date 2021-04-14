package io.lgsity.qaforum.mapper;

import io.lgsity.qaforum.pojo.Question;

public interface QuestionExtMapper {
    void incViewCount(Question question);
}