package com.java155.shop.support;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StaticPageUtil {
	public static void staticHtml(

					FreeMarkerConfigurer freeMarkerConfigurer,//freekerConfiguer配置

					String pagePath, //存储静态文件的路径

					String template,//模板路径

					Object dataModel) {//数据

		//获取config

		Configuration config = freeMarkerConfigurer.getConfiguration();

		//设置页面静态化

		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		try {

			// 获取模板

			Template temple = config.getTemplate(template);



			// 获取输出文件的输出流

			Writer out = new OutputStreamWriter(

							new FileOutputStream(pagePath),"utf-8");// 生成最终页面并写到文件

			temple.process(dataModel, out);// 处理

		} catch (TemplateNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (MalformedTemplateNameException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (ParseException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}catch (TemplateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	};
}
