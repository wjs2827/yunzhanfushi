package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import com.wmeimob.yzfs.vo.GoodsCommentVO;

public interface CommentService {
    /**
     * 查询评价信息
     * @param map
     * @return
     */
    public List<GoodsCommentVO> queryCommentsInfo(Map<String, Object> map);

    /**
     * 显示或者隐藏评论
     */
    public Integer deleteComments(GoodsCommentVO params);
}
