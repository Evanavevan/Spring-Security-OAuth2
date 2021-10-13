package com.evan.oauth2.resource.service;


import com.evan.oauth2.resource.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {
    /**
     * 根据 ID 获取
     *
     * @param id ID
     * @return {@link TbContentCategory}
     */
    default TbContentCategory getById(Long id) {
        return null;
    }

    /**
     * 获取全部数据
     *
     * @return {@link List<TbContentCategory>}
     */
    default List<TbContentCategory> selectAll() {
        return null;
    }

    /**
     * 新增
     *
     * @param tbContentCategory {@link TbContentCategory}
     * @return int 数据库受影响行数
     */
    default int insert(TbContentCategory tbContentCategory) {
        return 0;
    }

    /**
     * 编辑
     *
     * @param tbContentCategory {@link TbContentCategory}
     * @return int 数据库受影响行数
     */
    default int update(TbContentCategory tbContentCategory) {
        return 0;
    }

    /**
     * 删除
     *
     * @param id ID
     * @return int 数据库受影响行数
     */
    default int delete(Long id) {
        return 0;
    }
}
