package com.shatteredpixel.shatteredpixeldungeon.cheats.v2;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.ui.Component;

/**
 * 角色管理选项卡 - 完整功能版本
 * 包含角色属性修改、状态恢复、等级调整等功能
 */
public class CharacterTab extends Component {

    // UI常量
    private static final float GAP = 2;
    private static final float BTN_HEIGHT = 18;
    private static final float TITLE_HEIGHT = 12;

    // UI组件
    private RenderedTextBlock title;
    private RedButton levelUpBtn;
    private RedButton restoreHealthBtn;
    private RedButton addStrengthBtn;
    private RedButton addGoldBtn;
    private RedButton clearBuffsBtn;
    private RedButton feedHeroBtn;
    private RedButton identifyBtn;
    private RedButton uncursBtn;

    // 位置跟踪
    private float pos;

    public CharacterTab() {
        super();
    }

    @Override
    protected void createChildren() {
        // 标题
        title = PixelScene.renderTextBlock("角色管理", 9);
        title.hardlight(Window.TITLE_COLOR);
        add(title);

        // 升级按钮 - 直接升到满级
        levelUpBtn = new RedButton("提高等级") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    int expNeeded = Dungeon.hero.maxExp() - Dungeon.hero.exp;
                    Dungeon.hero.earnExp(expNeeded, this.getClass());
                }
            }
        };
        add(levelUpBtn);

        // 恢复生命值按钮
        restoreHealthBtn = new RedButton("恢复生命") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    Dungeon.hero.HP = Dungeon.hero.HT;
                    Hunger hunger = Dungeon.hero.buff(Hunger.class);
                    if (hunger != null) {
                        hunger.satisfy(Hunger.STARVING - hunger.hunger());
                    }
                }
            }
        };
        add(restoreHealthBtn);

        // 喂食按钮
        feedHeroBtn = new RedButton("恢复饥饿") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    Hunger hunger = Dungeon.hero.buff(Hunger.class);
                    if (hunger != null) {
                        hunger.satisfy(Hunger.STARVING);
                    }
                }
            }
        };
        add(feedHeroBtn);

        // 增加力量按钮
        addStrengthBtn = new RedButton("增加力量") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    Dungeon.hero.STR++;
                }
            }
        };
        add(addStrengthBtn);

        // 添加金币按钮
        addGoldBtn = new RedButton("添加金币") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    Gold gold = new Gold(500);
                    gold.doPickUp(Dungeon.hero);
                }
            }
        };
        add(addGoldBtn);



        // 清除负面效果按钮
        clearBuffsBtn = new RedButton("清除负面效果") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    // 移除所有负面buff
                    for (Buff buff : Dungeon.hero.buffs()) {
                        if (buff.type == Buff.buffType.NEGATIVE) {
                            buff.detach();
                        }
                    }
                }
            }
        };
        add(clearBuffsBtn);

        // 一键鉴定按钮
        identifyBtn = new RedButton("鉴定所有物品") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    Dungeon.hero.belongings.identify();
                }
            }
        };
        add(identifyBtn);

        // 解除诅咒按钮
        uncursBtn = new RedButton("解除所有诅咒") {
            @Override
            protected void onClick() {
                if (Dungeon.hero != null) {
                    for (Item item : Dungeon.hero.belongings) {
                        if (item.cursed) {
                            item.cursed = false;
                        }
                    }
                }
            }
        };
        add(uncursBtn);
    }

    @Override
    protected void layout() {
        pos = 0;

        // 标题布局
        title.setRect(x, y, width, TITLE_HEIGHT);
        pos = TITLE_HEIGHT + GAP;

        // 按钮布局 - 垂直排列
        placeButton(levelUpBtn);
        placeButton(restoreHealthBtn);
        placeButton(addStrengthBtn);
        placeButton(addGoldBtn);
        placeButton(feedHeroBtn);
        placeButton(clearBuffsBtn);
        placeButton(identifyBtn);
        placeButton(uncursBtn);

        height = pos;
    }

    private void placeButton(RedButton btn) {
        btn.setRect(x, y + pos, width, BTN_HEIGHT);
        pos += BTN_HEIGHT + GAP;
    }
}