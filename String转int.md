```

/**

* 字符串转数组

*

* @author shenjg

* @date 2019/07/14

**/

public class String2Int {

public static void main(String[] args) {

String s ="-623456";

        System.out.println(str2int(s));

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

        int index =0;

        // 正负标识

        int sign =1;

        char[] arr = string.toCharArray();

        if (arr[0] =='-') {

sign = -1;

            index++;

        }

if (arr[0] =='+') {

index++;

        }

long result =0L;

        for (; index < arr.length; index++) {

int number =char2int(arr[index]);

            number = number *getDigit(arr.length - index, 1);

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

return cha -'0';

    }

/**

* 获取位数

*

    * @param length

    * @param digit

    * @return

    */

    private static int getDigit(int length, int digit) {

if (length ==1) {

return digit;

        }

digit = digit *10;

        return getDigit(length -1, digit);

    }

}

```
