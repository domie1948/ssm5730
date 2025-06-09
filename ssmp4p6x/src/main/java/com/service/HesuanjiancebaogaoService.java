package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HesuanjiancebaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HesuanjiancebaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HesuanjiancebaogaoView;


/**
 * 核酸检测报告
 *
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
public interface HesuanjiancebaogaoService extends IService<HesuanjiancebaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HesuanjiancebaogaoVO> selectListVO(Wrapper<HesuanjiancebaogaoEntity> wrapper);
   	
   	HesuanjiancebaogaoVO selectVO(@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);
   	
   	List<HesuanjiancebaogaoView> selectListView(Wrapper<HesuanjiancebaogaoEntity> wrapper);
   	
   	HesuanjiancebaogaoView selectView(@Param("ew") Wrapper<HesuanjiancebaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HesuanjiancebaogaoEntity> wrapper);
   	
}

