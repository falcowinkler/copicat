# copicat
[![Build Status](https://travis-ci.org/falcowinkler/copicat.svg?branch=master)](https://travis-ci.org/falcowinkler/copicat)

https://soundcloud.com/rivalconsoles/copicat (From the official soundtrack)

The higher goal of this project is to use generative machine learning
models to generate tilesets for levels of the game n++ and it's previous versions.

 - http://www.metanetsoftware.com/games/nplusplus
 - http://www.metanetsoftware.com/games/n

This repository contains the various format conversions needed.
The idea is to write conversions from every available format
(nv1 textual, n++ textual (maybe, only used for the levels created by metanet),
and the custom machine learning format) to the n++ binary format.
Then the binary format can be converted to images, can be loaded in the actual game,
converted back to ML format etc.

## Formats

The game consist of (a lot) of levels that are made up of a *tileset*
and objects. The tilesets define the "concrete" of the level that the
player jumps around on. The objects are enemies, gold, triggers, etc.
For the sake of simplicity, this project is first just concerned
about the tile data.

Each tile is decoded by a tile-code. There are 33 tiles,
meaning that for a 31 * 23 grid (the n level format), this will
be 31 * 23 * 33 = 23.529 inputs to a neural network (one-hot encoded).

So far copicat can parse n++ binary format (but there is not
really a website available where to scrape a dataset from, and the traffic
to the server is encoded) and n textual format.

This format is used on the website http://numa-notdot-net.appspot.com
from where the main dataset was scraped.

Supported output formats will include images (the rendered tileset),
protobuf, .tfrecord, n-textual and n++ binary format.

## Usage

`lein run --i <path-to-input-file-or-folder> -o <output-path> --input-format <binary|text-n++|text-n|ml> --output-format <binary|ml|image>` 

For example

`lein run --input-format text-n --output-format image -i resources/numa_archive.csv -o out`
## Compile protobuf

Needed for conversion to protobuf files or .tfrecord dataset.
(The generated code is in git, but if you change the formats this is
necessary)

`protoc --java_out src/main/java/ -I resources/proto/ resources/proto/*.proto`