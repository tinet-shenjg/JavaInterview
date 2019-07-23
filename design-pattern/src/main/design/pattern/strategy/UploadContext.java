package main.design.pattern.strategy;

/**
 * @author shenjg
 * @date 2019/07/23
 **/
public class UploadContext {

    private UploadService uploadService;

    public UploadContext(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    public void uploadToWeb(Object object) {
        uploadService.uploadToWeb(object);
    }
}
