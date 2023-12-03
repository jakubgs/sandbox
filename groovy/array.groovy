#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

def flags = []
if (true) { flags.add('-a=what') }
if (true) { flags.add('-b=wtf') }
if (true) { flags.add('-c=wat') }
println flags.join(' ')
