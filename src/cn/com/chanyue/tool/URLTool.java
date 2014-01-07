package cn.com.chanyue.tool;

/**
 * 网址长短管理
 * 
 * @author Howe
 * 
 */
public class URLTool {

	private static final String SOURCE = "";

	/**
	 * 长网址缩短
	 * @param urlLong
	 * @return
	 */
	public static String long2Short(String urlLong) {

		if (urlLong.equals(""))
			return null;
		else {
			String tmp = HttpClientTool
					.get("http://api.t.sina.com.cn/short_url/shorten.json?source="
							+ SOURCE
							+ "&url_long=" + CodeCryption.encode("URL", urlLong));
			if (tmp.indexOf("url_short") >= 0)
				return tmp.substring(tmp.indexOf("url_short") + 12,
						tmp.indexOf("url_long") - 3);
			else
				return null;
		}
	}

	/**
	 * 短网址还原
	 * @param urlShort
	 * @return
	 */
	public static String short2Long(String urlShort) {

		if (urlShort.equals(""))
			return null;
		else {
			String tmp = HttpClientTool
					.get("http://api.t.sina.com.cn/short_url/expand.json?source="
							+ SOURCE
							+ "&url_short=" + CodeCryption.encode("URL", urlShort));
			if (tmp.indexOf("url_long") >= 0) {
				return tmp.substring(tmp.indexOf("url_long") + 11,
						tmp.indexOf("type") - 3);
			} else
				return null;
		}
	}

}
