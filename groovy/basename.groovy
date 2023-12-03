#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

url = 'https://ci.status.im/job/status-desktop/job/branches/job/linux/job/x86_64/job/package/view/change-requests/job/PR-12037/lastSuccessfulBuild/artifact/pkg/StatusIm-Desktop-231019-183252-92b344-pr12037-x86_64.tar.gz'
println(url.count('s'))

regex = 'https://(?<domain>[^/]+)/.*'
matcher = url =~ regex
println(matcher.matches())
println(matcher.group('domain'))
//println(matcher.group('test'))
//println(matcher.hasGroup('test'))
println()

def x = null
def y = "y"

println(x ?: y)
