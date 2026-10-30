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

/**
 * @author jflute
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int displayPrice; // written on ticket, park guest can watch this
    private int remainingDays; // remaining days of admission; unavailable when zero or less

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // #1on1: いいね、remainingDays という名前がわかりやすい (2026/10/30)
    // 他のアンチパターンの紹介。単なるcountとかdaysだと、どっち？ってのがわからなくなる。
    // あとdaysという言葉が良い。日数という業務表現をしっかりしている。
    // 他のパターン、day だとカレンダーの日をイメージしちゃう。
    public Ticket(int displayPrice, int remainingDays) {
        this.displayPrice = displayPrice;
        this.remainingDays = remainingDays;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (remainingDays <= 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        remainingDays--;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
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
