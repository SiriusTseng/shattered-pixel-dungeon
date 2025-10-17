package com.shatteredpixel.shatteredpixeldungeon.cheats.v2;

import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.watabou.noosa.Image;

/**
 * 新的作弊系统主窗口，使用真正的选项卡式布局
 * 完全参考WndSettings的设计模式
 */
public class WndCheatSystem extends com.shatteredpixel.shatteredpixeldungeon.windows.WndTabbed {

    private static final int WIDTH_P = 135;  // 竖屏宽度
    private static final int WIDTH_L = 220;  // 横屏宽度
    private static final int BTN_HEIGHT = 18;
    private static final float GAP = 1;

    // 选项卡引用
    private CharacterTab characterTab;      // 角色选项卡
    private ItemsTab itemsTab;              // 道具选项卡
    private DungeonTab dungeonTab;          // 地牢选项卡
    private InventoryTab inventoryTab;      // 背包选项卡
    private ResourcesTab resourcesTab;      // 资源选项卡

    public static int last_index = 0;

    public WndCheatSystem() {
        super();

        float height;
        int width = PixelScene.landscape() ? WIDTH_L : WIDTH_P;

        // 初始化角色选项卡
        characterTab = new CharacterTab();
        characterTab.setSize(width, 0);
        height = characterTab.height();
        add(characterTab);

        // 添加角色选项卡按钮
        add(new IconTab(Icons.get(Icons.TALENT)) {
            @Override
            protected void select(boolean value) {
                super.select(value);
                characterTab.visible = characterTab.active = value;
                if (value) last_index = 0;
            }
        });

        // 初始化道具选项卡
        itemsTab = new ItemsTab();
        itemsTab.setSize(width, 0);
        height = Math.max(height, itemsTab.height());
        add(itemsTab);

        // 添加道具选项卡按钮
        add(new IconTab(Icons.get(Icons.BACKPACK)) {
            @Override
            protected void select(boolean value) {
                super.select(value);
                itemsTab.visible = itemsTab.active = value;
                if (value) last_index = 1;
            }
        });

        // 初始化地牢选项卡
        dungeonTab = new DungeonTab();
        dungeonTab.setSize(width, 0);
        height = Math.max(height, dungeonTab.height());
        add(dungeonTab);

        // 添加地牢选项卡按钮
        add(new IconTab(Icons.get(Icons.DEPTH)) {
            @Override
            protected void select(boolean value) {
                super.select(value);
                dungeonTab.visible = dungeonTab.active = value;
                if (value) last_index = 2;
            }
        });

        // 初始化背包选项卡
        inventoryTab = new InventoryTab();
        inventoryTab.setSize(width, 0);
        height = Math.max(height, inventoryTab.height());
        add(inventoryTab);

        // 添加背包选项卡按钮
        add(new IconTab(Icons.get(Icons.CATALOG)) {
            @Override
            protected void select(boolean value) {
                super.select(value);
                inventoryTab.visible = inventoryTab.active = value;
                if (value) last_index = 3;
            }
        });

        // 初始化资源选项卡
        resourcesTab = new ResourcesTab();
        resourcesTab.setSize(width, 0);
        height = Math.max(height, resourcesTab.height());
        add(resourcesTab);

        // 添加资源选项卡按钮
        add(new IconTab(Icons.get(Icons.GOLD)) {
            @Override
            protected void select(boolean value) {
                super.select(value);
                resourcesTab.visible = resourcesTab.active = value;
                if (value) last_index = 4;
            }
        });

        resize(width, (int) Math.ceil(height));
        layoutTabs();

        // 默认选中第一个选项卡
        select(last_index);
    }

    /**
     * 重写IconTab类，移除不必要的blocker
     */
    private class IconTab extends com.shatteredpixel.shatteredpixeldungeon.windows.WndTabbed.IconTab {

        public IconTab(Image icon) {
            super(icon);
        }

        @Override
        protected void createChildren() {
            super.createChildren();
            // 移除全局blocker以避免阻塞游戏交互
            if (blocker != null) {
                remove(blocker);
                blocker = null;
            }
        }
    }
}