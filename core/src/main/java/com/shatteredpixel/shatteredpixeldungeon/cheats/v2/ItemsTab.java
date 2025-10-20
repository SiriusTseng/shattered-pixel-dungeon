package com.shatteredpixel.shatteredpixeldungeon.cheats.v2;

import com.shatteredpixel.shatteredpixeldungeon.cheats.ItemClasses;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.ui.Component;

/**
 * 道具管理选项卡 - 完整功能版本
 * 包含道具生成、鉴定、解除诅咒等功能
 */
public class ItemsTab extends Component {

    // UI常量
    private static final float GAP = 2;
    private static final float BTN_HEIGHT = 18;
    private static final float TITLE_HEIGHT = 12;

    // UI组件
    private RenderedTextBlock title;
    private RedButton potionBtn;
    private RedButton scrollBtn;
    private RedButton weaponBtn;
    private RedButton armorBtn;
    private RedButton wandBtn;
    private RedButton ringBtn;
    private RedButton foodBtn;
    private RedButton artifactBtn;
    private RedButton bombBtn;
    private RedButton stoneBtn;


    // 位置跟踪
    private float pos;

    public ItemsTab() {
        super();
    }

    @Override
    protected void createChildren() {
        // 标题
        title = PixelScene.renderTextBlock("道具管理", 11);
        title.hardlight(Window.TITLE_COLOR);
        add(title);

        // 药水选择按钮
        potionBtn = new RedButton("选择药水") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.POTION, "选择药水"));
            }
        };
        add(potionBtn);

        // 卷轴选择按钮
        scrollBtn = new RedButton("选择卷轴") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.SCROLL, "选择卷轴"));
            }
        };
        add(scrollBtn);

        // 武器选择按钮
        weaponBtn = new RedButton("选择武器") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.WEAPON, "选择武器"));
            }
        };
        add(weaponBtn);

        // 护甲选择按钮
        armorBtn = new RedButton("选择护甲") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.ARMOR, "选择护甲"));
            }
        };
        add(armorBtn);

        // 魔杖选择按钮
        wandBtn = new RedButton("选择魔杖") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.WAND, "选择魔杖"));
            }
        };
        add(wandBtn);

        // 指环选择按钮
        ringBtn = new RedButton("选择指环") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.RING, "选择指环"));
            }
        };
        add(ringBtn);

        // 食物选择按钮
        foodBtn = new RedButton("选择食物") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.FOOD, "选择食物"));
            }
        };
        add(foodBtn);

        // 遗物选择按钮
        artifactBtn = new RedButton("选择遗物") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.ARTIFACT, "选择遗物"));
            }
        };
        add(artifactBtn);

        // 炸弹选择按钮
        bombBtn = new RedButton("选择炸弹") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.BOMB, "选择炸弹"));
            }
        };
        add(bombBtn);

        // 符石选择按钮
        stoneBtn = new RedButton("选择投掷武器") {
            @Override
            protected void onClick() {
                GameScene.show(new ItemSelectionWindow(ItemClasses.STONE, "选择投掷武器"));
            }
        };
        add(stoneBtn);
    }

    @Override
    protected void layout() {
        pos = 0;

        // 标题布局
        title.setRect(x, y, width, TITLE_HEIGHT);
        pos = TITLE_HEIGHT + GAP;

        // 按钮布局 - 垂直排列
        placeButton(potionBtn);
        placeButton(scrollBtn);
        placeButton(weaponBtn);
        placeButton(armorBtn);
        placeButton(wandBtn);
        placeButton(ringBtn);
        placeButton(foodBtn);
        placeButton(artifactBtn);
        placeButton(bombBtn);
        placeButton(stoneBtn);

        height = pos;
    }

    private void placeButton(RedButton btn) {
        btn.setRect(x, y + pos, width, BTN_HEIGHT);
        pos += BTN_HEIGHT + GAP;
    }
}