#! /usr/bin/env nix-shell
#! nix-shell -i groovy -p groovy

m = [:]
println(m['a'] = 'A')
println(m['b'] = 'B')
println(m['c'] = 'C')
println(m)

m['d'] = null

if (!m.d) {
    println('X')
}
println(m)
println(m.d)
println(m.get('d', ''))
println(m.get('d', '').startsWith('x'))
