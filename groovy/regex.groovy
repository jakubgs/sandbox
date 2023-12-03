#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

def regexSafeGetGroup(java.util.regex.Matcher matcher, String groupName) {
    try {
        return matcher.group(groupName)
    } catch (java.lang.IllegalStateException ex) {
        return "WAT"
    } catch (java.lang.IllegalArgumentException ex) {
        return null
    }
}

def filename = 'StatusIm-Desktop-231019-183252-92b344-pr12037-x86_64.tar.gz'
def pattern = /^(?<name>\w+)-(?<type>\w+)-(?<tstamp>\w+-\w+)-(?<commit>\w+)-(?<build>\w+)-(?<arch>\w+)\.(?<ext>[\w\.]+)$/
def matcher = filename =~ pattern
println('---------------------')
println(matcher.groupCount())
println('---------------------')
println(regexSafeGetGroup(matcher, 'name'))
println(regexSafeGetGroup(matcher, 'type'))
println(regexSafeGetGroup(matcher, 'build'))
println(regexSafeGetGroup(matcher, 'version'))
println(regexSafeGetGroup(matcher, 'commit'))
println(regexSafeGetGroup(matcher, 'tstamp'))
println(regexSafeGetGroup(matcher, 'arch'))
println(regexSafeGetGroup(matcher, 'ext'))
