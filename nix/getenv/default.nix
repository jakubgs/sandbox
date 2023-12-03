{ pkgs ? import <nixpkgs> { } }:

pkgs.stdenv.mkDerivation {
  name = "getenv-test";
  builder = pkgs.writeText "builder.sh" ''
    echo "${builtins.getEnv "PATH"}" > $out
  '';
}
