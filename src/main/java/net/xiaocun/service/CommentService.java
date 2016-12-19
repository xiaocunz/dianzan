package net.xiaocun.service;

import net.xiaocun.common.PageResult;
import net.xiaocun.model.Comment;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface CommentService {
    public PageResult<Comment> getCommentByPram(Comment comment, int page, int pageSize);
    public Comment insert(Comment comment);
}
