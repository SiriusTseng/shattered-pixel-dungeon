package com.shatteredpixel.shatteredpixeldungeon.cheats;

import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.*;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.glyphs.Stone;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.*;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.*;
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
import com.shatteredpixel.shatteredpixeldungeon.items.food.*;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.*;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.*;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.*;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.*;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.*;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.*;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.*;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.*;

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
     * 将多个Class数组合并为一个数组
     *
     * @param arrays 要合并的Class数组
     * @return 合并后的Class数组
     */
    private static Class<?>[] mergeClassArrays(Class<?>[]... arrays) {
        int totalLength = 0;
        for (Class<?>[] array : arrays) {
            totalLength += array.length;
        }

        Class<?>[] result = new Class<?>[totalLength];
        int currentIndex = 0;
        for (Class<?>[] array : arrays) {
            System.arraycopy(array, 0, result, currentIndex, array.length);
            currentIndex += array.length;
        }
        return result;
    }

    // 私有构造函数，防止实例化
    private ItemClasses() {
        throw new AssertionError("ItemClasses类不应该被实例化");
    }
}