package cn.com.chanyue.bean;

import org.nutz.dao.entity.annotation.*;

/**
* 
*/
@Table("tb_chanyue_shouyou_game")
public class Game {

	/**
	 * ID
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 游戏名称
	 */
	@Column("gameName")
	private String gameName;
	/**
	 * 下载次数
	 */
	@Column("downloads")
	private Integer downloads;
	/**
	 * 文件大小
	 */
	@Column("size")
	private Double size;
	/**
	 * 资费
	 */
	@Column("tariff")
	private String tariff;
	/**
	 * 游戏类型
	 */
	@Column("type")
	private String type;
	/**
	 * 语言
	 */
	@Column("language")
	private String language;
	/**
	 * 版本
	 */
	@Column("version")
	private String version;
	/**
	 * 更新时间
	 */
	@Column("update")
	private java.util.Date update;
	/**
	 * 固件版本
	 */
	@Column("firmware")
	private String firmware;
	/**
	 * 开发者
	 */
	@Column("developers")
	private String developers;
	/**
	 * 下载地址
	 */
	@Column("download")
	private String download;
	/**
	 * 应用介绍
	 */
	@Column("introduction")
	private String introduction;
	/**
	 * 更新日志
	 */
	@Column("features")
	private String features;
	/**
	 * 短信发送地址
	 */
	@Column("url")
	private String url;
	/**
	 * 游戏平台
	 */
	@Column("platform")
	private String platform;
	/**
	 * 推荐
	 */
	@Column("top")
	private String top;
	/**
	 * 热门
	 */
	@Column("hot")
	private String hot;

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public java.util.Date getUpdate() {
		return update;
	}

	public void setUpdate(java.util.Date update) {
		this.update = update;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getDevelopers() {
		return developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	public String getDownload() {
		return download;
	}

	public void setDownload(String download) {
		this.download = download;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}