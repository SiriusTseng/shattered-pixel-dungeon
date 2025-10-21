package com.shatteredpixel.shatteredpixeldungeon.cheats;

import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.Armor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.glyphs.Stone;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.Artifact;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.PotionBandolier;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.ScrollHolder;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ArcaneBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Firebomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FlashBangBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FrostBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.HolyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Noisemaker;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.RegrowthBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShrapnelBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.SmokeBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.WoollyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Berry;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Blandfruit;
import com.shatteredpixel.shatteredpixeldungeon.items.food.ChargrilledMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.items.food.FrozenCarpaccio;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MeatPie;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Pasty;
import com.shatteredpixel.shatteredpixeldungeon.items.food.PhantomMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallRation;
import com.shatteredpixel.shatteredpixeldungeon.items.food.StewedMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SupplyRation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.Potion;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfExperience;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHaste;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfMindVision;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfParalyticGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfPurity;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfToxicGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.AquaBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.BlizzardBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.CausticBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.InfernalBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.ShockingBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.UnstableBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfArcaneArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfDragonsBlood;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfFeatherFall;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfIcyTouch;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfMight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfToxicEssence;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDivineInspiration;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDragonsBreath;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfEarthenArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMagicalSight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMastery;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShielding;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfSnapFreeze;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStamina;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStormClouds;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
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
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfAntiMagic;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfDivination;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfDread;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfEnchantment;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfMetamorphosis;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfMysticalEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPassage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPrismaticImage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.Wand;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;

/**
 * 道具类常量定义
 * 统一管理所有作弊系统中使用的道具类，提高代码可维护性
 */
public final class ItemClasses {

    // ==================== 药水类 ====================

    /**
     * 药水基类
     */
    public static final Class<Potion> POTION = Potion.class;

    /**
     * 药水类数组
     */
    public static final Class<?>[] POTION_CLASSES = new Class<?>[]{
            //基础
            PotionOfExperience.class,
            PotionOfFrost.class,
            PotionOfHaste.class,
            PotionOfInvisibility.class,
            PotionOfHealing.class,
            PotionOfLiquidFlame.class,
            PotionOfLevitation.class,
            PotionOfMindVision.class,
            PotionOfParalyticGas.class,
            PotionOfToxicGas.class,
            PotionOfPurity.class,
            PotionOfStrength.class,

            // 酿造物 (Brews)
            AquaBrew.class,
            BlizzardBrew.class,
            CausticBrew.class,
            InfernalBrew.class,
            ShockingBrew.class,
            UnstableBrew.class,

            // 灵药 (Elixirs)
            ElixirOfHoneyedHealing.class,
            ElixirOfAquaticRejuvenation.class,
            ElixirOfArcaneArmor.class,
            ElixirOfDragonsBlood.class,
            ElixirOfIcyTouch.class,
            ElixirOfToxicEssence.class,
            ElixirOfMight.class,
            ElixirOfFeatherFall.class,

            // 奇异药水 (Exotic Potions)
            PotionOfCleansing.class,
            PotionOfCorrosiveGas.class,
            PotionOfDivineInspiration.class,
            PotionOfDragonsBreath.class,
            PotionOfEarthenArmor.class,
            PotionOfMagicalSight.class,
            PotionOfMastery.class,
            PotionOfShielding.class,
            PotionOfShroudingFog.class,
            PotionOfSnapFreeze.class,
            PotionOfStamina.class,
            PotionOfStormClouds.class
            //
    };

    // ==================== 卷轴类 ====================

    /**
     * 卷轴基类
     */
    public static final Class<Scroll> SCROLL = Scroll.class;

    /**
     * 卷轴类数组
     */
    public static final Class<?>[] SCROLL_CLASSES = new Class<?>[]{
            //基础
            ScrollOfIdentify.class,
            ScrollOfLullaby.class,
            ScrollOfMagicMapping.class,
            ScrollOfMirrorImage.class,
            ScrollOfRage.class,
            ScrollOfRecharging.class,
            ScrollOfRemoveCurse.class,
            ScrollOfRetribution.class,
            ScrollOfTeleportation.class,
            ScrollOfTerror.class,
            ScrollOfTransmutation.class,
            ScrollOfUpgrade.class,
            //高级
            ScrollOfAntiMagic.class,
            ScrollOfChallenge.class,
            ScrollOfDivination.class,
            ScrollOfDread.class,
            ScrollOfEnchantment.class,
            ScrollOfForesight.class,
            ScrollOfMetamorphosis.class,
            ScrollOfMysticalEnergy.class,
            ScrollOfPassage.class,
            ScrollOfPrismaticImage.class,
            ScrollOfPsionicBlast.class,
            ScrollOfSirensSong.class
    };

    // ==================== 食物类 ====================

    /**
     * 食物基类
     */
    public static final Class<Food> FOOD = Food.class;


    /**
     * 食物类数组
     */
    public static final Class<?>[] FOOD_CLASSES = new Class<?>[]{
            Berry.class,
            Blandfruit.class,
            ChargrilledMeat.class,
            FrozenCarpaccio.class,
            MeatPie.class,
            MysteryMeat.class,
            Pasty.class,
            PhantomMeat.class,
            SmallRation.class,
            StewedMeat.class,
            SupplyRation.class
    };

    // ==================== 装备类 ====================

    /**
     * 武器基类
     */
    public static final Class<Weapon> WEAPON = Weapon.class;


    public static final Class<?>[] WEAPON_CLASSES = mergeClassArrays(
            Generator.Category.WEAPON.classes,
            Generator.Category.WEP_T1.classes,
            Generator.Category.WEP_T2.classes,
            Generator.Category.WEP_T3.classes,
            Generator.Category.WEP_T4.classes,
            Generator.Category.WEP_T5.classes
    );

    public static final Class<?>[] MISSILE_WEAPON_CLASSES = mergeClassArrays(
            Generator.Category.MISSILE.classes,
            Generator.Category.MIS_T1.classes,
            Generator.Category.MIS_T2.classes,
            Generator.Category.MIS_T3.classes,
            Generator.Category.MIS_T4.classes,
            Generator.Category.MIS_T5.classes
    );

    public static final Class<?>[] ALL_WEAPON_CLASSES = mergeClassArrays(WEAPON_CLASSES, MISSILE_WEAPON_CLASSES);


    /**
     * 护甲基类
     */
    public static final Class<Armor> ARMOR = Armor.class;

    public static final Class<?>[] ARMOR_CLASSES = Generator.Category.ARMOR.classes;

    /**
     * 魔杖基类
     */
    public static final Class<Wand> WAND = Wand.class;

    public static final Class<?>[] WAND_CLASSES = Generator.Category.WAND.classes;


    /**
     * 指环基类
     */
    public static final Class<Ring> RING = Ring.class;

    public static final Class<?>[] RING_CLASSES = Generator.Category.RING.classes;


    /**
     * 遗物基类
     */
    public static final Class<Artifact> ARTIFACT = Artifact.class;

    public static final Class<?>[] ARTIFACT_CLASSES = Generator.Category.ARTIFACT.classes;


    // ==================== 背包类 ====================

    /**
     * 背包基类
     */
    public static final Class<Bag> BAG = Bag.class;

    /**
     * 背包类数组
     */
    public static final Class<? extends Bag>[] BAG_CLASSES = new Class[]{
            ScrollHolder.class,
            PotionBandolier.class,
            MagicalHolster.class,
            VelvetPouch.class
    };

    // ==================== 投掷物 ====================
    public static final Class<Stone> STONE = Stone.class;
    public static final Class<?>[] STONE_CLASSES = Generator.Category.STONE.classes;

    // ==================== 炸弹 ====================
    public static final Class<Bomb> BOMB = Bomb.class;

    public static final Class<?>[] BOMB_CLASSES = {
            ArcaneBomb.class,
            Firebomb.class,
            FlashBangBomb.class,
            FrostBomb.class,
            HolyBomb.class,
            Noisemaker.class,
            RegrowthBomb.class,
            ShrapnelBomb.class,
            SmokeBomb.class,
            WoollyBomb.class
    };


    /**
     * 将多个Class数组合并为一个数组，严格保持原有顺序
     *
     * 该方法按照传入数组的顺序依次合并，确保：
     * 1. 第一个数组的元素在前，第二个数组的元素在后，以此类推
     * 2. 每个数组内部的元素顺序保持不变
     * 3. 结果数组的顺序与传入参数的顺序完全一致
     *
     * @param arrays 要合并的Class数组，按期望的最终顺序传入
     * @return 合并后的Class数组，严格保持原有顺序
     */
    private static Class<?>[] mergeClassArrays(Class<?>[]... arrays) {
        // 处理空数组的情况
        if (arrays == null || arrays.length == 0) {
            return new Class<?>[0];
        }

        // 计算总长度
        int totalLength = 0;
        for (Class<?>[] array : arrays) {
            if (array != null) {
                totalLength += array.length;
            }
        }

        // 创建结果数组
        Class<?>[] result = new Class<?>[totalLength];
        int currentIndex = 0;

        // 按顺序合并数组
        for (int i = 0; i < arrays.length; i++) {
            Class<?>[] array = arrays[i];
            if (array != null && array.length > 0) {
                // 使用System.arraycopy保持数组内部顺序
                System.arraycopy(array, 0, result, currentIndex, array.length);
                currentIndex += array.length;

                // 调试信息：记录合并过程（可选择性启用）
                // System.out.println("合并数组 " + (i+1) + ": " + array.length + " 个元素，位置: " + (currentIndex - array.length) + "-" + (currentIndex-1));
            }
        }

        return result;
    }


    // 私有构造函数，防止实例化
    private ItemClasses() {
        throw new AssertionError("ItemClasses类不应该被实例化");
    }
}