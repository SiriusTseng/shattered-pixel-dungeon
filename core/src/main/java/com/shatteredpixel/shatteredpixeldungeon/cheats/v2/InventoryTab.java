package com.shatteredpixel.shatteredpixeldungeon.cheats.v2;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.PotionBandolier;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.ScrollHolder;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndMessage;
import com.watabou.noosa.ui.Component;

/**
 * 背包管理选项卡 - 完整功能版本
 * 包含获取所有背包和单个背包获取功能
 */
public class InventoryTab extends Component {

    // UI常量
    private static final float GAP = 2;
    private static final float BTN_HEIGHT = 18;
    private static final float TITLE_HEIGHT = 12;

    // UI组件
    private RenderedTextBlock title;
    private RedButton getAllBagsBtn;
    private RedButton scrollHolderBtn;
    private RedButton potionBandolierBtn;
    private RedButton magicalHolsterBtn;
    private RedButton velvetPouchBtn;

    // 位置跟踪
    private float pos;

    public InventoryTab() {
        super();
    }

    @Override
    protected void createChildren() {
        // 标题
        title = PixelScene.renderTextBlock("背包管理", 9);
        title.hardlight(Window.TITLE_COLOR);
        add(title);

        // 获取所有背包按钮
        getAllBagsBtn = new RedButton("获取所有背包") {
            @Override
            protected void onClick() {
                getAllBags();
            }
        };
        add(getAllBagsBtn);

        // 卷轴包按钮
        scrollHolderBtn = new RedButton("获取卷轴包") {
            @Override
            protected void onClick() {
                getBag(ScrollHolder.class, "卷轴包");
            }
        };
        add(scrollHolderBtn);

        // 药水包按钮
        potionBandolierBtn = new RedButton("获取药水包") {
            @Override
            protected void onClick() {
                getBag(PotionBandolier.class, "药水包");
            }
        };
        add(potionBandolierBtn);

        // 魔杖包按钮
        magicalHolsterBtn = new RedButton("获取魔杖包") {
            @Override
            protected void onClick() {
                getBag(MagicalHolster.class, "魔杖包");
            }
        };
        add(magicalHolsterBtn);

        // 天鹅绒袋按钮
        velvetPouchBtn = new RedButton("获取天鹅绒袋") {
            @Override
            protected void onClick() {
                getBag(VelvetPouch.class, "天鹅绒袋");
            }
        };
        add(velvetPouchBtn);
    }

    @Override
    protected void layout() {
        pos = 0;

        // 标题布局
        title.setRect(x, y, width, TITLE_HEIGHT);
        pos = TITLE_HEIGHT + GAP;

        // 按钮布局 - 垂直排列
        placeButton(getAllBagsBtn);
        placeButton(scrollHolderBtn);
        placeButton(potionBandolierBtn);
        placeButton(magicalHolsterBtn);
        placeButton(velvetPouchBtn);

        height = pos;
    }

    private void placeButton(RedButton btn) {
        btn.setRect(x, y + pos, width, BTN_HEIGHT);
        pos += BTN_HEIGHT + GAP;
    }

    /**
     * 获取所有背包
     */
    private void getAllBags() {
        if (Dungeon.hero == null) return;

        // 尝试获取所有4种背包
        getBagWithoutMessage(ScrollHolder.class);
        getBagWithoutMessage(PotionBandolier.class);
        getBagWithoutMessage(MagicalHolster.class);
        getBagWithoutMessage(VelvetPouch.class);
    }

    /**
     * 获取指定类型的背包（带消息提示）
     */
    private void getBag(Class<? extends Bag> bagClass, String bagName) {
        if (Dungeon.hero == null) return;

        // 检查是否已拥有该背包
        if (Dungeon.hero.belongings.getItem(bagClass) != null) {
            GameScene.show(new WndMessage("你已拥有" + bagName));
            return;
        }

        // 创建并给予背包
        try {
            Bag bag = bagClass.getDeclaredConstructor().newInstance();
            bag.doPickUp(Dungeon.hero);
        } catch (Exception e) {
            // 创建失败时静默处理
        }
    }

    /**
     * 获取指定类型的背包（无消息提示）
     */
    private void getBagWithoutMessage(Class<? extends Bag> bagClass) {
        if (Dungeon.hero == null) return;

        // 检查是否已拥有该背包
        if (Dungeon.hero.belongings.getItem(bagClass) != null) {
            return; // 已拥有，跳过
        }

        // 创建并给予背包
        try {
            Bag bag = bagClass.getDeclaredConstructor().newInstance();
            bag.doPickUp(Dungeon.hero);
        } catch (Exception e) {
            // 创建失败时静默处理
        }
    }
}