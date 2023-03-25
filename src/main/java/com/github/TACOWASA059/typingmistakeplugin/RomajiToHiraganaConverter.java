package com.github.TACOWASA059.typingmistakeplugin;

import com.google.common.collect.ImmutableSortedMap;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RomajiToHiraganaConverter {
    private Map<String, String> ROMAJI_TO_HIRAGANA_MAP = new HashMap<>();

    public RomajiToHiraganaConverter(){
        // ローマ字と平仮名の対応表を初期化
        ROMAJI_TO_HIRAGANA_MAP.put("a", "あ");
        ROMAJI_TO_HIRAGANA_MAP.put("i", "い");
        ROMAJI_TO_HIRAGANA_MAP.put("yi", "い");
        ROMAJI_TO_HIRAGANA_MAP.put("u", "う");
        ROMAJI_TO_HIRAGANA_MAP.put("wu", "う");
        ROMAJI_TO_HIRAGANA_MAP.put("whu", "う");
        ROMAJI_TO_HIRAGANA_MAP.put("e", "え");
        ROMAJI_TO_HIRAGANA_MAP.put("o", "お");
        ROMAJI_TO_HIRAGANA_MAP.put("wha", "うぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("whi", "うぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("wi", "うぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("whe", "うぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("we", "うぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("who", "うぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("wyi", "ゐ");
        ROMAJI_TO_HIRAGANA_MAP.put("wye", "ゑ");
        ROMAJI_TO_HIRAGANA_MAP.put("la", "ぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("xa", "ぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("li", "ぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("xi", "ぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("lyi", "ぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("xyi", "ぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("lu", "ぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("xu", "ぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("le", "ぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("xe", "ぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("lye", "ぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("xye", "ぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("lo", "ぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("xo", "ぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("ye", "いぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("ka", "か");
        ROMAJI_TO_HIRAGANA_MAP.put("ca", "か");
        ROMAJI_TO_HIRAGANA_MAP.put("ki", "き");
        ROMAJI_TO_HIRAGANA_MAP.put("ku", "く");
        ROMAJI_TO_HIRAGANA_MAP.put("cu", "く");
        ROMAJI_TO_HIRAGANA_MAP.put("qu", "く");
        ROMAJI_TO_HIRAGANA_MAP.put("ke", "け");
        ROMAJI_TO_HIRAGANA_MAP.put("ko", "こ");
        ROMAJI_TO_HIRAGANA_MAP.put("co", "こ");
        ROMAJI_TO_HIRAGANA_MAP.put("kya", "きゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("kyi", "きぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("kyu", "きゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("kye", "きぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("kyo", "きょ");
        ROMAJI_TO_HIRAGANA_MAP.put("qya", "くゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("qyu", "くゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("qyo", "くょ");
        ROMAJI_TO_HIRAGANA_MAP.put("qwa", "くぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("qa", "くぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("kwa", "くぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("qwi", "くぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("qi", "くぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("qyi", "くぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("qwu", "くぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("qwe", "くぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("qe", "くぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("qye", "くぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("qwo", "くぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("qo", "くぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("kwo", "くぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("ga", "が");
        ROMAJI_TO_HIRAGANA_MAP.put("gi", "ぎ");
        ROMAJI_TO_HIRAGANA_MAP.put("gu", "ぐ");
        ROMAJI_TO_HIRAGANA_MAP.put("ge", "げ");
        ROMAJI_TO_HIRAGANA_MAP.put("go", "ご");

        ROMAJI_TO_HIRAGANA_MAP.put("gya", "ぎゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("gyi", "ぎぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("gyu", "ぎゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("gye", "ぎぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("gyo", "ぎょ");

        ROMAJI_TO_HIRAGANA_MAP.put("gwa", "ぐぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("gwi", "ぐぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("gwu", "ぐぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("gwe", "ぐぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("gwo", "ぐぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("lka", "ヵ");
        ROMAJI_TO_HIRAGANA_MAP.put("xka", "ヵ");
        ROMAJI_TO_HIRAGANA_MAP.put("lke", "ヶ");
        ROMAJI_TO_HIRAGANA_MAP.put("xke", "ヶ");
        ROMAJI_TO_HIRAGANA_MAP.put("sa", "さ");
        ROMAJI_TO_HIRAGANA_MAP.put("si", "し");
        ROMAJI_TO_HIRAGANA_MAP.put("ci", "し");
        ROMAJI_TO_HIRAGANA_MAP.put("shi", "し");
        ROMAJI_TO_HIRAGANA_MAP.put("su", "す");
        ROMAJI_TO_HIRAGANA_MAP.put("se", "せ");
        ROMAJI_TO_HIRAGANA_MAP.put("ce", "せ");
        ROMAJI_TO_HIRAGANA_MAP.put("so", "そ");

        ROMAJI_TO_HIRAGANA_MAP.put("sya", "しゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("sha", "しゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("syi", "しぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("syu", "しゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("shu", "しゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("sye", "しぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("she", "しぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("syo", "しょ");
        ROMAJI_TO_HIRAGANA_MAP.put("sho", "しょ");

        ROMAJI_TO_HIRAGANA_MAP.put("swa", "すぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("swi", "すぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("swu", "すぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("swe", "すぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("swo", "すぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("za", "ざ");
        ROMAJI_TO_HIRAGANA_MAP.put("zi", "じ");
        ROMAJI_TO_HIRAGANA_MAP.put("ji", "じ");
        ROMAJI_TO_HIRAGANA_MAP.put("zu", "ず");
        ROMAJI_TO_HIRAGANA_MAP.put("ze", "ぜ");
        ROMAJI_TO_HIRAGANA_MAP.put("zo", "ぞ");

        ROMAJI_TO_HIRAGANA_MAP.put("zya", "じゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("ja", "じゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("jya", "じゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("zyi", "じぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("jyi", "じぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("zyu", "じゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("ju", "じゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("jyu", "じゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("zye", "じぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("je", "じぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("jye", "じぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("zyo", "じょ");
        ROMAJI_TO_HIRAGANA_MAP.put("jo", "じょ");
        ROMAJI_TO_HIRAGANA_MAP.put("jyo", "じょ");

        ROMAJI_TO_HIRAGANA_MAP.put("ta", "た");
        ROMAJI_TO_HIRAGANA_MAP.put("ti", "ち");
        ROMAJI_TO_HIRAGANA_MAP.put("chi", "ち");
        ROMAJI_TO_HIRAGANA_MAP.put("tu", "つ");
        ROMAJI_TO_HIRAGANA_MAP.put("tsu", "つ");
        ROMAJI_TO_HIRAGANA_MAP.put("te", "て");
        ROMAJI_TO_HIRAGANA_MAP.put("to", "と");

        ROMAJI_TO_HIRAGANA_MAP.put("tya", "ちゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("cha", "ちゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("cya", "ちゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("tyi", "ちぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("cyi", "ちぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("tyu", "ちゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("chu", "ちゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("cyu", "ちゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("tye", "ちぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("che", "ちぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("cye", "ちぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("tyo", "ちょ");
        ROMAJI_TO_HIRAGANA_MAP.put("cho", "ちょ");
        ROMAJI_TO_HIRAGANA_MAP.put("cyo", "ちょ");

        ROMAJI_TO_HIRAGANA_MAP.put("tsa", "つぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("tsi", "つぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("tse", "つぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("tso", "つぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("tha", "てゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("thi", "てぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("thu", "てゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("the", "てぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("tho", "てょ");

        ROMAJI_TO_HIRAGANA_MAP.put("twa", "とぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("twi", "とぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("twu", "とぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("twe", "とぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("two", "とぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("da", "だ");
        ROMAJI_TO_HIRAGANA_MAP.put("di", "ぢ");
        ROMAJI_TO_HIRAGANA_MAP.put("du", "づ");
        ROMAJI_TO_HIRAGANA_MAP.put("de", "で");
        ROMAJI_TO_HIRAGANA_MAP.put("do", "ど");

        ROMAJI_TO_HIRAGANA_MAP.put("dya", "ぢゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("dyi", "ぢぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("dyu", "ぢゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("dye", "ぢぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("dyo", "ぢょ");

        ROMAJI_TO_HIRAGANA_MAP.put("dha", "でゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("dhi", "でぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("dhu", "でゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("dhe", "でぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("dho", "でょ");

        ROMAJI_TO_HIRAGANA_MAP.put("dwa", "どぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("dwi", "どぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("dwu", "どぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("dwe", "どぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("dwo", "どぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("ltu", "っ");
        ROMAJI_TO_HIRAGANA_MAP.put("xtu", "っ");
        ROMAJI_TO_HIRAGANA_MAP.put("ltsu", "っ");
        ROMAJI_TO_HIRAGANA_MAP.put("xtsu", "っ");

        ROMAJI_TO_HIRAGANA_MAP.put("na", "な");
        ROMAJI_TO_HIRAGANA_MAP.put("ni", "に");
        ROMAJI_TO_HIRAGANA_MAP.put("nu", "ぬ");
        ROMAJI_TO_HIRAGANA_MAP.put("ne", "ね");
        ROMAJI_TO_HIRAGANA_MAP.put("no", "の");

        ROMAJI_TO_HIRAGANA_MAP.put("nya", "にゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("nyi", "にぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("nyu", "にゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("nye", "にぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("nyo", "にょ");

        ROMAJI_TO_HIRAGANA_MAP.put("ha", "は");
        ROMAJI_TO_HIRAGANA_MAP.put("hi", "ひ");
        ROMAJI_TO_HIRAGANA_MAP.put("hu", "ふ");
        ROMAJI_TO_HIRAGANA_MAP.put("fu", "ふ");
        ROMAJI_TO_HIRAGANA_MAP.put("he", "へ");
        ROMAJI_TO_HIRAGANA_MAP.put("ho", "ほ");

        ROMAJI_TO_HIRAGANA_MAP.put("hya", "ひゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("hyi", "ひぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("hyu", "ひゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("hye", "ひぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("hyo", "ひょ");

        ROMAJI_TO_HIRAGANA_MAP.put("fwa", "ふぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("fa", "ふぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("fwi", "ふぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("fi", "ふぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("fyi", "ふぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("fwu", "ふぅ");
        ROMAJI_TO_HIRAGANA_MAP.put("fwe", "ふぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("fe", "ふぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("fye", "ふぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("fwo", "ふぉ");
        ROMAJI_TO_HIRAGANA_MAP.put("fo", "ふぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("fya", "ふゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("fyu", "ふゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("fyo", "ふょ");

        ROMAJI_TO_HIRAGANA_MAP.put("ba", "ば");
        ROMAJI_TO_HIRAGANA_MAP.put("bi", "び");
        ROMAJI_TO_HIRAGANA_MAP.put("bu", "ぶ");
        ROMAJI_TO_HIRAGANA_MAP.put("be", "べ");
        ROMAJI_TO_HIRAGANA_MAP.put("bo", "ぼ");

        ROMAJI_TO_HIRAGANA_MAP.put("bya", "びゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("byi", "びぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("byu", "びゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("bye", "びぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("byo", "びょ");

        ROMAJI_TO_HIRAGANA_MAP.put("va", "ヴぁ");
        ROMAJI_TO_HIRAGANA_MAP.put("vi", "ヴぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("vu", "ヴ");
        ROMAJI_TO_HIRAGANA_MAP.put("ve", "ヴぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("vo", "ヴぉ");

        ROMAJI_TO_HIRAGANA_MAP.put("vya", "ヴゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("vyi", "ヴぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("vyu", "ヴゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("vye", "ヴぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("vyo", "ヴょ");

        ROMAJI_TO_HIRAGANA_MAP.put("pa", "ぱ");
        ROMAJI_TO_HIRAGANA_MAP.put("pi", "ぴ");
        ROMAJI_TO_HIRAGANA_MAP.put("pu", "ぷ");
        ROMAJI_TO_HIRAGANA_MAP.put("pe", "ぺ");
        ROMAJI_TO_HIRAGANA_MAP.put("po", "ぽ");

        ROMAJI_TO_HIRAGANA_MAP.put("pya", "ぴゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("pyi", "ぴぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("pyu", "ぴゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("pye", "ぴぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("pyo", "ぴょ");

        ROMAJI_TO_HIRAGANA_MAP.put("ma", "ま");
        ROMAJI_TO_HIRAGANA_MAP.put("mi", "み");
        ROMAJI_TO_HIRAGANA_MAP.put("mu", "む");
        ROMAJI_TO_HIRAGANA_MAP.put("me", "め");
        ROMAJI_TO_HIRAGANA_MAP.put("mo", "も");

        ROMAJI_TO_HIRAGANA_MAP.put("mya", "みゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("myi", "みぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("myu", "みゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("mye", "みぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("myo", "みょ");

        ROMAJI_TO_HIRAGANA_MAP.put("ya", "や");
        ROMAJI_TO_HIRAGANA_MAP.put("yu", "ゆ");
        ROMAJI_TO_HIRAGANA_MAP.put("yo", "よ");
        ROMAJI_TO_HIRAGANA_MAP.put("lya", "ゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("xya", "ゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("lyu", "ゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("xyu", "ゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("lyo", "ょ");
        ROMAJI_TO_HIRAGANA_MAP.put("xyo", "ょ");

        ROMAJI_TO_HIRAGANA_MAP.put("ra", "ら");
        ROMAJI_TO_HIRAGANA_MAP.put("ri", "り");
        ROMAJI_TO_HIRAGANA_MAP.put("ru", "る");
        ROMAJI_TO_HIRAGANA_MAP.put("re", "れ");
        ROMAJI_TO_HIRAGANA_MAP.put("ro", "ろ");

        ROMAJI_TO_HIRAGANA_MAP.put("rya", "りゃ");
        ROMAJI_TO_HIRAGANA_MAP.put("ryi", "りぃ");
        ROMAJI_TO_HIRAGANA_MAP.put("ryu", "りゅ");
        ROMAJI_TO_HIRAGANA_MAP.put("rye", "りぇ");
        ROMAJI_TO_HIRAGANA_MAP.put("ryo", "りょ");

        ROMAJI_TO_HIRAGANA_MAP.put("wa", "わ");
        ROMAJI_TO_HIRAGANA_MAP.put("wo", "を");

        ROMAJI_TO_HIRAGANA_MAP.put("lwa", "ゎ");
        ROMAJI_TO_HIRAGANA_MAP.put("xwa", "ゎ");

        ROMAJI_TO_HIRAGANA_MAP.put("n", "ん");
        ROMAJI_TO_HIRAGANA_MAP.put("nn", "ん");
        ROMAJI_TO_HIRAGANA_MAP.put("n'", "ん");
        ROMAJI_TO_HIRAGANA_MAP.put("xn", "ん");
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>(ROMAJI_TO_HIRAGANA_MAP);
        Set<String> romaji_list = concurrentMap.keySet();
// 促音を追加する
        for (String romaji : romaji_list) {
            if (!StringUtils.startsWithAny(romaji, new String[]{"a", "i", "u", "e", "o", "n"})) {
                concurrentMap.put(romaji.charAt(0) + romaji, "っ" + concurrentMap.get(romaji));
            }
        }
        ROMAJI_TO_HIRAGANA_MAP=concurrentMap;
        ROMAJI_TO_HIRAGANA_MAP.put("-", "ー");
        ROMAJI_TO_HIRAGANA_MAP.put(",", "、");
        ROMAJI_TO_HIRAGANA_MAP.put(".", "。");
    }

    public String convert(String romaji) {
        StringBuilder hiraganaBuilder = new StringBuilder();

        // ローマ字を1文字ずつ処理
        for (int i = 0; i < romaji.length(); i++) {
            // 残りの文字数が3文字以上で、現在の3文字が変換対象の場合
            if (i < romaji.length() - 2 &&
                    ROMAJI_TO_HIRAGANA_MAP.containsKey(romaji.substring(i, i + 3))) {
                hiraganaBuilder.append(ROMAJI_TO_HIRAGANA_MAP.get(romaji.substring(i, i + 3)));
                i+=2;
            }
            // 残りの文字数が2文字以上で、現在の2文字が変換対象の場合
            if (i < romaji.length() - 1 &&
                    ROMAJI_TO_HIRAGANA_MAP.containsKey(romaji.substring(i, i + 2))) {
                hiraganaBuilder.append(ROMAJI_TO_HIRAGANA_MAP.get(romaji.substring(i, i + 2)));
                i++;
            }
            // 1文字が変換対象の場合
            else if (ROMAJI_TO_HIRAGANA_MAP.containsKey(romaji.substring(i, i + 1))) {
                hiraganaBuilder.append(ROMAJI_TO_HIRAGANA_MAP.get(romaji.substring(i, i + 1)));
            }
            // 変換できない場合はそのまま出力
            else {
                hiraganaBuilder.append(romaji.charAt(i));
            }
        }

        return hiraganaBuilder.toString();
    }
}
