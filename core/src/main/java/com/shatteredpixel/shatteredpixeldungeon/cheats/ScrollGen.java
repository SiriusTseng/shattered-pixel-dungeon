package com.shatteredpixel.shatteredpixeldungeon.cheats;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.Scroll;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRecharging;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRetribution;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTerror;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ScrollGen {
    private static final LinkedHashMap<String, Class<? extends Item>> map = new LinkedHashMap<>();

    public ScrollGen() {
        map.put("鉴定卷轴", ScrollOfIdentify.class);
        map.put("催眠卷轴", ScrollOfLullaby.class);
        map.put("探地卷轴", ScrollOfMagicMapping.class);
        map.put("镜像卷轴", ScrollOfMirrorImage.class);
        map.put("复仇卷轴", ScrollOfRetribution.class);
        map.put("盛怒卷轴", ScrollOfRage.class);
        map.put("充能卷轴", ScrollOfRecharging.class);
        map.put("祛协卷轴", ScrollOfRemoveCurse.class);
        map.put("传送卷轴", ScrollOfTeleportation.class);
        map.put("恐惧卷轴", ScrollOfTerror.class);
        map.put("嬗变卷轴", ScrollOfTransmutation.class);
        map.put("升级卷轴", ScrollOfUpgrade.class);
    }

    public void show() {
        ArrayList<String> list = new ArrayList<>(map.keySet());

        GameScene.show(new WndOptions("卷轴", "请选择卷轴", list.toArray(new String[0])) {
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
