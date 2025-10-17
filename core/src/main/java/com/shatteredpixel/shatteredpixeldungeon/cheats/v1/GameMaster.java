package com.shatteredpixel.shatteredpixeldungeon.cheats.v1;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.PotionBandolier;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.ScrollHolder;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndMessage;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;

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
                GameScene.show(new WndOptions("Cheat", "操作类型", "角色", "道具", "地牢", "背包", "金币", "生成器", "取消") {
                    @Override
                    protected void onSelect(int index) {
                        switch (index) {
                            case 0:
                                getCharacterEntry();
                                break;
                            case 1:
                                getItemEntry();
                                break;
                            case 2:
                                getDungeonEntry();
                                break;
                            case 3:
                                getBagEntry();
                                break;
                            case 4:
                                getGoldEntry();
                                break;
                            case 5:
                                getGeneratorEntry();
                                break;
                            default:
                                GameScene.show(new WndMessage("取消作弊选项"));
                        }
                    }
                });
            }
        };
        entry.icon(Icons.get(Icons.CUBE_CODE));
        return entry;
    }

    public void getGeneratorEntry() {
        new ItemGen().show();
    }

    public void getCharacterEntry() {
        GameScene.show(new WndOptions("角色", "功能", "升级", "恢复状态", "增加力量", "取消") {
            @Override
            protected void onSelect(int index) {
                switch (index) {
                    case 0:
                        int expNeeded = Dungeon.hero.maxExp() - Dungeon.hero.exp;
                        Dungeon.hero.earnExp(expNeeded, this.getClass());
                        break;
                    case 1:
                        Dungeon.hero.HP = Dungeon.hero.HT;
                        Hunger hunger = Dungeon.hero.buff(Hunger.class);
                        if (hunger != null) {
                            hunger.satisfy(Hunger.STARVING - hunger.hunger());
                        }
                        break;
                    case 2:
                        Dungeon.hero.STR++;
                        break;
                    default:
                }
            }
        });
    }

    public void getBagEntry() {
        GameScene.show(new WndOptions("背包", "类型", "卷轴包", "药水包", "魔杖包", "天鹅绒袋", "取消") {
            @Override
            protected void onSelect(int index) {
                Bag bag = null;
                switch (index) {
                    case 0: // 卷轴包 (Scroll Holder)
                        if (Dungeon.hero.belongings.getItem(ScrollHolder.class) != null) {
                            GameScene.show(new WndMessage("你已拥有该背包"));
                            return;
                        }
                        bag = new ScrollHolder();
                        break;
                    case 1: // 药水包 (Potion Bandolier)
                        if (Dungeon.hero.belongings.getItem(PotionBandolier.class) != null) {
                            GameScene.show(new WndMessage("你已拥有该背包"));
                            return;
                        }
                        bag = new PotionBandolier();
                        break;
                    case 2: // 魔杖包 (Magical Holster)
                        if (Dungeon.hero.belongings.getItem(MagicalHolster.class) != null) {
                            GameScene.show(new WndMessage("你已拥有该背包"));
                            return;
                        }
                        bag = new MagicalHolster();
                        break;
                    case 3: // 天鹅绒袋 (Velvet Pouch)
                        if (Dungeon.hero.belongings.getItem(VelvetPouch.class) != null) {
                            GameScene.show(new WndMessage("你已拥有该背包"));
                            return;
                        }
                        bag = new VelvetPouch();
                        break;
                    default:
                        return;
                }
                if (bag != null) {
                    bag.doPickUp(Dungeon.hero);
                }
            }
        });
    }

    public void getItemEntry() {
        GameScene.show(new WndOptions("道具", "类型", "药品", "卷轴", "武器", "护甲", "魔杖", "指环", "食物", "遗物", "一键鉴定", "解除诅咒", "取消") {
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
                        new WeaponGen().show();
                        break;
                    case 3://护甲
                        new ArmorGen().show();
                        break;
                    case 4://魔仗
                        new WandGen().show();
                        break;
                    case 5://指环
                        new RingGen().show();
                        break;
                    case 6://食物
                        new FoodGen().show();
                        break;
                    case 7://遗物
                        new ArtifactGen().show();
                        break;
                    case 8://一键鉴定
                        Dungeon.hero.belongings.identify();
                        break;
                    case 9://解除诅咒
                        for (Item item : Dungeon.hero.belongings) {
                            if (item.cursed) {
                                item.cursed = false;
                            }
                        }
                        break;
                    default:
                }
            }
        });
    }


    public void getDungeonEntry() {
        GameScene.show(new WndOptions("地牢", "功能", "地图全开", "取消") {
            @Override
            protected void onSelect(int index) {
                switch (index) {
                    case 0:
                        if (Dungeon.level != null) {
                            for (int i = 0; i < Dungeon.level.visited.length; i++) {
                                Dungeon.level.visited[i] = true;
                                Dungeon.level.mapped[i] = true;
                            }
                            Dungeon.observe();
                        }
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
