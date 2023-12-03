#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

def str = 'status-desktop » nightly #12'
def reg = /nightly/
if (str =~ reg) {
    println("match")
}
