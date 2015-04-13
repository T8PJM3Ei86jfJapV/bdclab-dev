package com.ricoxie.bdc.test;

import com.ricoxie.bdc.pool.Constant;
import com.ricoxie.bdc.weibo.WeiboUser;

public final class TestWeibo {

	public static void main(String[] args) {
		
		String token = Constant.WEIBO_ACCESS_TOKEN;
		
		WeiboUser user = new WeiboUser(token);
		
		long uid = 3316161562L;
		String nickname = "-肥猩肥猩-";
		System.out.println(String.valueOf(user.getUserInfo(nickname)));
		System.out.println(String.valueOf(user.getUserInfo(uid)));
	}
}
