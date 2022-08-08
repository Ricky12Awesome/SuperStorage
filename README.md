# Super Storage
One giant inventory to store all your items

## Why make this mod?

I just want a simple way to store large amounts of different items,
and technically this should cause less lag since there less stuff
on the network

* **Why not use Refined Storage or Applied Energistics 2?**
  * in a lot of modpacks they tend to be gated to mid to end game,
    while this mod is for early game

* **Why not use Simple Storage Networks?**
  * this mod can be used with it, 
    since all this mod is just one giant inventory

## Rough draft of what this mod will do (WIP)

- Very Customizable
- Storage Module
  - connects in a multi-block structure
  - unique item limit defaults to 8 per module
  - stack limit
    - Tier 1 (Iron) - stack limit * 8
    - Tier 2 (Gold) - stack limit * 16
    - Tier 3 (Diamond) - stack limit * 32
    - Tier 4 (Emerald) - stack limit * 64
    - Tier 5 (Netherrite)- stack limit * 128

- Controller
  - controls the multi-block structure
  - view all connected modules
  - can upgrade modules within its gui
  - multi-block size upgrades (`size - 1 * module_size`, `-1` for the controller, `module_size` defaults to 8)
    - no upgrades - 2^3 (56 unique items)
    - Tier 1 (Diamond)- 3^3 (208 unique items)
    - Tier 2 (Emerald) - 4^3 (504 unique items)
    - Tier 3 (Netherrite) - 5^3 (992 unique items)

- Items will NOT overflow to the next module,
  if a unique item reaches its limit
  no more of that item can be stored in the multi-block structure

- Interfaces (Input/Output)
- Crafting Interface