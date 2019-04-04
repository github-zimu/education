package com.educationexampleproject.education.card.controller;

import com.educationexampleproject.education.card.service.CardService;
import com.educationexampleproject.education.utils.JsonUtil;
import com.educationexampleproject.education.utils.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    /**
     * 根据菜单ID查询菜单下所有帖子
     *
     * @param menuId
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryCard.do")
    public String queryCard(String menuId, String cardTwo) {
        return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", cardService.queryCard(menuId, cardTwo)));
    }

    String titles = null;

    @RequestMapping("/toDetail.do")
    public String toDetail(String title) {
        titles = title;
        return "details/detail";
    }

    /**
     * 根据标题查询帖子详情
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryCardToTitle.do")
    public String queryCardToTitle() {
        return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", cardService.queryCardToTitle(titles)));
    }

    /**
     * 根据标题查询帖子详情--vue
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryCardToTitleVue.do")
    public String queryCardToTitleVue(String title) {
        return JsonUtil.toJSon(new ResponseData("200", "成功获取数据!", cardService.queryCardToTitle(title)));
    }
}
