package cn.com.chanyue.interFace;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import cn.com.chanyue.bean.Ad;

public class AdsFace{

	Ioc ioc = new NutIoc(new JsonLoader("ioc/dao.js"));
	private Dao dao = ioc.get(Dao.class, "dao");
	
	public List<Ad> queryAdsList(String type) {

		Sql sql = Sqls
				.create("SELECT T.* FROM tb_8wan_shouyou_ads T WHERE "
						+ "T.TYPE=@TYPE AND T.STATUS = '1' ORDER BY "
						+ "T.addTime DESC, T.type ASC");
		sql.params().set("TYPE", type == null ? "all" : type);
		sql.setCallback(Sqls.callback.entities());
		sql.setEntity(dao.getEntity(Ad.class));
		dao.execute(sql);
		return sql.getList(Ad.class);
	}
}