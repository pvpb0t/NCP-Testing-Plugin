# NCP-Testing-Plugin
A plugin to test modules/cheats on ncp. Made for bukkit but works on spigot

Instead of kicked it displays:
![bild](https://user-images.githubusercontent.com/74259011/211204393-80b07d2c-efa9-4fe3-ac02-2fc38944fe7c.png)

Show flags in chat:
![bild](https://user-images.githubusercontent.com/74259011/211204400-e3b01d51-ef95-4a3d-ab9b-e9eeded4bba7.png)

Also takes a password so you can run the server offline to test features through ide

<h1> Add this in the ncp config to prevent kick</h1>

```
  kickagainst: title [player] title "&c&l(!)&7 Invalid block placements."
  kickalive: title [player] title "&c&l(!)&7 Too many keep-alive packets."
  kickattackfrequency: title [player] title "&c&l(!)&7 Unlikely fast clicking."
  kickbow: title [player] title "&c&l(!)&7 Shooting arrows too quickly."
  kickbspeed: title [player] title "&c&l(!)&7 Too fast block interactions."
  kickcaptcha: title [player] title "&c&l(!)&7 Enter the captcha!"
  kickchat1: title [player] title "&c&l(!)&7 Do not spam the server chat (1 minute tempkick)"
  kickchat5: title [player] title "&c&l(!)&7 You are not allowed to spam the server chat (5 minutes tempkick)"
  kickchatfast: title [player] title "&c&l(!)&7 Stop spamming."
  kickchatnormal: title [player] title "&c&l(!)&7 Too many chat messages, take a break."
  kickcommands: title [player] title "&c&l(!)&7 Do not spam commands (1 minute tempkick)"
  kickcritical: title [player] title "&c&l(!)&7 Incorrect movements (Critical cheats?)"
  kickfastbreak: title [player] title "&c&l(!)&7 Breaking blocks too fast."
  kickfastclick: title [player] title "&c&l(!)&7 Unlikely inventory interactions."
  kickfastconsume: title [player] title "&c&l(!)&7 Using items too quickly."
  kickfastheal: title [player] title "&c&l(!)&7 Too fast health regeneration."
  kickfastplace: title [player] title "&c&l(!)&7 Placing blocks too quickly."
  kickfly: title [player] title "&c&l(!)&7 Moved unexpectedly."
  kickflyingfrequency: title [player] title "&c&l(!)&7 Kicked for packet spam."
  kickfrequency: title [player] title "&c&l(!)&7 Illegal block-breaking frequency."
  kickgod: title [player] title "&c&l(!)&7 GodMode?"
  kickillegalblockinteract: title [player] title "&c&l(!)&7 Illegal block interactions."
  kickillegalrotations: title [player] title "&c&l(!)&7 Invalid rotations."
  kickimprobable: title [player] title "&c&l(!)&7 Illegal client modifications."
  kickinvaliddata: title [player] title "&c&l(!)&7 Invalid book data."
  kickpacketfrequency: title [player] title "&c&l(!)&7 Too many packets."
  kickpackets: title [player] title "&c&l(!)&7 You sent too many moves (extreme lag?)"
  kickscaffold: title [player] title "&c&l(!)&7 Unnatural block placements."
  kickselfhit: title [player] title "&c&l(!)&7 You tried to hit yourself!"
  kicksuspiciouscombat: title [player] title "&c&l(!)&7 Illegal combat modifications."
  kickvehiclefly: title [player] title "&c&l(!)&7 Unexpected vehicle movement."
  kickwb: title [player] title "&c&l(!)&7 Block breaking out of sync."
```
