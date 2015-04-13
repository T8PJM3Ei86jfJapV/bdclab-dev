package com.ricoxie.bdc.weibo;

import java.io.IOException;
import java.util.Random;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

public class WeiboUser {

	private String BASE_URL;

	public WeiboUser(String token) {
		BASE_URL = "https://api.weibo.com/2/users/show.json?access_token=".concat(token);
	}

	private String getUserAgent() {
		String[] userAgent = new String[3];
		userAgent[0] = "Mozilla/5.0 (X11; Linux x86_64)";
		userAgent[1] = "Opera/9.23 (Windows NT 5.0; U; en)";
		userAgent[2] = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3)";
		int index = new Random().nextInt(3);
		return userAgent[index];
	}

	public Content getUserInfo(String nickname) {
		String url = BASE_URL.concat(String.format("&screen_name=%s", nickname));

		Content content = null;

		try {
			Request request = Request.Get(url).addHeader("User-Agent", getUserAgent());
			content = request.execute().returnContent();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	public Content getUserInfo(long uid) {
		String url = BASE_URL.concat(String.format("&uid=%d", uid));

		Content content = null;

		try {
			Request request = Request.Get(url).addHeader("User-Agent", getUserAgent());
			content = request.execute().returnContent();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}
}

