package org.example.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    // todo: 摘抄 yudao
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("""

                            ----------------------------------------------------------
                            \t项目启动成功！
                            \t接口文档: \t{}\s
                            \t开发文档: \t{}\s
                            \t视频教程: \t{}\s
                            ----------------------------------------------------------
                            """,
                    "https://cloud.iocoder.cn/api-doc/",
                    "https://cloud.iocoder.cn",
                    "https://t.zsxq.com/02Yf6M7Qn");

            // 数据报表
            System.out.println("[报表模块 yudao-module-report 教程][参考 https://cloud.iocoder.cn/report/ 开启]");
            // 工作流
            System.out.println("[工作流模块 yudao-module-bpm 教程][参考 https://cloud.iocoder.cn/bpm/ 开启]");
            // 微信公众号
            System.out.println("[微信公众号 yudao-module-mp 教程][参考 https://cloud.iocoder.cn/mp/build/ 开启]");
            // 商城系统
            System.out.println("[商城系统 yudao-module-mall 教程][参考 https://cloud.iocoder.cn/mall/build/ 开启]");
            // 支付平台
            System.out.println("[支付系统 yudao-module-pay - 已禁用][参考 https://doc.iocoder.cn/pay/build/ 开启]");
        });
    }
}
