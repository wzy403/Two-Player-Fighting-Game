# Two Player Fighting Game

## Overview

This is a two-player fighting game developed using the Greenfoot platform. The game involves two players controlling their respective characters to fight against each other using various moves and skills. The objective is to reduce the opponent's health to zero to win the game.

## Game Premise

The game is a fast-paced, action-packed fighting game where two players face off in a dynamic arena. Players can move, jump, and use skills to attack their opponent. The game incorporates elements of strategy, as players must manage their mana to maximize damage output.

## How To Play

### Installation

1. Visit the [release page](https://github.com/wzy403/Two-Player-Fighting-Game/releases/tag/v1.0.0).
2. Download the `Two-player-Fighting-Game.gfar` file.
3. Open the `Two-player-Fighting-Game.gfar` file with Greenfoot.
4. Click Run.

### Controls

**Player 1:**
- Move Left: `a`
- Move Right: `d`
- Jump: `space`
- Use Skill: `q`

**Player 2:**
- Move Left: `left arrow`
- Move Right: `right arrow`
- Jump: `up arrow`
- Run: `l` (hold `left` or `right` arrow first)
- Use Skill: `p`

### Game Mechanics

1. **Movement and Jumping:** Both players can move left and right, and jump. Double pressing the jump key enables a double jump.
2. **Attacking:** To attack, players must move close to their opponent and use their skill key. 
3. **Floor Dynamics:** The floor at the center of the screen can be jumped on and will move, adding a strategic element to the game.
4. **Damage Calculation:** Damage is based on the remaining mana and luck. The formula for damage is $$(random \ value) * (player's \ mana \ left + 1) * 3$$
5. **Mana Management:** Each skill usage reduces mana by half. For example, if a player has 10 mana, the first skill usage will reduce it to 5, the next to 2, and so on.

## Features

- **Shooting Mechanics:** Both players can shoot skills at each other.
- **Damage Tracking:** The game keeps track of the damage inflicted and displays health status. The game ends when a player's health reaches zero.
- **Gravity:** The game includes gravity effects, especially noticeable during jumps.
- **Mana Reloads:** Mana automatically reloads if it falls below 10, with a reload time of 100 iterations.
- **Animations:** Characters and skills are animated using arrays for a smooth visual experience.
- **Jumping and Floor Dynamics:** Players can jump and interact with a moving floor in the center of the screen.
- **Transparency Effects:** The central floor has dynamic transparency for a visually appealing effect.

## Release History

* 1.0.0
    * First Release

## Authors

* **Zhengyu-Joey-Wang**

## License

This project is protected under the GNU license. Please refer to the [LICENSE](LICENSE) for more information.
