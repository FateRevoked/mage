/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.w;

import java.util.UUID;
import mage.constants.CardType;
import mage.MageInt;
import mage.abilities.common.LeavesBattlefieldTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.EvokeAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.game.permanent.token.Token;

/**
 *
 * @author LevelX2
 */
public class WalkerOfTheGrove extends CardImpl {

    public WalkerOfTheGrove(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{6}{G}{G}");
        this.subtype.add("Elemental");

        this.power = new MageInt(7);
        this.toughness = new MageInt(7);

        // When Walker of the Grove leaves the battlefield, create a 4/4 green Elemental creature token.
        this.addAbility(new LeavesBattlefieldTriggeredAbility(new CreateTokenEffect(new WalkerOfTheGroveToken(),1),false));
        // Evoke {4}{G}
        this.addAbility(new EvokeAbility(this, "{4}{G}"));
    }

    public WalkerOfTheGrove(final WalkerOfTheGrove card) {
        super(card);
    }

    @Override
    public WalkerOfTheGrove copy() {
        return new WalkerOfTheGrove(this);
    }
}

class WalkerOfTheGroveToken extends Token {
    public WalkerOfTheGroveToken() {
        super("Elemental", "4/4 green Elemental creature token");
        cardType.add(CardType.CREATURE);
        this.subtype.add("Elemental");
        this.color.setGreen(true);
        power = new MageInt(4);
        toughness = new MageInt(4);
    }
}