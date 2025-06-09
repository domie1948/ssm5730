package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FangkedengjiDao;
import com.entity.FangkedengjiEntity;
import com.service.FangkedengjiService;
import com.entity.vo.FangkedengjiVO;
import com.entity.view.FangkedengjiView;

@Service("fangkedengjiService")
public class FangkedengjiServiceImpl extends ServiceImpl<FangkedengjiDao, FangkedengjiEntity> implements FangkedengjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangkedengjiEntity> page = this.selectPage(
                new Query<FangkedengjiEntity>(params).getPage(),
                new EntityWrapper<FangkedengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangkedengjiEntity> wrapper) {
		  Page<FangkedengjiView> page =new Query<FangkedengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FangkedengjiVO> selectListVO(Wrapper<FangkedengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangkedengjiVO selectVO(Wrapper<FangkedengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangkedengjiView> selectListView(Wrapper<FangkedengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangkedengjiView selectView(Wrapper<FangkedengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
