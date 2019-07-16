##  Java将String转为Int
---
####  用Java写一段将字符串转成整数的函数
---
要求：不要调用str2int,parseInt等转换函数。按位读取字符串里的字符进行处理将字符串转化为整数，给定的输入一定是合法输入不包含非法字符，字符串头尾没有空格，考虑字符串开头可能有正负号。
```
/**
 * 字符串转数组
 *
 * @author shenjg
 * @date 2019/07/14
 **/
public class String2Int {
    public static void main(String[] args) {
        String str = "-623456";
        System.out.println(str2int(str));
    }

    /**
     * String类型转换为int
     *
     * @param string
     * @return
     */
    private static int str2int(String string) {
        // 空值判断
        if (StringUtils.isEmpty(string)) {
            return 0;
        }

        // 遍历数组位置
        int index = 0;
        // 正负标识
        int sign = 1;

        char[] arr = string.toCharArray();

        if (arr[0] == '-') {
            sign = -1;
            index++;
        }
        if (arr[0] == '+') {
            index++;
        }

        long result = 0L;
        for (; index < arr.length; index++) {
            int number = char2int(arr[index]);
            number = number * getDigit(arr.length - index, 1);
            result = result + number;
            if (result >= Integer.MAX_VALUE) {
                break;
            }
        }
        // 如果数据超限，则返回数据极限值
        if (result * sign <= Integer.MIN_VALUE) {
            System.out.println("数据非法，超出int最小数值");
            return Integer.MIN_VALUE;
        }
        if (result * sign >= Integer.MAX_VALUE) {
            System.out.println("数据非法，超出int最大数值");
            return Integer.MAX_VALUE;
        }
        return (int) result * sign;
    }

    /**
     * char类型转int
     *
     * @param cha
     * @return
     */
    private static int char2int(char cha) {
        return cha - '0';
    }

    /**
     * 获取位数
     *
     * @param length
     * @param digit
     * @return
     */
    private static int getDigit(int length, int digit) {
        if (length == 1) {
            return digit;
        }
        digit = digit * 10;
        return getDigit(length - 1, digit);
    }

}

```