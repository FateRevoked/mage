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
package mage.sets.starwars;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.RestrictionEffect;
import mage.abilities.keyword.FlashAbility;
import mage.abilities.keyword.SpaceflightAbility;
import mage.abilities.keyword.TrampleAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author Styxo
 */
public class Exogorth extends CardImpl {

    public Exogorth(UUID ownerId) {
        super(ownerId, 136, "Exogorth", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{5}{G}{G}");
        this.expansionSetCode = "SWS";
        this.subtype.add("Slug");
        this.power = new MageInt(7);
        this.toughness = new MageInt(7);

        // Flash
        this.addAbility(FlashAbility.getInstance());

        // Trample
        this.addAbility(TrampleAbility.getInstance());

        // Exogorth can block only creatures with spaceflight.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new CanBlockOnlySpaceflightEffect()));
    }

    public Exogorth(final Exogorth card) {
        super(card);
    }

    @Override
    public Exogorth copy() {
        return new Exogorth(this);
    }
}

class CanBlockOnlySpaceflightEffect extends RestrictionEffect {

    public CanBlockOnlySpaceflightEffect() {
        super(Duration.EndOfTurn);
        this.staticText = "{this} can block only creatures with spaceflight";
    }

    public CanBlockOnlySpaceflightEffect(final CanBlockOnlySpaceflightEffect effect) {
        super(effect);
    }

    @Override
    public boolean applies(Permanent permanent, Ability source, Game game) {
        return permanent.getId().equals(source.getSourceId());
    }

    @Override
    public boolean canBlock(Permanent attacker, Permanent blocker, Ability source, Game game) {
        return attacker.getAbilities().contains(SpaceflightAbility.getInstance());
    }

    @Override
    public CanBlockOnlySpaceflightEffect copy() {
        return new CanBlockOnlySpaceflightEffect(this);
    }

}