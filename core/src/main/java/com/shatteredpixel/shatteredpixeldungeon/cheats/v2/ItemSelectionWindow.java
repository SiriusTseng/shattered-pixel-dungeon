package com.shatteredpixel.shatteredpixeldungeon.cheats.v2;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.cheats.ItemClasses;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndMessage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 道具选择窗口 - 分页显示所有道具
 * 一页显示6个道具，支持翻页功能
 */
public class ItemSelectionWindow extends Window {

    // UI常量
    private static final int WIDTH_P = 120;
    private static final int WIDTH_L = 160;
    private static final float BTN_HEIGHT = 18;
    private static final float GAP = 2;
    private static final int ITEMS_PER_PAGE = 12;

    // UI组件
    private RenderedTextBlock title;
    private RedButton[] itemButtons;
    private RedButton prevBtn;
    private RedButton nextBtn;
    private RenderedTextBlock pageInfo;

    // 数据
    private Map<String, Class<? extends Item>> allItems;
    private int currentPage = 0;
    private int totalPages;
    private String categoryTitle;

    // 静态变量保存道具类别
    public static Class<?> currentCategory;

    // 移除硬编码的道具类数组，现在使用ItemClasses常量类

    public ItemSelectionWindow(Class<?> itemClass, String title) {
        super();

        this.categoryTitle = title;
        currentCategory = itemClass;

        int width = PixelScene.landscape() ? WIDTH_L : WIDTH_P;

        // 生成该类别的所有可能道具
        generateAllItems(itemClass);

        // 计算总页数
        totalPages = Math.max(1, (allItems.size() + ITEMS_PER_PAGE - 1) / ITEMS_PER_PAGE);
        currentPage = 0;

        // 创建UI组件
        createComponents();

        // 更新页面显示
        updatePage();

        // 设置窗口大小
        resize(width, (int) calculateHeight());

        // 调用布局方法
        layout();
    }

    private void generateAllItems(Class<?> itemClass) {
        allItems = new LinkedHashMap<>();
        Class<?>[] itemClasses = null;

        // 确定道具类数组
        if (itemClass == ItemClasses.POTION) {
            itemClasses = ItemClasses.POTION_CLASSES;
        } else if (itemClass == ItemClasses.SCROLL) {
            itemClasses = ItemClasses.SCROLL_CLASSES;
        } else if (itemClass == ItemClasses.FOOD) {
            itemClasses = ItemClasses.FOOD_CLASSES;
        } else if (itemClass == ItemClasses.WEAPON) {
            itemClasses = ItemClasses.ALL_WEAPON_CLASSES;
        } else if (itemClass == ItemClasses.ARMOR) {
            itemClasses = ItemClasses.ARMOR_CLASSES;
        } else if (itemClass == ItemClasses.WAND) {
            itemClasses = ItemClasses.WAND_CLASSES;
        } else if (itemClass == ItemClasses.RING) {
            itemClasses = ItemClasses.RING_CLASSES;
        } else if (itemClass == ItemClasses.ARTIFACT) {
            itemClasses = ItemClasses.ARTIFACT_CLASSES;
        }

        if (itemClasses != null) {
            Map<String, Class<? extends Item>> sortedItems = new TreeMap<>();
            for (Class<?> clazz : itemClasses) {
                try {
                    if (Item.class.isAssignableFrom(clazz)) {
                        @SuppressWarnings("unchecked")
                        Class<? extends Item> itemType = (Class<? extends Item>) clazz;
                        Item item = itemType.getDeclaredConstructor().newInstance();
                        sortedItems.put(item.trueName(), itemType);
                    }
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                         InvocationTargetException e) {
                    // 跳过无法实例化的类
                }
            }
            allItems.putAll(sortedItems);
        }
    }

//    private void useGeneratorForCategory(Class<?> itemClass) {
//        Generator.Category category = null;
//
//        if (itemClass == ItemClasses.WEAPON) {
//            category = Generator.Category.WEAPON;
//        } else if (itemClass == ItemClasses.ARMOR) {
//            category = Generator.Category.ARMOR;
//        } else if (itemClass == ItemClasses.WAND) {
//            category = Generator.Category.WAND;
//        } else if (itemClass == ItemClasses.RING) {
//            category = Generator.Category.RING;
//        } else if (itemClass == ItemClasses.ARTIFACT) {
//            category = Generator.Category.ARTIFACT;
//        }
//
//        if (category != null) {
//            Map<String, Class<? extends Item>> sortedItems = new TreeMap<>();
//            // 生成多个道具以覆盖所有可能性
//            for (int i = 0; i < 30; i++) {
//                Item item = Generator.random(category);
//                if (item != null && !sortedItems.containsKey(item.name())) {
//                    try {
//                        Class<? extends Item> itemType = item.getClass();
//                        // 创建新实例以获取名称
//                        Item newItem = itemType.getDeclaredConstructor().newInstance();
//                        sortedItems.put(newItem.trueName(), itemType);
//                    } catch (Exception e) {
//                        // 忽略创建失败的道具
//                    }
//                }
//            }
//            allItems.putAll(sortedItems);
//        }
//    }

    private void createComponents() {
        // 标题
        title = PixelScene.renderTextBlock(categoryTitle, 9);
        title.hardlight(TITLE_COLOR);
        add(title);

        // 创建道具按钮数组
        itemButtons = new RedButton[ITEMS_PER_PAGE];
        for (int i = 0; i < ITEMS_PER_PAGE; i++) {
            final int index = i;
            itemButtons[i] = new RedButton("") {
                @Override
                protected void onClick() {
                    List<String> itemNames = new ArrayList<>(allItems.keySet());
                    int itemIndex = currentPage * ITEMS_PER_PAGE + index;
                    if (itemIndex < itemNames.size()) {
                        String itemName = itemNames.get(itemIndex);
                        generateAndGiveItem(itemName);
                    }
                }
            };
            add(itemButtons[i]);
        }

        // 翻页按钮
        prevBtn = new RedButton("上一页") {
            @Override
            protected void onClick() {
                if (currentPage > 0) {
                    currentPage--;
                    updatePage();
                }
            }
        };
        add(prevBtn);

        nextBtn = new RedButton("下一页") {
            @Override
            protected void onClick() {
                if (currentPage < totalPages - 1) {
                    currentPage++;
                    updatePage();
                }
            }
        };
        add(nextBtn);

        // 页面信息
        pageInfo = PixelScene.renderTextBlock("", 6);
        add(pageInfo);
    }

    private void updatePage() {
        // 更新道具按钮
        List<String> itemNames = new ArrayList<>(allItems.keySet());
        int startIndex = currentPage * ITEMS_PER_PAGE;
        for (int i = 0; i < ITEMS_PER_PAGE; i++) {
            int itemIndex = startIndex + i;
            if (itemIndex < itemNames.size()) {
                String itemName = itemNames.get(itemIndex);
                itemButtons[i].text(itemName);
                itemButtons[i].enable(true);
                itemButtons[i].visible = true;
            } else {
                itemButtons[i].text("");
                itemButtons[i].enable(false);
                itemButtons[i].visible = false;
            }
        }

        // 更新翻页按钮状态
        prevBtn.enable(currentPage > 0);
        nextBtn.enable(currentPage < totalPages - 1);

        // 更新页面信息
        pageInfo.text(Messages.format("第 %d/%d 页", currentPage + 1, totalPages));

        // 重新布局
        layout();
    }

    private void generateAndGiveItem(String itemName) {
        if (Dungeon.hero == null) return;

        try {
            // 根据名称获取道具类
            Class<? extends Item> itemClass = allItems.get(itemName);
            if (itemClass == null) return;

            // 创建新的道具实例
            Item item = itemClass.getDeclaredConstructor().newInstance();

            // 如果是指环或魔杖，随机等级
            if (item instanceof com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring) {
                item.upgrade(1 + Dungeon.depth / 5);
            } else if (item instanceof com.shatteredpixel.shatteredpixeldungeon.items.wands.Wand) {
                item.upgrade(1 + Dungeon.depth / 5);
            }

            // 尝试将物品添加到英雄背包
            if (item.doPickUp(Dungeon.hero)) {
                // 物品成功拾取
                GameScene.show(new WndMessage(String.format("拾取了 %s", item.trueName())));

            } else {
                // 如果背包满了，放在地上
                Dungeon.level.drop(item, Dungeon.hero.pos).type = Heap.Type.HEAP;
            }
        } catch (Exception e) {
            // 生成失败时静默处理
        }
    }

    private float calculateHeight() {
        float height = 0;

        // 标题高度
        height += 12 + GAP;

        // 道具按钮高度 (6行 x 2列)
        height += 6 * (BTN_HEIGHT + GAP);

        // 翻页按钮和信息高度
        height += BTN_HEIGHT + GAP + 6;

        return height + GAP;
    }

    public void layout() {
        float pos = 0;

        // 标题布局
        title.setRect(0, pos, width, 12);
        pos += 12 + GAP;

        // 道具按钮布局 (2列 x 6行)
        float btnWidth = (width - GAP) / 2;
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 2; col++) {
                int index = row * 2 + col;
                float x = col * (btnWidth + GAP);
                itemButtons[index].setRect(x, pos, btnWidth, BTN_HEIGHT);
            }
            pos += BTN_HEIGHT + GAP;
        }

        // 翻页按钮布局 (同一行)
        float navBtnWidth = (width - GAP) / 2;
        prevBtn.setRect(0, pos, navBtnWidth, BTN_HEIGHT);
        nextBtn.setRect(navBtnWidth + GAP, pos, navBtnWidth, BTN_HEIGHT);
        pos += BTN_HEIGHT + GAP;

        // 页面信息布局
        pageInfo.setRect(0, pos, width, 6);
    }
}