package cn.wewintech.common.controller;

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

import cn.wewintech.common.domain.SeqnoDO;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;

/**
 * 流水号生成
 * 
 * @author 
 * @email 
 * @date 2020-05-15 16:24:23
 */
 
@Controller
@RequestMapping("/common/seqno")
public class SeqnoController {
	@Autowired
	private SeqnoService seqnoService;
	@Autowired
	private DictService dictService; 
	
	@GetMapping()
	@RequiresPermissions("common:seqno:seqno")
	String Seqno(){
	    return "common/seqno/seqno";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:seqno:seqno")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SeqnoDO> seqnoList = seqnoService.list(query);
		for (SeqnoDO seqnoDO : seqnoList) {
			seqnoDO.setGenName(dictService.findNameByValueAndType(String.valueOf(seqnoDO.getGenType()), "gen_type"));
		}
		int total = seqnoService.count(query);
		PageUtils pageUtils = new PageUtils(seqnoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:seqno:add")
	String add(){
	    return "common/seqno/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:seqno:edit")
	String edit(@PathVariable("id") String id,Model model){
		SeqnoDO seqno = seqnoService.get(id);
		model.addAttribute("seqno", seqno);
	    return "common/seqno/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:seqno:add")
	public ResultObject save( SeqnoDO seqno){
		if(seqnoService.save(seqno)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:seqno:edit")
	public ResultObject update( SeqnoDO seqno){
		seqnoService.update(seqno);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:seqno:remove")
	public ResultObject remove( String id){
		if(seqnoService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:seqno:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		seqnoService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
