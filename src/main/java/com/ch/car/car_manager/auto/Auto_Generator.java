package com.ch.car.car_manager.auto;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 陈辉
 * @Date: 2023/09/23/15:25
 * @Description:
 * @version: 1.0
 */
public class Auto_Generator {

    public static void main(String[] args) {
// 需要构建一个 代码自动生成器 对象
            AutoGenerator mpg = new AutoGenerator();
// 配置策略
// 1、全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/java");
            gc.setAuthor("chen");
            gc.setOpen(false);
            gc.setFileOverride(true); // 是否覆盖
            gc.setServiceName("%sService"); // 去Service的I前缀
            gc.setIdType(IdType.ID_WORKER);
            gc.setDateType(DateType.ONLY_DATE);
            gc.setSwagger2(true);
            mpg.setGlobalConfig(gc);
//2、设置数据源
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://localhost:3306/car");
            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("000000");
            dsc.setDbType(DbType.MYSQL);
            mpg.setDataSource(dsc);
//3、包的配置
            PackageConfig pc = new PackageConfig();
            pc.setModuleName("car_manager");
            pc.setParent("com.ch.car");
            pc.setEntity("pojo");
            pc.setMapper("mapper");
            pc.setService("service");
            pc.setController("controller");
            mpg.setPackageInfo(pc);
//4、策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setInclude("c_user","car_infor"); // 设置要映射的表名
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true); // 自动lombok；
            strategy.setLogicDeleteFieldName("deleted");
// 自动填充配置
            TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
            TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
            ArrayList<TableFill> tableFills = new ArrayList<>();
            tableFills.add(gmtCreate);
            tableFills.add(gmtModified);
            strategy.setTableFillList(tableFills);
// 乐观锁
            strategy.setVersionFieldName("version");
            strategy.setRestControllerStyle(true);
            strategy.setControllerMappingHyphenStyle(true);//开启驼峰
            // localhost:8080 / hello_id_2
            mpg.setStrategy(strategy);
            mpg.execute(); //执行

        }
    }
