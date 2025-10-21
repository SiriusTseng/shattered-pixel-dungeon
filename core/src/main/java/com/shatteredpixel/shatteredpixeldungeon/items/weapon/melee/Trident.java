/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2025 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Feast;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Trident extends MeleeWeapon {

    {
        image = ItemSpriteSheet.TRIDENT;
        hitSound = Assets.Sounds.HIT_STAB;
        hitSoundPitch = 0.8f;

        tier = 3;
        DLY = 1.4f; //稍慢的攻击速度
        RCH = 2;    //2格攻击距离

        //鱼叉天生自带饕餮盛宴附魔
        enchant(new Feast());
    }

    @Override
    public int max(int lvl) {
        return Math.round(8f * (tier + 1)) +    //基础伤害32
                lvl * Math.round(2f * (tier + 1)); //每级+8伤害
    }

    @Override
    public String targetingPrompt() {
        return Messages.get(this, "prompt");
    }

    @Override
    protected void duelistAbility(Hero hero, Integer target) {
        //+(12+3*lvl) damage, 约+75%基础伤害，+75%成长
        int dmgBoost = augment.damageFactor(12 + Math.round(3f * buffedLvl()));
        Spear.spikeAbility(hero, target, 1, dmgBoost, this);
    }

    @Override
    public String abilityInfo() {
        int dmgBoost = levelKnown ? 12 + Math.round(3f * buffedLvl()) : 12;
        if (levelKnown) {
            return Messages.get(this, "ability_desc", augment.damageFactor(min() + dmgBoost), augment.damageFactor(max() + dmgBoost));
        } else {
            return Messages.get(this, "typical_ability_desc", min(0) + dmgBoost, max(0) + dmgBoost);
        }
    }

    public String upgradeAbilityStat(int level) {
        return Integer.toString(12 + Math.round(3f * level));
    }

    public boolean canReach(Char owner, int target) {
        //鱼叉的攻击距离为2格
        return Dungeon.level.distance(owner.pos, target) <= 2;
    }


    @Override
    public String info() {
        String info = super.info();
        info += "\n\n" + Messages.get(Feast.class, "name");
        return info;
    }
}