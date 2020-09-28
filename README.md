# Atlantis Generator
[![Nukkit](https://img.shields.io/badge/Nukkit-1.0-green)](https://github.com/NukkitX/Nukkit)
[![Build](https://img.shields.io/circleci/build/github/wode490390/AtlantisGenerator/master)](https://circleci.com/gh/wode490390/AtlantisGenerator/tree/master)
[![Release](https://img.shields.io/github/v/release/wode490390/AtlantisGenerator)](https://github.com/wode490390/AtlantisGenerator/releases)
[![Release date](https://img.shields.io/github/release-date/wode490390/AtlantisGenerator)](https://github.com/wode490390/AtlantisGenerator/releases)
<!--[![MCBBS](https://img.shields.io/badge/-mcbbs-inactive)](https://www.mcbbs.net/thread-867768-1-1.html "亚特兰蒂斯水世界生成器")
[![Servers](https://img.shields.io/bstats/servers/4840)](https://bstats.org/plugin/bukkit/AtlantisGenerator/4840)
[![Players](https://img.shields.io/bstats/players/4840)](https://bstats.org/plugin/bukkit/AtlantisGenerator/4840)-->

Waterworld generator plugin for Nukkit.

![](https://i.loli.net/2020/09/28/1Bz6E7UHtrvRwJV.png)

If you found any bugs or have any suggestions, please open an issue on [GitHub](https://github.com/wode490390/AtlantisGenerator/issues).

If you like this plugin, please star it on [GitHub](https://github.com/wode490390/AtlantisGenerator).

*Note: Please back up old worlds before using this plugin.*

## Download
- [Releases](https://github.com/wode490390/AtlantisGenerator/releases)
- [Snapshots](https://circleci.com/gh/wode490390/AtlantisGenerator)

## Configuration
<details>
<summary>config.yml</summary>

```yaml
# Allowed values: Integers in the range [0, 255]
sea-level: 128
# enable biome
biome: true
# register limited old world generator
old: true
```
</details>

## Compiling
1. Install [Maven](https://maven.apache.org/).
2. Run `mvn clean package`. The compiled JAR can be found in the `target/` directory.

## Metrics Collection

This plugin uses [bStats](https://github.com/wode490390/bStats-Nukkit). You can opt out using the global bStats config; see the [official website](https://bstats.org/getting-started) for more details.

<!--[![Metrics](https://bstats.org/signatures/bukkit/AtlantisGenerator.svg)](https://bstats.org/plugin/bukkit/AtlantisGenerator/4840)-->

###### If I have any grammar and/or term errors, please correct them :)
