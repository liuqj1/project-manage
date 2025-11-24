package com.example.science.util.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    private static final String URL = "jdbc:mysql://localhost:3306/keshe?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

    public static void main(String[] args) {
        generator();
    }

    public static void generator(){
        FastAutoGenerator.create(URL, "root", "123456")
                .globalConfig(builder -> {
                    builder.author("lsy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride()//覆盖已生成文件
                            .disableOpenDir()
                            .outputDir("F:\\数据库课设\\scientific-manage\\src\\main\\java\\"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.example.science") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "F:\\数据库课设\\scientific-manage\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("team") // 设置需要生成的表名
                            .addTablePrefix("sys_", "c_","ums_") // 设置过滤表前缀
                            .entityBuilder().enableFileOverride().fileOverride();


                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
