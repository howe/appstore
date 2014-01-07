package cn.com.chanyue.interFace;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import cn.com.chanyue.bean.Game;

public class GameFace {

	Ioc ioc = new NutIoc(new JsonLoader("ioc/dao.js"));
	private Dao dao = ioc.get(Dao.class, "dao1");

	/**
	 * 查询游戏
	 * 
	 * @param gid
	 *            游戏ID
	 * @return
	 */
	public Game queryGame(String gid) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_game T WHERE T.ID=@GID");
		sql.params().set("GID", gid);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(Game.class));
		dao.execute(sql);
		return sql.getObject(Game.class);
	}

	public List<Game> queryGameList(Integer num) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_game T ORDER BY "
						+ "T.UPDATE DESC LIMIT 0, @NUM");
		sql.params().set("NUM", num == null ? 0 : num);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(Game.class));
		dao.execute(sql);
		return sql.getList(Game.class);
	}

	public List<Game> queryGameHotList(Integer num) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_game T WHERE T.HOT = '1' ORDER BY "
						+ "T.UPDATE DESC LIMIT 0, @NUM");
		sql.params().set("NUM", num == null ? 0 : num);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(Game.class));
		dao.execute(sql);
		return sql.getList(Game.class);
	}

	public List<Game> queryGameTopList(Integer num) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_game T WHERE T.TOP = '1' ORDER BY "
						+ "T.UPDATE DESC LIMIT 0, @NUM");
		sql.params().set("NUM", num == null ? 0 : num);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(Game.class));
		dao.execute(sql);
		return sql.getList(Game.class);
	}
}