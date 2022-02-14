# RPG_Characters

Old school RPG-style character generator. This command line application was programmed with Java utilising OOP paradigm.

## 1. Usage

```git clone``` the repository into chosen directory. Run the project with the IDE of your choice.

## 2. Classes

The program logic is mainly divided into object classes, which handle the logic behind characters and equipment.

- ```Character```
  - Is extended by Mage, Ranger, Rogue and Warrior.
  - Subclasses have their unique program logic. 
- ```Item```
  - Is extended by Weapon and Armor.
  - Subclasses have their unique program logic. 
- ```Items```
  - Is a container class for inventory/items.
- ```Main```
  - User interactions to classes are handled in Main class.
  - Contains a demonstrative command line "game".

## 3. Notable methods

Character class is responsible for much of the functionalities.

- ```levelUp()```
  - All characters start at level 1.
  - This method ups the character level by 1.
  - It also affects the character attributes.
- ```dealDamage()```
  - Character "deals damage".
  - Prints the dps value to console.
- ```characterStats(Character character)```
  - Prints character stats to console.
- ```equipItem(Item item)```
  - Character equips an item.
  - Items have effects on character stats.

## 4. Items

Items are initialized and created into Items class.
Item constructor requires parameters, such as name and required level. 

## 5. Maintainer

[JuliusHuttunen](https://github.com/JuliusHuttunen)


