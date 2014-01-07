package cn.com.chanyue.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import cn.com.chanyue.bean.Ad;
import cn.com.chanyue.bean.Game;
import cn.com.chanyue.bean.News;
import cn.com.chanyue.interFace.AdsFace;
import cn.com.chanyue.interFace.GameFace;
import cn.com.chanyue.interFace.NewsFace;
import cn.com.chanyue.tool.CodeCryption;
import cn.com.chanyue.tool.URLTool;

public class ControlModule {

	@At("/news/id/*")
	@Ok(".jetx:/WEB-INF/template/news_info.jetx")
	public Map<String, Object> queryNews(String nid) {
		News news = new NewsFace().queryNews(nid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("news", news);
		Game game = new GameFace().queryGame(news.getGid().toString());
		map.put("game", game);
		return map;
	}

	@At("/game/id/*")
	@Ok(".jetx:/WEB-INF/template/game_info.jetx")
	public Map<String, Object> queryGame(String gid) {
		Game game = new GameFace().queryGame(gid);
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

	@At("/index")
	@Ok(".jetx:/WEB-INF/template/index.jetx")
	public Map<String, Object> index() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = new AdsFace().queryAdsList("index");
		List<Game> hots = new GameFace().queryGameHotList(6);
		List<Game> tops = new GameFace().queryGameTopList(4);
		List<News> newses = new NewsFace().queryNewsList(4);
		map.put("ads", ads);
		map.put("hots", hots);
		map.put("tops", tops);
		map.put("newses", newses);
		return map;
	}

	@At("/game/")
	@Ok(".jetx:/WEB-INF/template/game_list.jetx")
	public Map<String, Object> gameList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = new AdsFace().queryAdsList("game");
		List<Game> hots = new GameFace().queryGameHotList(6);
		List<Game> tops = new GameFace().queryGameTopList(4);
		map.put("hots", hots);
		map.put("tops", tops);
		map.put("ads", ads);
		return map;
	}

	@At("/news/")
	@Ok(".jetx:/WEB-INF/template/news_list.jetx")
	public Map<String, Object> newsList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ad> ads = new AdsFace().queryAdsList("news");
		List<News> newses = new NewsFace().queryNewsList(998);
		map.put("ads", ads);
		map.put("newses", newses);
		return map;
	}
}
