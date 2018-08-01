# ninja-vision
[![Build Status](https://travis-ci.org/falcowinkler/ninja-vision.svg?branch=master)](https://travis-ci.org/falcowinkler/ninja-vision)

The higher goal of this project is to use generative machine learning models to generate tilesets for levels of the game n++ and it's previous versions. 

This repository contains the various format conversions needed.
The idea is to write conversions from every available format (nv1 textual, nv2 textual, n++ textual (maybe, only used for the levels created by metanet, and the custom machine learning format) to the n++ binary format.
Then the binary format can be converted to images, can be loaded in the actual game, converted back to ML format etc.

## Usage

`lein run --i <path-to-input-file-or-folder> -o <output-path> --input-format <binary|text-n++|text-nv1|text-nv2|ml> --output-format <binary|ml|image>` 
