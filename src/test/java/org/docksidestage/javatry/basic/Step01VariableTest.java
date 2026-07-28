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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => mystic8null:mai
        // #1on1: プログラミング言語の決め (2026/07/28)
        // エラーになる言語もあったり、空文字になったりする言語もある。
        // "null" って文字列になるメリデメ:
        // o デメリット: ないデータなのに "null" って文字になっちゃう by はっとりさん
        // 画面やメールとかにnullって表示されやすい。体裁が悪い。言語を推測されやすい。by jflute
        // o メリット: 空白とは別に扱える、数値の0とnullは違う by はっとりさん
        // 開発時はnullって表示されて不具合がわかりやすい。
        // 些細な違いでもメリデメを考える習慣が大事。思考トレーニング。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // 1 (1丁目1番地)
        String land = "oneman"; // 2 (2丁目2番地)
        sea = land; // seaの1丁目1番地を消しゴム消して、2丁目2番地に書き直してる
        land = land + "'s dreams"; // 3('s dreams), 4(oneman's dreams)
        log(sea); // your answer? => oneman
        // #1on1: 変数とインスタンスの関係性 (2026/07/28)
        // インスタンスとは？
        // $ インスタンス変数とは聞いたことある by はっとりさん
        // 一軒家の例。
        // Stringインスタンスの例、value/hashというインスタンス変数。
        // インスタンスにフォーカスを当てることの大切さ。
        //
        // 変数とは？
        // オブジェクト型の場合。
        // 変数とインスタンスは、1:1ではなく、n:1になりうる。
        // スコープ違いで、n:1になること多い。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
        // #1on1: プリミティヴ型 (2026/07/28)
        // 変数に値そのものが入っているイメージ。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        sea = land.add(new BigDecimal(1));
        sea.add(new BigDecimal(1));
        log(sea); // your answer? => 417
        //答えは416 BigDecimal型の変数はImmutability（不可変）な型のためsea.add(new BigDecimal(1));で数字を増やすことはできない
        //sea = sea.add(new BigDecimal(1));という計算式での代入であれば加算が可能
        //floatやdoubleは二進数で表現されるため、小数点の生じる計算に誤差が生じることがある
        //BigDecimalは、10進数で表現されるため、誤差が生じない
        // #1on1: immutableとは？mutableとは？ (2026/07/28)
        // o immutableなクラス(インスタンス) // default
        // o immutableな変数
        // BigDecimalはimmutableなクラスで、newするとimmutableなインスタンスができあがる
        // BigDecimalのコードリーディングしてみました。構造だけフォーカス当てて読んでみる。
        // immutableな変数は、finalがついた変数。JSだったらconst。
        //
        // 後半のエクササイズでimmutableとmutableの理解を深めた。
        // 今日から、クラスを見かけたらimmutableなのかmutableなのか、気になってしょうがないはず。
        // TODO jflute 次回1on1にて、immutable/mutableのメリデメ思考トレーニング (2026/07/28)
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => null
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 0
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => 0
        //答えはnull Integer型の変数はnullを代入することができるため、初期値はnullとなる
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bbb|0|null|magician
        //答えはbigband|1|null|magician　何もリターンしていないから関数の影響はないと思った
    }

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
        //instanceBroadwayとinstanceDocksideはインスタンス変数なので、メソッド内で変更してもそのまま反映される
        //instanceMagiclampはメソッド引数なので、メソッド内で変更しても呼び出し元には影響しない
        //インスタンス変数としてのinstanceMagiclampと、引数としてのinstanceMagiclampが同じ名前であるという罠
        //Javaの場合、スコープが狭い方が優先度が高い
        // TODO jflute 次回1on1にて、サクッとふぉろー (2026/07/28)
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor
        //関数は何もリターンしていないし、それを受け取ってもいないから影響がない
        // #1on1: Stringがimmutableだから、実はhelpを読まなくても答えが出ちゃう (2026/07/28)
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
        //sea.concat(landStr);を入れる変数も存在していない
        // #1on1: concat()のソースコードも読んでみた (2026/07/28)
    }
    //関数に意味を持たせたい場合
    //    public void test_variable_method_argument_immutable_methodcall() {
    //        String sea = "harbor";
    //        int land = 415;
    //        sea = helpMethodArgumentImmutableMethodcall(sea, land);
    //        log(sea);
    //    }
    //
    //    private String helpMethodArgumentImmutableMethodcall(String sea, int land) {
    //        ++land;
    //        String landStr = String.valueOf(land); // is "416"
    //        String test = sea.concat(landStr);
    //        return test;
    //    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => harbor
        //答えはharbor416
        //StringBuilderはMutable（可変）のため、関数内で変更された内容が呼び出し元にも反映される
        //C言語のポインタ変数みたいなものかな？
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => harbor
        //helpMethodArgumentVariable内のseaがグレーアウトしてたから、わかっただけのまぐれ当たりです。
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
        //関数内でnewをしても呼び出しもとには影響しない
        // #1on1: 関数内でnewしたものは、二軒目のインスタンスなので... (2026/07/28)
        // 一軒目のインスタンスのメソッドは呼び出してない。
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */

    private int piari;

    public void test_variable_writing() {
        String sea = "mystic";
        Integer land = null;
        log(sea + "," + land + "," + piari);
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 各ログ（計７箇所）で出力される数字は何でしょうか？
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        BigDecimal num1 = new BigDecimal("0");
        num1.add(new BigDecimal("1"));
        log("num1: " + num1); // your answer? =>
        BigDecimal num2 = num1.add(new BigDecimal("1"));
        log("num2: " + num2); // your answer? =>
        BigDecimal num3 = num2.add(new BigDecimal("1"));
        log("num3-1: " + num3); // your answer? =>
        addNumberMethod(num3);
        log("num3-2: " + num3); // your answer? =>
        BigDecimal num4 = addNumberReturnMethod(num3);
        log("num4: " + num4); // your answer? =>
    }

    private void addNumberMethod(BigDecimal num) {
        num = num.add(new BigDecimal("1"));
        log("numMethod1: " + num); // your answer? =>
    }

    private BigDecimal addNumberReturnMethod(BigDecimal num) {
        num = num.add(new BigDecimal("1"));
        log("numMethod2: " + num); // your answer? =>
        return num;
    }
}
