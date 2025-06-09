package com.dao;

import com.entity.FangkedengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangkedengjiVO;
import com.entity.view.FangkedengjiView;


/**
 * 访客登记
 * 
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface FangkedengjiDao extends BaseMapper<FangkedengjiEntity> {
	
	List<FangkedengjiVO> selectListVO(@Param("ew") Wrapper<FangkedengjiEntity> wrapper);
	
	FangkedengjiVO selectVO(@Param("ew") Wrapper<FangkedengjiEntity> wrapper);
	
	List<FangkedengjiView> selectListView(@Param("ew") Wrapper<FangkedengjiEntity> wrapper);

	List<FangkedengjiView> selectListView(Pagination page,@Param("ew") Wrapper<FangkedengjiEntity> wrapper);
	
	FangkedengjiView selectView(@Param("ew") Wrapper<FangkedengjiEntity> wrapper);
	
}
