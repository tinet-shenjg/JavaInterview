package main.design.pattern.strategy;

/**
 * 上传接口
 *
 * @author shenjg
 * @date 2019/07/23
 **/
public interface UploadService {

    /**
     * 上传数据到网站
     *
     * @param object
     */
    void uploadToWeb(Object object);
}
