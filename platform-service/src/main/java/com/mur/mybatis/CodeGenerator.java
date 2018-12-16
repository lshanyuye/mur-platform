package com.mur.mybatis;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName CodeGenerator
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/13 15:18
 **/
public class CodeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CodeGenerator.class);
    private static String url = "jdbc:mysql://127.0.0.1:3306/platform?useUnicode=true&amp&characterEncoding=utf8";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String passsword = "root";
    private static String projectPath = "E:\\IdeaProjects\\platform\\";
//    private static String projectPath = "D:/sources";
    private static String author = "Mu.R";
    private static String parentPackage = "com.mur.platform";
    private static String domainPath = "/platform-domain";
    private static String servicePath = "/platform-service";
    private static String controllerPath = "/platform-web";
    private static String tablePrefix = "plat_";

    /**
     * <p> 读取控制台内容 </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void generateCode() {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dc = new DataSourceConfig();
        dc.setUrl(url);
        dc.setDriverName(driverName);
        dc.setUsername(username);
        dc.setPassword(passsword);
        dc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent(parentPackage);
        pc.setEntity("domain");
        mpg.setPackageInfo(pc);
        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        String mapperXmlTmpPath = "/templates/mapper.xml.vm";
        String mapperJavaTmpPath = "/templates/mapper.java.vm";
        String domainTmpPath = "/templates/entity.java.vm";
        String serviceTmpPath = "/templates/service.java.vm";
        String serviceImplTmpPath = "/templates/serviceImpl.java.vm";
        String controllerTmpPath = "/templates/controller.java.vm";

        //自定义输出目录
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(domainTmpPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + domainPath + "/src/main/java/" + pc.getParent().replace(".", "//") + "/" + pc.getEntity() + "/"
                        + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(mapperXmlTmpPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名
                return projectPath + servicePath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(mapperJavaTmpPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + servicePath + "/src/main/java/" + pc.getParent().replace(".", "//") + "/" + pc.getMapper() + "/"
                        + tableInfo.getMapperName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(serviceTmpPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + servicePath + "/src/main/java/" + pc.getParent().replace(".", "//") + "/" + pc.getService() + "/"
                        + tableInfo.getServiceName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(serviceImplTmpPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + servicePath + "/src/main/java/" + pc.getParent().replace(".", "//") + "/" + pc.getServiceImpl().replace(".","//") + "/"
                        + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(controllerTmpPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + controllerPath + "/src/main/java/" + pc.getParent().replace(".", "//") + "/" + pc.getController() + "/"
                        + tableInfo.getControllerName() + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.mur.domain.Domain");
        strategy.setTablePrefix(tablePrefix);
        strategy.setRestControllerStyle(true);
        String tables = scanner("表名");
        strategy.setInclude(tables.split(","));
        strategy.setSuperEntityColumns("ID", "CREATED_BY", "CREATED_TIME", "MODIFIED_BY", "MODIFIED_TIME");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setSuperServiceClass("com.mur.service.base.BaseService");
        strategy.setSuperServiceImplClass("com.mur.service.base.impl.BaseServiceImpl");
        strategy.entityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    public static void main(String[] args) {
        generateCode();
//        String tables = "plat_serial_number_rule,plat_serial_number";
//        String[] t = tables.split(",");
//        for(int i = 0 ; i< t.length; i++){
//            System.out.println(t[i]);
//        }
    }
}
