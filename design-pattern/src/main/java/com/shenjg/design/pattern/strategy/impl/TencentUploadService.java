package main.java.com.shenjg.design.pattern.strategy.impl;

import main.java.com.shenjg.design.pattern.strategy.UploadService;

/**
 * 上传数据到腾讯
 *
 * @author shenjg
 * @date 2019/07/23
 **/
public class TencentUploadService implements UploadService {
    @Override
    public void uploadToWeb(Object object) {
        // do something
        System.out.println("执行上传到腾讯所需要的逻辑" + object);
    }
}
