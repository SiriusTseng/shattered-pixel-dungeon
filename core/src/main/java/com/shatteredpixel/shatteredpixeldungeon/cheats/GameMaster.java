package com.shatteredpixel.shatteredpixeldungeon.cheats;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.Potion;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndMessage;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.watabou.utils.GameSettings;
import com.watabou.utils.Graph;

public class GameMaster {

    private final Window window;

    public GameMaster(Window window) {
        this.window = window;
    }

    public RedButton getEntry() {
        RedButton entry = new RedButton("Cheat") {
            @Override
            protected void onClick() {
                window.hide();
                GameScene.show(new WndOptions("Cheat", "操作类型", "道具", "金币", "取消") {
                    @Override
                    protected void onSelect(int index) {
                        switch (index) {
                            case 0:
                                getItemEntry();
                                break;
                            case 1:
                                getGoldEntry();
                                break;
                            case 2:
                            default:
                                GameScene.show(new WndMessage("You canceled the cheating operation"));
                        }
                    }
                });
            }
        };
        entry.icon(Icons.get(Icons.CUBE_CODE));
        return entry;
    }

    public void getItemEntry() {
        GameScene.show(new WndOptions("道具", "类型", "药品", "卷轴", "武器", "护甲", "魔杖", "指环", "食物", "遗物", "取消") {
            @Override
            protected void onSelect(int index) {
                switch (index) {
                    case 0://药品
                        new PotionGen().show();
                        break;
                    case 1://卷轴
                        new ScrollGen().show();
                        break;
                    case 2://武器
                        Generator.randomWeapon().collect();
                        break;
                    case 3://护甲
                        Generator.randomArmor().collect();
                        break;
                    case 4://魔仗
                        Generator.random(Generator.Category.WAND).collect();
                        break;
                    case 5://指环
                        Generator.random(Generator.Category.RING).collect();
                        break;
                    case 6://食物
                        Generator.random(Generator.Category.FOOD).collect();
                        break;
                    case 7://遗物
                        Generator.random(Generator.Category.ARTIFACT).collect();
                        break;
                    default:
                }
            }
        });
    }

    public void getGoldEntry() {
        GameScene.show(new WndOptions("金币", "数量", "100", "500", "1000", "5000") {
            @Override
            protected void onSelect(int index) {
                int number = 0;
                switch (index) {
                    case 0:
                        number = 100;
                        break;
                    case 1:
                        number = 500;
                        break;
                    case 2:
                        number = 1000;
                        break;
                    case 3:
                        number = 5000;
                        break;
                }
                if (number > 0) {
                    Gold gold = new Gold(number);
                    gold.doPickUp(Dungeon.hero);
                }

            }
        });
    }


}

