package cn.com.chanyue.module;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;

import cn.com.chanyue.bean.Ad;
import cn.com.chanyue.bean.Game;
import cn.com.chanyue.bean.News;
import cn.com.chanyue.tool.CodeCryption;
import cn.com.chanyue.tool.URLTool;

@IocBean(fields = {"dao"})
public class ControlModule {

	private Dao dao;

	@GET
	@At("/news/id/*")
	@Ok("jetx:/news_info.jetx")
	public Map<String, Object> queryNews(String nid) throws IOException {

		News news = dao.fetch(News.class, Cnd.where("id", "=", nid));
		if (news == null)
			Mvcs.getResp().sendRedirect("/404.html");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("news", news);
		Game game = dao.fetch(Game.class, Cnd.where("id", "=", news.getGid()));
		map.put("game", game);
		return map;
	}

	@GET
	@At("/game/id/*")
	@Ok("jetx:/game_info.jetx")
	public Map<String, Object> queryGame(String gid) throws IOException {
		Game game = dao.fetch(Game.class, Cnd.where("id", "=", gid));
		if (game == null)
			Mvcs.getResp().sendRedirect("/404.html");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("game", game);
		if (game != null) {
			String weiboUrl = "http://weibo.cn/ext/share?ru="
					+ CodeCryption.encode(
							"URL",
							URLTool.long2Short("http://xxxxxxxx.com/game/id/"
									+ gid))
					+ "&rt="
					+ CodeCryption.encode("URL", " - 手游下载")
					+ "&st="
					+ System.currentTimeMillis()
					/ 1000
					+ "&appkey=xxxxxxxxxxxxxx&relateUid=xxxxxxxxxxxx&skipshow=1&ntitle="
					+ CodeCryption.encode(
							"URL",
							"我下载了" + game.getGameName() + "（"
									+ game.getPlatform() + "），大家都来玩啊~~");
			map.put("weiboUrl", weiboUrl);
		}
		return map;
	}

	@GET
	@At("/index")
	@Ok("jetx:/index.jetx")
	public Map<String, Object> index() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = dao.query(Ad.class, Cnd.where("type", "=", "index").and("STATUS", "=", "1").desc("addTime").asc("type"));
		List<Game> hots = dao.query(Game.class, Cnd.where("hot", "=", "1").limit(0, 6).desc("UPDATES"));
		List<Game> tops = dao.query(Game.class, Cnd.where("top", "=", "1").limit(0, 4).desc("UPDATES"));
		List<News> newses = dao.query(News.class, Cnd.where("1", "=" ,"1").limit(0, 4).desc("PUBLISHED").desc("top"));
		map.put("ads", ads);
		map.put("hots", hots);
		map.put("tops", tops);
		map.put("newses", newses);
		return map;
	}

	@GET
	@At("/")
	@Ok("jetx:/index.jetx")
	public Map<String, Object> index1() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = dao.query(Ad.class, Cnd.where("type", "=", "index").and("STATUS", "=", "1").desc("addTime").asc("type"));
		List<Game> hots = dao.query(Game.class, Cnd.where("hot", "=", "1").limit(0, 6).desc("UPDATES"));
		List<Game> tops = dao.query(Game.class, Cnd.where("top", "=", "1").limit(0, 4).desc("UPDATES"));
		List<News> newses = dao.query(News.class, Cnd.where("1", "=" ,"1").limit(0, 4).desc("PUBLISHED").desc("top"));
		map.put("ads", ads);
		map.put("hots", hots);
		map.put("tops", tops);
		map.put("newses", newses);
		return map;
	}

	@GET
	@At("/game/")
	@Ok("jetx:/game_list.jetx")
	public Map<String, Object> gameList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = dao.query(Ad.class, Cnd.where("type", "=", "game").and("STATUS", "=", "1").desc("addTime").asc("type"));
		List<Game> hots = dao.query(Game.class, Cnd.where("hot", "=", "1").limit(0, 6).desc("UPDATES"));
		List<Game> tops = dao.query(Game.class, Cnd.where("top", "=", "1").limit(0, 4).desc("UPDATES"));
		map.put("hots", hots);
		map.put("tops", tops);
		map.put("ads", ads);
		return map;
	}

	@GET
	@At("/news/")
	@Ok("jetx:/news_list.jetx")
	public Map<String, Object> newsList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = dao.query(Ad.class, Cnd.where("type", "=", "news").and("STATUS", "=", "1").desc("addTime").asc("type"));
		List<News> newses = dao.query(News.class, Cnd.where("1", "=" ,"1").limit(0, 998).desc("PUBLISHED").desc("top"));
		map.put("ads", ads);
		map.put("newses", newses);
		return map;
	}
}
