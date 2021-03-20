package cn.wewintech.common.controller;

import cn.wewintech.system.domain.UserToken;
import org.springframework.stereotype.Controller;
import cn.wewintech.common.utils.ShiroUtils;
import cn.wewintech.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}