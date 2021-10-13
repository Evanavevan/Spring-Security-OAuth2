package com.evan.oauth2.resource.controller;

import com.evan.oauth2.resource.domain.TbContent;
import com.evan.oauth2.resource.dto.ResponseResult;
import com.evan.oauth2.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    /**
     * 获取全部资源
     * @return {@link TbContent}
     */
    @GetMapping("/")
    public ResponseResult<List<TbContent>> selectAll() {
        return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentService.selectAll());
    }

    /**
     * 获取资源详情
     * @param id ID
     * @return {@link TbContent}
     */
    @GetMapping("/view/{id}")
    public ResponseResult<TbContent> getById(@PathVariable Long id) {
        return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentService.getById(id));
    }

    /**
     * 新增资源
     * @param tbContent {@link TbContent}
     * @return int
     */
    @GetMapping("/insert")
    public ResponseResult<Integer> insert(@RequestBody TbContent tbContent) {
        int count = tbContentService.insert(tbContent);
        if (count > 0) {
            return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), count);
        }
        return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
    }

    /**
     * 更新资源
     * @param tbContent {@link TbContent}
     * @return int
     */
    @GetMapping("/update")
    public ResponseResult<Integer> update(@RequestBody TbContent tbContent) {
        int count = tbContentService.update(tbContent);
        if (count > 0) {
            return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), count);
        }
        return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
    }

    /**
     * 删除资源
     * @param id ID
     * @return int
     */
    @GetMapping("/delete/{id}")
    public ResponseResult<Integer> delete(@PathVariable Long id) {
        int count = tbContentService.delete(id);
        if (count > 0) {
            return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), count);
        }
        return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
    }
}
