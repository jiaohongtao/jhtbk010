package com.tencent.examples.demo.web.rest;

import com.tencent.bk.api.cc.CCApi;
import com.tencent.bk.api.cc.req.GetHostBaseInfoReq;
import com.tencent.bk.api.cc.req.SearchBusinessReq;
import com.tencent.bk.api.cc.req.SearchHostReq;
import com.tencent.bk.api.gse.GseApi;
import com.tencent.bk.api.gse.req.GetAgentStatusReq;
import com.tencent.bk.api.login.BKLoginApi;
import com.tencent.bk.utils.json.JsonUtil;
import com.tencent.examples.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController extends BaseController {

	@Autowired
	CCApi ccApi;
	@Autowired
	GseApi gseApi;
	/*@Autowired
	BKLoginApi bkLoginApi;*/

	@RequestMapping(value = "/test/list", method = {RequestMethod.GET})
	@ResponseBody
	public String getServiceList(HttpServletRequest request) {

		SearchBusinessReq req = ccApi.makeBaseReqByWeb(SearchBusinessReq.class, request);

		//System.out.println("================");
		//System.out.println(ccApi.searchBusiness(req));
		return JsonUtil.toJson(ccApi.searchBusiness(req));
	}

	@RequestMapping(value = "/test/agentList", method = {RequestMethod.GET})
	public String getAgentList(HttpServletRequest request) {

		GetAgentStatusReq req = gseApi.makeBaseReqByWeb(GetAgentStatusReq.class, request);
		return JsonUtil.toJson(gseApi.getAgentStatus(req));
	}

	/*@RequestMapping(value = "/test/hostList2", method = {RequestMethod.GET})
	public String getHostList2(HttpServletRequest request) {

		GetHostBaseInfoReq req = ccApi.makeBaseReqByWeb(GetHostBaseInfoReq.class, request);
		return JsonUtil.toJson(ccApi.getHostBaseInfo(req));
	}*/

	@RequestMapping(value = "/test/hostList", method = {RequestMethod.GET})
	public String getHostList(HttpServletRequest request) {

		SearchHostReq req = ccApi.makeBaseReqByWeb(SearchHostReq.class, request);
		return JsonUtil.toJson(ccApi.searchHost(req));
	}
}
