{ pkgs ? import <nixpkgs> { } }:

pkgs.fetchFromGitHub rec {
  owner = "status-im";
  repo = "nimbus-eth1";
  rev = "4019492cd873101078b6d2bd414dc9c1b4a4fff5";
  sha256 = "0pjh9dq4x07pa9zgikq8y4rb0xkads46c13r06c4wpjpk00kck2j";
  name = "${repo}-${pkgs.lib.strings.substring 0 7 rev}-source-with-submodules";
  fetchSubmodules = true;
}
