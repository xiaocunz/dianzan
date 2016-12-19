package net.xiaocun.service.impl;

import net.xiaocun.common.PageResult;
import net.xiaocun.dao.CommentDao;
import net.xiaocun.model.Comment;
import net.xiaocun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    public Comment insert(Comment comment) {
        Long commentId = commentDao.insert(comment);
        comment.setId(commentId);
        return comment;
    }

    public PageResult<Comment> getCommentByPram(Comment comment, int page, int pageSize) {
        PageResult<Comment> result = new PageResult<Comment>();
        result.setPage(page);
        result.setPageSize(pageSize);
        long total = commentDao.countByParam(comment);
        List<Comment> data = commentDao.getCommentsByParam(comment, page, pageSize);
        result.setTotalNulber(total);
        result.setData(data);
        return result;
    }
}
