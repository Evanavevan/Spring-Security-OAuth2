package com.evan.oauth2.resource.controller;

import com.evan.oauth2.resource.domain.TbContentCategory;
import com.evan.oauth2.resource.dto.ResponseResult;
import com.evan.oauth2.resource.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class TbContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    /**
     * 获取全部资源
     * @return {@link TbContentCategory}
     */
    @GetMapping("/")
    public ResponseResult<List<TbContentCategory>> selectAll() {
        return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentCategoryService.selectAll());
    }

    /**
     * 获取资源详情
     * @param id ID
     * @return {@link TbContentCategory}
     */
    @GetMapping("/view/{id}")
    public ResponseResult<TbContentCategory> getById(@PathVariable Long id) {
        return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContentCategoryService.getById(id));
    }

    /**
     * 新增资源
     * @param tbContentCategory {@link TbContentCategory}
     * @return int
     */
    @GetMapping("/insert")
    public ResponseResult<Integer> insert(@RequestBody TbContentCategory tbContentCategory) {
        int count = tbContentCategoryService.insert(tbContentCategory);
        if (count > 0) {
            return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), count);
        }
        return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
    }

    /**
     * 更新资源
     * @param tbContentCategory {@link TbContentCategory}
     * @return int
     */
    @GetMapping("/update")
    public ResponseResult<Integer> update(@RequestBody TbContentCategory tbContentCategory) {
        int count = tbContentCategoryService.update(tbContentCategory);
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
        int count = tbContentCategoryService.delete(id);
        if (count > 0) {
            return new ResponseResult<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), count);
        }
        return new ResponseResult<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
    }
}
