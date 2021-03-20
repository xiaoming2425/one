package cn.wewintech.work.outWork.controller;

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

import cn.wewintech.work.outWork.domain.OutWorkDO;
import cn.wewintech.work.outWork.service.OutWorkService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 出差申请
 * 
 * @author 
 * @email 
 * @date 2020-06-01 17:32:09
 */
 
@Controller
@RequestMapping("/work/outWork")
public class OutWorkController {
	@Autowired
	private OutWorkService outWorkService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("work:outWork:outWork")
	String OutWork(){
	    return "work/outWork/outWork";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:outWork:outWork")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OutWorkDO> outWorkList = outWorkService.list(query);
		int total = outWorkService.count(query);
		PageUtils pageUtils = new PageUtils(outWorkList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:outWork:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/outWork/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:outWork:edit")
	String edit(@PathVariable("id") String id,Model model){
		OutWorkDO outWork = outWorkService.get(id);
		model.addAttribute("outWork", outWork);
	    return "work/outWork/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:outWork:add")
	public ResultObject save( OutWorkDO outWork){
		if(outWorkService.save(outWork)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:outWork:edit")
	public ResultObject update( OutWorkDO outWork){
		outWorkService.update(outWork);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:outWork:remove")
	public ResultObject remove( String id){
		if(outWorkService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:outWork:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		outWorkService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
