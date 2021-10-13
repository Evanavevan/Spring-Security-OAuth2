package com.evan.oauth2.resource.service.impl;

import com.evan.oauth2.resource.domain.TbContentCategory;
import com.evan.oauth2.resource.mapper.TbContentCategoryMapper;
import com.evan.oauth2.resource.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryMapper.selectAll();
    }

    @Override
    public int insert(TbContentCategory tbContentCategory) {
        return tbContentCategoryMapper.insert(tbContentCategory);
    }

    @Override
    public int update(TbContentCategory tbContentCategory) {
        return tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
    }

    @Override
    public int delete(Long id) {
        return tbContentCategoryMapper.deleteByPrimaryKey(id);
    }
}
