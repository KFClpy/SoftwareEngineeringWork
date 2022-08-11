package com.example.pinksir.wordfilter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

    public static Logger LOG =  LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        String word = "习近平和毛泽东";
        // word = ChineseToEnglish.getPingYin(word);
        List<ACAutomaton.Match> list = StaticValue.getGoldenEyes().findSensitive(word);
        // List<ACAutomaton.Match> list = WordFilterUtil.ge.findSensitive(word);
        List<String> forbidWordList = new ArrayList<>();
        JSONObject json = new JSONObject();
        for (Iterator<ACAutomaton.Match> iter = list.iterator(); iter.hasNext();) {
            ACAutomaton.Match match = iter.next();
            SensitiveInfo info = (SensitiveInfo) match.info;
            forbidWordList.add(info.getTerm());
        }

        json.put("code", 0);
        json.put("check_status", forbidWordList.size() > 0 ? false : true);
        json.put("message", forbidWordList.size() > 0 ? "注意! 验证文本中含有敏感词!" : "ok! 验证文本无敏感词!");
        json.put("forbid_word_list", forbidWordList);
        if (forbidWordList != null && forbidWordList.size() > 0) {
            for (String w : forbidWordList) {
                LOG.info(Joiner.on("|").join(word, w));
                System.out.println(Joiner.on("|").join(word, w));
            }
        }
        System.out.println(json);

    }
}
