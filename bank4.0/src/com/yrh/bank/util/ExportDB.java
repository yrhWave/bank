/**
 * Copyright (C), 2018, JXAU
 * FileName: ExportDB
 * Author:   YRH
 * Date:     2018/9/13 21:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yrh.bank.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author YRH
 * @create 2018/9/13
 * @since 1.0.0
 */
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {

    public static void main(String[] args) {

        //读取hibernate.cfg.xml文件
        Configuration cfg = new Configuration().configure();

        SchemaExport export = new SchemaExport(cfg);

        export.create(true, true);
    }
}
