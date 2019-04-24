package com.zxkj;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author kk
 * AutoGenerator MyBatis-Plus 代码生成器
 */
public class MyBatisPlusCodeGenerator {
    //包名
    private static final String BASE_PACKAGE = "com.zxkj";
    private static final String MAPPER_PACKAGE = "dao";
    private static final String SERVICE_PACKAGE = "service";
    private static final String CONTROLLER_PACKAGE = "controller";
    private static final String ENTITY_PACKAGE = "entity";
    private static final String XML_PACKAGE = "mapper";
    // 模块名称
//    private static final String MODULE_NAME = "test";
    //输出文件的路径
    private static final String OUT_PATH = System.getProperty("user.dir") + "/src/main/java";
    //代码生成者
    private static final String AUTHOR = "ZhuXingKeJi";
    //JDBC相关配置
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    // 需要生成代码的表的名字
    private static final String[] INCLUDE_TABLE = {"tb_activity","tb_city","tb_coupon","tb_district",
            "tb_fire_license","tb_goods","tb_hotel","tb_hygienic_license","tb_member","tb_member_coupon",
            "tb_member_level","tb_order","tb_order_item","tb_order_other","tb_province","tb_room","tb_room_goods",
            "tb_room_type","tb_safe_license","tb_security_license","tb_staff","tb_trip_group",
    };

    //    private static final String[] EXCLUDE_TABLE = {"test"};

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/mysql.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 全局配置：设置作者、输出路径、是否重写等属性
        GlobalConfig globalConfig = new GlobalConfig().setOutputDir(OUT_PATH)// 输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(true)  // 开启 activeRecord 模式
                // .setEnableCache(false)  // XML 二级缓存
                // .setBaseResultMap(false)  // XML ResultMap
                // .setBaseColumnList(true)  // XML columList
                .setAuthor(AUTHOR)
                .setIdType(IdType.AUTO)//主键策略
                .setXmlName("%sMapper")
                .setMapperName("%sDao")
                .setServiceName("%sService") //设置service接口名字首字母没有I
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");
        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig()
                .setDbType(DbType.MYSQL)// 数据库类型
                .setUrl(url)
                .setDriverName(driver)
                .setUsername(user)
                .setPassword(password)
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String
                            fieldType) {// 自定义数据库表字段类型转换（可选）
                        System.out.println("转换类型：" + fieldType);
                        // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                        // return DbColumnType.BOOLEAN;
                        // }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                });
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)// 全局大写命名
                .setTablePrefix("tb_")//表名前缀
                .setEntityLombokModel(true)//使用lombok，如果没有集成Lombok，可以设置为false
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setInclude(INCLUDE_TABLE) // 需要生成的表
                // .setExclude(EXCLUDE_TABLE) // <include> 与 <exclude> 只能配置一项
                //  -------------- ② -------------
                // .setEntityColumnConstant(true) // 【实体】是否生成字段常量（默认 false）
                // .setSuperEntityClass("com.hc.bean.BaseEntity") //自定义实体父类
                // .setSuperEntityColumns(new String[]{"test_id"}) // 自定义实体，公共字段
                // .setSuperMapperClass("com.hc.bean.BaseMapper") //自定义mapper父类
                // .setSuperServiceClass("com.hc.bean.BaseService") //自定义service父类
                // .setSuperServiceImplClass("com.hc.bean.BaseServiceImpl") //自定义service实现类父类
                // .setSuperControllerClass("com.hc.bean.TestController")//自定义controller父类
                // .setEntityBuilderModel(true) // 【实体】是否为构建者模型（默认 false）
                // .setEntityBooleanColumnRemoveIsPrefix(true)//是否移除Boolean类型is前缀
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
                ;
        // 包配置
        PackageConfig packageConfig = new PackageConfig()
                // .setModuleName(MODULE_NAME)
                .setParent(BASE_PACKAGE) // 自定义包路径
                .setEntity(ENTITY_PACKAGE)
                .setMapper(MAPPER_PACKAGE)
                .setXml(XML_PACKAGE)
                .setService(SERVICE_PACKAGE)
                .setController(CONTROLLER_PACKAGE);// 这里是控制器包名

        AutoGenerator mpg = new AutoGenerator()
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSource)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)//进行包设置
                .setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();      // 执行生成
    }


    /////////////////////////////////////下面代码用来产生表名////////////////////////////////////////////////////////////
    @Test
    public void fun() throws Exception {
        List<String> db_zxkj = getAllTableNamesByDatabase("db_zxkj");
        db_zxkj.forEach(item->System.out.print("\""+item+"\","));
    }

    public static List<String> getAllTableNamesByDatabase(String databaseName) throws Exception {
        List<String> tables = new ArrayList();
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select table_name from information_schema.TABLES where TABLE_SCHEMA=?");
        ps.setString(1, databaseName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        closeAll(conn, ps, rs);
        return tables;
    }

    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

}