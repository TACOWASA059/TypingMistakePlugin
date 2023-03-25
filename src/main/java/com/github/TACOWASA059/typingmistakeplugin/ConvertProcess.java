package com.github.TACOWASA059.typingmistakeplugin;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import net.gcardone.junidecode.Junidecode;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//https://github.com/atilika/kuromoji
public class ConvertProcess {
    Map<Character, String> nearbyKeys = new HashMap<>();
    public ConvertProcess(){
        nearbyKeys.put('q', "wa");
        nearbyKeys.put('w', "qase");
        nearbyKeys.put('e', "wdsr");
        nearbyKeys.put('r', "etdf");
        nearbyKeys.put('t', "ryfg");
        nearbyKeys.put('y', "tughj");
        nearbyKeys.put('u', "yihjk");
        nearbyKeys.put('i', "uojkl");
        nearbyKeys.put('o', "ipkl;");
        nearbyKeys.put('p', "ol");
        nearbyKeys.put('a', "qwszx");
        nearbyKeys.put('s', "qweadzx");
        nearbyKeys.put('d', "werfcsx");
        nearbyKeys.put('f', "ertgvdc");
        nearbyKeys.put('g', "rtyhfbv");
        nearbyKeys.put('h', "tyujgnb");
        nearbyKeys.put('j', "yuihkm");
        nearbyKeys.put('k', "uiojlm");
        nearbyKeys.put('l', "iopk");
        nearbyKeys.put('z', "asx");
        nearbyKeys.put('x', "asdzc");
        nearbyKeys.put('c', "sdfxv");
        nearbyKeys.put('v', "dfgcb");
        nearbyKeys.put('b', "fghvn");
        nearbyKeys.put('n', "ghjbm");
        nearbyKeys.put('m', "hjkln");
    }

    // チャットメッセージを処理するメソッド
    public String processMessage(String message) {
        // メッセージをローマ字に変換する
        String romajiText = convertToRomaji(message);
        // タイプミスを模倣する
        String typoText = simulateTypo(romajiText);
        // 日本語に変換する
        String correctedText = convertToJapanese(typoText);
        // 処理されたメッセージを返す

        return correctedText;
    }

    // 日本語をローマ字に変換するメソッド
    public String convertToRomaji(String japaneseText) {
        //形態素は挟まないと漢字が日本語読みされない
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(japaneseText);
        StringBuilder romajiText = new StringBuilder();
        for (Token token : tokens) {
            String surface=token.getSurface();
            boolean isNumeric =  surface.matches("[+-]?\\d*(\\.\\d+)?");//数値かどうかの判定
            //boolean isAlphabet= surface.matches("^[a-zA-Z]*$");//アルファベットのみかどうかの判定
            String reading = token.getReading();//読みを得る
            if(isNumeric||reading==null){
                romajiText.append(token.getSurface());
            }
            else {
                if(reading.equalsIgnoreCase("*")) reading=token.getSurface();//例外処理(例)ドボルザーク

                int size=reading.split("ー",-1).length;
                int count=1;
                for(String readline:reading.split("ー",-1)){
                    String s=Junidecode.unidecode(readline);
                    //カタカナローマ字変換が上手くいったかどうかで分ける
                    if(!s.equalsIgnoreCase("*")){
                        romajiText.append(Junidecode.unidecode(readline));
                        if(count<size)romajiText.append("-");
                    }
                    else{
                        romajiText.append(token.getSurface());
                        break;
                    }
                    count++;
                }

            }
        }

        return romajiText.toString();
    }

    // ローマ字を日本語に変換するメソッド
    public String convertToJapanese(String romaji) {
        String encodedRomaji = null;
        try {
            encodedRomaji = URLEncoder.encode(TypingMistakePlugin.plugin.romajiToHiraganaConverter.convert(romaji), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        URL url = null;
        try {
            url = new URL("https://www.google.com/transliterate?langpair=ja-Hira|ja&text=" + encodedRomaji);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        URLConnection conn = null;
        try {
            conn = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStream in = null;
        try {
            in = conn.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(in, "UTF-8");
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String json = scanner.nextLine();
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jsonArray.size(); i++) {
                String firstElement = jsonArray.get(i).getAsJsonArray().get(1).getAsJsonArray().get(0).getAsString();
                sb.append(firstElement);
            }
            builder.append(sb);
        }
        return builder.toString();
    }

    // タイプミスを模倣するメソッド
    public String simulateTypo(String romajiText) {
        StringBuilder typoText = new StringBuilder();
        for (char c : romajiText.toCharArray()) {
            // キーボード入力時にprobabilityの確率で誤変換される
            if (Math.random() < TypingMistakePlugin.plugin.getConfig().getDouble("probability")) {
                typoText.append(getNearbyKey(c)); // 近いキーに変換
            } else {
                typoText.append(c);
            }
        }

        return typoText.toString();
    }
    private char getNearbyKey(char c) {
        String nearby = nearbyKeys.get(Character.toLowerCase(c));
        if (nearby != null && nearby.length() > 0) {
            int index = (int) (Math.random() * nearby.length());
            char nearbyKey = nearby.charAt(index);
            // keyが大文字なら返り値も大文字にする
            if (Character.isUpperCase(c)) {
                nearbyKey=Character.toUpperCase(nearbyKey);
            }
            return nearbyKey;
        } else {
            return c;
        }
    }
}