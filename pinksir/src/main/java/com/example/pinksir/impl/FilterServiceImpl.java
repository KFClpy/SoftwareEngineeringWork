package com.example.pinksir.impl;

import com.example.pinksir.runner.InitialCache;
import com.example.pinksir.service.FilterService;
import com.example.pinksir.service.GroupService;
import com.example.pinksir.service.WordService;
import com.example.pinksir.wordfilter.ACAutomaton;
import com.example.pinksir.wordfilter.SensitiveInfo;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service

public class FilterServiceImpl implements FilterService {
    @Autowired
    GroupService groupService;
    @Autowired
    WordService wordService;

    @Override
    public boolean isExist(String group_num) {
        int rows=groupService.findGroup(group_num).size();
        return rows != 0;
    }

    @Override
    public boolean isInvalid(String str) {
        List<ACAutomaton.Match> list = InitialCache.getGe().findSensitive(str);
        List<String> forbidWordList = new ArrayList<>();
        for (Iterator<ACAutomaton.Match> iter = list.iterator(); iter.hasNext(); ) {
            ACAutomaton.Match match = iter.next();
            SensitiveInfo info = (SensitiveInfo) match.info;
            forbidWordList.add(info.getTerm());
        }
        return forbidWordList != null && forbidWordList.size() > 0;
    }

    @Override
    public String randomReply() {
        List<String> strlist = new ArrayList<>();
        strlist.add("少放屁");
        strlist.add("请文明发言");
        strlist.add("请发言符合核心价值观");
        strlist.add("你真是÷");
        strlist.add("脑瘫");
        Random random = new Random();
        return strlist.get(random.nextInt(strlist.size()));
    }
}
