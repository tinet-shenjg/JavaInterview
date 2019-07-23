package main.java.com.shenjg.design.pattern.strategy;

import main.java.com.shenjg.design.pattern.strategy.impl.BaiduUploadService;
import main.java.com.shenjg.design.pattern.strategy.impl.SinaUploadService;
import main.java.com.shenjg.design.pattern.strategy.impl.TencentUploadService;

/**
 * 策略模式测试类
 *
 * @author shenjg
 * @date 2019/07/23
 **/
public class StrategyTest {
    public static void main(String[] args) {

        Object object = new Object();

        // 上传object到百度
        UploadContext baiduUpload = new UploadContext(new BaiduUploadService());
        baiduUpload.uploadToWeb(object);

        // 上传object到腾讯
        UploadContext tencentUpload = new UploadContext(new TencentUploadService());
        tencentUpload.uploadToWeb(object);


        // 上传object到新浪
        UploadContext sinaUpload = new UploadContext(new SinaUploadService());
        sinaUpload.uploadToWeb(object);

    }
}
