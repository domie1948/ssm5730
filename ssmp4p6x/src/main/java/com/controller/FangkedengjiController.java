package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FangkedengjiEntity;
import com.entity.view.FangkedengjiView;

import com.service.FangkedengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 访客登记
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-22 10:48:58
 */
@RestController
@RequestMapping("/fangkedengji")
public class FangkedengjiController {
    @Autowired
    private FangkedengjiService fangkedengjiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangkedengjiEntity fangkedengji, HttpServletRequest request){

        EntityWrapper<FangkedengjiEntity> ew = new EntityWrapper<FangkedengjiEntity>();
		PageUtils page = fangkedengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangkedengji), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangkedengjiEntity fangkedengji, HttpServletRequest request){
        EntityWrapper<FangkedengjiEntity> ew = new EntityWrapper<FangkedengjiEntity>();
		PageUtils page = fangkedengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangkedengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangkedengjiEntity fangkedengji){
       	EntityWrapper<FangkedengjiEntity> ew = new EntityWrapper<FangkedengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangkedengji, "fangkedengji")); 
        return R.ok().put("data", fangkedengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangkedengjiEntity fangkedengji){
        EntityWrapper< FangkedengjiEntity> ew = new EntityWrapper< FangkedengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangkedengji, "fangkedengji")); 
		FangkedengjiView fangkedengjiView =  fangkedengjiService.selectView(ew);
		return R.ok("查询访客登记成功").put("data", fangkedengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangkedengjiEntity fangkedengji = fangkedengjiService.selectById(id);
        return R.ok().put("data", fangkedengji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangkedengjiEntity fangkedengji = fangkedengjiService.selectById(id);
        return R.ok().put("data", fangkedengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangkedengjiEntity fangkedengji, HttpServletRequest request){
    	fangkedengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangkedengji);

        fangkedengjiService.insert(fangkedengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangkedengjiEntity fangkedengji, HttpServletRequest request){
    	fangkedengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangkedengji);

        fangkedengjiService.insert(fangkedengji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FangkedengjiEntity fangkedengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangkedengji);
        fangkedengjiService.updateById(fangkedengji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangkedengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<FangkedengjiEntity> wrapper = new EntityWrapper<FangkedengjiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = fangkedengjiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
