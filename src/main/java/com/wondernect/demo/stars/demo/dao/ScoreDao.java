package com.wondernect.demo.stars.demo.dao;

import com.wondernect.demo.stars.demo.model.Score;
import com.wondernect.elements.rdb.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 分数数据库操作类
 *
 * @author chenxun 2020-07-02 17:01:57
 **/
@Repository
public class ScoreDao extends BaseDao<Score, Long> {
}