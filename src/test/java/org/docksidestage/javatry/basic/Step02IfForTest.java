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

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() { // example, so begin from the next method
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false;
        int sea = 904;
        if (sea > 904) {//false
            sea = 2001;
            sea = sea++ * 2;
        } else if (land && sea >= 904) {//false
            sea = 7;
            sea = ++sea * 2;
        } else if (sea >= 903 || land) {//true
            if (sea % 2 == 0) {//true
                sea = sea++ * 2;//sea=1808
                //intellJの機能で++で変更されないことがわかりました。
            }
            if (!land) {//true
                land = true; // ここを通ればsea=10で仕事おしまい
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) {//true
                sea = 8;
            }
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        //land = true, sea=8
        if (sea >= 9 || (sea > 7 && sea < 9)) {//true
            sea--;//7
            if (sea % 2 == 1) {
                sea++;//8
            }
        }
        if (land) {//true
            sea = 10;
        }
        log(sea); // your answer? => 10

        // #1on1: インクリメントのいたずら (2026/08/12)
        // インクリメントは単独行で書くのが無難。

        // done jflute よもやま話: 1on1にて、漠然読みの話 (2026/08/12)

        // #1on1: コードを読む時、目的を達成するための裏ルートがあるかもしれない話 (2026/08/25)
        // その裏ルートを見つけるためにも、こういう読み方をしたら良い話。
        // (とりあえずスクロールする)
        // o 漠然読みで構造だけ把握 (全体像を見る)
        //  → 今回の場合は5つのパート分解 (if が大中小)
        // o 当たり(ギャンブルポイント)を付けてフォーカス読み
        //  → 当たりを見つけたりフォーカス読みのために逆さ読みも取り入れて
        //
        // ただ、ギャンブルに負けることはある。でも損はない。
        // 構造把握してlandもある程度踏み込んで見てるので、0から読むよりは速く読めるようになってる。
        //
        // あと、ギャンブルに負けたあと、また次の当たりが見つかる可能性も高い。
        // それを3,4回繰り返しても、網羅読みするよりは速い可能性あり。(規模によるが、現場の規模が大抵でかい)
        //
        // 仮説思考的なコードリーディング。
        // 
        // TODO hattori [読み物課題] My Favorite Book: 仮説思考 by jflute (2026/08/25)
        // https://jflute.hatenadiary.jp/entry/20150111/kasetsu
        //
        // #1on1: $先輩がぱっあああああっと見て判断できているのはなんでだ!? (2026/08/25)
        // もしかしたら、このへんの話と通じるところあるかも。当たりをよく知ってる。
        // 当たりを見つける経験値が高い。
    }

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) {
            String stage = stageList.get(i);
            if (i == 1) {
                sea = stage;
            }
        }
        log(sea); // your answer? => dockside
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            sea = stage;
        }
        log(sea); // your answer? => magiclamp
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            //今回はこのif文なくても結果同じ、brから始まって、gaを含む文字列が先にあれば結果が変わる
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // your answer? => hangar
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder();
        stageList.forEach(stage -> {
            if (sb.length() > 0) {
                return;
            }
            if (stage.contains("i")) {
                sb.append(stage);
            }
        });
        String sea = sb.toString();
        log(sea); // your answer? => dockside
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
        List<String> stageList = prepareStageList();
        List<String> sb = new ArrayList<>();
        stageList.forEach(stage -> {
            if (stage.contains("a")) {
                sb.add(stage);
            }
        });
        sb.forEach(sea -> {
            log(sea);
        });
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    //    public void test_iffor_refactor_foreach_to_forEach() {
    //        List<String> stageList = prepareStageList();
    //        String sea = null;
    //        for (String stage : stageList) {
    //            if (stage.startsWith("br")) {
    //                continue;
    //            }
    //            sea = stage;
    //            if (stage.contains("ga")) {
    //                break;
    //            }
    //        }
    //        log(sea); // should be same as before-fix
    //    }//元

    public void test_iffor_refactor_foreach_to_forEach() {
        List<String> stageList = prepareStageList();
        String[] sea = new String[1];
        // done hattori flagという変数名だと読み手にとっての情報量が少ないので... by jflute (2026/08/09)
        // (flagであることはboolean型を見ればわかるし)
        // 具体的に何を入れているのか？true/falseは何を示すのか？を変数名にしてみましょう。
        // done hattori 一方で、フラグは、できれば false から true にしたいところですね。 by jflute (2026/08/09)
        // フラグってflag, 旗なので、下げている状態(false)から何かが起きたら上がる(true)というニュアンスなので...
        // 必ずしも意味的に難しいときもありますが、可能ならデフォルトがfalseで何かがおきたらtrueになる方が直感的かなと。
        // (もしくは、"その後の処理をしないように" って否定ニュアンスを表現するために、false にしたんですかね？)
        // TODO hattori 昔、アンケートの回答者を表示しない機能を作るときに、
        //  「アンケートの回答者を表示しない」フラグを作ろうとしたけど「匿名回答機能が有効」のフラグに変えたことを思い出しました by fujisawa (2026/08/13)
        final boolean[] isStopped = { false };
        stageList.forEach(stage -> {
            if (isStopped[0]) {
                return;
            }
            sea[0] = stage;
            if (sea[0].contains("ga")) {
                isStopped[0] = true;
            }
        });
        log(sea[0]); // should be same as before-fix
        //ラムダ式の中はfinalか実質finalでないといけないとエラー文から知りました。
        //AIに聞けば配列にすればいいということなので、変数を配列にしました。
        //あとforeachにbreakはないということなので、flagを作って、gaを含んだらfalseにして、その後の処理をしないようにしました。

        // done jflute 次回1on1にて、forEach()メソッドの特徴をじっくり (2026/08/09)
        // なぜfinalでないといけないのか？なぜbreakがないのか？

        // #1on1: Javaのforループ (2026/08/12)
        // o intあいのfor文 (伝統的なfor)      // Java当初から, Javaの文法
        // o 拡張for文 (foreach文/普通のfor文) // 10年後くらい, Javaの文法
        // o forEach()メソッド                // 20年後くらい, 単なるメソッド
        //
        // 単なるメソッドで、たまたまforEach()メソッドの中でfor文から呼ばれているだけ、
        // なので、forの中で呼ばれているかどうかの確証はないから、forの文法は使えない。
        // continue, breakも使えない。
        //
        // forEach()メソッドのメリット:
        // o $ 制限が掛かるからこその、安全性/可読性が上がる by はっとりさん
        // o いかに上手に制限を掛けられるか？絶妙なバランスを考えるのがぼくらのお仕事。
        // 
        // forEach()メソッドのデメリット:
        // o 本当にmutableなことやりたいとき
        //  → 適材適所って判断コスト
        //
        // 言語/フレームワークの機能デザインのコンセプトにもつながる。
    }

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
        List<String> stageList = exerciseList();
        StringBuilder sea = new StringBuilder();
        int length = 4;
        for (String stage : stageList) {
            if (stage.length() > length) {
                sea.append("|");
                length++;
            } else if (stage.length() == length)
                sea.append(stage);
            else {
                sea.append("/");
                length--;
            }
        }
        String sb = sea.toString();
        log(sb); // answer? => |fluit|orange

        // done hattori [いいね] elseの括弧がなくて絶妙に読みづらくて良いエクササイズ笑 by jflute (2026/08/09)
        // 自分も追ってみました。これはなかなか難易度高くて良い（＾＾。
    }

    // done hattori 一応、Javaだとメソッドの先頭は小文字が慣習となります。 by jflute (2026/08/09)
    // TODO hattori 命名規則、慣れるまでは大変ですよね。「プログラム 命名規則 キャメル」とかで調べると、色々な命名規則見られておもしろい by fujisawa (2026/08/13)
    // #1on1: せっかくなので1on1の場でググってみた (2026/08/25)
    // // 命名規則についてまとめてみた（キャメルケース，パスカルケース，スネークケース，ケバブケース, etc...）
    // https://qiita.com/shota0616/items/4ac7a8696b3f6ccbe2bc
    // o 現場で言葉として浸透してるのはキャメルケースくらいかな!? スネークは若干通じない人もいるかも!?
    // o アンスコつなぎ、ハイフンつなぎ、という言い方なら無難
    // o Javaだと、キャメルケース中心で、定数にスネークケース
    private List<String> exerciseList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("apple");
        stageList.add("fluit");
        stageList.add("grapes");
        stageList.add("orange");
        return stageList;
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        stageList.add("hangar");
        stageList.add("magiclamp");
        return stageList;
    }
}
