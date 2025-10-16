package com.shatteredpixel.shatteredpixeldungeon.cheats;

import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class WeaponGen {
    private static final Map<String, Class<? extends MeleeWeapon>> weapons = new LinkedHashMap<>();
    private static final int ITEMS_PER_PAGE = 6;

    public WeaponGen() {
        if (weapons.isEmpty()) {
            Map<String, Class<? extends MeleeWeapon>> sortedWeapons = new TreeMap<>();
            for (Generator.Category tier : Generator.wepTiers) {
                for (Class<?> weaponClass : tier.classes) {
                    try {
                        if (MeleeWeapon.class.isAssignableFrom(weaponClass)) {
                            @SuppressWarnings("unchecked")
                            Class<? extends MeleeWeapon> wClass = (Class<? extends MeleeWeapon>) weaponClass;
                            MeleeWeapon w = wClass.getDeclaredConstructor().newInstance();
                            sortedWeapons.put(w.name(), wClass);
                        }
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                        // Skip classes that cannot be instantiated
                    }
                }
            }
            weapons.putAll(sortedWeapons);
        }
    }

    public void show() {
        showPage(0);
    }

    private void showPage(int page) {
        ArrayList<String> allItems = new ArrayList<>(weapons.keySet());
        int totalItems = allItems.size();
        int totalPages = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);

        int start = page * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, totalItems);

        ArrayList<String> pageItems = new ArrayList<>(allItems.subList(start, end));
        ArrayList<String> options = new ArrayList<>(pageItems);

        String title = "武器";
        if (totalPages > 1) {
            title += " (" + (page + 1) + "/" + totalPages + ")";
        }

        if (page > 0) {
            options.add("上一页");
        }
        if (page < totalPages - 1) {
            options.add("下一页");
        }
        options.add("取消");

        GameScene.show(new WndOptions(title, "请选择武器", options.toArray(new String[0])) {
            @Override
            protected void onSelect(int index) {
                String selectedOption = options.get(index);

                if (selectedOption.equals("下一页")) {
                    showPage(page + 1);
                } else if (selectedOption.equals("上一页")) {
                    showPage(page - 1);
                } else if (!selectedOption.equals("取消")) {
                    try {
                        Class<?> clazz = weapons.get(selectedOption);
                        if (clazz != null) {
                            Item item = (Item) clazz.getDeclaredConstructor().newInstance();
                            item.collect();
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });
    }
}
