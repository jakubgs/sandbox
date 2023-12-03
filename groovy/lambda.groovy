#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

def testFunc = { "x" == "y" }
println(testFunc())

def testArgFunc = { x -> "string: ${x}" }
println(testArgFunc("wat"))
