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


import com.dao.HesuanjiancebaogaoDao;
import com.entity.HesuanjiancebaogaoEntity;
import com.service.HesuanjiancebaogaoService;
import com.entity.vo.HesuanjiancebaogaoVO;
import com.entity.view.HesuanjiancebaogaoView;

@Service("hesuanjiancebaogaoService")
public class HesuanjiancebaogaoServiceImpl extends ServiceImpl<HesuanjiancebaogaoDao, HesuanjiancebaogaoEntity> implements HesuanjiancebaogaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HesuanjiancebaogaoEntity> page = this.selectPage(
                new Query<HesuanjiancebaogaoEntity>(params).getPage(),
                new EntityWrapper<HesuanjiancebaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HesuanjiancebaogaoEntity> wrapper) {
		  Page<HesuanjiancebaogaoView> page =new Query<HesuanjiancebaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HesuanjiancebaogaoVO> selectListVO(Wrapper<HesuanjiancebaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HesuanjiancebaogaoVO selectVO(Wrapper<HesuanjiancebaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HesuanjiancebaogaoView> selectListView(Wrapper<HesuanjiancebaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HesuanjiancebaogaoView selectView(Wrapper<HesuanjiancebaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
