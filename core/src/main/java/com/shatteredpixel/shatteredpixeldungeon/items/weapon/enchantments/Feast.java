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

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.FloatingText;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite.Glowing;

public class Feast extends Weapon.Enchantment {

    private static ItemSprite.Glowing FEAST_GREEN = new ItemSprite.Glowing(0x44AA44);

    @Override
    public int proc(Weapon weapon, Char attacker, Char defender, int damage) {

        // 效果只在击杀敌人时触发
        if (!defender.isAlive() && attacker instanceof Hero) {

            Hero hero = (Hero) attacker;
            Hunger hunger = hero.buff(Hunger.class);

            if (hunger != null) {

                // 计算饥饿度恢复量 (最大饥饿度的5%)
                float hungerRestore = Hunger.STARVING * 0.05f; // 450 * 0.05 = 22.5

                // 检查饱食度是否高于80%
                float hungerPercent = hunger.hunger() / Hunger.STARVING;
                boolean highSatiety = hungerPercent >= 0.8f;

                // 恢复饥饿度
                hunger.satisfy(hungerRestore);
                hero.sprite.showStatusWithIcon(CharSprite.POSITIVE, "饱食", FloatingText.HUNGER);

                // 如果饱食度高于80%且生命值未满，恢复5%生命值
                if (highSatiety && hero.HP < hero.HT) {
                    int healAmount = Math.round(hero.HT * 0.05f);
                    healAmount = Math.min(healAmount, hero.HT - hero.HP);

                    if (healAmount > 0) {
                        hero.HP += healAmount;
                        hero.sprite.showStatusWithIcon(CharSprite.POSITIVE, Integer.toString(healAmount), FloatingText.HEALING);
                    }
                }
            }
        }

        return damage;
    }


    @Override
    public Glowing glowing() {
        return FEAST_GREEN;
    }
}