var ioc = {
	dataSource: {
		type: "com.alibaba.druid.pool.DruidDataSource",
		events: {
			depose: "close"
		},
		fields: {
			driverClassName: 'com.mysql.jdbc.Driver',
			url: 'jdbc:mysql://localhost:3306/appstore?useUnicode=true&characterEncoding=UTF-8&useSSL=false',
			username: 'appstore',
			password: 'SfqME/6xEe0C0i8YEEQ/c/xAjkXEe70jxvnE+Wf7EgnX9ZHS5VDwSwy59dgxO/2E1y4rij2GCXeLfE/GaiMRQQ==',
			initialSize: 1,
			maxActive: 500,
			minIdle: 1,
			filters: 'config',
			connectionProperties: 'config.decrypt=true;config.decrypt.key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJha56yd28ghN0Pt35JJs1WOO/f+0++tMeC3d1IPgDlqk+4J28UpDyHhb4r3s6DiUklZFC9UI/vpFBCT52lnxEUCAwEAAQ==',
			defaultAutoCommit: false,

			//validationQueryTimeout : 5,
			validationQuery: "select 1"
		}
	},
	dao: {
		type: "org.nutz.dao.impl.NutDao",
		args: [{refer: "dataSource"}],
		fields: {
			executor: {refer: "cacheExecutor"}
		}
	},
	cacheExecutor: {
		type: "org.nutz.plugins.cache.dao.CachedNutDaoExecutor",
		fields: {
			cacheProvider: {refer: "cacheProvider"},
			cachedTableNames: [ // 任意N个表
				"tb_chanyue_shouyou_news"
			],
			//cachedTableNamePatten : ".+" // 也可以通过正则表达式来匹配
		}
	},
	cacheProvider: {
		type: "org.nutz.plugins.cache.dao.impl.provider.MemoryDaoCacheProvider",
		fields: {
			cacheSize: 10000 // 缓存的对象数
		},
		events: {
			create: "init"
		}
	}
};