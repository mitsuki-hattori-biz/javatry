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

import java.time.LocalTime;

/**
 * @author jflute
 */
public class Ticket {

    // ===================================================================================
    //                                                                           TicketType
    //                                                                           =========

    public enum TicketType {
        ONE_DAY,
        TWO_DAY,
        FOUR_DAY, // 4日券の追加 (2026/10/30)
        NightOnlyTwoDay // 2日券の夜間版の追加 (2026/10/30)
    }// written on ticket, park guest can watch this
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200; // when 2019/06/15
    private static final int FOUR_DAY_PRICE = 22400; // when 2019/06/15
    private static final int NIGHT_ONLY_TWO_DAY_PRICE = 7400; // when 2019/06/15


    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========

    private final TicketType ticketType;
    private int remainingDays; // remaining days of admission; unavailable when zero or less
    private final int displayPrice; // written on ticket, park guest can watch this

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // #1on1: いいね、remainingDays という名前がわかりやすい (2026/10/30)
    // 他のアンチパターンの紹介。単なるcountとかdaysだと、どっち？ってのがわからなくなる。
    // あとdaysという言葉が良い。日数という業務表現をしっかりしている。
    // 他のパターン、day だとカレンダーの日をイメージしちゃう。
    // hattori ここのif文を汎用化したい気持ちもあるけど、汎用化しすぎると実装する気のないDayTicketとかが使えるようになってしまうので、あえて汎用化しない。
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        if (ticketType == TicketType.ONE_DAY) {
            this.remainingDays = 1;
            this.displayPrice = ONE_DAY_PRICE;
        } else if (ticketType == TicketType.TWO_DAY) {
            this.remainingDays = 2;
            this.displayPrice = TWO_DAY_PRICE;
        } else if (ticketType == TicketType.FOUR_DAY) {
            this.remainingDays = 4;
            this.displayPrice = FOUR_DAY_PRICE;
        } else if (ticketType == TicketType.NightOnlyTwoDay) {
            this.remainingDays = 2;
            this.displayPrice = NIGHT_ONLY_TWO_DAY_PRICE;
        } else {
            throw new IllegalArgumentException("Invalid ticket type: " + ticketType);
        }
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark(LocalTime currentTime) {
        if (ticketType == TicketType.NightOnlyTwoDay&&currentTime.isBefore(LocalTime.of(20, 00))) {
            throw new IllegalStateException("Cannot enter park before 20:00 with NightOnlyTwoDay ticket: currentTime=" + currentTime);
        }
        if (remainingDays <= 0) {
            throw new IllegalStateException("Already in park by this ticket: TicketType=" + ticketType);
        }
        remainingDays--;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    // #1on1: $互換性のために、あとシンプルな判定のメソッドは便利なので合っても良いだろう (2026/10/30)
    // Good。
    // alreadyIn がすでに古い言葉問題:
    // o OneDayオンリー時代は、「すでに入ったこと」と「使い切ったこと」が同じだった、区別する必要なかった
    // o なので "すでに入った" というニュアンスで "使い切った" を表現していた
    // o isAlreadyIn() も直せたら直したいところ、ただ影響範囲が大きいのでケースバイケース
    // o 色々なケースバイケースがある。システムの世間的な重要度による面、開発運用的な面。
    // $空気的に別チケットでリファクタリングかな!?
    // 
    // さらに追求するとしたら、こんなコメントを残しておくと良い
    // e.g. // 互換性のために古い言葉はそのままで、後でリファクタしたい
    // #for_now や #thinking のお話
    // 補完でパッとでるようにしてる話。ちょっとでも面倒だと人間やらなくなってしまう話。
    public boolean isAlreadyIn() {
        return remainingDays <= 0;
    }
}
