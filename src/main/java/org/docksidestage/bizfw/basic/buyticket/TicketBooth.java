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
package org.docksidestage.bizfw.basic.buyticket;

// done hattori authorの追加をお願いします by jflute (2026/09/24)
/**
 * @author jflute
 * @author hattori
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200; // when 2019/06/15
    // #1on1: $twoDayのwhenのコメントは、一応気にした記憶がある (2026/10/13)
    // じゃあOK。
    // jfluteだと、"when 2019/06/15" まんまではなく、"↑と同じ" みたいに表現を変えたり。
    // コピペミスじゃないですよってのを示すために。

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // you can rewrite comments for your own language by jflute
    // e.g. Japanese
    // /**
    // * 1Dayパスポートを買う、パークゲスト用のメソッド。
    // * @param handedMoney パークゲストから手渡しされたお金(金額) (NotNull, NotMinus)
    // * @throws TicketSoldOutException ブース内のチケットが売り切れだったら
    // * @throws TicketShortMoneyException 買うのに金額が足りなかったら
    // */
    // done hattori buyTicket()とsalesCalculation()の間に追加処理が入ったときに... by jflute (2026/09/24)
    // 呼び出し側の修正を一箇所で済ませられるようにしたい。
    // (あと例えば、buyTicket()とsalesCalculation()の順番を入れ替えるってときに一箇所修正で済むように)
    // done hattori @returnの追加をお願いします by jflute (2026/10/13)
    // e.g. @return 購入したチケット (NotNull)
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @return The purchased one-day passport. (NotNull)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
    public Ticket buyOneDayPassport(Integer handedMoney) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < ONE_DAY_PRICE) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        Ticket ticket = new Ticket(ONE_DAY_PRICE,1);
        reduceTicketQuantity();
//        calculateChange(handedMoney, ONE_DAY_PRICE); //one-day passportのときはお釣りの計算は不要なのでコメントアウト
        calculateSales(ONE_DAY_PRICE);
        return ticket;
    }

    public TicketBuyResult buyTwoDayPassport(Integer handedMoney) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < TWO_DAY_PRICE) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        reduceTicketQuantity();
        int change = calculateChange(handedMoney, TWO_DAY_PRICE);
        // #1on1: $handedMoneyが所持金というニュアンスだったから減らした (2026/09/24)
        // $いま、handedMoneyがもらったお金というニュアンスで捉えたらお釣りは別の方がいい
        // done hattori "パークゲストから手渡しされたお金(金額)" と書かれているので、お釣り変数も用意しましょう by jflute (2026/09/24)
        calculateSales(TWO_DAY_PRICE);
        TicketBuyResult ticketBuyResult = new TicketBuyResult(new Ticket(TWO_DAY_PRICE,2), change);
        return ticketBuyResult;
    }

    private void reduceTicketQuantity() {
        --quantity;
    }

    // done hattori Javaの慣習として、変数名は先頭小文字 Price → price by jflute (2026/09/24)
    // done hattori publicのbuyとprivateのbuyがかぶるのを避ける手法がある by jflute (2026/09/24)
    // コントローラー的なbuyと実処理のbuy, が補完の一覧で混ざって若干わかりにくいのを避けるために、
    // 実処理は例えば doBuyTicket() にするとか。
    // もちろん違う単語を使って区別することもあるが、業務的にしっくり来なければ、
    // doのようなprefixで区別するってことよくある。会話上も区別しやすい。
    private int calculateChange(Integer handedMoney, int price) {
        // #1on1: test_class_letsFix_ticketQuantityReduction() の方でじっくり議論メモあり (2026/09/24)
        // done hattori handedMoney(手渡し金額)という概念の変数が、お釣りに変わっている by jflute (2026/10/13)
        // 短い変数なのでまあ良いじゃん感もあるんですが、やはり1行単位で見ると、誤解を産むこともある。
        // (実際、もっとこのメソッドの中が複雑で、業務の流れをパッと把握することができないレベルの場合も想定して)
        // #1on1: calculateChange()を作る場合のメリットのお話 (2026/10/13)
        // 小さくてもれっきとしたビジネスロジックということで、お釣りの計算を見つけやすくなる。
        // (存在感の表現: step4の最後のprivateメソッド群みたいな感じで)
        int change = handedMoney - price;
        return change;
    }

    // #1on1: $changeの計算自体、doBuyTicket()なのか？ (2026/10/13)
    // $元々のdoBuyTicket()のニュアンスが、売上も入れないくらいチケットに特化した処理なので...
    // doBuyTicket()が広い意味か？狭い意味か？
    // 広い意味だったらそもそも売上も入ってもいいかも。
    // 狭い意味だったら確かにお釣りは独立した方がいいかも。
    // ただ、狭い意味の場合、もう --quantity しかないので、
    // メソッド名の抽象度が紛らわしいので、reduceQuantity() とか抽象度を周りに合わせる方が良いかも。
    // もしくは、Ticketの発行(new)までdoBuyTicket()の中までやって、チケット処理感を出す。
    //  → その場合、doBuyTicket()よりも、issueTicket() とかでも良いかも。
    //
    // メソッドの粒度、処理の配置(どのメソッドに置くのか？) が可読性につながる。
    // done hattori ぜひ思うがままにリファクタリングを by jflute (2026/10/13)

    // done hattori 一応、オーソドックスには、メソッド名は動詞始まりの方が良いかなと by jflute (2026/09/24)
    // (あえてこういう名前にして何かしらの特徴を得るみたいなテクニックはあるけど、普通はしない)
    // done hattori 引数名、変数は先頭小文字で (上は直ってる) by jflute (2026/10/13)
    // 格言: 「一つ直したら、他にも似たところがないか探す習慣を」
    // (練習で手を抜いたら、本番でも手を抜いてしまう話)
    private void calculateSales(int price) {
        if (salesProceeds != null) { // second or more purchase
            salesProceeds = salesProceeds + price;
        } else { // first purchase
            salesProceeds = price;
        }
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
