# 设计模式之策略模式
> 策略模式
在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。
这种类型的设计模式属于行为型模式。   
> 在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。
策略对象改变 context 对象的执行算法。
>> 策略模式是指有一定行动内容的相对稳定的策略名称。策略模式在古代中又称“计策”，简称“计”，
如《汉书·高帝纪上》：“汉王从其计”。这里的“计”指的就是计谋、策略。策略模式具有相对稳定的形式，
如“避实就虚”、“出奇制胜”等。一定的策略模式，既可应用于战略决策，也可应用于战术决策；
既可实施于大系统的全局性行动，也可实施于大系统的局部性行动。

---
先直接贴栗子吧，概念在文章最后会介绍，也可以自行百度
---
我们有一个系统对接了各大主流的新闻网站，在我们的系统在中录入新闻可以实现一键发布到指定的网站中，
现在需要实现这个功能。主要需求：
1. 各个网站的对接逻辑不同，需要解耦。
2. 对于客户端的使用习惯不能有影响。    
考虑再三决定使用策略模式来解决    
#### 步骤一：创建一个上传接口
```java
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
```
#### 步骤二：针对不同网站实现接口  
```java
/**
 * 上传数据到百度
 *
 * @author shenjg
 * @date 2019/07/23
 **/
public class BaiduUploadService implements UploadService {
    @Override
    public void uploadToWeb(Object object) {
        // do something
        System.out.println("执行上传到百度所需要的逻辑" + object);
    }
}
```
```java
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
```
```java
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
```

#### 步骤三：创建context
```java
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
```
#### 步骤四：测试
```java
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
```
输出打印
```javascript
执行上传到百度所需要的逻辑java.lang.Object@610455d6
执行上传到腾讯所需要的逻辑java.lang.Object@610455d6
执行上传到新浪所需要的逻辑java.lang.Object@610455d6
```
点击查看完整代码[github](https://github.com/tinet-shenjg/JavaInterview/tree/master/design-pattern/src/main/design/pattern/strategy)

## 介绍    
策略模式作为一种软件设计模式，指对象有某个行为，但是在不同的场景中，该行为有不同的实现算法。例如：   
我们需要上传同一篇文章到新浪、腾讯、百度三大网站中，此时系统针对不同网站就需要不同的对接逻辑。    
策略模式：     
+ 定义了一组算法（业务规则）；
+ 封装了每个算法；
+ 这族的算法可互换代替（interchangeable）

## 组成
- 抽象策略角色： 策略类，通常由一个接口或者抽象类实现。
- 具体策略角色：包装了相关的算法和行为。
- 环境角色：持有一个策略类的引用，最终给客户端调用。   
![策略模式UML图](https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D250/sign=b18a632b33fa828bd5239ae6cd1e41cd/5366d0160924ab189a9f061935fae6cd7b890b16.jpg)

## 应用场景：
1. 多个类只区别在表现行为不同，可以使用Strategy模式，在运行时动态选择具体要执行的行为。
2. 需要在不同情况下使用不同的策略(算法)，或者策略还可能在未来用其它方式来实现。
3. 对客户隐藏具体策略(算法)的实现细节，彼此完全独立。   

## 优缺点
### 优点
+ 策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。恰当使用继承可以把公共的代码转移到父类里面，从而避免重复的代码。
+ 策略模式提供了可以替换继承关系的办法。继承可以处理多种算法或行为。如果不是用策略模式，那么使用算法或行为的环境类就可能会有一些子类，每一个子类提供一个不同的算法或行为。但是，这样一来算法或行为的使用者就和算法或行为本身混在一起。决定使用哪一种算法或采取哪一种行为的逻辑就和算法或行为的逻辑混合在一起，从而不可能再独立演化。继承使得动态改变算法或行为变得不可能。
+ 使用策略模式可以避免使用多重条件转移语句。多重转移语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，统统列在一个多重转移语句里面，比使用继承的办法还要原始和落后。
### 缺点
+ 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道所有的算法或行为的情况。
+ 策略模式造成很多的策略类，每个具体策略类都会产生一个新类。有时候可以通过把依赖于环境的状态保存到客户端里面，而将策略类设计成可共享的，这样策略类实例可以被不同客户端使用。换言之，可以使用享元模式来减少对象的数量。