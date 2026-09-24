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

// TODO hattori authorの追加をお願いします by jflute (2026/09/24)
/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200; // when 2019/06/15

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
    // TODO hattori buyTicket()とsalesCalculation()の間に追加処理が入ったときに... by jflute (2026/09/24)
    // 呼び出し側の修正を一箇所で済ませられるようにしたい。
    // (あと例えば、buyTicket()とsalesCalculation()の順番を入れ替えるってときに一箇所修正で済むように)
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
    public void buyOneDayPassport(Integer handedMoney) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        buyTicket(handedMoney, ONE_DAY_PRICE);
        salesCalculation(ONE_DAY_PRICE);
    }

    public int buyTwoDayPassport(Integer handedMoney) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        // #1on1: $handedMoneyが所持金というニュアンスだったから減らした (2026/09/24)
        // $いま、handedMoneyがもらったお金というニュアンスで捉えたらお釣りは別の方がいい
        // TODO hattori "パークゲストから手渡しされたお金(金額)" と書かれているので、お釣り変数も用意しましょう by jflute (2026/09/24)
        handedMoney = buyTicket(handedMoney, TWO_DAY_PRICE);
        salesCalculation(TWO_DAY_PRICE);
        return handedMoney;
    }

    // TODO hattori Javaの慣習として、変数名は先頭小文字 Price → price by jflute (2026/09/24)
    // TODO hattori publicのbuyとprivateのbuyがかぶるのを避ける手法がある by jflute (2026/09/24)
    // コントローラー的なbuyと実処理のbuy, が補完の一覧で混ざって若干わかりにくいのを避けるために、
    // 実処理は例えば doBuyTicket() にするとか。
    // もちろん違う単語を使って区別することもあるが、業務的にしっくり来なければ、
    // doのようなprefixで区別するってことよくある。会話上も区別しやすい。
    private Integer buyTicket(Integer handedMoney, int Price) {
        // #1on1: test_class_letsFix_ticketQuantityReduction() の方でじっくり議論メモあり (2026/09/24)
        if (handedMoney >= Price) { // main
            --quantity;
            handedMoney -= Price;
        } else { // sub
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        return handedMoney;
    }

    // TODO hattori 一応、オーソドックスには、メソッド名は動詞始まりの方が良いかなと by jflute (2026/09/24)
    // (あえてこういう名前にして何かしらの特徴を得るみたいなテクニックはあるけど、普通はしない)
    private void salesCalculation(int Price) {
        if (salesProceeds != null) { // second or more purchase
            salesProceeds = salesProceeds + Price;
        } else { // first purchase
            salesProceeds = Price;
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
