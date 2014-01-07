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
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public java.util.Date getAddTime() {
		return addTime;
	}
	public void setAddTime(java.util.Date addTime) {
		this.addTime = addTime;
	}
}