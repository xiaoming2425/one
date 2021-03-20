package cn.wewintech.work.car.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wewintech.work.car.domain.CarDO;
import cn.wewintech.work.car.service.CarService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 用车申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 09:46:05
 */
 
@Controller
@RequestMapping("/work/car")
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("work:car:car")
	String Car(){
	    return "work/car/car";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:car:car")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CarDO> carList = carService.list(query);
		int total = carService.count(query);
		PageUtils pageUtils = new PageUtils(carList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:car:add")
	String add(Model model){
		
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/car/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:car:edit")
	String edit(@PathVariable("id") String id,Model model){
		CarDO car = carService.get(id);
		model.addAttribute("car", car);
	    return "work/car/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:car:add")
	public ResultObject save( CarDO car){
		if(carService.save(car)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:car:edit")
	public ResultObject update( CarDO car){
		carService.update(car);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:car:remove")
	public ResultObject remove( String id){
		if(carService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:car:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		carService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
