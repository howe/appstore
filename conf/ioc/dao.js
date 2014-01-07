var ioc = {
	dataSource1 : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
			depose : "close"
		},
		fields : {
			driverClassName : 'com.mysql.jdbc.Driver',
			url : 'jdbc:mysql://127.0.0.1:3306/appstore?useUnicode=true&characterEncoding=UTF-8',
			username : 'root',
			password : 'root',
			initialSize : 10,
			maxActive : 100,
			minIdle : 10,
			maxIdle : 20,
			defaultAutoCommit : false,

			// validationQueryTimeout : 5,
			validationQuery : "select 1"
		}
	},
	dao1 : {
		type : "org.nutz.dao.impl.NutDao",
		fields : {
			dataSource : {
				refer : 'dataSource1'
			}
		}
	},
	dataSource2 : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
			depose : "close"
		},
		fields : {
			driverClassName : 'com.mysql.jdbc.Driver',
			url : 'jdbc:mysql://127.0.0.1:3306/common?useUnicode=true&characterEncoding=UTF-8',
			username : 'root',
			password : 'root',
			initialSize : 10,
			maxActive : 100,
			minIdle : 10,
			maxIdle : 20,
			defaultAutoCommit : false,

			// validationQueryTimeout : 5,
			validationQuery : "select 1"
		}
	},
	dao2 : {
		type : "org.nutz.dao.impl.NutDao",
		fields : {
			dataSource : {
				refer : 'dataSource2'
			}
		}
	}
};