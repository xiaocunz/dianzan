package net.xiaocun.dao;

import net.xiaocun.model.Comment;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
public interface CommentDao {
    public Long insert(Comment comment);
    public List<Comment> getCommentsByParam(Comment comment, int page, int pageSize);
    public long countByParam(Comment param);
}
