#!/usr/bin/env nix-shell
#!nix-shell -i groovy -p groovy

def data = [
    Something: 'other',
    Whatever: 'more stuff',
    Another: 'meh'
]

def formatMap(Map data=[:]) {
  def text = ''
  data.each { key, val -> text += "<b>${key}</b>: ${val}<br>\n" }
  return text
}

println(formatMap(data))
