package cn.com.chanyue.interFace;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import cn.com.chanyue.bean.News;

public class NewsFace {

	Ioc ioc = new NutIoc(new JsonLoader("ioc/dao.js"));
	private Dao dao = ioc.get(Dao.class, "dao1");

	/**
	 * 查询资讯
	 * 
	 * @param nid
	 *            资讯ID
	 * @return
	 */
	public News queryNews(String nid) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_news T WHERE T.ID = @NID");
		sql.params().set("NID", nid);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(News.class));
		dao.execute(sql);
		return sql.getObject(News.class);
	}

	public List<News> queryNewsList(Integer num) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_news T ORDER BY "
						+ "T.PUBLISHED, T.TOP DESC LIMIT 0, @NUM");
		sql.params().set("NUM", num == null ? 0 : num);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(News.class));
		dao.execute(sql);
		return sql.getList(News.class);
	}
}