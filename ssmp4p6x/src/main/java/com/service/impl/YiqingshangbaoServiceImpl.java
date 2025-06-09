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


import com.dao.YiqingshangbaoDao;
import com.entity.YiqingshangbaoEntity;
import com.service.YiqingshangbaoService;
import com.entity.vo.YiqingshangbaoVO;
import com.entity.view.YiqingshangbaoView;

@Service("yiqingshangbaoService")
public class YiqingshangbaoServiceImpl extends ServiceImpl<YiqingshangbaoDao, YiqingshangbaoEntity> implements YiqingshangbaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiqingshangbaoEntity> page = this.selectPage(
                new Query<YiqingshangbaoEntity>(params).getPage(),
                new EntityWrapper<YiqingshangbaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiqingshangbaoEntity> wrapper) {
		  Page<YiqingshangbaoView> page =new Query<YiqingshangbaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiqingshangbaoVO> selectListVO(Wrapper<YiqingshangbaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiqingshangbaoVO selectVO(Wrapper<YiqingshangbaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiqingshangbaoView> selectListView(Wrapper<YiqingshangbaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiqingshangbaoView selectView(Wrapper<YiqingshangbaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
