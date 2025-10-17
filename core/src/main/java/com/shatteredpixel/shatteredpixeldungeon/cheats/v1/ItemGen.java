package com.shatteredpixel.shatteredpixeldungeon.cheats.v1;

import com.shatteredpixel.shatteredpixeldungeon.items.ArcaneResin;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;

// Manually import all item classes
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.LiquidMetal;
import com.shatteredpixel.shatteredpixeldungeon.items.Waterskin;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.*;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.*;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.food.*;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.*;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.Brew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.Elixir;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.ExoticPotion;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Pickaxe;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.*;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.*;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ExoticScroll;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.Spell;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.*;
import com.shatteredpixel.shatteredpixeldungeon.items.trinkets.*;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.Dart;
import com.shatteredpixel.shatteredpixeldungeon.plants.*;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ItemGen {

    public static final List<Class<? extends Item>> ALL_ITEMS = new ArrayList<>();
    private static final Map<String, Class<? extends Item>> items = new LinkedHashMap<>();
    private static final int ITEMS_PER_PAGE = 6;

    static {
        ALL_ITEMS.addAll(Arrays.asList(
                // Potions
                PotionOfStrength.class, PotionOfHealing.class, PotionOfMindVision.class, PotionOfFrost.class,
                PotionOfLiquidFlame.class, PotionOfToxicGas.class, PotionOfHaste.class, PotionOfInvisibility.class,
                PotionOfLevitation.class, PotionOfParalyticGas.class, PotionOfPurity.class, PotionOfExperience.class,
                Waterskin.class, Potion.class, ExoticPotion.class, Brew.class, Elixir.class, LiquidMetal.class,

                // Seeds
                Sungrass.Seed.class, Fadeleaf.Seed.class, Icecap.Seed.class,
                Firebloom.Seed.class, Sorrowmoss.Seed.class, Swiftthistle.Seed.class, Blindweed.Seed.class,
                Stormvine.Seed.class, Earthroot.Seed.class, Mageroyal.Seed.class, Starflower.Seed.class,
                Rotberry.Seed.class,

                // Scrolls
                ScrollOfUpgrade.class, ScrollOfIdentify.class, ScrollOfRemoveCurse.class, ScrollOfMirrorImage.class,
                ScrollOfRecharging.class, ScrollOfTeleportation.class, ScrollOfLullaby.class, ScrollOfMagicMapping.class,
                ScrollOfRage.class, ScrollOfRetribution.class, ScrollOfTerror.class, ScrollOfTransmutation.class,
                Scroll.class, ExoticScroll.class, Spell.class, ArcaneResin.class,

                // Stones
                StoneOfEnchantment.class, StoneOfIntuition.class, StoneOfDetectMagic.class, StoneOfFlock.class,
                StoneOfShock.class, StoneOfBlink.class, StoneOfDeepSleep.class, StoneOfClairvoyance.class,
                StoneOfAggression.class, StoneOfBlast.class, StoneOfFear.class, StoneOfAugmentation.class,

                // Wands
                WandOfMagicMissile.class, WandOfLightning.class, WandOfDisintegration.class, WandOfFireblast.class,
                WandOfCorrosion.class, WandOfBlastWave.class, WandOfLivingEarth.class, WandOfFrost.class,
                WandOfPrismaticLight.class, WandOfWarding.class, WandOfTransfusion.class, WandOfCorruption.class,
                WandOfRegrowth.class,

                // Melee Weapons
                WornShortsword.class, MagesStaff.class, Dagger.class, Gloves.class, Rapier.class, Cudgel.class,
                Shortsword.class, HandAxe.class, Spear.class, Quarterstaff.class, Dirk.class, Sickle.class, Pickaxe.class,
                Sword.class, Mace.class, Scimitar.class, RoundShield.class, Sai.class, Whip.class,
                Longsword.class, BattleAxe.class, Flail.class, RunicBlade.class, AssassinsBlade.class, Crossbow.class, Katana.class,
                Greatsword.class, WarHammer.class, Glaive.class, Greataxe.class, Greatshield.class, Gauntlet.class, WarScythe.class,

                // Armors
                ClothArmor.class, LeatherArmor.class, MailArmor.class, ScaleArmor.class, PlateArmor.class,
                WarriorArmor.class, MageArmor.class, RogueArmor.class, HuntressArmor.class, DuelistArmor.class, ClericArmor.class,

                // Missile Weapons
                ThrowingStone.class, ThrowingKnife.class, ThrowingSpike.class, Dart.class,
                FishingSpear.class, ThrowingClub.class, Shuriken.class,
                ThrowingSpear.class, Kunai.class, Bolas.class,
                Javelin.class, Tomahawk.class, HeavyBoomerang.class,
                Trident.class, ThrowingHammer.class, ForceCube.class,
                MissileWeapon.class, Bomb.class,

                // Food
                Food.class, Pasty.class, MysteryMeat.class,

                // Rings
                RingOfAccuracy.class, RingOfArcana.class, RingOfElements.class, RingOfEnergy.class,
                RingOfEvasion.class, RingOfForce.class, RingOfFuror.class, RingOfHaste.class,
                RingOfMight.class, RingOfSharpshooting.class, RingOfTenacity.class, RingOfWealth.class,

                // Artifacts
                AlchemistsToolkit.class, ChaliceOfBlood.class, CloakOfShadows.class, DriedRose.class,
                EtherealChains.class, HolyTome.class, HornOfPlenty.class, MasterThievesArmband.class,
                SandalsOfNature.class, TalismanOfForesight.class, TimekeepersHourglass.class, UnstableSpellbook.class,

                // Trinkets
                RatSkull.class, ParchmentScrap.class, PetrifiedSeed.class, ExoticCrystals.class,
                MossyClump.class, DimensionalSundial.class, ThirteenLeafClover.class, TrapMechanism.class,
                MimicTooth.class, WondrousResin.class, EyeOfNewt.class, SaltCube.class,
                VialOfBlood.class, ShardOfOblivion.class, ChaoticCenser.class, FerretTuft.class,
                Trinket.class, TrinketCatalyst.class,

                // Other
                Gold.class
        ));
    }


    public ItemGen() {
        if (items.isEmpty()) {
            Map<String, Class<? extends Item>> sortedItems = new TreeMap<>();
            for (Class<? extends Item> itemClass : ALL_ITEMS) {
                try {
                    Item item = itemClass.getDeclaredConstructor().newInstance();
                    String name = item.trueName();
                    sortedItems.put(name, itemClass);
                } catch (Exception e) {
                    // Ignored
                }
            }
            items.putAll(sortedItems);
        }
        show();
    }

    public void show() {
        showPage(0);
    }

    private void showPage(int page) {
        ArrayList<String> allItems = new ArrayList<>(items.keySet());
        int totalItems = allItems.size();
        int totalPages = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);

        int start = page * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, totalItems);

        ArrayList<String> pageItems = new ArrayList<>(allItems.subList(start, end));
        ArrayList<String> options = new ArrayList<>(pageItems);

        String title = "物品生成器";
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

        GameScene.show(new WndOptions(title, "请选择物品", options.toArray(new String[0])) {
            @Override
            protected void onSelect(int index) {
                String selectedOption = options.get(index);

                if (selectedOption.equals("下一页")) {
                    showPage(page + 1);
                } else if (selectedOption.equals("上一页")) {
                    showPage(page - 1);
                } else if (!selectedOption.equals("取消")) {
                    try {
                        Class<?> clazz = items.get(selectedOption);
                        if (clazz != null) {
                            Item item = (Item) clazz.getDeclaredConstructor().newInstance();
                            item.collect();
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        });
    }
}
