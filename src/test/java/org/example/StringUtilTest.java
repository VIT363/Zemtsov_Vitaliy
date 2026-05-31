package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    @DisplayName("Пример из задачи: J@va the be$t!123 -> t@eb eht av$J!123")
    void reverseOnlyLetters_ExampleFromTask() {
        String input = "J@va the be$t!123";
        String expected = "t@eb eht av$J!123";
        assertEquals(expected, StringUtil.reverseOnlyLetters(input));
    }

    @Test
    @DisplayName("Строка только из букв (обычный реверс)")
    void reverseOnlyLetters_OnlyLetters() {
        assertEquals("cba", StringUtil.reverseOnlyLetters("abc"));
        assertEquals("zyx", StringUtil.reverseOnlyLetters("xyz"));
        assertEquals("Hello", StringUtil.reverseOnlyLetters("olleH"));
    }

    @Test
    @DisplayName("Строка только из небуквенных символов")
    void reverseOnlyLetters_OnlyNonLetters() {
        assertEquals("123!@#", StringUtil.reverseOnlyLetters("123!@#"));
        assertEquals("   ", StringUtil.reverseOnlyLetters("   "));
    }

    @Test
    @DisplayName("Пустая строка и null")
    void reverseOnlyLetters_EmptyOrNull() {
        assertEquals("", StringUtil.reverseOnlyLetters(""));
        assertEquals("", StringUtil.reverseOnlyLetters(null));
    }

    @Test
    @DisplayName("Небуквенные символы на границах и внутри")
    void reverseOnlyLetters_NonLettersAtEdges() {
        assertEquals("!dcba?", StringUtil.reverseOnlyLetters("!abcd?"));
        assertEquals("1a2b3c", StringUtil.reverseOnlyLetters("1c2b3a"));
    }

    @Test
    @DisplayName("Смешанный регистр и Unicode буквы")
    void reverseOnlyLetters_MixedCaseAndUnicode() {
        String input = "Привет! Мир.";
        String expected = "риМтев! ирП.";
        assertEquals(expected, StringUtil.reverseOnlyLetters(input));
    }

    @Test
    @DisplayName("Регистр букв сохраняется при перевороте")
    void reverseOnlyLetters_CaseSensitivity() {
        assertEquals("AbCd", StringUtil.reverseOnlyLetters("dCbA"));
        assertEquals("XyZ", StringUtil.reverseOnlyLetters("ZyX"));
        assertEquals("Hello World", StringUtil.reverseOnlyLetters("dlroW olleH"));
    }

    @Test
    @DisplayName("Небуквенные символы в несимметричных позициях")
    void reverseOnlyLetters_NonLettersAsymmetric() {
        assertEquals("a$b#c@d!", StringUtil.reverseOnlyLetters("d$c#b@a!"));
    }

    @Test
    @DisplayName("Длинная строка с буквами, цифрами и символами")
    void reverseOnlyLetters_LongString() {
        String longInput = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+-=[]{}|;:,.<>?";
        String expected = "zyxwvutsrqponmlkjihgfedcba1234567890!@#$%^&*()_+-=[]{}|;:,.<>?";
        assertEquals(expected, StringUtil.reverseOnlyLetters(longInput));
    }

    @Test
    @DisplayName("Диакритические знаки (буквы с ударениями)")
    void reverseOnlyLetters_Diacritics() {
        assertEquals("éèêë", StringUtil.reverseOnlyLetters("ëêèé"));
        assertEquals("éè!êë", StringUtil.reverseOnlyLetters("ëê!èé"));
    }

    @Test
    @DisplayName("Строка без букв (отрицательный тест)")
    void reverseOnlyLetters_NoLetters() {
        String input = "123!@#";
        assertEquals(input, StringUtil.reverseOnlyLetters(input));
        assertEquals("   ", StringUtil.reverseOnlyLetters("   "));
        assertEquals("", StringUtil.reverseOnlyLetters(""));
    }

    @Test
    @DisplayName("Эмодзи и другие небуквенные Unicode символы")
    void reverseOnlyLetters_EmojisAndSpecialUnicode() {
        assertEquals("😊abc😊", StringUtil.reverseOnlyLetters("😊cba😊"));
        assertEquals("😊a😊b😊c", StringUtil.reverseOnlyLetters("😊c😊b😊a"));
        assertEquals("∫a∫b∫", StringUtil.reverseOnlyLetters("∫b∫a∫"));
    }

    @Test
    @DisplayName("Сохранение позиций небуквенных символов — сложный кейс с несколькими небуквенными подряд")
    void reverseOnlyLetters_MultipleNonLettersInARow() {
        assertEquals("d!!c b? a", StringUtil.reverseOnlyLetters("a!!b c? d"));
    }
}