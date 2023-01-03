package com.wzl.entity;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author weiZhiLin
 * @version 1.0
 * @date 2023/1/3 14:06
 */
@Component
@Getter
@Setter
public class Book {
    private String title;
    private String subtitle;
    private String author;
    private String publisher;
    private String publicationTime;
    private String weight;
    private String link;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("《").append(title).append(CharSequenceUtil.nullToDefault(subtitle, "")).append("》");
        sb.append(" ").append(author);
        sb.append(" ").append(publicationTime);
        sb.append(" ").append(publisher);
        sb.append(" ").append(weight);
        sb.append(" [豆瓣链接](").append(link).append(")");
        return sb.toString();
    }
}
