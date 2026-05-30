/*
Задача:

Необходимо перевернуть порядок символов в строке, оставляя все небуквенные символы на своей позиции.

Пример:

Input: J@va the be$t!123

Output: t@eb eht av$J!123
*/

package org.example;

public class AdditionalClass {
    public static String reverseOnlyLetters(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            else if (!Character.isLetter(chars[right])) {
                right--;
            }
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
