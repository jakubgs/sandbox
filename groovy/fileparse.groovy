#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

def regexSafeGetGroup(java.util.regex.Matcher matcher, String groupName) {
    try {
        return matcher.group(groupName)
    } catch (java.lang.IllegalArgumentException ex) {
        return null
    }
}

def parseFilename(String filename) {
  def matcher = filename =~ /^(?<name>\w+)-(?<type>\w+)-(?<tstamp>\w+-\w+)-(?<commit>\w+)-(?<build>\w+)-(?<arch>\w+)\.(?<ext>[\w\.]+)$/
  if (! matcher.matches()) {
    matcher = filename =~ /^(?<name>\w+)-(?<type>\w+)-(?<version>[\w\.-]+)-(?<commit>\w+)-(?<arch>\w+)\.(?<ext>[\w\.]+)$/
  }
  if (! matcher.matches()) {
    throw new Exception("No pattern matches filename!")
  }
  return [
    name:    regexSafeGetGroup(matcher, 'name'),
    type:    regexSafeGetGroup(matcher, 'type'),
    build:   regexSafeGetGroup(matcher, 'build'),
    version: regexSafeGetGroup(matcher, 'version'),
    commit:  regexSafeGetGroup(matcher, 'commit'),
    tstamp:  regexSafeGetGroup(matcher, 'tstamp'),
    arch:    regexSafeGetGroup(matcher, 'arch'),
    ext:     regexSafeGetGroup(matcher, 'ext'),
  ]
}

println(parseFilename('StatusIm-Desktop-231107-133746-d2439c-nightly-x86_64.tar.gz'))
println(parseFilename('StatusIm-Desktop-v0.15.0-rc.1-6aa497-x86_64.tar.gz'))
