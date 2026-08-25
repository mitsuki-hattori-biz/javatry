/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.basic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.docksidestage.unit.PlainTestCase;

// TODO hattori クラスJavaDocの@authorをお願いします (javatryポリシーとして) by jflute (2026/08/25)
/**
 * The test of data type. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step03DataTypeTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          Basic Type
    //                                                                          ==========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_datatype_basicType() {
        String sea = "mystic";
        Integer land = 416;
        // #1on1: 日付というとyyyy/MM/dd, 日時というとyyyy/MM/dd HH:mm:ss... (2026/08/25)
        // 若干日付という言葉が曖昧で、抽象的な日付という言葉と、年月日を指す日付とあるけど...
        // おおむねこんな使い分けをされていることが多い。
        //
        // 英語名として、Dateは日付、DateTimeは日時。
        // ただ、そこも曖昧なこともある。Dateって書いて日時だったり... (広義/狭義の違い!?)
        //
        // なんなら、昔のJavaはDate型というクラスがあって、時分秒も持っていた。
        //
        LocalDate piari = LocalDate.of(2001, 9, 4);
        LocalDateTime bonvo = LocalDateTime.of(2001, 9, 4, 12, 34, 56);
        Boolean dstore = true;
        BigDecimal amba = new BigDecimal("9.4");

        // LocalDateもLocalDateTimeもimmutable
        // (昔のDateクラスはmutable)
        piari = piari.plusDays(1);
        land = piari.getYear();
        bonvo = bonvo.plusMonths(1);//bonvo=10
        land = bonvo.getMonthValue();//land=10
        land--;//land=9
        if (dstore) {
            BigDecimal addedDecimal = amba.add(new BigDecimal(land));//9.4+416=425.6
            //9.4+9=18.4
            sea = String.valueOf(addedDecimal);
        }
        log(sea); // your answer? => 425.6
        //正解は18.4
        // #1on1: landの見逃し、単なる凡ミス (2026/08/25)
    }

    // ===================================================================================
    //                                                                           Primitive
    //                                                                           =========
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_primitive() {
        byte sea = 127; // max
        short land = 32767; // max
        int piari = 1;
        long bonvo = 9223372036854775807L; // max
        float dstore = 1.1f;
        double amba = 2.3d;
        char miraco = 'a';
        boolean dohotel = miraco == 'a';
        if (dohotel && dstore >= piari) {
            bonvo = sea;//127
            land = (short) bonvo;//127
            bonvo = piari;
            sea = (byte) land;//127
            if (amba == 2.3D) {
                sea = (byte) amba;//2.3d
            }
        }
        if ((int) dstore > piari) {
            sea = 0;
        }
        log(sea); // your answer? => 2
        // #1on1: まあトレーニングだからってのはありますが... (2026/08/25)
        // 読むのにレアな文法知識を必要とする書き方はできるだけ避けたい。
        // そういう匙加減をしながら書いたりする。
        // あんまり配慮しすぎると選択肢が減るので書く方がつらくなる。
        // ただ今回のレベルで言うとみんな共通だと思うので避けたい。

        // #1on1: 自分の書いたプログラムを自分がずっとメンテするわけではない話 (2026/08/25)
    }

    // ===================================================================================
    //                                                                              Object
    //                                                                              ======
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_object() {
        St3ImmutableStage stage = new St3ImmutableStage("hangar");
        String sea = stage.getStageName();
        log(sea); // your answer? => hanger
    }

    // #1on1: immutableなクラスを自分で作るってなったらこんな感じ (2026/08/25)
    // o newするときに値を受け取る
    // o 受け取った値をfinalにしておく (厳密には必須ではないが可読性のために)
    // o getterしか用意しない (setterは作らない)
    //
    // o 変化させるときは、新しいインスタンスを戻す

    // #1on1: $ hangarしかないだろという感想 (2026/08/25)
    // エクササイズとして迷いポイントがない。immutableのクラスにあまりフォーカスが当たらない。

    private static class St3ImmutableStage {

        private final String stageName;

        public St3ImmutableStage(String stageName) {
            this.stageName = stageName;
        }

        public String getStageName() {
            return stageName;
        }
    }
}
