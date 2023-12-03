{ pkgs ? import ../../work/nixpkgs { } }:

pkgs.stdenv.mkDerivation {
  name = "just-a-test-build";
  
  #phases = [ "buildPhase" ];
  #NIX_DEBUG = 8;

  makeFlags = [ "--nothing" ];

  src = ./.;
}
