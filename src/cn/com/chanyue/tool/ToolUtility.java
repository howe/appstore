package cn.com.chanyue.tool;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import cn.com.chanyue.bean.Game;
import cn.com.chanyue.interFace.GameFace;

/**
 * 工具类
 * 
 * @author Howe
 * 
 */
public class ToolUtility {

	/**
	 * 获取IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 解析XML
	 * 
	 * @param keyname
	 * @param srcstr
	 * @return
	 */
	public static String getxmlvalue(String keyname, String srcstr) {
		if (srcstr.indexOf("<" + keyname + ">") >= 0) {
			srcstr = srcstr.substring(srcstr.indexOf("<" + keyname + ">")
					+ keyname.length() + 2,
					srcstr.indexOf("</" + keyname + ">"));
			if (keyname.equals("msg")) {
				srcstr = replacebrack(srcstr);
			}
		} else {
			srcstr = "";
		}
		return srcstr;
	}

	private static String replacebrack(String str) {
		str = str.replaceAll("<", "");
		str = str.replaceAll(">", "");
		return str;
	}

	/**
	 * SQL过滤
	 * 
	 * @param sql
	 * @return
	 */
	public static String TransactSQLInjection(String sql) {
		return sql.replaceAll(".*([';]+|(--)+).*", "").replaceAll(" ", "");
	}

	public static String appId2AppName(String appId) {
		if (appId.equals("qq"))
			return "QQ登录";
		else if (appId.equals("weixin"))
			return "微信登录";
		else if (appId.equals("360"))
			return "360安全登录";
		else if (appId.equals("txwb"))
			return "腾讯微博登录";
		else if (appId.equals("alipay"))
			return "支付宝快捷登录";
		else if (appId.equals("taobao"))
			return "淘宝ID登录";
		else if (appId.equals("weibo"))
			return "新浪微博登录";
		else if (appId.equals("189"))
			return "天翼帐号登录";
		else if (appId.equals("163"))
			return "网易微博登录";
		else if (appId.equals("douban"))
			return "豆瓣帐号登录";
		else if (appId.equals("tudou"))
			return "土豆网帐号登录";
		else
			return "帐号登录";
	}

	/**
	 * 生成随机数字
	 * 
	 * @param length
	 *            长度
	 * @return
	 */
	public static String getRandomNumber(int length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			buffer.append(base.charAt(number));
		}
		return buffer.toString();
	}

	/**
	 * 生成随机字符
	 * 
	 * @param length
	 *            长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			buffer.append(base.charAt(number));
		}
		return buffer.toString();
	}

	/**
	 * 判断EMAIL格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean verifyEmail(String email) {

		if (email == null || email.length() < 5 || email.equals(""))
			// #如果帐号小于5位，则肯定不可能为邮箱帐号eg: x@x.x
			return false;
		if (!email.contains("@")) // 判断是否含有@符号
			return false;// 没有@则肯定不是邮箱
		String[] tmp = email.split("@");
		if (tmp.length != 2) // # 数组长度不为2则包含2个以上的@符号，不为邮箱帐号
			return false;
		if (tmp[0].length() <= 0) // #@前段为邮箱用户名，自定义的话至少长度为1，其他暂不验证
			return false;
		if (tmp[1].length() < 3 || !tmp[1].contains("."))
			// # @后面为域名，位数小于3位则不为有效的域名信息
			// #如果后端不包含.则肯定不是邮箱的域名信息
			return false;
		else {
			if (tmp[1].substring(tmp[1].length() - 1).equals("."))
				// # 最后一位不能为.结束
				return false;
			String[] domain = tmp[1].split("\\.");
			// #将域名拆分 tm-sp.com 或者 .com.cn.xxx
			for (String str : domain) {
				if (str.length() <= 0)
					return false;
			}

		}
		return true;
	}

	/**
	 * 判断手机号码格式
	 * 
	 * @param mobi
	 * @return
	 */
	public static boolean verifyMobile(String mobi) {

		if (mobi == null || mobi.equals(""))
			return false;
		Pattern pattern = Pattern
				.compile("^((13[0-9])|(145)|(147)|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(mobi);
		return matcher.matches();
	}

	public static boolean verifyUrl(String url) {

		if (url == null || url.equals(""))
			return false;
		Pattern pattern = Pattern
				.compile("[http|https]+[://]+[0-9A-Za-z:/[-]_#[?][=][.]]*");
		Matcher matcher = pattern.matcher(url);
		return matcher.matches();
	}

	/**
	 * 判断QQ格式
	 * 
	 * @param qq
	 * @return
	 */
	public static boolean verifyQQ(String qq) {
		if (qq == null || qq.equals(""))
			return false;
		else if (qq.length() < 5 || qq.length() > 11)
			return false;
		else
			return isNumeric(qq);
	}

	/**
	 * 判断是否是汉字
	 * 
	 * @param str
	 *            字符
	 * @return
	 */
	public static boolean verifyChinese(String str) {
		if (null == str || "".equals(str.trim()))
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (isChinese(str.charAt(i)))
				return true;
		}
		return false;
	}

	private static boolean isChinese(char a) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(a);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 判断身份证号码
	 * 
	 * @param idCard
	 *            身份证号码
	 * @return
	 */
	public static boolean verifyIdCard(String idCard) {
		if (idCard == null || idCard.equals(""))
			return false;
		if (idCard.length() == 15)
			idCard = uptoeighteen(idCard);
		if (idCard.length() != 18)
			return false;
		String verify = idCard.substring(17, 18);
		if (verify.equals(getVerify(idCard)))
			return true;
		return false;
	}

	// wi =2(n-1)(mod 11);加权因子
	static final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4,
			2, 1 };
	// 校验码
	static final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
	static int[] ai = new int[18];

	// 15位转18位
	private static String uptoeighteen(String fifteen) {
		StringBuffer eighteen = new StringBuffer(fifteen);
		eighteen = eighteen.insert(6, "19");
		return eighteen.toString();
	}

	// 计算最后一位校验值
	private static String getVerify(String eighteen) {
		int remain = 0;
		if (eighteen.length() == 18)
			eighteen = eighteen.substring(0, 17);
		if (eighteen.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eighteen.substring(i, i + 1);
				ai[i] = Integer.valueOf(k);
			}
			for (int i = 0; i < 17; i++) {
				sum += wi[i] * ai[i];
			}
			remain = sum % 11;
		}
		return remain == 2 ? "X" : String.valueOf(vi[remain]);

	}

	/**
	 * 过滤HTML标签
	 * 
	 * @param input
	 * @param length
	 * @return
	 */
	public static String splitAndFilterString(String input, int length) {
		if (input == null || input.trim().equals("")) {
			return "";
		}
		// 去掉所有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll(
				"<[^>]*>", "");
		str = str.replaceAll("[(/>)<]", "");
		int len = str.length();
		if (len <= length) {
			return str;
		} else {
			str = str.substring(0, length);
			str += "...";
		}
		return str;
	}
	
	
	/**
	 * 查询游戏名称
	 * @param gid
	 * @return
	 */
	public static String queryGameNameById(Integer gid){
		
		Game game = new GameFace().queryGame(gid.toString());
		if(game!=null)
			return "["+game.getGameName()+"（"+game.getPlatform()+"）]";
		else
			return "";
	}

}
