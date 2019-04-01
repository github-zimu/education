package com.educationexampleproject.education.discuss.controller;

import com.educationexampleproject.education.discuss.entity.Discuss;
import com.educationexampleproject.education.discuss.service.DiscussService;
import com.educationexampleproject.education.utils.JsonUtil;
import com.educationexampleproject.education.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;


    /**
     * 查询帖子ID相关评论
     *
     * @param cardId
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryDiscuss.do")
    public String queryDisCuss(String cardId) {
        return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", discussService.queryDiscuss(cardId)));
    }

    /**
     * 添加评论
     *
     * @param context
     * @param userId
     * @param cardId
     * @return
     */
    @ResponseBody
    @RequestMapping("/addDiscuss.do")
    public String addDiscuss(String context, String userId, String cardId) {
        Discuss discuss = new Discuss();
        discuss.setContext(context);
        discuss.setUserId(userId);
        discuss.setCardId(cardId);
        return JsonUtil.toJSon(new ResponseData("200", "评论成功!", discussService.addDiscuss(discuss)));
    }
}
