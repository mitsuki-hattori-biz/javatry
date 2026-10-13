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
 * @author hattori
 */
public class TicketBuyResult {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final Ticket ticket;
    private final int change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBuyResult(Ticket ticket, int change) {
        // #1on1: 逆にConstructorの悩み実装の他のパターンの紹介 (2026/10/13)
        // 1. Resultなのか、ResultCreatorなのか？
        // 2. Constructorでやるのか、どうか？
        //    Constructorは極力スッキリさせる傾向にある。
        this.ticket = ticket;
        this.change = change;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        return change;
    }

    // #1on1: Resultクラスの実装だけ見ると、ticketがnullかもしれないので... (2026/10/13)
    // nullPointerで落とすのではなく、0として振る舞うというのも一つの考え方。
    // 一方で、状況的にはおかしいので、下手に動くよりもnullPointerでもいいから落ちる方が良いという考え方。
    // (jfluteの感想: 会社のプログラミングだと、後者の "下手に動くよりも" が重視される傾向にある)
    public int getDisplayPrice() {
        // #1on1: もし後者の考え方をするのであれば、こんな感じ (2026/10/13)
        //if (ticket == null) {
        //    throw new IllegalStateException("Not found the ticket");
        //}
        // #1on1: AIのSuggestionのクラスの完結性のお話 (2026/10/13)
        // TicketBoothと足し合わせてチェックを考えるか？
        // TicketBuyResultだけでの完結性でチェックを考えるか？
        return ticket != null ? ticket.getDisplayPrice() : 0;
    }
}
