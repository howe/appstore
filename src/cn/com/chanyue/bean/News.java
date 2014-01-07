package cn.com.chanyue.bean;

import org.nutz.dao.entity.annotation.*;

/**
 * 资讯表
 */
@Table("tb_chanyue_shouyou_news")
public class News {

	/**
	 * ID
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 游戏ID
	 */
	@Column("gid")
	private Integer gid;
	/**
	 * 标题
	 */
	@Column("title")
	private String title;
	/**
	 * 内容分类
	 */
	@Column("sort")
	private String sort;
	/**
	 * 内容
	 */
	@Column("content")
	private String content;
	/**
	 * 作者
	 */
	@Column("author")
	private String author;
	/**
	 * 发布时间
	 */
	@Column("published")
	private java.util.Date published;
	/**
	 * URL
	 */
	@Column("url")
	private String url;
	/**
	 * 置顶
	 */
	@Column("top")
	private String top;

	public Integer getId() {
		return id;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public java.util.Date getPublished() {
		return published;
	}

	public void setPublished(java.util.Date published) {
		this.published = published;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}