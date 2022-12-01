package com.shatteredpixel.shatteredpixeldungeon.cheats;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.Potion;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfExperience;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHaste;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfMindVision;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfParalyticGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfPurity;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfToxicGas;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PotionGen {
    private static final LinkedHashMap<String, Class<?>> map = new LinkedHashMap<>();

    public PotionGen() {
        map.put("经验药剂", PotionOfExperience.class);
        map.put("冰霜药剂", PotionOfFrost.class);
        map.put("极速药剂", PotionOfHaste.class);
        map.put("治疗药剂", PotionOfHealing.class);
        map.put("隐形药剂", PotionOfInvisibility.class);
        map.put("液火药剂", PotionOfLiquidFlame.class);
        map.put("灵视药剂", PotionOfMindVision.class);
        map.put("浮空药剂", PotionOfLevitation.class);
        map.put("麻痹药剂", PotionOfParalyticGas.class);
        map.put("净化药剂", PotionOfPurity.class);
        map.put("力量药剂", PotionOfStrength.class);
        map.put("毒气药剂", PotionOfToxicGas.class);
    }

    public void show() {
        ArrayList<String> list = new ArrayList<>(map.keySet());

        GameScene.show(new WndOptions("药剂", "请选择药剂", list.toArray(new String[0])) {
            @Override
            protected void onSelect(int index) {
                try {
                    Class<?> clazz = map.get(list.get(index));
                    Item item = (Item) clazz.getDeclaredConstructor().newInstance();
                    item.collect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
