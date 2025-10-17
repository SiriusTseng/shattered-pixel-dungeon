package com.shatteredpixel.shatteredpixeldungeon.cheats.v1;

import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.Potion;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PotionGen {
    private static final Map<String, Class<? extends Potion>> potions = new LinkedHashMap<>();
    private static final int ITEMS_PER_PAGE = 6;

    public PotionGen() {
        if (potions.isEmpty()) {
            Map<String, Class<? extends Potion>> sortedPotions = new TreeMap<>();
            for (Class<?> potionClass : Generator.Category.POTION.classes) {
                try {
                    @SuppressWarnings("unchecked")
                    Class<? extends Potion> pClass = (Class<? extends Potion>) potionClass;
                    Potion p = pClass.getDeclaredConstructor().newInstance();
                    sortedPotions.put(p.trueName(), pClass);
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    // Skip classes that cannot be instantiated
                }
            }
            potions.putAll(sortedPotions);
        }
    }

    public void show() {
        showPage(0);
    }

    private void showPage(int page) {
        ArrayList<String> allItems = new ArrayList<>(potions.keySet());
        int totalItems = allItems.size();
        int totalPages = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);

        int start = page * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, totalItems);

        ArrayList<String> pageItems = new ArrayList<>(allItems.subList(start, end));
        ArrayList<String> options = new ArrayList<>(pageItems);

        String title = "药剂";
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

        GameScene.show(new WndOptions(title, "请选择药剂", options.toArray(new String[0])) {
            @Override
            protected void onSelect(int index) {
                String selectedOption = options.get(index);

                if (selectedOption.equals("下一页")) {
                    showPage(page + 1);
                } else if (selectedOption.equals("上一页")) {
                    showPage(page - 1);
                } else if (!selectedOption.equals("取消")) {
                    try {
                        Class<?> clazz = potions.get(selectedOption);
                        Item item = (Item) clazz.getDeclaredConstructor().newInstance();
                        item.collect();
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });
    }
}
