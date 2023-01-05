package com.wzl.controller;

import cn.hutool.core.text.CharSequenceUtil;
import com.wzl.entity.Book;
import com.wzl.entity.BookVO;
import com.wzl.entity.RawBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiZhiLin
 * @version 1.0
 * @date 2023/1/3 13:39
 */
@RestController
public class BootController {
    @PostMapping("/tool/getBook")
    public ResponseEntity<BookVO> responseEntity(@RequestBody() RawBook rawBook) {
        String lines[] = rawBook.getStr().split("\\r?\\n");
        Book entity = new Book();
        for (String s : lines) {
            if (s.contains("书名: ")) {
                String title = CharSequenceUtil.subAfter(s, "书名: ", true);
                if (title.contains("（")) {
                    title = CharSequenceUtil.subBefore(title, "（", true);
                }
                entity.setTitle(title);
            } else if (s.contains("副标题: ")) {
                entity.setSubtitle("：" + CharSequenceUtil.subAfter(s, "副标题: ", true));
            } else if (s.contains("作者: ")) {
                entity.setAuthor(CharSequenceUtil.subAfter(s, "作者: ", true));
            } else if (s.contains("出版社: ")) {
                entity.setPublisher(CharSequenceUtil.subAfter(s, "出版社: ", true));
            } else if (s.contains("出版时间: ")) {
                entity.setPublicationTime(CharSequenceUtil.subAfter(s, "出版时间: ", true));
            } else if (s.contains("页数: ")) {
                entity.setWeight(CharSequenceUtil.subAfter(s, "页数: ", true));
            } else if (s.contains("豆瓣链接: ")) {
                entity.setLink(CharSequenceUtil.subAfter(s, "豆瓣链接: ", true));
            }
        }

        return new ResponseEntity<>(BookVO.builder()
                .fullName(entity.toString())
                .simpleName(entity.getSimpleName())
                .middleName(entity.getMiddleName()).build(), HttpStatus.OK);
    }

}
