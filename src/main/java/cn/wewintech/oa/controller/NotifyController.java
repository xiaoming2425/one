package cn.wewintech.oa.controller;

import cn.wewintech.common.config.Constant;
import cn.wewintech.common.controller.BaseController;
import cn.wewintech.common.domain.DictDO;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.oa.domain.NotifyDO;
import cn.wewintech.oa.domain.NotifyRecordDO;
import cn.wewintech.oa.service.NotifyRecordService;
import cn.wewintech.oa.service.NotifyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知通告
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */

@Controller
@RequestMapping("/oa/notify")
public class NotifyController extends BaseController {
	@Autowired
	private NotifyService notifyService;
	@Autowired
	private NotifyRecordService notifyRecordService;
	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("oa:notify:notify")
	String oaNotify() {
		return "oa/notify/notify";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("oa:notify:notify")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<NotifyDO> notifyList = notifyService.list(query);
		int total = notifyService.count(query);
		PageUtils pageUtils = new PageUtils(notifyList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("oa:notify:add")
	String add() {
		return "oa/notify/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("oa:notify:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		NotifyDO notify = notifyService.get(id);
		List<DictDO> dictDOS = dictService.listByType("oa_notify_type");
		String type = notify.getType();
		for (DictDO dictDO:dictDOS){
			if(type.equals(dictDO.getValue())){
				dictDO.setRemarks("checked");
			}
		}
		model.addAttribute("oaNotifyTypes",dictDOS);
		model.addAttribute("notify", notify);
		return "oa/notify/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("oa:notify:add")
	public ResultObject save(NotifyDO notify) {
		notify.setCreateBy(getUserId());
		if (notifyService.save(notify) > 0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("oa:notify:edit")
	public ResultObject update(NotifyDO notify) {
		notifyService.update(notify);
		return ResultObject.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("oa:notify:remove")
	public ResultObject remove(Long id) {
		if (notifyService.remove(id) > 0) {
			return ResultObject.ok();
		}
		return ResultObject.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("oa:notify:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") Long[] ids) {
		notifyService.batchRemove(ids);
		return ResultObject.ok();
	}

	@ResponseBody
	@GetMapping("/message")
	PageUtils message() {
		Map<String, Object> params = new HashMap<>(16);
		params.put("offset", 0);
		params.put("limit", 3);
		Query query = new Query(params);
        query.put("userId", getUserId());
        query.put("isRead",Constant.OA_NOTIFY_READ_NO);
		return notifyService.selfList(query);
	}

	@GetMapping("/selfNotify")
	String selefNotify() {
		return "oa/notify/selfNotify";
	}

	@ResponseBody
	@GetMapping("/selfList")
	PageUtils selfList(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		query.put("userId", getUserId());

		return notifyService.selfList(query);
	}

	@GetMapping("/read/{id}")
	@RequiresPermissions("oa:notify:edit")
	String read(@PathVariable("id") Long id, Model model) {
		NotifyDO notify = notifyService.get(id);
		//更改阅读状态
		NotifyRecordDO notifyRecordDO = new NotifyRecordDO();
		notifyRecordDO.setNotifyId(id);
		notifyRecordDO.setUserId(getUserId());
		notifyRecordDO.setReadDate(new Date());
		notifyRecordDO.setIsRead(Constant.OA_NOTIFY_READ_YES);
		notifyRecordService.changeRead(notifyRecordDO);
		model.addAttribute("notify", notify);
		return "oa/notify/read";
	}



}
