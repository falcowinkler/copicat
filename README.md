# copicat
[![Build Status](https://travis-ci.org/falcowinkler/copicat.svg?branch=master)](https://travis-ci.org/falcowinkler/copicat)

https://soundcloud.com/rivalconsoles/copicat (From the official soundtrack)

The higher goal of this project is to use generative machine learning models to generate tilesets for levels of the game n++ and it's previous versions.

http://www.metanetsoftware.com/games/nplusplus

http://www.metanetsoftware.com/games/n

This repository contains the various format conversions needed.
The idea is to write conversions from every available format (nv1 textual, n++ textual (maybe, only used for the levels created by metanet), and the custom machine learning format) to the n++ binary format.
Then the binary format can be converted to images, can be loaded in the actual game, converted back to ML format etc.

## Usage`

`lein run --i <path-to-input-file-or-folder> -o <output-path> --input-format <binary|text-n++|text-n|ml> --output-format <binary|ml|image>` 

For example

`lein run --input-format text-n --output-format image -i resources/numa_archive.csv -o out
## Compile protobuf

`protoc --java_out src/main/java/ -I resources/proto/ resources/proto/*.proto