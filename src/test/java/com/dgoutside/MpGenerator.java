package com.dgoutside;



import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @author WangShuai
 * @create  2019-08-23
 *
 *
 *
 */
public class MpGenerator {


    public static void main(String[] args) {

        String packageName = "com.dgoutside.modules.account";   // 生成的包名
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService

        String dir = System.getProperty("user.dir") + "/src/main/java";
//        String dir = "C:\\Users\\liuxy\\aqi";

        //  tablenames  是需要生成的数据库名称
        // 用"" 默认是全部表  如果需要生成个别张表,  可以打开55行的注释并注释掉56行
        generateByTables(serviceNameStartWithI,
                packageName,
                dir,
                "card_liquidation",
                "deal_dt",
                "pos_liquidation"
        );
    }
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String dir, String... tableNames ) {

        GlobalConfig config = new GlobalConfig();
        //mysql
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/hesuan?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.cj.jdbc.Driver");

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();

        strategyConfig.setInclude(tableNames);   //指定表
//        strategyConfig.setExclude(null);     //全表
        strategyConfig
                .setCapitalMode(false)   // 全局大写命名
                .setEntityLombokModel(true)   // Lomnok
                // .setDbColumnUnderline(true)   // 表名 字段名 是否使用下滑线命名
                //.setTablePrefix("tb_") // 去除表前缀
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel) //// underline_to_camel数据库表映射到实体的命名策略

                //设置父类路径
                .setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper")
                .setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService")
                .setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        //.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");


        // 全局配置
        config.setActiveRecord(true)   //是否支持AR模式
                .setAuthor("cucsscn")   // 设置作者
                .setOutputDir(dir)   // 设置生成的目标路径（绝对路径）
                .setIdType(IdType.AUTO) //主键策略
                .setBaseColumnList(true)  // 设置sql片段
                .setBaseResultMap(true)  // resultMap
                .setEnableCache(false)   // 不开缓存
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setOpen(false) //生成之后 默认打开文件夹
                .setFileOverride(true);  // 每一次生成需要覆盖
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)

                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("api")
                                .setEntity("entity")
                ).execute();
    }

    private void generateByTables(String packageName, String dir,String... tableNames) {
        generateByTables(true, packageName, dir, tableNames);
    }
}
