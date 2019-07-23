package main.java.com.shenjg.design.pattern.strategy.impl;

import main.java.com.shenjg.design.pattern.strategy.UploadService;

/**
 * 上传数据到新浪
 *
 * @author shenjg
 * @date 2019/07/23
 **/
public class SinaUploadService implements UploadService {
    @Override
    public void uploadToWeb(Object object) {
        // do something
        System.out.println("执行上传到新浪所需要的逻辑" + object);
    }
}
