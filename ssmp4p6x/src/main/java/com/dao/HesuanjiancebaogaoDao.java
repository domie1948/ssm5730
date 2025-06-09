package com.dao;

import com.entity.HesuanjiancebaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HesuanjiancebaogaoVO;
import com.entity.view.HesuanjiancebaogaoView;


/**
 * 核酸检测报告
 * 
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface HesuanjiancebaogaoDao extends BaseMapper<HesuanjiancebaogaoEntity> {
	
	List<HesuanjiancebaogaoVO> selectListVO(@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);
	
	HesuanjiancebaogaoVO selectVO(@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);
	
	List<HesuanjiancebaogaoView> selectListView(@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);

	List<HesuanjiancebaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);
	
	HesuanjiancebaogaoView selectView(@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);
	
}
