package cn.com.chanyue.bean;

import org.nutz.dao.entity.annotation.*;

/**
* 
*/
@Table("tb_chanyue_shouyou_ads")
public class Ad {

	/**
	 * ID
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 标题
	 */
	@Column("title")
	private String title;
	/**
	 * 链接
	 */
	@Column("url")
	private String url;
	/**
	 * 显示状态
	 */
	@Column("status")
	private String status;
	/**
	 * 广告类型
	 */
	@Column("type")
	private String type;
	/**
	 * 添加时间
	 */
	@Column("addTime")
	private java.util.Date addTime;
}