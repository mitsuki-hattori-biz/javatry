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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of method. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author hattori
 */
public class Step04MethodTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Method Call
    //                                                                         ===========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_method_call_basic() {
        String sea = supplySomething();
        log(sea); // your answer? => over
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_call_many() {
        // #1on1: FunctionalInterfaceのお話 (2026/09/07)
        // function: 関数、引数と戻り値があるもの
        // consumer: 消費者、引数をもらって消費するだけ (戻り値ない)
        // supplier: 供給者、供給するだけ (引数ない)
        // (runnable: 引数/戻り値なし) // ちょっと亜種
        //
        // (関数型プログラミングのコンセプトをちょっととり入れて)
        //
        // (ざっくり: 引数戻り値をベースにしたやり方)
        //
        // 関数という言葉:
        // o 関数型プログラミングの関数 (哲学的!?)
        // o なんかの言語の文法としての関数 (狭義!?)
        //
        // またいつかstep8のStream APIのところで関数型プログラミングの補足。
        String sea = functionSomething("mystic");
        consumeSomething(supplySomething());
        runnableSomething();
        log(sea); // your answer? => mysmys
    }

    private String functionSomething(String name) {
        String replaced = name.replace("tic", "mys");
        log("in function: {}", replaced);
        return replaced;
    }

    private String supplySomething() {
        String sea = "over";
        log("in supply: {}", sea);
        return sea;
    }

    private void consumeSomething(String sea) {
        log("in consume: {}", sea.replace("over", "mystic"));
    }

    private void runnableSomething() {
        String sea = "outofshadow";
        log("in runnable: {}", sea);
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_object() {
        St4MutableStage mutable = new St4MutableStage();
        int sea = 904;
        boolean land = false;
        helloMutable(sea - 4, land, mutable);
        if (!land) {
            sea = sea + mutable.getStageName().length();
            //mutable.getStageName().length() => "mystic".length() => 6
        }
        log(sea); // your answer? => 904
        // 正解 => 910
    }

    private int helloMutable(int sea, Boolean land, St4MutableStage piari) {
        sea++;
        land = true;
        piari.setStageName("mystic");
        return sea;
    }

    private static class St4MutableStage {

        private String stageName;

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private int inParkCount;
    private boolean hasAnnualPassport;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_instanceVariable() {
        hasAnnualPassport = true;
        int sea = inParkCount;
        offAnnualPassport(hasAnnualPassport);
        for (int i = 0; i < 100; i++) {
            goToPark();
        }
        ++sea;
        sea = inParkCount;
        log(sea); // your answer? => 100
    }

    private void offAnnualPassport(boolean hasAnnualPassport) {
        hasAnnualPassport = false;
    }

    private void goToPark() {
        if (hasAnnualPassport) {
            ++inParkCount;
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    // write instance variables here
    /**
     * Make private methods as followings, and comment out caller program in test method:
     * <pre>
     * o replaceAwithB(): has one argument as String, returns argument replaced "A" with "B" as String 
     * o replaceCwithB(): has one argument as String, returns argument replaced "C" with "B" as String 
     * o quote(): has two arguments as String, returns first argument quoted by second argument (quotation) 
     * o isAvailableLogging(): no argument, returns private instance variable "availableLogging" initialized as true (also make it separately)  
     * o showSea(): has one argument as String argument, no return, show argument by log()
     * </pre>
     * (privateメソッドを以下のように定義して、テストメソッド内の呼び出しプログラムをコメントアウトしましょう):
     * <pre>
     * o replaceAwithB(): 一つのString引数、引数の "A" を "B" に置き換えたStringを戻す 
     * o replaceCwithB(): 一つのString引数、引数の "C" を "B" に置き換えたStringを戻す 
     * o quote(): 二つのString引数、第一引数を第二引数(引用符)で囲ったものを戻す 
     * o isAvailableLogging(): 引数なし、privateのインスタンス変数 "availableLogging" (初期値:true) を戻す (それも別途作る)  
     * o showSea(): 一つのString引数、戻り値なし、引数をlog()で表示する
     * </pre>
     */
    private boolean availableLogging = true;

    public void test_method_making() {
        //         use after making these methods
        String replaced = replaceCwithB(replaceAwithB("ABC"));
        String sea = quote(replaced, "'");
        if (isAvailableLogging()) {
            showSea(sea);
        }
    }

    // #1on1: いいね。privateメソッドの定義順序が直感的で見やすい (2026/09/07)
    // 呼び出し順序と一致してて、呼び出しフローと照らし合わせやすい。
    // コードの輪郭を記憶しやすい。

    // #1on1: $カテゴリでまとめたいときは？ (2026/09/07)
    // そのカテゴリにどれだけ存在感があるかどうか？ (感覚値)
    // なければ気にせず呼び出し順序にするし、存在感あるのでまとめた方がわかりやすいと思ったら...
    // もうカテゴリコメント(タグコメント)入れて独立させちゃう。by jflute
    // そのハイブリッドでバランスを取っている。

    // #1on1: 既存コードへの追加、一番下に定義されやすい話 (2026/09/07)
    // 既存クラスのコード体裁コンセプトを見てあげて、追加をして欲しい。
    // 他人のもの感全開で既存クラスを修正するっていうのは避けて欲しい。
    // (責任感の話)

    // TODO hattori [読み物課題] 既存コードの甘い匂い (悪意なきチグハグコードの誕生) by jflute (2026/09/07)
    // https://jflute.hatenadiary.jp/entry/20160203/existingcode

    // write methods here
    private String replaceAwithB(String str) {
        return str.replace("A", "B");
    }

    private String replaceCwithB(String str) {
        return str.replace("C", "B");
    }

    // #1on1: いいね、引数名がとても良い。意味がある引数名。 (2026/09/07)
    private String quote(String text, String quotation) {
        return quotation + text + quotation;
    }

    private boolean isAvailableLogging() {
        return availableLogging;
    }

    private void showSea(String sea) {
        log(sea);
    }
}
