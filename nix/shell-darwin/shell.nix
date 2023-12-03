{ pkgs ? import <nixpkgs> { } }:

pkgs.mkShell {
  name = "test-darwin-shell";
  meta.platforms = pkgs.lib.platforms.darwin;
}
