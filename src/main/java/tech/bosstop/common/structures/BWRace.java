package tech.bosstop.common.structures;

public enum BWRace {
    VAMPIRE,
    WEREWOLF,
    HUMAN,
    MERMAID,
    SERPENTINE,
    ELF,
    TROLL,
    GIANT,
    DWARF,
    DARKELF,
    DRAGONBORN;

    public String toPrefix() {
        switch(this) {
            case VAMPIRE:
                return "&4Vampire&r";
            case WEREWOLF:
                return "&6Werewolf&r";
            case HUMAN:
                return "&fHuman&r";
            case MERMAID:
                return "&bMermaid&r";
            case SERPENTINE:
                return "&dSerpentine&r";
            case ELF:
                return "&aElf&r";
            case TROLL:
                return "&5Troll&r";
            case GIANT:
                return "&2Giant&r";
            case DWARF:
                return "&6Dwarf&r";
            case DARKELF:
                return "&1Dark Elf&r";
            case DRAGONBORN:
                return "&cDragonborn&r";
            default:
                return "Unknown";
        }
    }
};

/*
 * VAMPIRE: 
 * - 1 kill = 1 life
 * - 1 death = -1 life
 * WEREWOLF:
 * - 2.0x damage at night
 * - Can only eat meat
 * - Night Vision
 * HUMAN:
 * - None
 * MERMAID:
 * - 2.0x damage with trident
 * - 1.5x damage underwater
 * - Can breathe underwater
 * - Can swim faster
 * - Can mine underwater
 * - Can't drown
 * SERPENTINE:
 * - One punch poisons enemy
 * ELF:
 * - 1.5x damage with bow durning day
 * - 1.5x regeneration durning day
 * TROLL:
 * - 1.5x defense durning night
 * - 1.5x health
 * GIANT:
 * - 1.5x defense durning day
 * - 1.5x health
 * DWARF:
 * - 1.5x damage with pickaxe
 * - Can mine faster
 * - Enchant discount
 * DARKELF:
 * - 1.5x damage with bow durning night
 * - Night Vision
 * DRAGONBORN:
 * - Fire resistance
 * - 1.5x damage with sword
 */
