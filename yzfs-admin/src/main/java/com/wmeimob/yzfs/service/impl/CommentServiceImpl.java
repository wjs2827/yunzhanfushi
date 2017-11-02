package com.wmeimob.yzfs.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmeimob.yzfs.dao.GoodsCommentMapper;
import com.wmeimob.yzfs.service.CommentService;
import com.wmeimob.yzfs.vo.GoodsCommentVO;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private GoodsCommentMapper commentMapper;

    /**
     * 评论列表
     */
    @Override
    public List<GoodsCommentVO> queryCommentsInfo(Map<String, Object> map) {
        return commentMapper.queryCommentsInfo(map);
    }

    /**
     * 显示或者隐藏评论
     */
    @Override
    public Integer deleteComments(GoodsCommentVO params) {
        return commentMapper.deleteComments(params);
    }
}
