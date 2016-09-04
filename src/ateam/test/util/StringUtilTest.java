package ateam.test.util;

import ateam.util.StringUtil;
import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
	public void testConvertHiraganaToKatakana() {
		assertEquals("フセン", StringUtil.convertHiraganaToKatakana("ふせん"));
		assertEquals("フセン", StringUtil.convertHiraganaToKatakana("フセン"));
		assertEquals("付箋", StringUtil.convertHiraganaToKatakana("付箋"));
		assertEquals("", StringUtil.convertHiraganaToKatakana(""));
		assertEquals(null, StringUtil.convertHiraganaToKatakana(null));
	}

}
